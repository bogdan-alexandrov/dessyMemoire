package bg.tusofia.controllers.layout;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.models.Array;
import bg.tusofia.models.Index;
import bg.tusofia.models.Item;
import bg.tusofia.models.SeparatorType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ArrayController extends AbstractController {
    public TextField length;
    public HBox previewEnd;
    public Text previewTextEnd;
    public Button endB;
    public HBox previewIndex;
    public Text previewTextIndex;
    public Button indexB;
    public HBox previewSeparator;
    public Text previewTextSeparator;
    public Button separatorB;
    public HBox previewItem;
    public Text previewTextItem;
    public Button itemB;

    @Override
    public void initialize() {
        Array data = (Array) getData();

        previewEnd.managedProperty().bind(previewEnd.visibleProperty());
        endB.managedProperty().bind(endB.visibleProperty());
        previewIndex.managedProperty().bind(previewIndex.visibleProperty());
        previewSeparator.managedProperty().bind(previewSeparator.visibleProperty());
        previewItem.managedProperty().bind(previewItem.visibleProperty());

        length.setText(data.getLength());

        if (data.getEndCriteria() != null) {
            previewEnd.setVisible(true);
            previewTextEnd.setText(data.getEndCriteria().getPreview());
            endB.setVisible(false);
        } else {
            endB.setVisible(true);
            previewEnd.setVisible(false);
        }
        if (data.getItem() != null && !data.getItem().isEmpty()) {
            previewItem.setVisible(true);
            previewTextItem.setText(data.getItem().get(0).preview());
            itemB.setVisible(false);
        } else {
            itemB.setVisible(true);
            previewItem.setVisible(false);
        }
        if (data.getSeparator() != null) {
            previewSeparator.setVisible(true);
            previewTextSeparator.setText(data.getSeparator().getPreview());
            separatorB.setVisible(false);
        } else {
            separatorB.setVisible(true);
            previewSeparator.setVisible(false);
        }
        if (data.getIndex() != null) {
            previewIndex.setVisible(true);
            previewTextIndex.setText("Index");
            indexB.setVisible(false);
        } else {
            indexB.setVisible(true);
            previewIndex.setVisible(false);
        }
    }

    @Override
    public void updateParent() {
        //todo update
    }

    @Override
    protected boolean validate() {
        return false;
        //todo validate
    }

    @Override
    protected String errorMessage() {
        return null;
        //todo errors
    }

    public void indexButtons(String stageName, Index data) {
        addModifyCommonButtons(stageName, data, "/fxmls/layout/index.fxml");
    }

    public void addIndex() {
        indexButtons("Add Index", new Index());
    }

    public void editIndex() {
        Array data = (Array) getData();
        setWorkingFileAsModified();
        indexButtons("Edit Index", data.getIndex());
        initialize();
    }

    public void deleteIndex() {
        Array data = (Array) getData();
        data.setIndex(null);
    }

    public void itemButtons(String stageName, Item data) {
        addModifyCommonButtons(stageName, data, "/fxmls/layout/item.fxml");
    }

    public void addItem() {
        itemButtons("Add Item", new Item());
    }

    public void editItem() {
        Array data = (Array) getData();
        if (data.getItem() != null && !data.getItem().isEmpty()) {
            itemButtons("Add Item", data.getItem().get(0));
        }
    }

    public void deleteItem() {
        System.out.println("Deleting item");
        setWorkingFileAsModified();
        ((Array) getData()).getItem().clear();
        initialize();
    }

    public void addEnd() {
        Array data = (Array) getData();
        data.setEndCriteria(new SeparatorType());
        addModifyCommonButtons("Add End", data, "/fxmls/layout/strings.fxml", AdditionalInfoTypes.END);
    }

    public void editEnd() {
        Array data = (Array) getData();
        addModifyCommonButtons("Add End", data, "/fxmls/layout/strings.fxml", AdditionalInfoTypes.END);
    }

    public void deleteEnd() {
        ((Array) getData()).setEndCriteria(null);
        initialize();
    }

    public void addSeparator() {
        Array data = (Array) getData();
        data.setSeparator(new SeparatorType());
        addModifyCommonButtons("Add Separator", data, "/fxmls/layout/strings.fxml", AdditionalInfoTypes.SEPARATOR);
    }

    public void editSeparator() {
        Array data = (Array) getData();
        addModifyCommonButtons("Add Separator", data, "/fxmls/layout/strings.fxml", AdditionalInfoTypes.SEPARATOR);
    }

    public void deleteSeparator() {
        System.out.println("Deleting separator");
        setWorkingFileAsModified();
        ((Array) getData()).setSeparator(null);
        initialize();
    }
}
