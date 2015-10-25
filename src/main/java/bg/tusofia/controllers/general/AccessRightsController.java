package bg.tusofia.controllers.general;


import bg.tusofia.controllers.AbstractController;
import bg.tusofia.controllers.WizardController;
import bg.tusofia.models.Dataset;
import bg.tusofia.models.General;
import bg.tusofia.models.PersonalData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccessRightsController extends AbstractController {

    public Button modifyOwnershipButton;
    public Button deleteOwnershipButton;
    public TableView<PersonalData> table;

    public Button modifyDistributionButton;
    public Button deleteDistributionButton;
    public TableView<PersonalData> table1;

    public Button modifyReadButton;
    public Button deleteReadButton;
    public TableView<PersonalData> table2;

    private PersonalData personalDataToBeModified;

    @Override
    public void initialize() {

        modifyOwnershipButton.setDisable(true);
        deleteOwnershipButton.setDisable(true);
        if (!getAccessRights().getOwnership().isEmpty()) {
            modifyOwnershipButton.setDisable(false);
            deleteOwnershipButton.setDisable(false);
        }
        modifyDistributionButton.setDisable(true);
        deleteDistributionButton.setDisable(true);
        if (!getAccessRights().getDistributionRights().isEmpty()) {
            modifyDistributionButton.setDisable(false);
            deleteDistributionButton.setDisable(false);
        }
        modifyReadButton.setDisable(true);
        deleteReadButton.setDisable(true);
        if (!getAccessRights().getReadRights().isEmpty()) {
            modifyReadButton.setDisable(false);
            deleteReadButton.setDisable(false);
        }

        if (getAccessRights().getOwnership() != null) {
            table.setItems(FXCollections.observableArrayList(getAccessRights().getOwnership()));
            TableColumn nameCol = new TableColumn<>("Name");
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            table.getColumns().setAll(nameCol);
            table.setColumnResizePolicy(javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY);
        }

        if (getAccessRights().getDistributionRights() != null) {
            table1.setItems(FXCollections.observableArrayList(getAccessRights().getDistributionRights()));
            TableColumn nameCol = new TableColumn<>("Name");
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            table1.getColumns().setAll(nameCol);
            table1.setColumnResizePolicy(javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY);
        }

        if (getAccessRights().getReadRights() != null) {
            table2.setItems(FXCollections.observableArrayList(getAccessRights().getReadRights()));
            TableColumn nameCol = new TableColumn<>("Name");
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            table2.getColumns().setAll(nameCol);
            table2.setColumnResizePolicy(javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY);
        }

        Map<AdditionalInfoTypes, List<PersonalData>> additionalInfo = new HashMap<>();
        additionalInfo.put(AdditionalInfoTypes.OWNERSHIP, getAccessRights().getOwnership());
        additionalInfo.put(AdditionalInfoTypes.READ_RIGHTS, getAccessRights().getReadRights());
        additionalInfo.put(AdditionalInfoTypes.DISTRIBUTION_RIGHTS, getAccessRights().getDistributionRights());

        setAdditionalData(additionalInfo);
    }

    @Override
    public void updateParent() {
        WizardController controller = (WizardController) getMainController();
        ((Dataset) controller.getData()).getGeneral().setAccessRights(getAccessRights());
        controller.initialize();
    }

    @Override
    protected boolean validate() {
        return !getAccessRights().getOwnership().isEmpty();
    }

    @Override
    protected String errorMessage() {
        if (getAccessRights().getOwnership().isEmpty()) {
            return "Please add at least one person to the ownership list. ";
        }
        return "Validation error...";
    }

    public void addOwnership() {
        ownership("New Ownership", new PersonalData());
    }

    public void modifyOwnership() {
        ObservableList<?> selectedItem;
        selectedItem = table.getSelectionModel().getSelectedItems();
        personalDataToBeModified = (PersonalData) selectedItem.get(0);
        ownership("Modify child", personalDataToBeModified);
    }

    public void deleteOwnership() {
        deleteTableRow(table);
        deleteOwnershipButton.setDisable(false);
    }

    private void ownership(String stageName, PersonalData data) {
        addModifyCommonButtons(stageName, data, "/fxmls/general/personalData.fxml", AdditionalInfoTypes.OWNERSHIP);
    }

    public void addDistribution() {
        distribution("New Distribution", new PersonalData());
    }

    public void modifyDistribution() {
        ObservableList<?> selectedItem;
        selectedItem = table1.getSelectionModel().getSelectedItems();
        personalDataToBeModified = (PersonalData) selectedItem.get(0);
        distribution("Modify distribution", personalDataToBeModified);
    }

    public void deleteDistribution() {
        deleteTableRow(table1);
        deleteDistributionButton.setDisable(false);
    }

    private void distribution(String stageName, PersonalData data) {
        addModifyCommonButtons(stageName, data, "/fxmls/general/personalData.fxml", AdditionalInfoTypes.DISTRIBUTION_RIGHTS);
    }

    public void addReadRights() {
        readRights("New read rights", new PersonalData());
    }

    public void modifyReadRights() {
        ObservableList<?> selectedItem;
        selectedItem = table2.getSelectionModel().getSelectedItems();
        personalDataToBeModified = (PersonalData) selectedItem.get(0);
        readRights("Modify read rights", personalDataToBeModified);
    }

    public void deleteReadRights() {
        deleteTableRow(table2);
        deleteReadButton.setDisable(false);
    }

    private void readRights(String stageName, PersonalData data) {
        addModifyCommonButtons(stageName, data, "/fxmls/general/personalData.fxml", AdditionalInfoTypes.READ_RIGHTS);
    }

    //utilities
    public General.AccessRights getAccessRights() {
        return (General.AccessRights) super.getData();
    }

    public PersonalData getPersonalDataToBeModified() {
        return personalDataToBeModified;
    }
}
