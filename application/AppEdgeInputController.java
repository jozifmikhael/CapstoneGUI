package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AppEdgeInputController {
	Optional<String> appEdgeName;
    @FXML
    private TextField parent;

    @FXML
    private TextField child;

    @FXML
    private TextField tupleType;

    @FXML
    private Button saveAppEdge;

    @FXML
    private TextField periodicity;

    @FXML
    private TextField cpuLength;

    @FXML
    private TextField newLength;

    @FXML
    private TextField edgeType;

    @FXML
    private TextField direction;

    @FXML
    void saveAppEdgeHandler(ActionEvent event) {
    	appEdgeName = Optional.of(parent.getText()+"-"+child.getText()+" edge");
    	addLine();
    }
    
    private void addLine() {
        String line = parent.getText() +" " +child.getText() +" "+periodicity.getText()+" " +cpuLength.getText() +" " +newLength.getText()+" " +tupleType.getText()+" " +direction.getText() +" " +edgeType.getText()+"\n";
        FileWriter file_writer;
        try {
            file_writer = new FileWriter("edges.txt",true);
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
    
    public void TxtParser() throws Exception, IOException {
		String sourceFileName = "edges.txt";
		String jsonFileName = "test6.json";
    	TxtParser textfile = new TxtParser();
    		textfile.createTopology(sourceFileName);
    		textfile.writeJSON(jsonFileName);
    }

    public Optional<String> getAppEdgeName() {
        return appEdgeName;
    }
}
