package bg.tusofia.controllers.layout;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.models.SimpleItem;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class SimpleItemController extends AbstractController {
    public Text preview;
    public Button edit;
    public Button delete;
    public ChoiceBox numSystem;
    public TextField unit;
    public TextField length;
    public TextField format;
    public Button add;
    public TextArea description;
    public ChoiceBox typeBox;
    public HBox previewBox;
    public GridPane table;

    @Override
    public void initialize() {
        SimpleItem simpleItem = (SimpleItem) getData();
        numSystem.setItems(FXCollections.observableArrayList("roman",
                "decimal",
                "binary",
                "octal",
                "hexadecimal"));

        table.managedProperty().bind(table.visibleProperty());

        if (simpleItem.getType() != null && !simpleItem.getType().value().isEmpty()) {
            typeBox.setValue(simpleItem.getType().value().isEmpty());
        }
        unit.setText(simpleItem.getValue());
        if (simpleItem.getLength() != null) {
            length.setText(simpleItem.getLength().toString());
        }
        format.setText(simpleItem.getFormat());
        if (!simpleItem.getNumSystem().isEmpty()) {
            numSystem.setValue(simpleItem.getNumSystem());
        }
        if (simpleItem.getEnd() == null) {
            previewBox.setVisible(false);
            add.setVisible(true);
        } else {
            previewBox.setVisible(true);
            add.setVisible(false);
        }
        //TODO END
        //TODO description
    }

    @Override
    public void updateParent() {
        //todo parent
    }

    @Override
    protected boolean validate() {
        return false;
        //todo validate
    }

    @Override
    protected String errorMessage() {
        //todo errors
        return null;
    }
}
