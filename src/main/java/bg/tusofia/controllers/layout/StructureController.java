package bg.tusofia.controllers.layout;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.models.Cluster;
import bg.tusofia.models.Item;
import bg.tusofia.models.Structure;
import bg.tusofia.tools.CommonTools;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class StructureController extends AbstractController {

    public HBox previewBox;
    public GridPane choiceBox;
    public Text preview;
    public Button editButton;
    public Button deleteButton;

    @Override
    public void initialize() {
        Structure data = (Structure) getData();
        choiceBox.managedProperty().bind(choiceBox.visibleProperty());
        previewBox.managedProperty().bind(previewBox.visibleProperty());

        if ((data.getLiteral() == null || data.getLiteral().isEmpty()) && data.getRegexp() == null
                && (data.getItem() == null || data.getItem().isEmpty())) {
            choiceBox.setVisible(true);
            previewBox.setVisible(false);
        } else {
            choiceBox.setVisible(false);
            previewBox.setVisible(true);
            if (data.getLiteral() != null && !data.getLiteral().isEmpty()) {
                preview.setText("[Literal] " + CommonTools.abbreviate(data.getLiteral().get(0), 8));
                editButton.setOnAction(event -> editLiteral());
                deleteButton.setOnAction(event -> deleteLiteral());
            }
            if (data.getRegexp() != null) {
                preview.setText("[Regexp] " + CommonTools.abbreviate(data.getRegexp(), 8));
                editButton.setOnAction(event -> editRegexp());
                deleteButton.setOnAction(event -> deleteRagexp());
            }
            if (data.getItem() != null && !data.getItem().isEmpty()) {
                preview.setText(CommonTools.abbreviate(data.getItem().get(0).getName(), 8));
                editButton.setOnAction(event -> editItem());
                deleteButton.setOnAction(event -> deleteItem());
            }
        }
    }

    @Override
    public void updateParent() {
        AbstractController controller = getMainController();
        if (controller instanceof ClusterController) {
            ((Cluster) controller.getData()).setStructure((Structure) getData());
        } else if (controller instanceof ItemController) {
            ((Item) controller.getData()).setStructure((Structure) getData());
        }
        controller.initialize();
    }

    @Override
    protected boolean validate() {
        Structure data = (Structure) getData();
        if (data.getLiteral() != null && !data.getLiteral().isEmpty()) {
            return true;
        }
        if (data.getRegexp() != null && !data.getRegexp().isEmpty()) {
            return true;
        }
        if (data.getItem() != null && !data.getItem().isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    protected String errorMessage() {
        return "Please choose one of the three options.";
    }

    public void addLiteral() {
        System.out.println("Adding Literal");
        structureButtons("Add Literal", "", AdditionalInfoTypes.LITERAL);
    }

    public void addRegexp() {
        System.out.println("Adding regexp");
        structureButtons("Add Regexp", "", AdditionalInfoTypes.REGEXP);
    }

    public void editLiteral() {
        System.out.println("Adding Literal");
        Structure data = (Structure) getData();
        structureButtons("Add Literal", data.getLiteral().get(0), AdditionalInfoTypes.LITERAL);
    }

    public void editRegexp() {
        System.out.println("Editing regexp");
        Structure data = (Structure) getData();
        structureButtons("Edit Regexp", data.getRegexp(), AdditionalInfoTypes.REGEXP);
    }

    private void deleteLiteral() {
        System.out.println("Deleting literal");
        setWorkingFileAsModified();
        ((Structure) getData()).getLiteral().clear();
        initialize();
    }

    private void deleteRagexp() {
        System.out.println("Deleting ragexp");
        setWorkingFileAsModified();
        ((Structure) getData()).setRegexp(null);
        initialize();
    }

    public void structureButtons(String stageName, String data, AdditionalInfoTypes structureType) {
        addModifyCommonButtons(stageName, data, "/fxmls/layout/strings.fxml", structureType);
    }

    public void addItem() {
        itemButtons("Add Item", new Item());
    }

    private void editItem() {
        Structure data = (Structure) getData();
        if (data.getItem() != null && !data.getItem().isEmpty()) {
            itemButtons("Add Item", data.getItem().get(0));
        }
    }

    private void deleteItem() {
        System.out.println("Deleting item");
        setWorkingFileAsModified();
        ((Structure) getData()).getItem().clear();
        initialize();
    }

    public void itemButtons(String stageName, Item data) {
        addModifyCommonButtons(stageName, data, "/fxmls/layout/item.fxml");
    }
}
