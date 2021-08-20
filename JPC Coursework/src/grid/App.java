package grid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uk.ac.aston.jpc.javafx.gridball.model.Board;
import uk.ac.aston.jpc.javafx.gridball.model.Game;

/**
 * JavaFX App
 */
public class App extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Grid grd = new Grid(12, 12);
		Warehouse warehouse = new Warehouse(grd);
		warehouse.addRobot(1, 1);

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("MainWindow.fxml"));
		loader.setController(new MainWindowController(warehouse));
		Parent parent = loader.load();
		
		Scene scene = new Scene(parent);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		stage.setTitle("Grid");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}