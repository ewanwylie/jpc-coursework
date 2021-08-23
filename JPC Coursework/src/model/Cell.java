package model;
import java.util.*;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class Cell {

	/**
	 * Base class for anything that goes inside a Cell.
	 */
	public abstract static class Entity {
		private Cell cell;

		public Cell getCell() {
			return cell;
		}

		private void setCell(Cell cell) {
			this.cell = cell;
		}
	}

	private final Grid grid;
	private final int row, column;
	private Cell previousCellInPath;
	private int numberOfStepsFromStart;
	private double distanceToTarget;
	private ListProperty<Entity> entities
		= new SimpleListProperty<>(FXCollections.observableArrayList());

	public Cell(Grid grid, int row, int column) {
		this.grid = grid;
		this.row = row;
		this.column = column;
	}

	public Grid getGrid() {
		return grid;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void removeEntity(Entity entity) {
		if (entity.getCell() == this) {
			entity.setCell(null);
			entities.remove(entity);
		}
	}

	public void addEntity(Entity entity) {
		if (entity.getCell() != this) {
			if (entity.getCell() != null) {
				entity.getCell().removeEntity(entity);
			}
			entity.setCell(this);
			entities.add(entity);
		}
	}

	public ListProperty<Entity> entitiesProperty() {
		return entities;
	}
	
	public boolean equals(Cell cell) {
		if (cell == null)
			return false;

		return (this.row == cell.getRow()) && (this.column == cell.getColumn());
	}
	
	public Cell getPreviousCellInPath() {
		return this.previousCellInPath;
	}

	public void setPreviousCellInPath(Cell previousCell) {
		this.previousCellInPath = previousCell;
	}
	
	public int getNumberOfStepsFromStart() {
		return this.numberOfStepsFromStart;
	}

	public void setNumberOfStepsFromStart(int steps) {
		this.numberOfStepsFromStart = steps;
	}

	public double getDistanceToTarget() {
		return this.distanceToTarget;
	}
	
	public void setDirectDistanceToTarget(double distanceToTarget) {
		this.distanceToTarget = distanceToTarget;
	}
	
	public final int getManhattanDistanceTo(Cell cell) {
		int differenceInColumns = Math.abs(this.getColumn() - cell.getColumn());
		int differenceInRows = Math.abs(this.getRow() - cell.getRow());

		return differenceInColumns + differenceInRows;
	}
}
