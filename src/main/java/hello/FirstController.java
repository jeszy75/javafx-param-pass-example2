package hello;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;

public class FirstController {

    @FXML
    private TextField nameField;

    @FXML
    private void initialize() {
        nameField.setText(System.getProperty("user.name"));
    }

    @FXML
    private void handleOKButton(ActionEvent event) throws IOException {
        Logger.info("Name entered: {}", nameField.getText());
        FXMLLoader fxmlLoader = new FXMLLoader(FirstController.class.getResource("/fxml/second.fxml"));
        Parent root = fxmlLoader.load();
        SecondController controller = fxmlLoader.<SecondController>getController();
        controller.setName(nameField.getText());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

}
