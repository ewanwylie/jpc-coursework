package grid;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import uk.ac.aston.jpc.javafx.gridball.model.Ball;
import uk.ac.aston.jpc.javafx.gridball.model.Cell;
import uk.ac.aston.jpc.javafx.gridball.model.Cell.Entity;
import uk.ac.aston.jpc.javafx.gridball.model.Game;

public class MainWindowController {

	@FXML
	private GridPane grid;

	private final Warehouse warehouse;

	public MainWindowController(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@FXML
	public void initialize() {
		grid.getChildren().clear();

		for (int iRow = 0; iRow < warehouse.getGrid().getHeight(); iRow++) {
			for (int iCol = 0; iCol < warehouse.getGrid().getWidth(); iCol++) {
				StackPane pane = new StackPane();
				pane.setPrefWidth(50);
				pane.setPrefHeight(50);
				pane.getStyleClass().add("gridCell");
				grid.add(pane, iCol, iRow);

				final Cell cell = warehouse.getGrid().getCell(iRow, iCol);

				// First draw
				redrawCell(pane, cell.entitiesProperty().get());

				// In case it changes
				cell.entitiesProperty().addListener(new ListChangeListener<Entity>() {
					@Override
					public void onChanged(Change<? extends Entity> change) {
						redrawCell(pane, cell.entitiesProperty().get());
					}
				});
			}
		}
	}

	private void redrawCell(StackPane pane, ObservableList<? extends Entity> list) {
		pane.getChildren().clear();
		for (Entity e : list) {
			if (e instanceof Robot) {
				final Circle circle = new Circle(30);
				pane.getChildren().add(circle);
			}
		}
	}

	/*@FXML
	public void upPressed() {
		warehouse.getRobot().move(-1, 0);
	}

	@FXML
	public void leftPressed() {
		warehouse.getRobot().move(0, -1);
	}

	@FXML
	public void rightPressed() {
		warehouse.getRobot().move(0, 1);
	}

	@FXML
	public void downPressed() {
		warehouse.getRobot().move(1, 0);
	}*/
	
}
