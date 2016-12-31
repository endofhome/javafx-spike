package sample;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UiController implements Observer {

    static Scene fixedScene;
    static StackPane mainMenuStackPane;
    static StackPane newInvoiceStackPane;
    static StackPane invoiceDetailsStackPane;
    static StackPane newCustomerStackPane;
    static StackPane settingsStackPane;

    public UiController() {
        initialise();
    }

    private void initialise() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.registerObserver(this);
        mainMenuStackPane = mainMenu.mainMenuStackPane;

        NewInvoice newInvoice = new NewInvoice();
        newInvoice.registerObserver(this);
        newInvoiceStackPane = newInvoice.newInvoiceStackPane;

        InvoiceDetails invoiceDetails = new InvoiceDetails();
        invoiceDetails.registerObserver(this);
        invoiceDetailsStackPane = invoiceDetails.invoiceDetailsStackPane;

        NewCustomer newCustomer = new NewCustomer();
        newCustomer.registerObserver(this);
        newCustomerStackPane = newCustomer.newCustomerStackPane;

        Settings settings = new Settings();
        settings.registerObserver(this);
        settingsStackPane = settings.settingsStackPane;
    }

    void setTheStage(Stage primaryStage) {
        fixedScene = new Scene(mainMenuStackPane);
        mainMenuStackPane.requestFocus();
        primaryStage.setTitle("Javoice");
        primaryStage.setScene(fixedScene);
        primaryStage.setMaximized(true);
        primaryStage.getIcons().add(new Image("file:resources/icons/javoice_icon.png"));
        primaryStage.show();
    }

    public void switchScene(StackPane layout) {
        fixedScene.setRoot(layout);
        layout.requestFocus();
    }
}
