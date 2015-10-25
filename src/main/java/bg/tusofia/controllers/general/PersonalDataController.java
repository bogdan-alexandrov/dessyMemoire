package bg.tusofia.controllers.general;


import bg.tusofia.controllers.AbstractController;
import bg.tusofia.models.Name;
import bg.tusofia.models.PersAddress;
import bg.tusofia.models.PersonalData;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

public class PersonalDataController extends AbstractController {

    public TextField firstName;
    public TextField lastName;
    public TextField country;
    public TextField city;
    public TextField postCode;
    public TextField phone;
    public TextField email;
    public TextArea address;

    @Override
    public void initialize() {
        PersonalData personalData = (PersonalData) getData();

        if (personalData.getName() == null) {
            personalData.setName(new Name());
        }
        if (personalData.getName().getFirstName() != null) {
            firstName.setText(personalData.getName().getFirstName());
        }
        if (personalData.getName().getFamilyName() != null) {
            lastName.setText(personalData.getName().getFamilyName());
        }

        PersAddress address = new PersAddress();
        if (personalData.getPersAddress() != null) {
            address = personalData.getPersAddress();
        }

        if (address.getCountry() != null) {
            country.setText(address.getCountry());
        }
        if (address.getCity() != null) {
            city.setText(address.getCity());
        }
        if (address.getPostcode() != null) {
            postCode.setText(address.getPostcode());
        }
        if (address.getVoicePhone() != null) {
            phone.setText(address.getVoicePhone().toString());
        }
        if (!address.getEmail().isEmpty()) {
            email.setText(address.getEmail().get(0));
        }
        if (address.getAddress() != null) {
            this.address.setText(address.getAddress());
        }
    }

    @Override
    public void updateParent() {
        PersonalData personalData = (PersonalData) getData();

        //Name
        Name name = new Name();
        name.setFirstName(firstName.getText());
        name.setFamilyName(lastName.getText());
        personalData.setName(name);

        //Address
        PersAddress address = new PersAddress();
        address.setCountry(country.getText());
        address.setCity(city.getText());
        address.setPostcode(postCode.getText());
        address.setVoicePhone(phone.getText());
        address.getEmail().clear();
        address.getEmail().add(email.getText());
        address.setAddress(this.address.getText());
        personalData.setPersAddress(address);

        AbstractController parentController = getMainController();
        if (getAdditionalInfoType() != null) {
            List<PersonalData> additionalInfo = parentController.getAdditionalData().get(getAdditionalInfoType());

            switch (getAdditionalInfoType()) {
                case OWNERSHIP:
                case DISTRIBUTION_RIGHTS:
                case READ_RIGHTS:
                    additionalInfo.remove(((AccessRightsController) parentController).getPersonalDataToBeModified());
                    break;
            }
            additionalInfo.add(personalData);
            parentController.getAdditionalData().put(getAdditionalInfoType(), additionalInfo);
        }
        parentController.initialize();
    }

    @Override
    protected boolean validate() {
        if (firstName.getText().isEmpty()) {
            return false;
        }
        if (lastName.getText().isEmpty()) {
            return false;
        }
        if (country.getText().isEmpty()) {
            return false;
        }
        if (city.getText().isEmpty()) {
            return false;
        }
        if (postCode.getText().isEmpty()) {
            return false;
        }
        if (address.getText().isEmpty()) {
            return false;
        }
        return isNumeric(phone.getText());
    }

    @Override
    protected String errorMessage() {
        if (firstName.getText().isEmpty() || lastName.getText().isEmpty()) {
            return "Name can not be empty !";
        }
        if (country.getText().isEmpty()) {
            return "Country can not be empty !";
        }
        if (city.getText().isEmpty()) {
            return "City can not be empty !";
        }
        if (postCode.getText().isEmpty()) {
            return "Post code can not be empty !";
        }
        if (address.getText().isEmpty()) {
            return "The address can not be empty !";
        }
        if (!isNumeric(phone.getText())) {
            return "Please enter valid phone number !";
        }
        return "Validation error ! ";
    }
}
