package application;

import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class InputBoxController {
	Optional<String> nodeName;
	
	@FXML
    private TextField name;

    @FXML
    private TextField mips;

    @FXML
    private TextField ram;

    @FXML
    private Button saveNode;

    @FXML
    private TextField upbw;

    @FXML
    private TextField downbw;

    @FXML
    private TextField nodelvl;

    @FXML
    private TextField ratePerMIPS;

    @FXML
    private TextField busyPower;

    @FXML
    private TextField idlePower;

    @FXML
    void saveNodeHandler(ActionEvent event) {
    	nodeName = Optional.of(name.getText());  	
    	addLine();
    	
    }
    
    private void addLine() {
        String line = name.getText().toString() +" " +mips.getText() +" " +ram.getText() +" " +upbw.getText() +" " +downbw.getText()+" " +nodelvl.getText()+" " +ratePerMIPS.getText() +" " +busyPower.getText()+" " +idlePower.getText() +"\n";
// https://stackoverflow.com/questions/53020451/how-to-create-javafx-save-read-information-from-text-file-and-letting-user-to-e
         FileWriter file_writer;
        try {
            file_writer = new FileWriter("instances.txt",true);
            BufferedWriter buffered_Writer = new BufferedWriter(file_writer);
            buffered_Writer.write(line);
            buffered_Writer.flush();
            buffered_Writer.close();
        } catch (IOException e) {
            System.out.println("Add line failed!" +e);
        }
        	try {
				TxtParser();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    
    String jsonDestinationFileName = createJsonController.jsonDestinationFileName;
    
    public void TxtParser() throws Exception, IOException {
		String sourceFileName = "instances.txt";
		//String jsonFileName = "test6.json";
		String jsonFileName = jsonDestinationFileName + ".json";
    	TxtParser textfile = new TxtParser();
    		textfile.createTopology(sourceFileName);
    		textfile.writeJSON(jsonFileName);
    }
    
	public Optional<String> getNodeName() {
        return nodeName;
    }

	
}
