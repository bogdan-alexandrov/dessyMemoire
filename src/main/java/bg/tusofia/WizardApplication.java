package bg.tusofia;

import bg.tusofia.controllers.WelcomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WizardApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/welcome.fxml"));
        Parent root = loader.load();
        WelcomeController controller = loader.getController();
        controller.setStage(primaryStage); // or what you want to do

        primaryStage.setTitle("XML  Scientific data wizard");
        primaryStage.setScene(new Scene(root, 200, 100));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//TODO Information icons - properties
