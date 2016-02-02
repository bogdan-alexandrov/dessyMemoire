package bg.tusofia.controllers;

import bg.tusofia.models.*;
import bg.tusofia.tools.FileChooserHelper;
import bg.tusofia.tools.PromBox;
import bg.tusofia.tools.WorkingFile;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class WizardController extends AbstractController {

    public Accordion accordion;
    public MenuItem meSave;

    public TextField setId;
    public Button buttonAddAbout;
    public Button buttonAddSource;
    public Button buttonAddVersion;
    public Button buttonAddAccessRights;
    public Button buttonAddContact;
    public Button buttonModifyAbout;
    public Button buttonModifySource;
    public Button buttonModifyVersion;
    public Button buttonModifyAccessRights;
    public Button buttonModifyContact;
    public Button buttonDeleteAbout;
    public Button buttonDeleteSource;
    public Button buttonDeleteVersion;
    public Button buttonDeleteAccessRights;
    public Button buttonDeleteContact;

    public TextField byteSize;
    public TextField float32Exponent;
    public TextField float32Mantissa;
    public TextField float64Exponent;
    public TextField float64Mantissa;
    public ChoiceBox<String> codingChoiceBox;
    public ChoiceBox<String> byteOrderChoiceBox;
    public VBox clustersVBox;
    public VBox typedefsBox;
    public TitledPane generalPane;
    public TitledPane layoutPane;

    private Dataset dataset;
    private Cluster clusterToBeModified;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO change it to general
        accordion.setExpandedPane(layoutPane);

        /////////////general
        setId.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    dataset.getGeneral().setSetID(newValue);
                    setWorkingFileAsModified();
                }
        );

        /////////////layout
        codingChoiceBox.setItems(FXCollections.observableArrayList(
                        "ASCII", "Unicode", "EBCDIC", "Binary")
        );
        byteOrderChoiceBox.setItems(FXCollections.observableArrayList(
                        "Bigendian", "Littlelendian")
        );
        byteSize.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    dataset.getLayout().setByteSize(BigInteger.valueOf(Integer.valueOf(newValue)));
                    setWorkingFileAsModified();
                }
        );
        float32Exponent.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    dataset.getLayout().setFloat32Exponent(BigInteger.valueOf(Long.valueOf(newValue)));
                    setWorkingFileAsModified();
                }
        );
        float32Mantissa.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    dataset.getLayout().setFloat32Mantissa(BigInteger.valueOf(Long.valueOf(newValue)));
                    setWorkingFileAsModified();
                }
        );
        float64Exponent.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    dataset.getLayout().setFloat64Exponent(BigInteger.valueOf(Long.valueOf(newValue)));
                    setWorkingFileAsModified();
                }
        );
        float64Mantissa.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    dataset.getLayout().setFloat64Mantissa(BigInteger.valueOf(Long.valueOf(newValue)));
                    setWorkingFileAsModified();
                }
        );
        codingChoiceBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
                    dataset.getLayout().setCoding(codingChoiceBox.getItems().get(newValue.intValue()));
                    setWorkingFileAsModified();
                }
        );
        byteOrderChoiceBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
                    dataset.getLayout().setByteOrder(byteOrderChoiceBox.getItems().get(newValue.intValue()));
                    setWorkingFileAsModified();
                }
        );

        clustersVBox.setSpacing(5);
        typedefsBox.setSpacing(5);
    }

    @Override
    public void initialize() {
        boolean fileState = WorkingFile.getInstance().isChanged();

        dataset = WorkingFile.getInstance().getDataset();
        this.setData(dataset);

        if (dataset.getGeneral() == null) {
            dataset.setGeneral(new General());
        }
        if (dataset.getLayout() == null) {
            dataset.setLayout(new Layout());
        }

        //GENERAL STARTs here
        General general = dataset.getGeneral();

        if (general.getSetID() != null) {
            setId.setText(general.getSetID());
        } else {
            setId.setText("");
        }

        ///////////---BUTTONS---///////////
        buttonAddAbout.setDisable(false);
        buttonAddSource.setDisable(false);
        buttonAddVersion.setDisable(false);
        buttonAddAccessRights.setDisable(false);
        buttonAddContact.setDisable(false);

        buttonModifyAbout.setDisable(true);
        buttonModifySource.setDisable(true);
        buttonModifyVersion.setDisable(true);
        buttonModifyAccessRights.setDisable(true);
        buttonModifyContact.setDisable(true);

        buttonDeleteAbout.setDisable(true);
        buttonDeleteSource.setDisable(true);
        buttonDeleteVersion.setDisable(true);
        buttonDeleteAccessRights.setDisable(true);
        buttonDeleteContact.setDisable(true);

        if (general.getAbout() != null) {
            buttonAddAbout.setDisable(true);
            buttonModifyAbout.setDisable(false);
            buttonDeleteAbout.setDisable(false);
        }
        if (general.getSource() != null) {
            buttonAddSource.setDisable(true);
            buttonModifySource.setDisable(false);
            buttonDeleteSource.setDisable(false);
        }
        if (general.getVersion() != null) {
            buttonAddVersion.setDisable(true);
            buttonModifyVersion.setDisable(false);
            buttonDeleteVersion.setDisable(false);
        }
        if (general.getAccessRights() != null) {
            buttonAddAccessRights.setDisable(true);
            buttonModifyAccessRights.setDisable(false);
            buttonDeleteAccessRights.setDisable(false);
        }
        if (general.getContact() != null) {
            buttonAddContact.setDisable(true);
            buttonModifyContact.setDisable(false);
            buttonDeleteContact.setDisable(false);
        }
        //GENERAL ENDs here

        //LAYOUT STARTs here
        Layout layout = dataset.getLayout();
        if (layout.getByteSize() != null) {
            byteSize.setText(layout.getByteSize().toString());
        } else {
            setId.setText("");
        }
        if (layout.getFloat32Exponent() != null) {
            float32Exponent.setText(layout.getFloat32Exponent().toString());
        } else {
            setId.setText("");
        }
        if (layout.getFloat64Exponent() != null) {
            float64Exponent.setText(layout.getFloat64Exponent().toString());
        } else {
            setId.setText("");
        }
        if (layout.getFloat32Mantissa() != null) {
            float32Mantissa.setText(layout.getFloat32Mantissa().toString());
        } else {
            setId.setText("");
        }
        if (layout.getFloat64Mantissa() != null) {
            float64Mantissa.setText(layout.getFloat64Mantissa().toString());
        } else {
            setId.setText("");
        }

        if (layout.getCoding() != null) {
            codingChoiceBox.setValue(layout.getCoding());
        } else {
            codingChoiceBox.setValue("ASCII");
        }
        if (layout.getByteOrder() != null) {
            byteOrderChoiceBox.setValue(layout.getByteOrder());
        } else {
            byteOrderChoiceBox.setValue("Bigendian");
        }

        clustersVBox.getChildren().clear();
        for (int i = 0; i < layout.getCluster().size(); i++) {
            Cluster cluster = layout.getCluster().get(i);
            HBox hbox = new HBox();
            hbox.setSpacing(10);

            Label label = new Label("Name: " + cluster.getName());
            label.setPrefWidth(200);
            label.setMaxWidth(200);

            Button buttonEdit = new Button("Edit");
            String idEditB = "cluster-edit-" + i;
            buttonEdit.setId(idEditB);
            buttonEdit.setOnAction(event -> modifyCluster(idEditB));

            Button buttonDelete = new Button("Delete");
            String idDelB = "cluster-delete-" + i;
            buttonDelete.setId(idDelB);
            buttonDelete.setOnAction(event -> deleteListEntity(idDelB));

            hbox.getChildren().addAll(label, buttonEdit, buttonDelete);
            clustersVBox.getChildren().add(hbox);
        }
        Button addClusterB = new Button("Add");
        addClusterB.setOnAction(event -> addCluster());
        clustersVBox.getChildren().add(addClusterB);

        typedefsBox.getChildren().clear();
        for (int i = 0; i < layout.getTypedef().size(); i++) {
            Typedef typedef = layout.getTypedef().get(i);
            HBox hbox = new HBox();
            hbox.setSpacing(10);

            Label label = new Label("Name: " + typedef.getTypename());
            label.setPrefWidth(200);
            label.setMaxWidth(200);

            Button buttonEdit = new Button("Edit");
            String idEditB = "typedef-edit-" + i;
            buttonEdit.setId(idEditB);
            // TODO 2 buttonEdit.setOnAction(event -> modifyTypedef(idEditB));

            Button buttonDelete = new Button("Delete");
            String id = "typedef-delete-" + i;
            buttonDelete.setId(id);
            buttonDelete.setOnAction(event -> deleteListEntity(id));

            hbox.getChildren().addAll(label, buttonEdit, buttonDelete);
            typedefsBox.getChildren().add(hbox);
        }

        Button addTypedefB = new Button("Add");
        addTypedefB.setOnAction(event -> addTypedef());
        typedefsBox.getChildren().add(addTypedefB);

        //LAYOUT ENDs here

        ///////////---Menu Items---///////////
        meSave.setDisable(!fileState);

        ///////////---Window---///////////
        getStage().setOnCloseRequest(event -> {
            event.consume();
            quit();
        });

        WorkingFile.getInstance().setChanged(fileState);
    }

    //MENU STARTs here
    public void newFile() {
        PromBox.BoxAnswer answer;
        if (WorkingFile.getInstance().isChanged()) {
            answer = PromBox.confirmYesNoClose("Wizard application", "Do you want to save before opening new file?");
        } else {
            answer = PromBox.BoxAnswer.NO;
        }
        switch (answer) {
            case CLOSE:
                break;
            case YES:
                save();

                if (!isSuccessfullySaved()) {
                    return;
                }

            case NO:
                WorkingFile.getInstance().clear();
                initialize();
                break;
        }
    }

    public void openFile() {
        PromBox.BoxAnswer answer;
        if (WorkingFile.getInstance().isChanged()) {
            answer = PromBox.confirmYesNoClose("Wizard application", "Do you want to save before opening file?");
        } else {
            answer = PromBox.BoxAnswer.NO;
        }
        switch (answer) {
            case CLOSE:
                break;
            case YES:
                save();

                if (!isSuccessfullySaved()) {
                    return;
                }

            case NO:
                WorkingFile.getInstance().clear();
                setData(FileChooserHelper.openFile(getStage().getScene()));
                initialize();
                break;
        }
    }

    public void save() {
        if (WorkingFile.getInstance().getPhysicalFile() == null) {
            saveAs();
        } else {
            FileChooserHelper.saveFile(dataset, validate());
        }

        if (isSuccessfullySaved()) {
            initialize();
        }
    }

    public void saveAs() {
        FileChooserHelper.saveAsFile(dataset, getStage().getScene(), validate());

        if (isSuccessfullySaved()) {
            initialize();
        }
    }

    public void quit() {
        PromBox.BoxAnswer answer;
        if (WorkingFile.getInstance().isChanged()) {
            answer = PromBox.confirmYesNoClose("Closing window", "Do you want to save before exit?");
            switch (answer) {
                case YES:
                    save();
                    if (!isSuccessfullySaved()) {
                        return;
                    }
                case NO:
                    getStage().close();
                    break;
                case CLOSE:
                    break;
            }
        } else {
            answer = PromBox.confirmYesNo("Closing window", "Are you sure you want to exit?");
            switch (answer) {
                case YES:
                    getStage().close();
                case NO:
                    break;
            }
        }
    }
    //MENU ENDs HERE

    private boolean isSuccessfullySaved() {
        return !WorkingFile.getInstance().isChanged();
    }

    @Override
    public void updateParent() {
        //don't need it
    }

    @Override
    public boolean validate() {
        //TODO validation
        return false;
    }

    @Override
    protected String errorMessage() {
        //TODO errors

        return null;
    }

    ////------------Buttons BEGIN------------////
    public void addAbout() {
        System.out.println("Adding About");
        aboutButtons("Add About", new General.About());
    }

    public void modifyAbout() {
        System.out.println("Modifying About");
        aboutButtons("Modify About", dataset.getGeneral().getAbout());
    }

    public void deleteAbout() {
        System.out.println("Deleting About");
        setWorkingFileAsModified();
        dataset.getGeneral().setAbout(null);
        initialize();
    }

    public void addSource() {
        System.out.println("Adding Source");
        sourceButtons("Add Source", new General.Source());
    }

    public void modifySource() {
        System.out.println("Modifying Source");
        sourceButtons("Modify Source", dataset.getGeneral().getSource());
    }

    public void deleteSource() {
        System.out.println("Deleting Source");
        setWorkingFileAsModified();
        dataset.getGeneral().setAbout(null);
        initialize();
    }

    public void addVersion() {
        System.out.println("Adding Source");
        versionButtons("Add Source", new General.Version());
    }

    public void modifyVersion() {
        System.out.println("Modifying Source");
        versionButtons("Modify Source", dataset.getGeneral().getVersion());
    }

    public void deleteVersion() {
        System.out.println("Deleting Version");
        setWorkingFileAsModified();
        dataset.getGeneral().setVersion(null);
        initialize();
    }

    public void addAccessRights() {
        System.out.println("Adding Access Rights");
        accessRightsButtons("Add Access Rights", new General.AccessRights());
    }

    public void modifyAccessRights() {
        System.out.println("Modifying Access Rights");
        accessRightsButtons("Modify Access Rights", dataset.getGeneral().getAccessRights());
    }

    public void deleteAccessRights() {
        System.out.println("Deleting Access Rights");
        setWorkingFileAsModified();
        dataset.getGeneral().setAccessRights(null);
        initialize();
    }

    public void addContact() {
        System.out.println("Adding Contact");
        contactButtons("Add Contact", new General.Contact());
    }

    public void modifyContact() {
        System.out.println("Modifying Contact");
        contactButtons("Modify Contact", dataset.getGeneral().getContact());
    }

    public void deleteContact() {
        System.out.println("Deleting Contact");
        setWorkingFileAsModified();
        dataset.getGeneral().setContact(null);
        initialize();
    }

    public void aboutButtons(String stageName, General.About data) {
        addModifyCommonButtons(stageName, data, "/fxmls/general/about.fxml");
    }

    public void sourceButtons(String stageName, General.Source data) {
        addModifyCommonButtons(stageName, data, "/fxmls/general/source.fxml");
    }

    public void versionButtons(String stageName, General.Version data) {
        addModifyCommonButtons(stageName, data, "/fxmls/general/version.fxml");
    }

    public void accessRightsButtons(String stageName, General.AccessRights data) {
        addModifyCommonButtons(stageName, data, "/fxmls/general/accessRights.fxml");
    }

    public void contactButtons(String stageName, General.Contact data) {
        addModifyCommonButtons(stageName, data, "/fxmls/general/contact.fxml");
    }

    public void addCluster() {
        System.out.println("Adding Cluster");
        clusterButtons("Add Cluster", new Cluster());
    }

    public void modifyCluster(String buttonId) {
        System.out.println("Modifying Cluster");

        int index = Integer.valueOf((String) buttonId.subSequence(buttonId.lastIndexOf('-') + 1, (buttonId.length())));
        setClusterToBeModified(dataset.getLayout().getCluster().get(index));

        clusterButtons("Edit Cluster", getClusterToBeModified());
    }

    public void clusterButtons(String stageName, Cluster data) {
        addModifyCommonButtons(stageName, data, "/fxmls/layout/cluster.fxml");
    }

    private void addTypedef() {
        System.out.println("Adding Typedef");
        typedefButtons("Add Typedef", new Typedef());
    }

    private void typedefButtons(String stageName, Typedef typedef) {
        addModifyCommonButtons(stageName, typedef, "/fxmls/layout/typedef.fxml");
    }

    public void deleteListEntity(String buttonId) {
        List dataset = null;
        if (buttonId.startsWith("cluster-")) {
            dataset = this.dataset.getLayout().getCluster();
        } else if (buttonId.startsWith("typedef-")) {
            dataset = this.dataset.getLayout().getTypedef();
        }
        if (dataset != null) {
            int index = Integer.valueOf((String) buttonId.subSequence(buttonId.lastIndexOf('-') + 1, (buttonId.length())));
            dataset.remove(index);
            initialize();
        }
    }

    public Cluster getClusterToBeModified() {
        return clusterToBeModified;
    }

    public void setClusterToBeModified(Cluster clusterToBeModified) {
        this.clusterToBeModified = clusterToBeModified;
    }
}
