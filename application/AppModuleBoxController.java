package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AppModuleBoxController {
	Optional<String> appModuleName;
	
	@FXML
    private TextField nodeName;

    @FXML
    private TextField moduleName;

    @FXML
    private TextField ram;

    @FXML
    private Button saveModule;

    @FXML
    private TextField bandwidth;

    @FXML
    private TextField inTuple;

    @FXML
    private TextField outTuple;

    @FXML
    private TextField size;
    
    @FXML
    private TextField fractionalSensitivity;
    
    @FXML
    private TextField MIPS;
    
    @FXML
    void saveModuleHandler(ActionEvent event) {
    	appModuleName = Optional.of(moduleName.getText());
    	addLine();
    }
    
    private void addLine() {
        String line = nodeName.getText() +" " +moduleName.getText() +" " +ram.getText() +" " +MIPS.getText() +" " +size.getText()+" " +bandwidth.getText()+" "+ inTuple.getText()+" " +outTuple.getText() +" "+fractionalSensitivity.getText() +"\n";
        FileWriter file_writer;
        try {
            file_writer = new FileWriter("modules.txt",true);
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
		String sourceFileName = "modules.txt";
		String jsonFileName = jsonDestinationFileName + ".json";
		//String jsonFileName = "test6.json";
    	TxtParser textfile = new TxtParser();
    		textfile.createTopology(sourceFileName);
    		textfile.writeJSON(jsonFileName);
    }
    
    public Optional<String> getAppModuleName() {
        return appModuleName;
    }
}