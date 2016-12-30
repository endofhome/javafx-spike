package sample;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class NewInvoice implements Observable {

    public StackPane newInvoiceStackPane;
    private Observer observer;

    public NewInvoice() {
        initialise();
    }

    public void initialise() {
        GridPane newInvoiceGrid = new GridPane();
        newInvoiceGrid.setAlignment(Pos.CENTER);
        newInvoiceGrid.setHgap(10);
        newInvoiceGrid.setVgap(10);
        newInvoiceGrid.setPadding(new Insets(25, 25, 25, 25));

        Text invoiceSceneTitle = new Text("New invoice");
        invoiceSceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        newInvoiceGrid.add(invoiceSceneTitle, 0, 0, 2, 1);

        Label customerSearchLabel = new Label("Search for existing customer:");
        newInvoiceGrid.add(customerSearchLabel, 0, 10);

        TextField customerSearch = new TextField();
        newInvoiceGrid.add(customerSearch, 1, 10);

        Button searchCustomerButton = new Button();
        searchCustomerButton.setText("Search");
        searchCustomerButton.setOnAction(event -> notifyObserver(UiController.invoiceDetailsStackPane));
        newInvoiceGrid.add(searchCustomerButton, 2, 10);

        Label orLabel = new Label("- OR -");
        GridPane.setColumnSpan(orLabel, 3);
        GridPane.setHalignment(orLabel, HPos.CENTER);
        newInvoiceGrid.add(orLabel, 0, 12);

        Button newCustomerButton = new Button();
        newCustomerButton.setText("Add new customer");
        GridPane.setColumnSpan(newCustomerButton, 3);
        GridPane.setHalignment(newCustomerButton, HPos.CENTER);
        newCustomerButton.setOnAction(event -> notifyObserver(UiController.newCustomerStackPane));
        newInvoiceGrid.add(newCustomerButton, 0, 14);

        newInvoiceStackPane = new StackPane(newInvoiceGrid);

        Button mainFromInvoice = new Button();
        mainFromInvoice.setText("Main menu");
        mainFromInvoice.setOnAction(event -> notifyObserver(UiController.mainMenuStackPane));
        newInvoiceGrid.add(mainFromInvoice, 0, 25);
        invoiceSceneTitle.requestFocus();
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
