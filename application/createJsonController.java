package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class createJsonController {
	
	public static String jsonDestinationFileName;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField designName;

    @FXML
    private Button setJsonName;

    @FXML
    void saveJsonNameHandler(ActionEvent event) {
        jsonDestinationFileName = designName.getText().toString();
        System.out.println(jsonDestinationFileName + "\n");


    }

    @FXML
    void initialize() {
        assert designName != null : "fx:id=\"designName\" was not injected: check your FXML file 'createJsonBox.fxml'.";
        assert setJsonName != null : "fx:id=\"setJsonName\" was not injected: check your FXML file 'createJsonBox.fxml'.";

    }
}
