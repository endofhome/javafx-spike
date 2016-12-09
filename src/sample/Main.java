package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.time.LocalDateTime;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Click me");
//        btn.setOnAction(event -> System.out.println("Welcome to Javoice"));
//        btn.setOnAction(event -> btn.setText(LocalDateTime.now().toString()));
//
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);

//        Scene scene = new Scene(root, 300, 250);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 275);

        Text scenetitle = new Text("New customer");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label customerName = new Label("Name");
        grid.add(customerName, 0, 1);

        TextField customerNameField = new TextField();
        grid.add(customerNameField, 1, 1);

        Label addressOne = new Label("Address (1)");
        grid.add(addressOne, 0, 2);

        TextField customerAddressOneField = new TextField();
        grid.add(customerAddressOneField, 1, 2);

        Label customerAddressTwoField = new Label("Address (2)");
        grid.add(customerAddressTwoField, 0, 3);

        TextField customerPostcodeField = new TextField();
        grid.add(customerPostcodeField, 1, 3);

        Label customerPhoneNum = new Label("Phone number:");
        grid.add(customerPhoneNum, 0, 4);

        TextField customerPhoneField = new TextField();
        grid.add(customerPhoneField, 1, 4);

        Button btn = new Button();
        btn.setText("Add customer");
        btn.setOnAction(event -> System.out.println("...adding customer"));
        grid.add(btn, 0, 5);

        primaryStage.setTitle("Javoice");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Javoice");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }


    public static void main(String[] args) {
        launch(args);
    }
}
