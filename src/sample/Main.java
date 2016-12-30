package sample;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public static final Color OXBLOOD = Color.valueOf("76323F");
    public static final Color BLACKBOARD = Color.valueOf("565656");
    private UiController uiController;

    @Override
    public void start(Stage primaryStage) {
        uiController = new UiController();
        uiController.setTheStage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}