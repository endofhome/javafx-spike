package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDetails implements Observable {

    private Observer observer;
    public StackPane invoiceDetailsStackPane;
    private String fakeOrderNumber = "1053";

    public InvoiceDetails() {
        initialise();
    }

    public void initialise() {
        GridPane invoiceDetailsGrid = new GridPane();

        // Fake customer for testing purposes...
        FakeCustomer fakeCustomer = new FakeCustomer();
        invoiceDetailsGrid.setAlignment(Pos.CENTER);
        invoiceDetailsGrid.setHgap(10);
        invoiceDetailsGrid.setVgap(10);
        invoiceDetailsGrid.setPadding(new Insets(25, 25, 25, 25));

        Text invoiceDetailsTitle = new Text("Invoice details:");
        invoiceDetailsTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        invoiceDetailsGrid.add(invoiceDetailsTitle, 0, 0, 2, 1);

        Label nameLabel = new Label("Name:");
        invoiceDetailsGrid.add(nameLabel, 0, 2);

        TextField nameField = new TextField();
        GridPane.setColumnSpan(nameField, 3);
        nameField.setText(fakeCustomer.name);
        invoiceDetailsGrid.add(nameField, 0, 3);

        Label addressOne = new Label("Address (1):");
        invoiceDetailsGrid.add(addressOne, 0, 4);

        TextField addressField = new TextField();
        GridPane.setColumnSpan(addressField, 4);
        addressField.setText(fakeCustomer.addressOne);
        invoiceDetailsGrid.add(addressField, 0, 5);

        Label addressTwo = new Label("Address (2):");
        invoiceDetailsGrid.add(addressTwo, 0, 6);

        TextField addressTwoField = new TextField();
        GridPane.setColumnSpan(addressTwoField, 3);
        addressTwoField.setText(fakeCustomer.addressTwo);
        invoiceDetailsGrid.add(addressTwoField, 0, 7);

        Label postcodeLabel = new Label("Postcode:");
        invoiceDetailsGrid.add(postcodeLabel, 3, 6);

        TextField postcodeField = new TextField();
        postcodeField.setText(fakeCustomer.postcode);
        invoiceDetailsGrid.add(postcodeField, 3, 7);

        Label dateLabel = new Label("Date:");
        invoiceDetailsGrid.add(dateLabel, 5, 2);

        TextField dateField = new TextField();
        dateField.setText(todaysDate());
        invoiceDetailsGrid.add(dateField, 5, 3);

        Label orderNumberLabel = new Label("Order Number:");
        invoiceDetailsGrid.add(orderNumberLabel, 5, 4);

        TextField orderField = new TextField();
        orderField.setText(fakeOrderNumber);
        invoiceDetailsGrid.add(orderField, 5, 5);

        Label accountCodeLabel = new Label("Account code:");
        invoiceDetailsGrid.add(accountCodeLabel, 5, 6);

        TextField accountCodeField = new TextField();
        accountCodeField.setText(fakeCustomer.accountCode);
        invoiceDetailsGrid.add(accountCodeField, 5, 7);

        Label quantity = new Label("Quantity");
        invoiceDetailsGrid.add(quantity, 0, 12);

        Label description = new Label("Description");
        GridPane.setColumnSpan(description, 3);
        invoiceDetailsGrid.add(description, 1, 12);

        Label unitPrice = new Label("Unit price");
        invoiceDetailsGrid.add(unitPrice, 4, 12);

        Label total = new Label("Total");
        invoiceDetailsGrid.add(total, 5, 12);

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
            invoiceDetailsGrid.add(quantitiyFieldList.get(i), 0, 13 + i);
            invoiceDetailsGrid.add(descriptionFieldList.get(i), 1, 13 + i);
            invoiceDetailsGrid.add(unitPriceList.get(i), 4, 13 + i);
            invoiceDetailsGrid.add(totalList.get(i), 5, 13 + i);
        }

        Button mainFromInvoiceDetails = new Button();
        mainFromInvoiceDetails.setText("Main menu");
        mainFromInvoiceDetails.setOnAction(event -> notifyObserver(UiController.mainMenuStackPane));
        invoiceDetailsGrid.add(mainFromInvoiceDetails, 0, 30);

        Button invoiceSubmitButton = new Button();
        invoiceSubmitButton.setText("Submit");
        invoiceSubmitButton.setOnAction(event -> System.out.println("INVOICE SUBMITTED!"));
        invoiceDetailsGrid.add(invoiceSubmitButton, 2, 30);

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
