package bg.tusofia.controllers.layout;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.controllers.WizardController;
import bg.tusofia.models.*;
import bg.tusofia.tools.CommonTools;
import bg.tusofia.tools.WorkingFile;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class TypedefController extends AbstractController {
    public TextField typeName;
    public Text preview;
    public Button previewDelete;
    public Button previewEdit;
    public HBox previewGroup;
    public GridPane buttonsGroup;

    @Override
    public void initialize() {
        Typedef data = (Typedef) getData();

        buttonsGroup.managedProperty().bind(buttonsGroup.visibleProperty());
        previewGroup.managedProperty().bind(previewGroup.visibleProperty());

        typeName.setText(data.getTypename());
        if (data.getLiteral() != null || data.getArray() != null
                || data.getSimpleItem() != null || data.getStructure() != null) {
            buttonsGroup.setVisible(Boolean.FALSE);
            previewGroup.setVisible(Boolean.TRUE);
            if (data.getLiteral() != null && !data.getLiteral().isEmpty()) {
                preview.setText("Literal : " + CommonTools.abbreviate(data.getLiteral(), 10));
                previewEdit.setOnAction(event -> editLiteral());
                previewDelete.setOnAction(event -> deleteLiteral());
            } else if (data.getSimpleItem() != null && !data.getSimpleItem().getTypeRef().isEmpty()) {
                preview.setText("SimpleItem : " + CommonTools.abbreviate(data.getSimpleItem().getTypeRef(), 10));
                previewEdit.setOnAction(event -> editSimpleItem());
                previewDelete.setOnAction(event -> deleteSimpleItem());
            } else if (data.getStructure() != null && !data.getStructure().getPreview().isEmpty()) {
                preview.setText("[S]: " + data.getStructure().getPreview());
                previewEdit.setOnAction(event -> editStructure());
                previewDelete.setOnAction(event -> deleteStructure());
            } else if (data.getArray() != null) {
                preview.setText("Array");
                previewEdit.setOnAction(event -> editArray());
                previewDelete.setOnAction(event -> deleteArray());
            }
        } else {
            buttonsGroup.setVisible(Boolean.TRUE);
            previewGroup.setVisible(Boolean.FALSE);
        }
    }

    @Override
    public void updateParent() {
        AbstractController controller = getMainController();
        if (controller instanceof WizardController) {
            ((Dataset) controller.getData()).getLayout().getTypedef().add(updateData());
        }
        if (controller instanceof SimpleItemController) {
            WorkingFile.getInstance().getDataset().getLayout().getTypedef().add(updateData());
            ((SimpleItem) controller.getData()).setTypeRef(typeName.getText());
        }
        controller.initialize();
    }

    private Typedef updateData() {
        Typedef typedef = (Typedef) getData();
        typedef.setTypename(typeName.getText());
        return typedef;
    }

    @Override
    protected boolean validate() {
        Typedef typedef = updateData();
        return (typedef.getTypename() != null && !typedef.getTypename().isEmpty()) &&
                (typedef.getArray() != null || typedef.getSimpleItem() != null
                        || typedef.getStructure() != null || typedef.getLiteral() != null);
    }

    @Override
    protected String errorMessage() {
        if ((typeName.getText().isEmpty())) {
            return "Please enter typename.";
        }
        return "Please add \"Simple Item\" or \"Array\" or \"Structure\" or \"Literal\".";
    }

    public void literalButtons(String stageName, String data) {
        updateData();
        addModifyCommonButtons(stageName, data, "/fxmls/layout/strings.fxml", AdditionalInfoTypes.LITERAL);
    }

    public void addLiteral() {
        System.out.println("Adding Literal");
        literalButtons("Add Literal", "");
    }

    public void editLiteral() {
        System.out.println("Editing Literal");
        Typedef data = (Typedef) getData();
        literalButtons("Add Literal", data.getLiteral());
    }

    public void deleteLiteral() {
        System.out.println("Deleting literal");
        setWorkingFileAsModified();
        ((Typedef) getData()).setLiteral(null);
        initialize();
    }

    public void structureButtons(String stageName, Structure data) {
        updateData();
        addModifyCommonButtons(stageName, data, "/fxmls/layout/structure.fxml");
    }

    public void addStructure() {
        System.out.println("Adding Structure");
        structureButtons("Add Structure", new Structure());
    }

    public void editStructure() {
        System.out.println("Editing Structure");
        Typedef data = (Typedef) getData();
        structureButtons("Edit Structure", data.getStructure());
    }

    public void deleteStructure() {
        System.out.println("Deleting structure");
        setWorkingFileAsModified();
        ((Typedef) getData()).setStructure(null);
        initialize();
    }

    public void simpleItemButtons(String stageName, SimpleItem data) {
        updateData();
        addModifyCommonButtons(stageName, data, "/fxmls/layout/simpleItem.fxml");
    }

    public void addSimpleItem() {
        simpleItemButtons("Add Simple Item", new SimpleItem());
    }

    public void editSimpleItem() {
        System.out.println("Editing Simple Item");
        Item data = (Item) getData();
        simpleItemButtons("Edit Simple Item", data.getSimpleItem());
    }

    public void deleteSimpleItem() {
        System.out.println("Deleting simple item");
        setWorkingFileAsModified();
        ((Typedef) getData()).setSimpleItem(null);
        initialize();
    }

    private void arrayButtons(String stageName, Array array) {
        updateData();
        addModifyCommonButtons(stageName, array, "/fxmls/layout/array.fxml");
    }

    public void addArray() {
        System.out.println("Adding Array");
        arrayButtons("Add array", new Array());
    }

    public void editArray() {
        System.out.println("Editing Array");
        Item data = (Item) getData();
        arrayButtons("Edit array", data.getArray());
    }

    public void deleteArray() {
        System.out.println("Deleting array");
        setWorkingFileAsModified();
        ((Typedef) getData()).setArray(null);
        initialize();
    }
}
