package model;

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

}
