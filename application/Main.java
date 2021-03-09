package application;
	
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,500,374);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Policy Placement Application");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void stop(){
	    System.out.println("Default JSON Design File Self-Destructing...");
	    FileWriter file_writer;
        try {
            file_writer = new FileWriter("default.json",false);
            BufferedWriter buffered_Writer = new BufferedWriter(file_writer);        
            buffered_Writer.flush();
            buffered_Writer.close();
            

        } catch (IOException e) {
            System.out.println("Overwrite Null failed" +e);
        }
	}
}
