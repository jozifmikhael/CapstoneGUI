package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import org.fog.test.perfeval.VRGameFog_src;

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
	
	public static void main(String[] args) throws Exception {
<<<<<<< HEAD
		System.out.println("just testing git");
		new VRGameFog_src("test6.json");
=======
		new VRGameFog_src();
>>>>>>> parent of 1584e85... Updated call signature of main sim
		launch(args);
	}
}
