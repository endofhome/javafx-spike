package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDetails extends JavoiceScreen implements Observable {

    private Observer observer;
    public StackPane invoiceDetailsStackPane;
    private String fakeOrderNumber = "1053";

    public InvoiceDetails() {
        initialise();
    }

    public void initialise() {
        // Fake customer for testing purposes...
        FakeCustomer fakeCustomer = new FakeCustomer();

        GridPane invoiceDetailsGrid = new GridPane();
        basicGridSetup(invoiceDetailsGrid, "Invoice details:");

        Label nameLabel = new Label("Name:");
        invoiceDetailsGrid.add(nameLabel, 0, 3);

        TextField nameField = new TextField();
        GridPane.setColumnSpan(nameField, 3);
        nameField.setText(fakeCustomer.name);
        invoiceDetailsGrid.add(nameField, 0, 4);

        Label addressOne = new Label("Address (1):");
        invoiceDetailsGrid.add(addressOne, 0, 5);

        TextField addressField = new TextField();
        GridPane.setColumnSpan(addressField, 4);
        addressField.setText(fakeCustomer.addressOne);
        invoiceDetailsGrid.add(addressField, 0, 6);

        Label addressTwo = new Label("Address (2):");
        invoiceDetailsGrid.add(addressTwo, 0, 7);

        TextField addressTwoField = new TextField();
        GridPane.setColumnSpan(addressTwoField, 3);
        addressTwoField.setText(fakeCustomer.addressTwo);
        invoiceDetailsGrid.add(addressTwoField, 0, 8);

        Label postcodeLabel = new Label("Postcode:");
        invoiceDetailsGrid.add(postcodeLabel, 3, 7);

        TextField postcodeField = new TextField();
        postcodeField.setText(fakeCustomer.postcode);
        invoiceDetailsGrid.add(postcodeField, 3, 8);

        Label dateLabel = new Label("Date:");
        invoiceDetailsGrid.add(dateLabel, 5, 3);

        TextField dateField = new TextField();
        dateField.setText(todaysDate());
        invoiceDetailsGrid.add(dateField, 5, 4);

        Label orderNumberLabel = new Label("Order Number:");
        invoiceDetailsGrid.add(orderNumberLabel, 5, 5);

        TextField orderField = new TextField();
        orderField.setText(fakeOrderNumber);
        invoiceDetailsGrid.add(orderField, 5, 6);

        Label accountCodeLabel = new Label("Account code:");
        invoiceDetailsGrid.add(accountCodeLabel, 5, 7);

        TextField accountCodeField = new TextField();
        accountCodeField.setText(fakeCustomer.accountCode);
        invoiceDetailsGrid.add(accountCodeField, 5, 8);

        Label quantity = new Label("Quantity");
        invoiceDetailsGrid.add(quantity, 0, 13);

        Label description = new Label("Description");
        GridPane.setColumnSpan(description, 3);
        invoiceDetailsGrid.add(description, 1, 13);

        Label unitPrice = new Label("Unit price");
        invoiceDetailsGrid.add(unitPrice, 4, 13);

        Label total = new Label("Total");
        invoiceDetailsGrid.add(total, 5, 13);

        List<TextField> quantitiyFieldList = new ArrayList<>();
        for (int i = 0; i <= 16; i++) {
            quantitiyFieldList.add(new TextField());
            quantitiyFieldList.get(i).setMaxWidth(75);
        }

        List<TextField> descriptionFieldList = new ArrayList<>();
        for (int i = 0; i <= 16; i++) {
            descriptionFieldList.add(new TextField());
            descriptionFieldList.get(i).setMinWidth(200);
            GridPane.setColumnSpan(descriptionFieldList.get(i), 3);
        }

        List<TextField> unitPriceList = new ArrayList<>();
        for (int i = 0; i <= 16; i++) {
            unitPriceList.add(new TextField());
            unitPriceList.get(i).setMaxWidth(75);
        }

        List<TextField> totalList = new ArrayList<>();
        for (int i = 0; i <= 16; i++) {
            totalList.add(new TextField());
        }

        for (int i = 0; i <= 16; i++) {
            invoiceDetailsGrid.add(quantitiyFieldList.get(i), 0, 14 + i);
            invoiceDetailsGrid.add(descriptionFieldList.get(i), 1, 14 + i);
            invoiceDetailsGrid.add(unitPriceList.get(i), 4, 14 + i);
            invoiceDetailsGrid.add(totalList.get(i), 5, 14 + i);
        }

        Button mainFromInvoiceDetails = new Button();
        mainFromInvoiceDetails.setText("Main menu");
        mainFromInvoiceDetails.setOnAction(event -> notifyObserver(UiController.mainMenuStackPane));
        invoiceDetailsGrid.add(mainFromInvoiceDetails, 0, 31);

        Button invoiceSubmitButton = new Button();
        invoiceSubmitButton.setText("Submit");
        invoiceSubmitButton.setOnAction(event -> System.out.println("INVOICE SUBMITTED!"));
        invoiceDetailsGrid.add(invoiceSubmitButton, 2, 31);

        ScrollPane invoiceDetailsScroll = new ScrollPane(invoiceDetailsGrid);
        invoiceDetailsScroll.setFitToWidth(true);

        invoiceDetailsStackPane = new StackPane(invoiceDetailsScroll);
        // TODO: this doesn't work, for some reason:
        quantitiyFieldList.get(0).requestFocus();
    }

    private String todaysDate() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter ukFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return now.format(ukFormat);
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
