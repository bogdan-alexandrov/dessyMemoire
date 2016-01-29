package bg.tusofia.controllers.layout;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.models.Structure;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class StringsController extends AbstractController {

    public ChoiceBox<String> dropdown;
    public TextField value;

    @Override
    public void initialize() {
        String data = (String) getData();

        dropdown.setItems(FXCollections.observableArrayList("Literal", "Ragexp"));

        switch (getAdditionalInfoType()) {
            case LITERAL:
                dropdown.setValue("Literal");
                dropdown.setDisable(true);
                value.setText(data);
                break;
            case RAGEXP:
                dropdown.setValue("Ragexp");
                dropdown.setDisable(true);
                value.setText(data);
                break;
        }
    }

    @Override
    public void updateParent() {
        AbstractController controller = getMainController();
        if (controller instanceof StructureController) {
            if (dropdown.getValue().equals("Literal")) {
                ((Structure) controller.getData()).getLiteral().clear();
                ((Structure) controller.getData()).getLiteral().add(value.getText());
            }
            if (dropdown.getValue().equals("Ragexp")) {
                ((Structure) controller.getData()).setRegexp(value.getText());
            }
        }
        controller.initialize();
    }

    @Override
    protected boolean validate() {
        return !value.getText().isEmpty();
    }

    @Override
    protected String errorMessage() {
        return "Cannot be empty !";
    }
}
