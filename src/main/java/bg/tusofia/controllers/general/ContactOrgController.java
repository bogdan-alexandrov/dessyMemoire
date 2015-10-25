package bg.tusofia.controllers.general;


import bg.tusofia.controllers.AbstractController;
import bg.tusofia.models.General;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ContactOrgController extends AbstractController {

    public TextField orgName;
    public TextField country;
    public TextField city;
    public TextField postCode;
    public TextArea address;

    @Override
    public void initialize() {
        General.Contact.ContactOrganisation contactOrg = (General.Contact.ContactOrganisation) getData();

        if (contactOrg.getOrgName() != null) {
            orgName.setText(contactOrg.getOrgName());
        }
        if (contactOrg.getCountry() != null) {
            country.setText(contactOrg.getCountry());
        }
        if (contactOrg.getCity() != null) {
            city.setText(contactOrg.getCity());
        }
        if (contactOrg.getPostcode() != null) {
            postCode.setText(contactOrg.getPostcode());
        }
        if (contactOrg.getAddress() != null) {
            address.setText(contactOrg.getAddress());
        }
    }

    @Override
    public void updateParent() {
        General.Contact.ContactOrganisation orgData = (General.Contact.ContactOrganisation) getData();
        orgData.setOrgName(orgName.getText());
        orgData.setCountry(country.getText());
        orgData.setCity(city.getText());
        orgData.setPostcode(postCode.getText());
        orgData.setAddress(address.getText());

        ContactController controller = (ContactController) getMainController();
        General.Contact parentData = ((General.Contact) controller.getData());
        parentData.getContactPersonOrContactOrganisation().remove(controller.getItemToModify());
        parentData.getContactPersonOrContactOrganisation().add(orgData);

        controller.initialize();
    }

    @Override
    protected boolean validate() {
        return !orgName.getText().isEmpty() && !country.getText().isEmpty() && !city.getText().isEmpty() &&
                !postCode.getText().isEmpty() && !address.getText().isEmpty();
    }

    @Override
    protected String errorMessage() {
        return "All fields are required.";
    }
}