package bg.tusofia.controllers.general;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.models.General;
import bg.tusofia.models.ProcType;
import javafx.scene.control.TextField;

public class ParentController extends AbstractController {

    public TextField name;
    public TextField preProcedureName;
    public TextField preProcedureUri;

    @Override
    public void initialize() {
        General.Source.Parent parentData = (General.Source.Parent) getData();

        //Name
        if (parentData.getParentName() != null) {
            name.setText(parentData.getParentName());
        }
        //PreProcedure Name
        if (parentData.getPreProcedure() != null) {
            if (parentData.getPreProcedure().getName() != null) {
                preProcedureName.setText(parentData.getPreProcedure().getName());
            }
            //PreProcedure Name
            if (parentData.getPreProcedure().getURI() != null) {
                preProcedureUri.setText(parentData.getPreProcedure().getURI());
            }
        }
    }

    @Override
    public void updateParent() {
        General.Source.Parent parentData = (General.Source.Parent) getData();

        parentData.setParentName(name.getText());
        if (parentData.getPreProcedure() == null) {
            parentData.setPreProcedure(new ProcType());
        }
        parentData.getPreProcedure().setName(preProcedureName.getText());
        parentData.getPreProcedure().setURI(preProcedureUri.getText());

        SourceController controller = (SourceController) getMainController();
        ((General.Source) controller.getData()).setParent(parentData);
        controller.initialize();
    }

    @Override
    protected boolean validate() {
        return !name.getText().isEmpty() && !preProcedureName.getText().isEmpty();
    }

    @Override
    protected String errorMessage() {
        String result = "Error !";
        if (name.getText().isEmpty()) {
            result = "Name can not be empty !";
        }
        if (preProcedureName.getText().isEmpty()) {
            result = "PreProcedure's name can not be empty !";
        }
        return result;
    }
}
