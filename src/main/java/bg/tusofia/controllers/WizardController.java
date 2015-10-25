package bg.tusofia.controllers;

import bg.tusofia.models.Dataset;
import bg.tusofia.models.General;
import bg.tusofia.tools.FileChooserHelper;
import bg.tusofia.tools.PromBox;
import bg.tusofia.tools.WorkingFile;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class WizardController extends AbstractController {

    public Accordion accordion;
    public TitledPane generalPane;
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

    private Dataset dataset;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setId.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    dataset.getGeneral().setSetID(newValue);
                    setWorkingFileAsModified();
                }
        );
        accordion.setExpandedPane(generalPane);
    }

    @Override
    public void initialize() {
        dataset = WorkingFile.getInstance().getDataset();
        this.setData(dataset);

        if (dataset.getGeneral() == null) {
            dataset.setGeneral(new General());
        }

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


        ///////////---Menu Items---///////////
        meSave.setDisable(!WorkingFile.getInstance().isChanged());

        ///////////---Window---///////////
        getStage().setOnCloseRequest(event -> {
            event.consume();
            quit();
        });
    }


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
        //TODO validation

        return null;
    }

    ////------------Buttons BEGINS------------////
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
}
