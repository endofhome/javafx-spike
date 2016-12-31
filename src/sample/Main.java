package sample;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    static final Color OXBLOOD = Color.valueOf("76323F");
    static final Color BLACKBOARD = Color.valueOf("565656");

    @Override
    public void start(Stage primaryStage) {
        UiController uiController = new UiController();
        uiController.setTheStage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}