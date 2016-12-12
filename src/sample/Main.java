package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private StackPane newInvoiceScene;
    private StackPane mainMenuScene;
    private StackPane invoiceDetailsScene;
    private StackPane customerScene;
    private StackPane settingsScene;
    private static final Color CARBON = Color.valueOf("A9A9A9");
    private static final Color WATERMELON = Color.valueOf("FF3B3F");
    private static final Color GRAIN = Color.valueOf("D7CEC7");
    private static final Color OXBLOOD = Color.valueOf("76323F");
    private static final Color BLACKBOARD = Color.valueOf("565656");
    private Scene fixedScene;

    @Override
    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Click me");
//        btn.setOnAction(event -> System.out.println("Welcome to Javoice"));
//        btn.setOnAction(event -> btn.setText(LocalDateTime.now().toString()));
//
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//
//        Scene buttonTestScene = new Scene(root, 500, 700);

        //
        //
        //
        // MAIN MENU
        //

        GridPane mainMenuGrid = new GridPane();
        mainMenuGrid.setAlignment(Pos.CENTER);
        mainMenuGrid.setHgap(10);
        mainMenuGrid.setVgap(10);
        mainMenuGrid.setPadding(new Insets(25, 25, 25, 25));

        Text bannerTitle = new Text("J A V O I C E");
        bannerTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        bannerTitle.setFill(OXBLOOD);
        mainMenuGrid.add(bannerTitle, 0, 0, 2, 1);

        Text mainMenuTitle = new Text("Main menu");
        mainMenuTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        mainMenuTitle.setFill(BLACKBOARD);
        mainMenuGrid.add(mainMenuTitle, 0, 5, 2, 1);

//        Button dummyFocusButton = new Button();
//        dummyFocusButton.requestFocus();
//        dummyFocusButton.setVisible(false);
//        mainMenuGrid.add(dummyFocusButton, 0, 16);

        Button mainNewInvoice = new Button();
        mainNewInvoice.setText("New invoice");
        mainNewInvoice.setTextFill(BLACKBOARD);
        mainNewInvoice.setMinWidth(200);
        mainNewInvoice.setStyle("-fx-focus-color: transparent;");
        mainNewInvoice.setOnAction(event -> switchScene(fixedScene, newInvoiceScene));
        mainMenuGrid.add(mainNewInvoice, 0, 6);

        Button mainNewCustomer = new Button();
        mainNewCustomer.setText("New customer");
        mainNewCustomer.setTextFill(BLACKBOARD);
        mainNewCustomer.setMinWidth(200);
        mainNewCustomer.setStyle("-fx-focus-color: transparent;");
        mainNewCustomer.setOnAction(event -> switchScene(fixedScene, customerScene));
        mainMenuGrid.add(mainNewCustomer, 0, 7);

        Button mainSettings = new Button();
        mainSettings.setText("Settings");
        mainSettings.setTextFill(BLACKBOARD);
        mainSettings.setMinWidth(200);
        mainSettings.setStyle("-fx-focus-color: transparent;");
        mainSettings.setOnAction(event -> switchScene(fixedScene, settingsScene));
        mainMenuGrid.add(mainSettings, 0, 8);

        Label copyright = new Label(String.format("© %s  Tom Barnes", copyrightYears()));
        copyright.setTextFill(OXBLOOD);
        mainMenuGrid.add(copyright, 0, 15);

        mainMenuScene = new StackPane(mainMenuGrid);
        mainMenuScene.getStylesheets().add("sample/javoice.css");
        bannerTitle.requestFocus();

        //
        //
        //
        // NEW INVOICE SCENE
        //
        GridPane newInvoiceGrid = new GridPane();
        newInvoiceGrid.setAlignment(Pos.CENTER);
        newInvoiceGrid.setHgap(10);
        newInvoiceGrid.setVgap(10);
        newInvoiceGrid.setPadding(new Insets(25, 25, 25, 25));

        Text invoiceSceneTitle = new Text("New invoice");
        invoiceSceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        newInvoiceGrid.add(invoiceSceneTitle, 0, 0, 2, 1);

        Label customerSearchLabel = new Label("Search for existing customer:");
        newInvoiceGrid.add(customerSearchLabel, 0, 1);

        TextField customerSearch = new TextField();
        newInvoiceGrid.add(customerSearch, 1, 1);

        Button searchCustomerButton = new Button();
        searchCustomerButton.setText("Search");
        searchCustomerButton.setOnAction(event -> switchScene(fixedScene, invoiceDetailsScene));
        newInvoiceGrid.add(searchCustomerButton, 2, 1);

        Label orLabel = new Label("- OR -");
        newInvoiceGrid.add(orLabel, 0, 2);

        Button newCustomerButton = new Button();
        newCustomerButton.setText("Add new customer");
        newCustomerButton.setOnAction(event -> switchScene(fixedScene, customerScene));
        newInvoiceGrid.add(newCustomerButton, 0, 3);

//        Label quantity = new Label("Quantity");
//        newInvoiceGrid.add(quantity, 0, 2);
//
//        Label description = new Label("Description");
//        newInvoiceGrid.add(description, 1, 2);
//
//        Label unitPrice = new Label("Unit price");
//        newInvoiceGrid.add(unitPrice, 2, 2);

//        newInvoiceScene = new Scene(newInvoiceGrid, 500, 700);
        newInvoiceScene = new StackPane(newInvoiceGrid);

        Button mainFromInvoice = new Button();
        mainFromInvoice.setText("Main menu");
        mainFromInvoice.setOnAction(event -> switchScene(fixedScene, mainMenuScene));
        newInvoiceGrid.add(mainFromInvoice, 0, 7);
        invoiceSceneTitle.requestFocus();

        //
        //
        //
        // INVOICE DETAILS SCENE
        //
        GridPane invoiceDetailsGrid = new GridPane();
        invoiceDetailsGrid.setAlignment(Pos.CENTER);
        invoiceDetailsGrid.setHgap(10);
        invoiceDetailsGrid.setVgap(10);
        invoiceDetailsGrid.setPadding(new Insets(25, 25, 25, 25));

        Text invoiceDetailsTitle = new Text("Invoice details:");
        invoiceDetailsTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        invoiceDetailsGrid.add(invoiceDetailsTitle, 0, 0, 2, 1);

        Label nameLabel = new Label("Name:");
        invoiceDetailsGrid.add(nameLabel, 1, 2);

        TextField nameField = new TextField();
        invoiceDetailsGrid.add(nameField, 1, 3);

        Label addressOne = new Label("Address (1):");
        invoiceDetailsGrid.add(addressOne, 1, 4);

        TextField addressField = new TextField();
        GridPane.setColumnSpan(addressField, 2);
        invoiceDetailsGrid.add(addressField, 1, 5);

        Label addressTwo = new Label("Address (2):");
        invoiceDetailsGrid.add(addressTwo, 1, 6);

        TextField addressTwoField = new TextField();
        invoiceDetailsGrid.add(addressTwoField, 1, 7);

        Label postcodeLabel = new Label("Postcode:");
        invoiceDetailsGrid.add(postcodeLabel, 2, 6);

        TextField postcodeField = new TextField();
        invoiceDetailsGrid.add(postcodeField, 2, 7);

        Label dateLabel = new Label("Date:");
        invoiceDetailsGrid.add(dateLabel, 4, 2);

        TextField dateField = new TextField();
        invoiceDetailsGrid.add(dateField, 4, 3);

        Label orderNumberLabel = new Label("Order Number:");
        invoiceDetailsGrid.add(orderNumberLabel, 4, 4);

        TextField orderField = new TextField();
        invoiceDetailsGrid.add(orderField, 4, 5);

        Label accountCodeLabel = new Label("Account code:");
        invoiceDetailsGrid.add(accountCodeLabel, 4, 6);

        TextField accountCodeField = new TextField();
        invoiceDetailsGrid.add(accountCodeField, 4, 7);

        Label quantity = new Label("Quantity");
        invoiceDetailsGrid.add(quantity, 0, 12);

        Label description = new Label("Description");
        GridPane.setColumnSpan(description, 2);
        invoiceDetailsGrid.add(description, 1, 12);

        Label unitPrice = new Label("Unit price");
        invoiceDetailsGrid.add(unitPrice, 3, 12);

        Label total = new Label("Total");
        invoiceDetailsGrid.add(total, 4, 12);

        List<TextField> quantitiyFieldList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            quantitiyFieldList.add(new TextField());
            invoiceDetailsGrid.add(quantitiyFieldList.get(i), 0, 13 + i);
        }

        List<TextField> descriptionFieldList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            descriptionFieldList.add(new TextField());
            GridPane.setColumnSpan(descriptionFieldList.get(i), 2);
            invoiceDetailsGrid.add(descriptionFieldList.get(i), 1, 13 + i);
        }

        List<TextField> unitPriceList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            unitPriceList.add(new TextField());
            invoiceDetailsGrid.add(unitPriceList.get(i), 3, 13 + i);
        }

        List<TextField> totalList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            totalList.add(new TextField());
            invoiceDetailsGrid.add(totalList.get(i), 4, 13 + i);
        }

        Button invoiceSubmitButton = new Button();
        invoiceSubmitButton.setText("Submit");
        invoiceSubmitButton.setOnAction(event -> System.out.println("INVOICE SUBMITTED!"));
        invoiceDetailsGrid.add(invoiceSubmitButton, 0, 30);

        ScrollPane invoiceDetailsScroll = new ScrollPane(invoiceDetailsGrid);

        invoiceDetailsScene = new StackPane(invoiceDetailsScroll);

        //
        //
        //
        // NEW CUSTOMER SCENE
        //

        GridPane addCustomerGrid = new GridPane();
        addCustomerGrid.setAlignment(Pos.CENTER);
        addCustomerGrid.setHgap(10);
        addCustomerGrid.setVgap(10);
        addCustomerGrid.setPadding(new Insets(25, 25, 25, 25));


        Text customerSceneTitle = new Text("New customer");
        customerSceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        addCustomerGrid.add(customerSceneTitle, 0, 0, 2, 1);

        Label customerName = new Label("Name");
        addCustomerGrid.add(customerName, 0, 1);

        TextField customerNameField = new TextField();
        addCustomerGrid.add(customerNameField, 1, 1);

        Label customerAddressOne = new Label("Address (1)");
        addCustomerGrid.add(customerAddressOne, 0, 2);

        TextField customerAddressOneField = new TextField();
        addCustomerGrid.add(customerAddressOneField, 1, 2);

        Label customerAddressTwo = new Label("Address (2)");
        addCustomerGrid.add(customerAddressTwo, 0, 3);

        TextField customerAddressTwoField = new TextField();
        addCustomerGrid.add(customerAddressTwoField, 1, 3);

        Label customerPostcode = new Label("Postcode");
        addCustomerGrid.add(customerPostcode, 0, 4);

        TextField customerPostcodeField = new TextField();
        addCustomerGrid.add(customerPostcodeField, 1, 4);

        Label customerPhoneNum = new Label("Phone number:");
        addCustomerGrid.add(customerPhoneNum, 0, 5);

        TextField customerPhoneField = new TextField();
        addCustomerGrid.add(customerPhoneField, 1, 5);

        Button submitCustomerBtn = new Button();
        submitCustomerBtn.setText("Add customer");
        submitCustomerBtn.setOnAction(event -> printCustomerDetails(
                customerNameField,
                customerAddressOneField,
                customerAddressTwoField,
                customerPostcodeField,
                customerPhoneField
        ));
        addCustomerGrid.add(submitCustomerBtn, 0, 6);

        Button mainFromCustomer = new Button();
        mainFromCustomer.setText("Main menu");
        mainFromCustomer.setOnAction(event -> switchScene(fixedScene, mainMenuScene));
        addCustomerGrid.add(mainFromCustomer, 0, 7);

        customerScene = new StackPane(addCustomerGrid);
        //
        //
        //
        // SETTINGS
        //

        GridPane settingsGrid = new GridPane();
        settingsGrid.setAlignment(Pos.CENTER);
        settingsGrid.setHgap(10);
        settingsGrid.setVgap(10);
        settingsGrid.setPadding(new Insets(25, 25, 25, 25));

        Text settingsTitle = new Text("Settings");
        settingsTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        settingsGrid.add(settingsTitle, 0, 0, 2, 1);

        Label invoiceFileTemplateLabel = new Label("Invoice Template path:");
        settingsGrid.add(invoiceFileTemplateLabel, 0, 1);

        TextField invoiceFileTemplatePath = new TextField();
        settingsGrid.add(invoiceFileTemplatePath, 1, 1);

        Label invoiceFileOutputLabel = new Label("Invoice output path:");
        settingsGrid.add(invoiceFileOutputLabel, 0, 2);

        TextField invoiceFileOutputPath = new TextField();
        settingsGrid.add(invoiceFileOutputPath, 1, 2);

        Label salesLedgerOutputLabel = new Label("Sales ledger output path:");
        settingsGrid.add(salesLedgerOutputLabel, 0, 3);

        TextField salesLedgerOutputPath = new TextField();
        settingsGrid.add(salesLedgerOutputPath, 1, 3);

        Label customerDataLabel = new Label("Customer data path:");
        settingsGrid.add(customerDataLabel, 0, 4);

        TextField customerDataPath = new TextField();
        settingsGrid.add(customerDataPath, 1, 4);

        Button updateSettings = new Button();
        updateSettings.setText("Update settings");
        updateSettings.setOnAction(event -> System.out.println("settings updated..."));
        settingsGrid.add(updateSettings, 0, 6);

        Button mainFromSettings = new Button();
        mainFromSettings.setText("Main menu");
        mainFromSettings.setOnAction(event -> switchScene(fixedScene, mainMenuScene));
        settingsGrid.add(mainFromSettings, 0, 8);

        settingsScene = new StackPane(settingsGrid);

        //
        //
        // SET THE STAGE...
        //

        fixedScene = new Scene(mainMenuScene);
        primaryStage.setTitle("Javoice");
        primaryStage.setScene(fixedScene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    private void switchScene(Scene scene, StackPane layout) {
        scene.setRoot(layout);
    }

//    private void switchScene(Stage primaryStage) {

    //    }
//        }
//            primaryStage.setScene(newInvoiceScene);
//        } else {
//            primaryStage.setScene(customerScene);
//        if (primaryStage.getScene() == newInvoiceScene) {

    private String copyrightYears() {
        if (LocalDate.now().getYear() == 2016) {
            return "2016";
        }
        return String.format("2016-%s", LocalDate.now().getYear());
    }

    private void printCustomerDetails(TextField nameField, TextField customerAddressOneField, TextField customerAddressTwoField, TextField customerPostcodeField, TextField customerPhoneField) {
        System.out.println(String.format("...adding customer %s, from %s %s %s, ph. %s",
                nameField.getText(),
                customerAddressOneField.getText(),
                customerAddressTwoField.getText(),
                customerPostcodeField.getText(),
                customerPhoneField.getText()));
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
