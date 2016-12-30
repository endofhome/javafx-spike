package sample;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class NewInvoice extends JavoiceScreen implements Observable {

    public StackPane newInvoiceStackPane;
    private Observer observer;

    public NewInvoice() {
        initialise();
    }

    public void initialise() {
        GridPane newInvoiceGrid = new GridPane();
        basicGridSetup(newInvoiceGrid, "New invoice");

        Label customerSearchLabel = new Label("Search for existing customer:");
        newInvoiceGrid.add(customerSearchLabel, 0, 11);

        TextField customerSearch = new TextField();
        newInvoiceGrid.add(customerSearch, 1, 11);

        Button searchCustomerButton = new Button();
        searchCustomerButton.setText("Search");
        searchCustomerButton.setOnAction(event -> notifyObserver(UiController.invoiceDetailsStackPane));
        newInvoiceGrid.add(searchCustomerButton, 2, 11);

        Label orLabel = new Label("- OR -");
        GridPane.setColumnSpan(orLabel, 3);
        GridPane.setHalignment(orLabel, HPos.CENTER);
        newInvoiceGrid.add(orLabel, 0, 13);

        Button newCustomerButton = new Button();
        newCustomerButton.setText("Add new customer");
        GridPane.setColumnSpan(newCustomerButton, 3);
        GridPane.setHalignment(newCustomerButton, HPos.CENTER);
        newCustomerButton.setOnAction(event -> notifyObserver(UiController.newCustomerStackPane));
        newInvoiceGrid.add(newCustomerButton, 0, 15);

        newInvoiceStackPane = new StackPane(newInvoiceGrid);

        Button mainFromInvoice = new Button();
        mainFromInvoice.setText("Main menu");
        mainFromInvoice.setOnAction(event -> notifyObserver(UiController.mainMenuStackPane));
        newInvoiceGrid.add(mainFromInvoice, 0, 26);
        title.requestFocus();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void notifyObserver(StackPane stackPane) {
        observer.switchScene(stackPane);
    }
}
