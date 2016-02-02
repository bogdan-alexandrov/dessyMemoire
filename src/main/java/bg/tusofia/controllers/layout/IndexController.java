package bg.tusofia.controllers.layout;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.models.Array;
import bg.tusofia.models.Index;
import bg.tusofia.models.IntType;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.math.BigInteger;

public class IndexController extends AbstractController {
    public ChoiceBox<String> type;
    public TextField first;
    public TextField last;
    public TextField step;

    @Override
    public void initialize() {
        Index data = (Index) getData();
        type.setItems(FXCollections.observableArrayList("int_8", "int_16", "int_32"));
        if (data.getType() != null && !data.getType().value().isEmpty()) {
            type.setValue(data.getType().value());
        }

        first.setText(data.getFirst() == null ? "" : data.getFirst());
        last.setText(data.getLast() == null ? "" : data.getLast());
        step.setText(data.getStep().toString());
        step.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String character = event.getCharacter();
            if (!isNumeric(character)) {
                event.consume();
            }
        });
    }

    @Override
    public void updateParent() {
        Index data = (Index) getData();

        data.setType(IntType.fromValue(type.getValue()));
        data.setFirst(first.getText());
        data.setLast(last.getText());

        try {
            data.setStep(new BigInteger(step.getText()));
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException !");
        }

        ArrayController controller = (ArrayController) getMainController();
        ((Array) controller.getData()).setIndex(data);
        controller.initialize();
    }

    @Override
    protected boolean validate() {
        return !first.getText().isEmpty() && !last.getText().isEmpty();
    }

    @Override
    protected String errorMessage() {
        if (first.getText().isEmpty()) {
            return "\"First\" is required field";
        }
        return "\"Last\" is required field";
    }
}
