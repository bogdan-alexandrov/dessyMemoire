package bg.tusofia.controllers.layout;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.models.*;
import bg.tusofia.tools.CommonTools;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.math.BigInteger;

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
    public ChoiceBox<String> typedefBox;
    public TextField type;
    public HBox previewBox;
    public GridPane table;
    public Button addTypedef;
    public ChoiceBox<String> typeBox;

    @Override
    public void initialize() {
        previewBox.managedProperty().bind(previewBox.visibleProperty());

        SimpleItem simpleItem = (SimpleItem) getData();

        typeBox.setItems(FXCollections.observableArrayList(Predefined.valuesAsString()));
        typeBox.getItems().add(0, "");
        if (simpleItem.getType() != null && !simpleItem.getType().value().isEmpty()) {
            typeBox.setValue(simpleItem.getType().value());
        }

        typedefBox.setItems(FXCollections.observableArrayList(CommonTools.getListOfTypedef()));

        if (simpleItem.getTypeRef() != null && !simpleItem.getTypeRef().isEmpty()) {
            typedefBox.setValue(simpleItem.getTypeRef());
        }

        numSystem.setItems(FXCollections.observableArrayList("roman",
                "decimal",
                "binary",
                "octal",
                "hexadecimal"));

        table.managedProperty().bind(table.visibleProperty());

        if (simpleItem.getType() != null && !simpleItem.getType().value().isEmpty()) {
            typeBox.setValue(simpleItem.getType().value());
        }
        unit.setText(simpleItem.getUnit());
        if (simpleItem.getLength() != null) {
            length.setText(simpleItem.getLength().toString());
        }
        length.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String character = event.getCharacter();
            if (!isNumeric(character)) {
                event.consume();
            }
        });

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
                    && !simpleItem.getDescription().getAnnot().get(0).getValue().isEmpty()) {
                description.setText(simpleItem.getDescription().getAnnot().get(0).getValue());
            }
        } catch (NullPointerException exp) {
            System.out.println("NPE");
        }
    }

    @Override
    public void updateParent() {
        ItemController itemController = (ItemController) getMainController();
        ((Item) itemController.getData()).setSimpleItem(updateData());
        itemController.initialize();
    }

    private SimpleItem updateData() {
        SimpleItem simpleItem = (SimpleItem) getData();
        if (typeBox.getValue() != null && !typeBox.getValue().isEmpty()) {
            simpleItem.setType(Predefined.fromValue(typeBox.getValue()));
        } else {
            simpleItem.setType(null);
        }
        simpleItem.setTypeRef(typedefBox.getValue());
        simpleItem.setUnit(unit.getText());
        if (length.getText() != null && !length.getText().isEmpty()) {
            simpleItem.setLength(new BigInteger(length.getText()));
        }
        simpleItem.setFormat(format.getText());
        simpleItem.setNumSystem(numSystem.getValue());
        Description desc = new Description();
        desc.getAnnot().clear();
        desc.getAnnot().add(new Description.Annot(description.getText()));
        simpleItem.setDescription(desc);

        return simpleItem;
    }

    @Override
    protected boolean validate() {
        return (typedefBox != null && typedefBox.getValue() != null && !typedefBox.getValue().isEmpty()) ||
                (typeBox != null && typeBox.getValue() != null && !typeBox.getValue().isEmpty());
    }

    @Override
    protected String errorMessage() {
        return "Please enter type or type reference.";
    }

    public void addEnd() {
        SimpleItem data = updateData();
        data.setEnd(new SeparatorType());
        addModifyCommonButtons("Add End", data, "/fxmls/layout/strings.fxml", AdditionalInfoTypes.END);
    }

    public void editEnd() {
        SimpleItem data = updateData();

        addModifyCommonButtons("Add End", data, "/fxmls/layout/strings.fxml", AdditionalInfoTypes.END);
    }

    public void delete() {
        ((SimpleItem) getData()).setEnd(null);
        initialize();
    }

    public void addTypedef() {
        System.out.println("Adding Typedef");
        addModifyCommonButtons("Add Typedef", new Typedef(), "/fxmls/layout/typedef.fxml");
    }
}