package bg.tusofia.tools;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class PromBox {

    private enum BoxType {
        YES_NO,
        YES_NO_CLOSE,
        CLOSE
    }

    public enum BoxAnswer {
        YES,
        NO,
        CLOSE
    }

    static BoxAnswer answer;

    public static BoxAnswer confirmYesNo(String title, String message) {
        return message(title, message, BoxType.YES_NO);
    }

    public static BoxAnswer confirmYesNoClose(String title, String message) {
        return message(title, message, BoxType.YES_NO_CLOSE);
    }

    public static BoxAnswer alert(String title, String message) {
        return message(title, message, BoxType.CLOSE);
    }

    public static BoxAnswer message(String title, String message, BoxType boxType) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);

        //Create two buttons
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        Button closeButton = new Button();
        if ( boxType.equals(BoxType.YES_NO_CLOSE)){
            closeButton.setText("Cancel");
        }else {
            closeButton.setText("Close");
        }

        //Clicking will set answer and close window
        yesButton.setOnAction(e -> {
            answer = BoxAnswer.YES;
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = BoxAnswer.NO;
            window.close();
        });
        closeButton.setOnAction(e -> {
            answer = BoxAnswer.CLOSE;
            window.close();
        });
        VBox layoutQA = new VBox();
        VBox.setMargin(label, new Insets(5, 5, 5, 5));

        HBox layoutButtons = new HBox();
        layoutButtons.setSpacing(10);
        layoutButtons.setAlignment(Pos.CENTER);
        VBox.setMargin(layoutButtons, new Insets(10, 10, 10, 10));

        //Add buttons
        if (boxType == BoxType.YES_NO) {
            layoutButtons.getChildren().addAll(yesButton, noButton);
        } else if (boxType == BoxType.YES_NO_CLOSE) {
            layoutButtons.getChildren().addAll(yesButton, noButton, closeButton);
        } else if (boxType == BoxType.CLOSE) {
            layoutButtons.getChildren().add(closeButton);
        }
        layoutQA.getChildren().addAll(label, layoutButtons);
        layoutQA.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layoutQA);
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();

        //Make sure to return answer
        return answer;
    }

}