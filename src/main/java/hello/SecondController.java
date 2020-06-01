package hello;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.tinylog.Logger;

public class SecondController {

    @FXML
    private Text text;

    private StringProperty name = new SimpleStringProperty();

    @FXML
    private void initialize() {
        Logger.info("name = {}", name);
        text.textProperty().bind(Bindings.concat("Hello, ", name, "!"));
    }

    public void setName(String name) {
        Logger.info("Setting name to {}", name);
        this.name.set(name);
    }

    @FXML
    private void handleExitButton(ActionEvent event) {
        Platform.exit();
    }

}
