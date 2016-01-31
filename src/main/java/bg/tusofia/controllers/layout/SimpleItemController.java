package bg.tusofia.controllers.layout;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.models.SeparatorType;
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
    public ChoiceBox<String> numSystem;
    public TextField unit;
    public TextField length;
    public TextField format;
    public Button add;
    public TextArea description;
    public ChoiceBox<String> typeBox;
    public HBox previewBox;
    public GridPane table;

    @Override
    public void initialize() {
        //todo typeBox
        SimpleItem simpleItem = (SimpleItem) getData();
        numSystem.setItems(FXCollections.observableArrayList("roman",
                "decimal",
                "binary",
                "octal",
                "hexadecimal"));

        table.managedProperty().bind(table.visibleProperty());

        if (simpleItem.getType() != null && !simpleItem.getType().value().isEmpty()) {
            typeBox.setValue(simpleItem.getType().value());
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
            preview.setText(simpleItem.getEnd().getPreview());
        }
        try {
            if (simpleItem.getDescription() != null && simpleItem.getDescription().getAnnot() != null
                    && simpleItem.getDescription().getAnnot().get(0).getValue().isEmpty()) {
                description.setText(simpleItem.getDescription().getAnnot().get(0).getValue());
            }
        } catch (NullPointerException exp) {
            System.out.println("NPE");
        }
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

    public void addEnd() {
        SimpleItem data = (SimpleItem) getData();
        data.setEnd(new SeparatorType());
        addModifyCommonButtons("Add End", data, "/fxmls/layout/strings.fxml", AdditionalInfoTypes.END);
    }

    public void editEnd() {
        SimpleItem data = (SimpleItem) getData();
        addModifyCommonButtons("Add End", data, "/fxmls/layout/strings.fxml", AdditionalInfoTypes.END);
    }

    public void delete() {
        ((SimpleItem) getData()).setEnd(null);
        initialize();
    }
}













