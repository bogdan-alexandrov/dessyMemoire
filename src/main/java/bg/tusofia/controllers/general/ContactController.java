package bg.tusofia.controllers.general;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.controllers.WizardController;
import bg.tusofia.models.Dataset;
import bg.tusofia.models.General;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;


public class ContactController extends AbstractController {

    public Button addPerson;
    public Button modPerson;
    public Button delPerson;

    public Button addOrg;
    public Button modOrg;
    public Button delOrg;

    private Object itemToModify;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);

        addPerson.setOnAction(event -> person("New Person", new General.Contact.ContactPerson()));
        modPerson.setOnAction(event -> {
            itemToModify = getContactPerson();
            person("Modify Person", getContactPerson());
        });
        delPerson.setOnAction(event -> {
            setWorkingFileAsModified();
            getContact().getContactPersonOrContactOrganisation().remove(getContactPerson());
            initialize();
        });

        addOrg.setOnAction(event -> organisation("New Organisation", new General.Contact.ContactOrganisation()));
        modOrg.setOnAction(event -> {
            itemToModify = getContactOrganisation();
            organisation("Modify Organisation", getContactOrganisation());
        });
        delOrg.setOnAction(event -> {
            setWorkingFileAsModified();
            getContact().getContactPersonOrContactOrganisation().remove(getContactOrganisation());
            initialize();
        });
    }

    @Override
    public void initialize() {
        addPerson.setDisable(false);
        modPerson.setDisable(true);
        delPerson.setDisable(true);

        if (getContactPerson() != null) {
            addPerson.setDisable(true);
            modPerson.setDisable(false);
            delPerson.setDisable(false);
        }
        addOrg.setDisable(false);
        modOrg.setDisable(true);
        delOrg.setDisable(true);

        if (getContactOrganisation() != null) {
            addOrg.setDisable(true);
            modOrg.setDisable(false);
            delOrg.setDisable(false);
        }

    }

    @Override
    public void updateParent() {
        WizardController controller = (WizardController) getMainController();
        ((Dataset) controller.getData()).getGeneral().setContact(getContact());
        controller.initialize();
    }

    @Override
    protected boolean validate() {
        return getContact().getContactPersonOrContactOrganisation().size() == 2;
    }

    @Override
    protected String errorMessage() {
        return "Please enter Person and Organisation.";
    }

    private General.Contact getContact() {
        return (General.Contact) getData();
    }

    private General.Contact.ContactPerson getContactPerson() {
        for (Object current : getContact().getContactPersonOrContactOrganisation()) {
            if (current instanceof General.Contact.ContactPerson) {
                return (General.Contact.ContactPerson) current;
            }
        }
        return null;
    }

    private General.Contact.ContactOrganisation getContactOrganisation() {
        for (Object current : getContact().getContactPersonOrContactOrganisation()) {
            if (current instanceof General.Contact.ContactOrganisation) {
                return (General.Contact.ContactOrganisation) current;
            }
        }
        return null;
    }

    private void person(String stageName, General.Contact.ContactPerson data) {
        addModifyCommonButtons(stageName, data, "/fxmls/general/contactPerson.fxml");
    }

    private void organisation(String stageName, General.Contact.ContactOrganisation data) {
        addModifyCommonButtons(stageName, data, "/fxmls/general/contactOrg.fxml");
    }

    public Object getItemToModify() {
        return itemToModify;
    }
}
