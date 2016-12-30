package sample;

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

public class NewCustomer extends JavoiceScreen implements Observable {

    public StackPane newCustomerStackPane;
    private Observer observer;

    public NewCustomer() {
        initialise();
    }

    private void initialise() {
        GridPane addCustomerGrid = new GridPane();
        basicGridSetup(addCustomerGrid, "New customer");

        Label customerName = new Label("Name");
        addCustomerGrid.add(customerName, 0, 2);

        TextField customerNameField = new TextField();
        addCustomerGrid.add(customerNameField, 1, 2);

        Label customerAddressOne = new Label("Address (1)");
        addCustomerGrid.add(customerAddressOne, 0, 3);

        TextField customerAddressOneField = new TextField();
        addCustomerGrid.add(customerAddressOneField, 1, 3);

        Label customerAddressTwo = new Label("Address (2)");
        addCustomerGrid.add(customerAddressTwo, 0, 4);

        TextField customerAddressTwoField = new TextField();
        addCustomerGrid.add(customerAddressTwoField, 1, 4);

        Label customerPostcode = new Label("Postcode");
        addCustomerGrid.add(customerPostcode, 0, 5);

        TextField customerPostcodeField = new TextField();
        addCustomerGrid.add(customerPostcodeField, 1, 5);

        Label customerPhoneNum = new Label("Phone number:");
        addCustomerGrid.add(customerPhoneNum, 0, 6);

        TextField customerPhoneField = new TextField();
        addCustomerGrid.add(customerPhoneField, 1, 6);

        Button mainFromCustomer = new Button();
        mainFromCustomer.setText("Main menu");
        mainFromCustomer.setOnAction(event -> notifyObserver(UiController.mainMenuStackPane));
        addCustomerGrid.add(mainFromCustomer, 0, 7);

        Button submitCustomerBtn = new Button();
        submitCustomerBtn.setText("Add customer");
        submitCustomerBtn.setOnAction(event -> printCustomerDetails(
                customerNameField,
                customerAddressOneField,
                customerAddressTwoField,
                customerPostcodeField,
                customerPhoneField
        ));
        addCustomerGrid.add(submitCustomerBtn, 5, 7);

        newCustomerStackPane = new StackPane(addCustomerGrid);
    }

    private void printCustomerDetails(TextField nameField, TextField customerAddressOneField, TextField customerAddressTwoField, TextField customerPostcodeField, TextField customerPhoneField) {
        System.out.println(String.format("...adding customer %s, from %s %s %s, ph. %s",
                nameField.getText(),
                customerAddressOneField.getText(),
                customerAddressTwoField.getText(),
                customerPostcodeField.getText(),
                customerPhoneField.getText()));
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
