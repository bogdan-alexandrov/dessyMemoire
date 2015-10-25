package bg.tusofia.controllers.general;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.models.General;
import bg.tusofia.models.ProcType;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MethodController extends AbstractController {

    public TextField instrument;
    public TextField procTypeName;
    public TextField procTypeUri;
    public TableView<ProcType> table;

    @Override
    public void initialize() {
        General.Source.Method methodData = (General.Source.Method) getData();
        if (methodData.getInstrument() != null) {
            instrument.setText(methodData.getInstrument());
        }

        // Table view, data, columns and properties
        if (methodData.getProcedure() != null) {
            table.setItems(FXCollections.observableArrayList((methodData.getProcedure())));

            TableColumn<ProcType, Object> nameCol = new TableColumn<>("Name");
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            TableColumn uriCol = new TableColumn("URI");
            uriCol.setCellValueFactory(new PropertyValueFactory("URI"));

            table.getColumns().setAll(nameCol, uriCol);
            table.setPrefWidth(75);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        }
    }

    @Override
    public void updateParent() {
        General.Source.Method methodData = (General.Source.Method) getData();
        methodData.getProcedure().clear();
        methodData.getProcedure().addAll(table.getItems());
        methodData.setInstrument(instrument.getText());

        SourceController controller = (SourceController) getMainController();
        ((General.Source) controller.getData()).setMethod(methodData);
        controller.initialize();
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected String errorMessage() {
        return null;
    }

    // BUTTONS
    public void addButtonClicked() {
        ProcType procType = new ProcType();
        procType.setName(procTypeName.getText());
        procType.setURI(procTypeUri.getText());
        if (!procTypeName.getText().isEmpty()) {
            table.getItems().add(procType);
            procTypeName.clear();
            procTypeUri.clear();
        }
    }

    public void deleteButtonClicked() {
        deleteTableRow(table);
    }
}
