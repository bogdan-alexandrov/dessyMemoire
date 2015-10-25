package bg.tusofia.controllers.general;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.controllers.WizardController;
import bg.tusofia.models.Dataset;
import bg.tusofia.models.General;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class VersionController extends AbstractController {

    public TextField versionNumber;

    public DatePicker datePicker;
    public TextField hourField;
    public TextField minField;

    public TextArea modificationInfo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setShowWeekNumbers(false);

        hourField.textProperty().addListener((arg0, arg1, newValue) -> {
            if (!isNumeric(newValue)) {
                hourField.setText("");
            } else {
                if (newValue.length() >= 2) {
                    hourField.setText(newValue.substring(0, 2));
                }
            }
        });
        minField.textProperty().addListener((arg0, arg1, newValue) -> {
            if (!isNumeric(newValue)) {
                minField.setText("");
            } else {
                if (newValue.length() >= 2) {
                    minField.setText(newValue.substring(0, 2));
                }
            }
        });
    }

    @Override
    public void initialize() {
        if (getVersion().getVerTimestamp() != null) {
            XMLGregorianCalendar date = getVersion().getVerTimestamp();
            datePicker.setValue(LocalDate.of(date.getYear(), date.getMonth(), date.getDay()));
            hourField.setText(String.format("%02d", date.getHour()));
            minField.setText(String.format("%02d", date.getMinute()));
        }

        if (getVersion().getVersionNo() == null) {
            versionNumber.setText("");
        } else {
            versionNumber.setText(String.valueOf(getVersion().getVersionNo()));
        }

        modificationInfo.setText(getVersion().getModificationInfo());
    }

    @Override
    public void updateParent() {
        if (getVersion().getVerTimestamp() == null) {
            getVersion().setVerTimestamp(new XMLGregorianCalendarImpl());
        }
        getVersion().getVerTimestamp().setDay(datePicker.getValue().getDayOfMonth());
        getVersion().getVerTimestamp().setMonth(datePicker.getValue().getMonthValue());
        getVersion().getVerTimestamp().setYear(datePicker.getValue().getYear());
        getVersion().getVerTimestamp().setTime(Integer.valueOf(hourField.getText()), Integer.valueOf(minField.getText()), 0);

        getVersion().setVersionNo(convertVersionNumber(versionNumber.getText()));
        getVersion().setModificationInfo(modificationInfo.getText());

        WizardController controller = (WizardController) getMainController();
        ((Dataset) controller.getData()).getGeneral().setVersion(getVersion());
        controller.initialize();
    }

    @Override
    protected boolean validate() {
        try {
            int hours = Integer.valueOf(hourField.getText());
            int mins = Integer.valueOf(minField.getText());
            if (validateVersionNumber(versionNumber.getText())
                    && (0 <= hours && hours < 24)
                    && (0 <= mins && mins < 60)
                    && datePicker.getValue() != null) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    protected String errorMessage() {
        if (!validateVersionNumber(versionNumber.getText())) {
            return "Invalid version number !";
        }

        int hours, mins;
        try {
            hours = Integer.valueOf(hourField.getText());
            mins = Integer.valueOf(minField.getText());
        } catch (Exception e) {
            hours = -1;
            mins = -1;
        }

        if (datePicker.getValue() == null) {
            return "Invalid date !";
        }
        if (!((0 <= hours && hours < 24)
                && (0 <= mins && mins < 60))) {
            return "Invalid time !";
        }
        return "Error !";
    }

    //-------UTILITIES METHODS STARTS HERE-------
    private General.Version getVersion() {
        return (General.Version) super.getData();
    }

    private boolean validateVersionNumber(String stringValue) {
        try {
            convertVersionNumber(stringValue);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private BigDecimal convertVersionNumber(String stringValue) {
        BigDecimal myDec;
        myDec = new BigDecimal(stringValue);
        return myDec;
    }
}
