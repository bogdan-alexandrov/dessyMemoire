package bg.tusofia.controllers.layout;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.models.SeparatorType;
import bg.tusofia.models.SimpleItem;
import bg.tusofia.models.Structure;
import bg.tusofia.models.Typedef;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class StringsController extends AbstractController {

    public ChoiceBox<String> dropdown;
    public TextField value;

    @Override
    public void initialize() {
        dropdown.setItems(FXCollections.observableArrayList("Literal", "Regexp"));

        String data;
        switch (getAdditionalInfoType()) {
            case LITERAL:
                data = (String) getData();
                dropdown.setValue("Literal");
                dropdown.setDisable(true);
                value.setText(data);
                break;
            case REGEXP:
                data = (String) getData();
                dropdown.setValue("Regexp");
                dropdown.setDisable(true);
                value.setText(data);
                break;
            case END:
                if (((SimpleItem) getData()).getEnd().getRegexp() != null &&
                        !((SimpleItem) getData()).getEnd().getRegexp().isEmpty()) {
                    dropdown.setValue("Regexp");
                    value.setText(((SimpleItem) getData()).getEnd().getRegexp());
                } else if (((SimpleItem) getData()).getEnd().getLiteral() != null &&
                        !((SimpleItem) getData()).getEnd().getLiteral().isEmpty()) {
                    dropdown.setValue("Literal");
                    value.setText(((SimpleItem) getData()).getEnd().getLiteral());
                }
                break;
            default:
                dropdown.setValue("Literal");
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
            if (dropdown.getValue().equals("Regexp")) {
                ((Structure) controller.getData()).setRegexp(value.getText());
            }
        } else if (controller instanceof SimpleItemController) {
            SeparatorType separatorType = new SeparatorType();
            switch (dropdown.getValue()) {
                case "Literal":
                    separatorType.setLiteral(value.getText());
                    break;
                case "Regexp":
                    separatorType.setRegexp(value.getText());
                    break;
            }
            ((SimpleItem) controller.getData()).setEnd(separatorType);
        }  else if (controller instanceof TypedefController){
            ((Typedef) controller.getData()).setLiteral(value.getText());
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
