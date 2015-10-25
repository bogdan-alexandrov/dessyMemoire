package bg.tusofia.controllers.general;


import bg.tusofia.models.General;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ContactPersonController extends PersonalDataController {

    public TextField position;
    public TextField faxPhone;
    public TextField workingHours;
    public TextArea instructions;

    @Override

    public void initialize() {
        super.initialize();
        General.Contact.ContactPerson contactPerson = (General.Contact.ContactPerson) getData();

        if (contactPerson.getPosition() != null) {
            position.setText(contactPerson.getPosition());
        }
        if (contactPerson.getFaxPhone() != null) {
            faxPhone.setText(contactPerson.getFaxPhone());
        }
        if (contactPerson.getWorkHours() != null) {
            workingHours.setText(contactPerson.getWorkHours());
        }
        if (contactPerson.getContInstr() != null) {
            instructions.setText(contactPerson.getContInstr());
        }
    }

    @Override
    public void updateParent() {
        super.updateParent();

        General.Contact.ContactPerson contactPerson = (General.Contact.ContactPerson) getData();

        contactPerson.setPosition(position.getText());
        contactPerson.setFaxPhone(faxPhone.getText());
        contactPerson.setWorkHours(workingHours.getText());
        contactPerson.setContInstr(instructions.getText());

        ContactController controller = (ContactController) getMainController();
        General.Contact parentData = ((General.Contact) controller.getData());
        parentData.getContactPersonOrContactOrganisation().remove(controller.getItemToModify());
        parentData.getContactPersonOrContactOrganisation().add(contactPerson);

        controller.initialize();
    }
}