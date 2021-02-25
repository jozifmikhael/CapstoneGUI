package application;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SensorInputController {
	Optional<String> sensor_Name;
	
	@FXML
    private TextField sensorName;

    @FXML
    private TextField sensorTupleType;

    @FXML
    private TextField sensorUserID;

    @FXML
    private Button saveSensor;

    @FXML
    private TextField sensorAppID;

    @FXML
    private TextField sensorDistribution;
    
    public Optional<String> getSensorName() {
        return sensor_Name;
	}
	
	 @FXML
	    void saveSensorHandler(ActionEvent event) {
		 sensor_Name = Optional.of(sensorName.getText());
	    }
}
