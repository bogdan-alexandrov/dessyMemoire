package bg.tusofia.controllers.layout;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.models.Array;
import bg.tusofia.models.Item;
import bg.tusofia.models.SimpleItem;
import bg.tusofia.models.Structure;
import bg.tusofia.tools.CommonTools;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ItemController extends AbstractController {
    public TextField name;
    public Text type;
    public VBox buttonsBox;
    public HBox previewBox;
    public Text preview;
    public Button deleteButton;
    public Button editButton;

    @Override
    public void initialize() {
        Item item = (Item) getData();

        buttonsBox.managedProperty().bind(buttonsBox.visibleProperty());
        previewBox.managedProperty().bind(previewBox.visibleProperty());

        name.setText(item.getName());
        if (!item.getType().isEmpty()) {
            type.setText(item.getType());
        }

        if (item.getSimpleItem() == null && item.getArray() == null
                && item.getStructure() == null) {
            buttonsBox.setVisible(true);
            previewBox.setVisible(false);
        } else {
            buttonsBox.setVisible(false);
            previewBox.setVisible(true);
            if (item.getSimpleItem() != null && !item.getSimpleItem().getTypeRef().isEmpty()) {
                preview.setText("[SimpleItem] " + CommonTools.abbreviate(item.getSimpleItem().getTypeRef(), 8));
                editButton.setOnAction(event -> editSimpleItem());
                deleteButton.setOnAction(event -> deleteSimpleItem());
            }
            if (item.getArray() != null) {
                preview.setText("[Array]");
                editButton.setOnAction(event -> editArray());
                deleteButton.setOnAction(event -> deleteArray());
            }
            if (item.getStructure() != null) {
                preview.setText(item.getStructure().getPreview());
                editButton.setOnAction(event -> editStructure());
                deleteButton.setOnAction(event -> deleteStructure());
            }
        }
    }

    @Override
    public void updateParent() {
        AbstractController controller = getMainController();
        if (controller instanceof StructureController) {
            ((Structure) controller.getData()).getItem().clear();
            ((Structure) controller.getData()).getItem().add(updateData());
        }
        if (controller instanceof ArrayController){
            ((Array) controller.getData()).getItem().clear();
            ((Array) controller.getData()).getItem().add(updateData());
        }
        controller.initialize();
    }

    private Item updateData() {
        Item item = (Item) getData();
        if(name.getText()==null){
            item.setName("");
        } else {
            item.setName(name.getText());
        }
        return item;
    }

    @Override
    protected boolean validate() {
        Item item = (Item) getData();
        return !((item.getSimpleItem() == null && item.getArray() == null
                && item.getStructure() == null) || (name == null || name.getText().isEmpty()));
    }

    @Override
    protected String errorMessage() {
        if (name == null || name.getText().isEmpty()) {
            return "Please fill the name";
        }
        return "SimpleItem/Array/Structure is obligatory field";
    }

    public void structureButtons(String stageName, Structure data) {
        updateData();
        addModifyCommonButtons(stageName, data, "/fxmls/layout/structure.fxml");
    }

    public void structure() {
        System.out.println("Adding Structure");
        structureButtons("Add Structure", new Structure());
    }

    private void editStructure() {
        System.out.println("Editing Structure");
        Item data = (Item) getData();
        structureButtons("Edit Structure", data.getStructure());
    }

    private void deleteStructure() {
        System.out.println("Deleting structure");
        setWorkingFileAsModified();
        ((Item) getData()).setStructure(null);
        initialize();
    }

    private void arrayButtons(String stageName, Array array) {
        updateData();
        addModifyCommonButtons(stageName, array, "/fxmls/layout/array.fxml");
    }

    public void array() {
        System.out.println("Adding Array");
        arrayButtons("Add array", new Array());
    }

    private void editArray() {
        System.out.println("Editing Array");
        Item data = (Item) getData();
        arrayButtons("Edit array", data.getArray());
    }

    private void deleteArray() {
        System.out.println("Deleting array");
        setWorkingFileAsModified();
        ((Item) getData()).setArray(null);
        initialize();
    }

    public void simpleItemButtons(String stageName, SimpleItem data) {
        updateData();
        addModifyCommonButtons(stageName, data, "/fxmls/layout/simpleItem.fxml");
    }

    public void simpleItem() {
        System.out.println("Adding Simple Item");
        simpleItemButtons("Add Simple Item", new SimpleItem());
    }

    private void editSimpleItem() {
        System.out.println("Editing Simple Item");
        Item data = (Item) getData();
        simpleItemButtons("Edit Simple Item", data.getSimpleItem());
    }

    private void deleteSimpleItem() {
        System.out.println("Deleting simple item");
        setWorkingFileAsModified();
        ((Item) getData()).setSimpleItem(null);
        initialize();
    }
}
