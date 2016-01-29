package bg.tusofia.controllers.layout;

import bg.tusofia.controllers.AbstractController;
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
                preview.setText("[Ragexp] " + CommonTools.abbreviate(data.getRegexp(), 8));
                editButton.setOnAction(event -> editRagexp());
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
        //todo... 4 update parent
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

    public void addRagexp() {
        System.out.println("Adding ragexp");
        structureButtons("Add Ragexp", "", AdditionalInfoTypes.RAGEXP);
    }

    public void editLiteral() {
        System.out.println("Adding Literal");
        Structure data = (Structure) getData();
        structureButtons("Add Literal", data.getLiteral().get(0), AdditionalInfoTypes.LITERAL);
    }

    public void editRagexp() {
        System.out.println("Editing ragexp");
        Structure data = (Structure) getData();
        structureButtons("Edit Ragexp", data.getRegexp(), AdditionalInfoTypes.RAGEXP);
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
        //todo... 1 add Item
    }

    private void editItem() {
        //todo... 2 edit Item
    }

    private void deleteItem() {
        //todo... 3 delete Item
    }

}
