package bg.tusofia.controllers;

import bg.tusofia.models.PersonalData;
import bg.tusofia.tools.DeepCopy;
import bg.tusofia.tools.PromBox;
import bg.tusofia.tools.WorkingFile;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public abstract class AbstractController implements Initializable {

    public enum AdditionalInfoTypes {
        OWNERSHIP,
        DISTRIBUTION_RIGHTS,
        READ_RIGHTS,
        LITERAL,
        RAGEXP
    }

    private AbstractController mainController;
    private Stage stage;
    private Serializable data;
    private Map<AdditionalInfoTypes, List<PersonalData>> additionalData;


    private AdditionalInfoTypes additionalInfoType;

    public abstract void initialize();

    public abstract void updateParent();

    protected abstract boolean validate();

    protected abstract String errorMessage();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public AbstractController getMainController() {
        return mainController;
    }

    public void setMainController(AbstractController mainController) {
        this.mainController = mainController;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void save() {
        if (validate()) {
            updateParent();
            getStage().close();
        } else {
            PromBox.alert("Validation error", errorMessage());
        }
    }

    public void cancel() {
        getStage().close();
    }

    public Serializable getData() {
        return data;
    }

    public void setData(Serializable data) {
        this.data = data;
    }

    public void addModifyCommonButtons(String stageName, Serializable data, String fxmlPath) {
        addModifyCommonButtons(stageName, data, fxmlPath, null);
    }

    public void addModifyCommonButtons(String stageName, Serializable data, String fxmlPath, AdditionalInfoTypes additionalInfoType) {
        setWorkingFileAsModified();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle(stageName);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);

            AbstractController controller = fxmlLoader.getController();
            controller.setMainController(this);
            controller.setStage(stage);
            controller.setData((Serializable) DeepCopy.copy(data));
            controller.setAdditionalInfoType(additionalInfoType);
            controller.initialize();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void setWorkingFileAsModified() {
        WorkingFile workingFile = WorkingFile.getInstance();
        workingFile.setChanged(Boolean.TRUE);
    }

    protected void deleteTableRow(TableView<?> table) {
        ObservableList<?> selectedItem, tableItems;
        tableItems = table.getItems();
        selectedItem = table.getSelectionModel().getSelectedItems();

        selectedItem.forEach(tableItems::remove);
    }

    //UTILITIES
    protected boolean isNumeric(String str) {
        return str.matches("-?\\d+(.\\d+)?");
    }

    public Map<AdditionalInfoTypes, List<PersonalData>> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<AdditionalInfoTypes, List<PersonalData>> additionalData) {
        this.additionalData = additionalData;
    }

    public AdditionalInfoTypes getAdditionalInfoType() {
        return additionalInfoType;
    }

    public void setAdditionalInfoType(AdditionalInfoTypes additionalInfoType) {
        this.additionalInfoType = additionalInfoType;
    }
}