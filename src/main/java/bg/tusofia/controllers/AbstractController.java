package bg.tusofia.controllers;

import bg.tusofia.models.PersonalData;
import bg.tusofia.tools.DeepCopy;
import bg.tusofia.tools.PromBox;
import bg.tusofia.tools.WorkingFile;
import com.sun.javafx.scene.control.behavior.TabPaneBehavior;
import com.sun.javafx.scene.control.skin.TabPaneSkin;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public abstract class AbstractController implements Initializable {

    public enum AdditionalInfoTypes {
        OWNERSHIP,
        DISTRIBUTION_RIGHTS,
        READ_RIGHTS,
        LITERAL,
        REGEXP,
        END,
        SEPARATOR
    }

    private AbstractController mainController;
    private Stage stage;
    private Tab currentTab;
    private Serializable data;
    private Map<AdditionalInfoTypes, List<PersonalData>> additionalData;
    protected TabPane tabPane;


    private AdditionalInfoTypes additionalInfoType;

    public abstract void initialize();

    public abstract void updateParent();

    protected abstract boolean validate();

    protected abstract String errorMessage();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Preferences.userRoot().node(this.getClass().getName());
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
            close();
        } else {
            PromBox.alert("All required fields are marked with star. " +
                    "Validation is activated to the export in xml file. " +
                    "Use temporary file to save your current progress.", errorMessage());
        }
    }

    public void close() {
        cancel();
    }

    public void cancel() {
        TabPaneBehavior behavior = ((TabPaneSkin) getTabPane().getSkin()).getBehavior();
        if(behavior.canCloseTab(getCurrentTab())) {
            behavior.closeTab(getCurrentTab());
        }
    }

    public Serializable getData() {
        return data;
    }

    public void setData(Serializable data) {
        this.data = data;
    }

    public Tab getCurrentTab() {
        return currentTab;
    }

    public void setCurrentTab(Tab currentTab) {
        this.currentTab = currentTab;
    }

    public void addModifyCommonButtons(String stageName, Serializable data, String fxmlPath) {
        addModifyCommonButtons(stageName, data, fxmlPath, null);
    }

    public void addModifyCommonButtons(String stageName, Serializable data, String fxmlPath, AdditionalInfoTypes additionalInfoType) {
        setWorkingFileAsModified();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath),
                    ResourceBundle.getBundle("tooltips"));
            Node root = fxmlLoader.load();

            Tab tab = new Tab();
            tab.setText(stageName);
            tab.setContent(root);

            SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
            tabPane.getTabs().add(tab);
            selectionModel.select(tab);

            AbstractController controller = fxmlLoader.getController();
            controller.setTabPane(this.getTabPane());
            controller.setMainController(this);
            controller.setData((Serializable) DeepCopy.copy(data));
            controller.setAdditionalInfoType(additionalInfoType);
            controller.setCurrentTab(tab);
            controller.initialize();
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

    public TabPane getTabPane() {
        return tabPane;
    }

    public void setTabPane(TabPane tabPane) {
        this.tabPane = tabPane;
    }
}