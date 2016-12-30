package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static sample.Main.BLACKBOARD;

public abstract class JavoiceScreen {

    public Text title;

    public void basicGridSetup(GridPane gridPane, String screenTitle) {
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        title = new Text(screenTitle);
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        title.setFill(BLACKBOARD);
        gridPane.add(title, 0, 1, 2, 1);
    }
}
