package bg.tusofia.controllers.general;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.controllers.WizardController;
import bg.tusofia.models.Dataset;
import bg.tusofia.models.General;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.xml.datatype.XMLGregorianCalendar;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SourceController extends AbstractController {

    public DatePicker datePicker;
    public TextField hourField;
    public TextField minField;

    public Button addMethod;
    public Button modMethod;
    public Button delMethod;

    public Button addParent;
    public Button modParent;
    public Button delParent;

    public TableView<General.Source.Child> table;
    public Button modifyChildButton;
    public Button deleteChildButton;
    private General.Source.Child childToBeModified = null;

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

        addMethod.setOnAction(event -> method("New method", new General.Source.Method()));
        modMethod.setOnAction(event -> method("Modify method", getSource().getMethod()));
        delMethod.setOnAction(event -> {
            setWorkingFileAsModified();
            getSource().setMethod(null);
            initialize();
        });
        addParent.setOnAction(event -> parent("New Parent", new General.Source.Parent()));
        modParent.setOnAction(event -> parent("Modify Parent", getSource().getParent()));
        delParent.setOnAction(event -> {
            setWorkingFileAsModified();
            getSource().setParent(null);
            initialize();
        });
    }

    @Override
    public void initialize() {

        if (getSource().getTimestamp() != null) {
            XMLGregorianCalendar date = getSource().getTimestamp();
            datePicker.setValue(LocalDate.of(date.getYear(), date.getMonth(), date.getDay()));
            hourField.setText(String.format("%02d", date.getHour()));
            minField.setText(String.format("%02d", date.getMinute()));
        }

        ///////////---BUTTONS---///////////
        addMethod.setDisable(false);
        modMethod.setDisable(true);
        delMethod.setDisable(true);

        if (getSource().getMethod() != null) {
            addMethod.setDisable(true);
            modMethod.setDisable(false);
            delMethod.setDisable(false);
        }

        addParent.setDisable(false);
        modParent.setDisable(true);
        delParent.setDisable(true);

        if (getSource().getParent() != null) {
            addParent.setDisable(true);
            modParent.setDisable(false);
            delParent.setDisable(false);
        }

        modifyChildButton.setDisable(true);
        deleteChildButton.setDisable(true);
        if (!getSource().getChild().isEmpty()) {
            modifyChildButton.setDisable(false);
            deleteChildButton.setDisable(false);
        }

        // Table view, data, columns and properties
        if (getSource().getChild() != null) {
            table.setItems(FXCollections.observableArrayList((getSource().getChild())));

            TableColumn nameCol = new TableColumn<>("Name");
            nameCol.setCellValueFactory(new PropertyValueFactory<>("childName"));

            table.getColumns().setAll(nameCol);
            table.setColumnResizePolicy(javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY);
        }
    }

    @Override
    public void updateParent() {
        if (getSource().getTimestamp() == null) {
            getSource().setTimestamp(new XMLGregorianCalendarImpl());
        }
        getSource().getTimestamp().setDay(datePicker.getValue().getDayOfMonth());
        getSource().getTimestamp().setMonth(datePicker.getValue().getMonthValue());
        getSource().getTimestamp().setYear(datePicker.getValue().getYear());
        getSource().getTimestamp().setTime(Integer.valueOf(hourField.getText()), Integer.valueOf(minField.getText()), 0);

        getSource().getChild().clear();
        getSource().getChild().addAll(table.getItems());

        WizardController controller = (WizardController) getMainController();
        ((Dataset) controller.getData()).getGeneral().setSource(getSource());
        controller.initialize();


    }

    @Override
    protected boolean validate() {
        try {
            int hours = Integer.valueOf(hourField.getText());
            int mins = Integer.valueOf(minField.getText());
            if ((0 <= hours && hours < 24)
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

    private void method(String stageName, General.Source.Method data) {
        addModifyCommonButtons(stageName, data, "/fxmls/general/method.fxml");
    }

    private void parent(String stageName, General.Source.Parent data) {
        addModifyCommonButtons(stageName, data, "/fxmls/general/parent.fxml");
    }

    private void child(String stageName, General.Source.Child data) {
        addModifyCommonButtons(stageName, data, "/fxmls/general/child.fxml");
    }

    //-------UTILITIES METHODS STARTS HERE-------
    private General.Source getSource() {
        return (General.Source) super.getData();
    }

    public void addChildClicked() {
        child("New child", new General.Source.Child());
    }

    public void modifyChildClicked() {
        ObservableList<?> selectedItem;
        selectedItem = table.getSelectionModel().getSelectedItems();
        childToBeModified = (General.Source.Child) selectedItem.get(0);
        child("Modify child", childToBeModified);
    }

    public void deleteChildClicked() {
        deleteTableRow(table);
        modifyChildButton.setDisable(false);
        deleteChildButton.setDisable(false);
    }

    public General.Source.Child getChildToBeModified() {
        return childToBeModified;
    }
}
