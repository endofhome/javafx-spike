package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;

public class Settings extends JavoiceScreen implements Observable {

    private Observer observer;
    public StackPane settingsStackPane;
    private File fakeInvoiceTemplateConfig = new File(String.format("%s/Javoice/Templates/invoice-template.xls", System.getProperty("user.home")));;
    private File fakeInvoiceOutputPathConfig = new File(String.format("%s/Javoice/Invoices", System.getProperty("user.home")));;
    private File fakeSalesLedgerOutputPathConfig = new File(String.format("%s/Javoice/Sales Ledger", System.getProperty("user.home")));;
    private File fakeCustomerDataOutputPathConfig = new File(String.format("%s/Javoice/Customer Data/Customers.xls", System.getProperty("user.home")));;

    public Settings() {
        initialise();
    }

    public void initialise() {
        GridPane settingsGrid = new GridPane();
        basicGridSetup(settingsGrid, "Settings");

        Label invoiceFileTemplateLabel = new Label("Invoice template file:");
        settingsGrid.add(invoiceFileTemplateLabel, 0, 2);

        FileChooser invoiceTemplatePath = new FileChooser();
        File dataDirectory = new File(fakeInvoiceTemplateConfig.getParent());
        invoiceTemplatePath.setInitialDirectory(dataDirectory);
        invoiceTemplatePath.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel '97-2003 spreadsheet", "*.xls"));
        Button updateInvoiceTemplatePath = new Button();
        updateInvoiceTemplatePath.setText(fakeInvoiceTemplateConfig.toString());
        updateInvoiceTemplatePath.setOnAction(event -> chooseInvoiceTemplatePath(invoiceTemplatePath, updateInvoiceTemplatePath));
        settingsGrid.add(updateInvoiceTemplatePath, 1, 2);

        Label invoiceFileOutputLabel = new Label("Invoice output folder:");
        settingsGrid.add(invoiceFileOutputLabel, 0, 3);

        DirectoryChooser invoiceFileOutputPath = new DirectoryChooser();
        invoiceFileOutputPath.setInitialDirectory(fakeInvoiceOutputPathConfig);
        File initialDirectory = invoiceFileOutputPath.getInitialDirectory();
        Button updateInvoiceFileOutputPath = new Button();
        updateInvoiceFileOutputPath.setText(initialDirectory.toString());
        updateInvoiceFileOutputPath.setOnAction(event -> chooseInvoiceOutputPath(invoiceFileOutputPath, updateInvoiceFileOutputPath));
        settingsGrid.add(updateInvoiceFileOutputPath, 1, 3);

        Label salesLedgerOutputLabel = new Label("Sales ledger output folder:");
        settingsGrid.add(salesLedgerOutputLabel, 0, 4);

        DirectoryChooser salesLedgerOutputPath = new DirectoryChooser();
        salesLedgerOutputPath.setInitialDirectory(fakeSalesLedgerOutputPathConfig);
        File initialSalesLedgerDirectory = salesLedgerOutputPath.getInitialDirectory();
        Button updateSalesLedgerOutputPath = new Button();
        updateSalesLedgerOutputPath.setText(initialSalesLedgerDirectory.toString());
        updateSalesLedgerOutputPath.setOnAction(event -> chooseSalesLedgerOutputPath(salesLedgerOutputPath, updateSalesLedgerOutputPath));
        settingsGrid.add(updateSalesLedgerOutputPath, 1, 4);

        Label customerDataLabel = new Label("Customer data file:");
        settingsGrid.add(customerDataLabel, 0, 5);

        FileChooser customerDataOutputPath = new FileChooser();
        File templateDirectory = new File(fakeCustomerDataOutputPathConfig.getParent());
        customerDataOutputPath.setInitialDirectory(templateDirectory);
        customerDataOutputPath.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel '97-2003 spreadsheet", "*.xls"));
        Button updateCustomerLedgerOutputPath = new Button();
        updateCustomerLedgerOutputPath.setText(fakeCustomerDataOutputPathConfig.toString());
        updateCustomerLedgerOutputPath.setOnAction(event -> chooseCustomerDataOutputPath(customerDataOutputPath, updateCustomerLedgerOutputPath));
        settingsGrid.add(updateCustomerLedgerOutputPath, 1, 5);

        Button updateSettings = new Button();
        updateSettings.setText("Update settings");
        updateSettings.setOnAction(event -> System.out.println("settings updated..."));
        settingsGrid.add(updateSettings, 0, 7);

        Button mainFromSettings = new Button();
        mainFromSettings.setText("Main menu");
        mainFromSettings.setOnAction(event -> notifyObserver(UiController.mainMenuStackPane));
        settingsGrid.add(mainFromSettings, 0, 9);

        settingsStackPane = new StackPane(settingsGrid);
    }

    private void chooseInvoiceTemplatePath(FileChooser fileChooser, Button buttonToUpdate) {
        fakeInvoiceTemplateConfig = fileChooser.showOpenDialog(UiController.fixedScene.getWindow());
        fileChooser.setInitialDirectory(new File(fakeInvoiceTemplateConfig.getParent()));
        buttonToUpdate.setText(fakeInvoiceTemplateConfig.toString());
    }

    private void chooseInvoiceOutputPath(DirectoryChooser directoryChooser, Button buttonToUpdate) {
        fakeInvoiceOutputPathConfig = directoryChooser.showDialog(UiController.fixedScene.getWindow());
        directoryChooser.setInitialDirectory(fakeInvoiceOutputPathConfig);
        buttonToUpdate.setText(fakeInvoiceOutputPathConfig.toString());
    }

    private void chooseSalesLedgerOutputPath(DirectoryChooser directoryChooser, Button buttonToUpdate) {
        fakeSalesLedgerOutputPathConfig = directoryChooser.showDialog(UiController.fixedScene.getWindow());
        directoryChooser.setInitialDirectory(fakeSalesLedgerOutputPathConfig);
        buttonToUpdate.setText(fakeSalesLedgerOutputPathConfig.toString());
    }

    private void chooseCustomerDataOutputPath(FileChooser fileChooser, Button buttonToUpdate) {
        fakeCustomerDataOutputPathConfig = fileChooser.showOpenDialog(UiController.fixedScene.getWindow());
        fileChooser.setInitialDirectory(new File(fakeCustomerDataOutputPathConfig.getParent()));
        buttonToUpdate.setText(fakeCustomerDataOutputPathConfig.toString());
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
