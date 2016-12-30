package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.time.LocalDate;

import static sample.Main.BLACKBOARD;
import static sample.Main.OXBLOOD;

public class MainMenu extends JavoiceScreen implements Observable {
    public StackPane mainMenuStackPane;
    private Observer observer;

    public MainMenu() {
        initialise();
    }

    private void initialise() {
        GridPane mainMenuGrid = new GridPane();
        basicGridSetup(mainMenuGrid, "Main menu");

        Text bannerTitle = new Text("J A V O I C E");
        bannerTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        bannerTitle.setFill(OXBLOOD);
        mainMenuGrid.add(bannerTitle, 0, 0, 2, 1);

        Button mainNewInvoice = new Button();
        mainNewInvoice.setText("New invoice");
        mainNewInvoice.setTextFill(BLACKBOARD);
        mainNewInvoice.setMinWidth(200);
        mainNewInvoice.setStyle("-fx-focus-color: transparent;");
        mainNewInvoice.setOnAction(event -> notifyObserver(UiController.newInvoiceStackPane));
        mainMenuGrid.add(mainNewInvoice, 0, 7);

        Button mainNewCustomer = new Button();
        mainNewCustomer.setText("New customer");
        mainNewCustomer.setTextFill(BLACKBOARD);
        mainNewCustomer.setMinWidth(200);
        mainNewCustomer.setStyle("-fx-focus-color: transparent;");
        mainNewCustomer.setOnAction(event -> notifyObserver(UiController.newCustomerStackPane));
        mainMenuGrid.add(mainNewCustomer, 0, 8);

        Button mainSettings = new Button();
        mainSettings.setText("Settings");
        mainSettings.setTextFill(BLACKBOARD);
        mainSettings.setMinWidth(200);
        mainSettings.setStyle("-fx-focus-color: transparent;");
        mainSettings.setOnAction(event -> notifyObserver(UiController.settingsStackPane));
        mainMenuGrid.add(mainSettings, 0, 9);

        Label copyright = new Label(String.format("© %s  Tom Barnes", copyrightYears()));
        copyright.setTextFill(OXBLOOD);
        mainMenuGrid.add(copyright, 0, 16);

        mainMenuStackPane = new StackPane(mainMenuGrid);
        mainMenuStackPane.getStylesheets().add("sample/javoice.css");
        bannerTitle.requestFocus();
    }

    private String copyrightYears() {
        if (LocalDate.now().getYear() == 2016) {
            return "2016";
        }
        return String.format("2016-%s", LocalDate.now().getYear());
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
