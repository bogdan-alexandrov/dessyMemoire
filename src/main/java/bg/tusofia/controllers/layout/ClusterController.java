package bg.tusofia.controllers.layout;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.controllers.WizardController;
import bg.tusofia.models.Cluster;
import bg.tusofia.models.Dataset;
import bg.tusofia.models.Structure;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ClusterController extends AbstractController {

    public TextField name;
    public TextField url;
    public Text structurePreview;
    public Button addStructure;
    public Button editStructure;
    public Button deleteStructure;
    public HBox structurePreviewHBox;

    @Override
    public void updateParent() {
        Cluster data = (Cluster) getData();
        if (!name.getText().isEmpty()) {
            data.setName(name.getText());
        }
        if (!url.getText().isEmpty()) {
            data.setURL(url.getText());
        }

        WizardController controller = (WizardController) getMainController();
        ((Dataset) controller.getData()).getLayout().getCluster().remove(controller.getClusterToBeModified());
        ((Dataset) controller.getData()).getLayout().getCluster().add(data);

        controller.initialize();
    }

    @Override
    protected boolean validate() {
        return ((Cluster) getData()).getStructure() != null && !url.getText().isEmpty() && !name.getText().isEmpty();
    }

    @Override
    protected String errorMessage() {
        String message;
        if (((Cluster) getData()).getStructure() == null) {
            message = "Please enter structure.";
        } else if (url.getText().isEmpty()) {
            message = "URL can't be empty";
        } else if (name.getText().isEmpty()) {
            message = "Name can't be empty";
        } else { // default message
            message = "Error";
        }
        return message;
    }

    @Override
    public void initialize() {
        Cluster data = (Cluster) getData();
        name.setText(data.getName());
        url.setText(data.getURL());
        if (data.getStructure() != null) {
            addStructure.setVisible(false);
            structurePreview.setText(data.getStructure().getPreview());
            structurePreviewHBox.setVisible(true);
        } else {
            addStructure.setVisible(true);
            structurePreviewHBox.setVisible(false);
        }
    }

    public void addStructure() {
        System.out.println("Adding Structure");
        structureButtons("Add Structure", new Structure());
    }

    public void editStructure() {
        System.out.println("Editing Structure");
        Cluster data = (Cluster) getData();
        structureButtons("Edit Structure", data.getStructure());
    }

    public void structureButtons(String stageName, Structure data) {
        addModifyCommonButtons(stageName, data, "/fxmls/layout/structure.fxml");
    }

    public void deleteStructure() {
        System.out.println("Deleting Structure");
        setWorkingFileAsModified();
        ((Cluster) getData()).setStructure(null);
        initialize();
    }
}