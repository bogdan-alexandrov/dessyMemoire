package bg.tusofia.controllers;

import bg.tusofia.models.Dataset;
import bg.tusofia.tools.FileChooserHelper;
import bg.tusofia.tools.WorkingFile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {

    @FXML
    private HBox container;

    public Button buttonOpen;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void newFile() {
        System.out.println("New file clicked ...");
        startWorkingWith(new Dataset());
    }

    public void openFile() {
        Dataset dataset = FileChooserHelper.openFile(container.getScene());
        if (dataset != null) {
            startWorkingWith(dataset);
        } else {
            System.out.println("Error loading file ...");
            //PromBox.alert("Error ...", "Invalid file! Syntactical error");
        }
    }

    private void startWorkingWith(Dataset dataset) {
        System.out.println("Opening wizard ...");
        WorkingFile.getInstance().setDataset(dataset);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmls/wizard.fxml"));
            Parent root = fxmlLoader.load();
            stage.close();
            stage.setTitle("The magic wizard");
            stage.setScene(new Scene(root, 800, 600));

            WizardController controller = fxmlLoader.getController();
            controller.setData(dataset);
            controller.setStage(stage);
            controller.initialize();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
