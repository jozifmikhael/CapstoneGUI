package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class SampleController implements Initializable{
	@FXML
    private TextField deviceField;
	
	@FXML
    private MenuItem ProfitAwareItem;

    @FXML
    private MenuItem QosItem;

    @FXML
    private MenuItem LowestPowerItem;
    
    @FXML
    private Button exitButton;
    
    @FXML
    private Button listEditBttn;

    @FXML
    private Button listDeleteBttn;
    
    @FXML
    private TextField simulationTime;

    @FXML
    private TextField policyView;
    
	@FXML
    private Button addMobileButton;
	
    @FXML
    private Button createJsonButton;
		
    //@FXML
    //private Button addCloudButton;

    //@FXML
    //private Button addComputerButton;

    //@FXML
    //private Button addSensorButton;

    //@FXML
    //private Button addActuatorButton;
    @FXML
    private Button addModule;

    @FXML
    private Button addAppEdge;

    @FXML
    private MenuItem resettxt;
    
    @FXML
    private Canvas topoField;

    private ObservableList<String> devices = FXCollections.observableArrayList();
    //private ObservableList<String> sensors= FXCollections.observableArrayList();
    //private ObservableList<String> actuators= FXCollections.observableArrayList();
    
    @FXML
    private ListView<String> policyList;
    
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	System.out.println("init");
//    	topoField();
    }


    @FXML
    private void topoField(){
    	GraphicsContext gc = topoField.getGraphicsContext2D();
    	gc.setFill(Color.GREEN);
    	gc.setStroke(Color.BLUE);
    	gc.fillOval(100, 100, 20, 20);
    }
    
    @FXML
    void addAppEdge(ActionEvent event) {
    try {
    	//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("InputBox.fxml"));
		FXMLLoader addAppEdgeLoader = new FXMLLoader(getClass().getResource("AppEdgeInputBox.fxml"));
		Scene scene = new Scene(addAppEdgeLoader.load(),414,346);
		Stage stage = new Stage();
		stage.setScene(scene);
		AppEdgeInputController saveNewNodeController = addAppEdgeLoader.getController();
		stage.setTitle("Add App Edge");
		stage.showAndWait();
		Optional<String> edge = saveNewNodeController.getAppEdgeName();
		if(edge.isPresent()) {
			devices.add(edge.get());	
		}
		policyList.setItems(devices);
	} catch(Exception e) {
		e.printStackTrace();
	}
	
    }
    
    @FXML
    void addModule(ActionEvent event) {
    	try {
        	//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("InputBox.fxml"));
    		FXMLLoader addAppModuleLoader = new FXMLLoader(getClass().getResource("AppModuleInputBox.fxml"));
    		Scene scene = new Scene(addAppModuleLoader.load(),414,346);
    		Stage stage = new Stage();
    		stage.setScene(scene);
    		AppModuleBoxController saveNewNodeController = addAppModuleLoader.getController();
    		stage.setTitle("Add App Module");
    		stage.showAndWait();
    		Optional<String> module = saveNewNodeController.getAppModuleName();
    		if(module.isPresent()) {
    			devices.add(module.get());	
    		}
    		policyList.setItems(devices);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void deleteBttnHandler(ActionEvent event) {
    	
    }

    @FXML
    void editBttnHandler(ActionEvent event) {
    	
    }
    
   /* @FXML
    void addActuator(ActionEvent event) {
    	try {	
    		//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("ActuatorBox.fxml"));
    		FXMLLoader addNewActuatorLoader = new FXMLLoader(getClass().getResource("ActuatorBox.fxml"));
    		Scene scene = new Scene(addNewActuatorLoader.load(),450,320);
    		ActuatorInputController saveNewNodeController = addNewActuatorLoader.getController();
    		Stage stage = new Stage();
    		stage.setScene(scene);
    		stage.setTitle("Add Actuator");
    		stage.showAndWait();
    		Optional<String> node = saveNewNodeController.getActuatorName();
    		if(node.isPresent()) {
    			devices.add(node.get());	
    		}
    		policyList.setItems(devices);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }*/
    
    /*@FXML
    void addCloud(ActionEvent event) {
    	try {	
    		//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("InputBox.fxml"));
    		FXMLLoader addNewNodeLoader = new FXMLLoader(getClass().getResource("InputBox.fxml"));
    		Scene scene = new Scene(addNewNodeLoader.load(),450,320);
    		Stage stage = new Stage();
    		stage.setScene(scene);
    		InputBoxController saveNewNodeController = addNewNodeLoader.getController();
    		stage.setTitle("Add Cloud Node");
    		stage.showAndWait();
    		Optional<String> node = saveNewNodeController.getNodeName();
    		if(node.isPresent()) {
    			devices.add(node.get());	
    		}
    		policyList.setItems(devices);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }*/

    /*@FXML
    void addComputer(ActionEvent event) {
    	try {	
    		//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("InputBox.fxml"));
    		FXMLLoader addNewNodeLoader = new FXMLLoader(getClass().getResource("InputBox.fxml"));
    		Scene scene = new Scene(addNewNodeLoader.load(),450,320);
    		Stage stage = new Stage();
    		stage.setScene(scene);
    		InputBoxController saveNewNodeController = addNewNodeLoader.getController();
    		stage.setTitle("Add Computer Node");
    		stage.showAndWait();
    		Optional<String> node = saveNewNodeController.getNodeName();
    		if(node.isPresent()) {
    			devices.add(node.get());	
    		}
    		policyList.setItems(devices);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }*/
    
    @FXML
    void exitApp(ActionEvent event) {
    	Stage stage;
    	stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	stage.close();
    }

    @FXML
    void addMobile(ActionEvent event) {
    	try {	
    		//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("InputBox.fxml"));
    		FXMLLoader addNewNodeLoader = new FXMLLoader(getClass().getResource("InputBox.fxml"));
    		Scene scene = new Scene(addNewNodeLoader.load(),450,320);
    		Stage stage = new Stage();
    		stage.setScene(scene);
    		InputBoxController saveNewNodeController = addNewNodeLoader.getController();
    		stage.setTitle("Add Mobile Node");
    		stage.showAndWait();
    		Optional<String> node = saveNewNodeController.getNodeName();
    		if(node.isPresent()) {
    			devices.add(node.get());	
    		}
    		policyList.setItems(devices);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

   /* @FXML
    void addSensor(ActionEvent event) {
    	try {	
    		//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("SensorBox.fxml"));
    		FXMLLoader addNewSensorLoader = new FXMLLoader(getClass().getResource("SensorBox.fxml"));
    		Scene scene = new Scene(addNewSensorLoader.load(),450,320);
    		Stage stage = new Stage();
    		stage.setScene(scene);
    		SensorInputController saveNewNodeController = addNewSensorLoader.getController();
    		stage.setTitle("Add Sensor");
    		stage.showAndWait();
    		Optional<String> node = saveNewNodeController.getSensorName();
    		if(node.isPresent()) {
    			devices.add(node.get());	
    		}
    		policyList.setItems(devices);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }*/
    
    @FXML
    void displaySelected(MouseEvent event) {
    	String device = policyList.getSelectionModel().getSelectedItem();
    	if(device == null || device.isEmpty()) {
    		deviceField.setText("");
    	}else {
    		deviceField.setText(device);
    	}
    }

    @FXML
    void confirmPolicy(ActionEvent event) {
    	try {	
    		BorderPane root = FXMLLoader.load(getClass().getResource("PolicySelectionBox.fxml"));
    		Scene scene = new Scene(root,276,200);
    		Stage stage = new Stage();
    		stage.setScene(scene);
    		stage.setTitle("Add Sensor");
    		stage.show();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void startSim(ActionEvent event) throws IOException {
    	String policy = simulationTime.getText()+" "+policyView.getText();
    	FileWriter file_writer;
        try {
            file_writer = new FileWriter("simTime.txt",true);
            BufferedWriter buffered_Writer = new BufferedWriter(file_writer);
            buffered_Writer.write(policy);
            buffered_Writer.flush();
            buffered_Writer.close();
        } catch (IOException e) {
            System.out.println("Add line failed!" +e);
        }

    	String command = "AutoClicker.exe";
           // Running the above command 
           Runtime run  = Runtime.getRuntime(); 
           Process proc = run.exec(command);
    }
     
    @FXML
    void createJson(ActionEvent event) {
    	try {	
    		BorderPane root = FXMLLoader.load(getClass().getResource("createJsonBox.fxml"));
    		Scene scene = new Scene(root,414,139);
    		Stage stage = new Stage();
    		stage.setScene(scene);
    		stage.setTitle("Create New Design File");
    		stage.show();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
	}
    
    @FXML
    void resetalltxt(ActionEvent event) {
    	System.out.println("resetting all text files");
    	FileWriter file_writer;
        try {
            file_writer = new FileWriter("instances.txt",false);
            file_writer = new FileWriter("edges.txt",false);
            file_writer = new FileWriter("modules.txt",false);
            BufferedWriter buffered_Writer = new BufferedWriter(file_writer);
         //   buffered_Writer.write(line);
            buffered_Writer.flush();
            buffered_Writer.close();
            

        } catch (IOException e) {
            System.out.println("Add line failed!" +e);
        }
    }

    
}
