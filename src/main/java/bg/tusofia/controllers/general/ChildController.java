package bg.tusofia.controllers.general;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.models.General;
import bg.tusofia.models.ProcType;
import javafx.scene.control.TextField;

import java.util.List;

public class ChildController extends AbstractController {

    public TextField name;
    public TextField postProcedureName;
    public TextField postProcedureUri;

    @Override
    public void initialize() {
        General.Source.Child childData = (General.Source.Child) getData();

        //Name
        if (childData.getChildName() != null) {
            name.setText(childData.getChildName());
        }
        //PreProcedure Name
        if (childData.getPostProcedure() != null) {
            if (childData.getPostProcedure().getName() != null) {
                postProcedureName.setText(childData.getPostProcedure().getName());
            }
            //PreProcedure Name
            if (childData.getPostProcedure().getURI() != null) {
                postProcedureUri.setText(childData.getPostProcedure().getURI());
            }
        }
    }

    @Override
    public void updateParent() {
        General.Source.Child childData = (General.Source.Child) getData();

        childData.setChildName(name.getText());
        if (childData.getPostProcedure() == null) {
            childData.setPostProcedure(new ProcType());
        }
        childData.getPostProcedure().setName(postProcedureName.getText());
        childData.getPostProcedure().setURI(postProcedureUri.getText());

        SourceController controller = (SourceController) getMainController();
        List<General.Source.Child> children = ((General.Source) controller.getData()).getChild();
        children.remove(controller.getChildToBeModified());
        children.add(childData);
        controller.initialize();
    }

    @Override
    protected boolean validate() {
        return !name.getText().isEmpty() && !postProcedureName.getText().isEmpty();
    }

    @Override
    protected String errorMessage() {
        String result = "Error !";
        if (name.getText().isEmpty()) {
            result = "Name can not be empty !";
        }
        if (postProcedureName.getText().isEmpty()) {
            result = "PostProcedure's name can not be empty !";
        }
        return result;
    }
}
