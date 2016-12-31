package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import uk.co.endofhome.javoice.ui.UiController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        UiController uiController = new UiController();
        uiController.setTheStage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}