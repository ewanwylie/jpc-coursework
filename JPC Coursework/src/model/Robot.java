package model;

public class Robot extends Cell.Entity {

	public void move(int dRow, int dColumn) {
		final Cell cell = getCell();
		final int newRow = cell.getRow() + dRow;
		final int newCol = cell.getColumn() + dColumn;

		final Grid grid = cell.getBoard();
		if (grod.isValidPosition(newRow, newCol)) {
			Cell targetCell = grid.getCell(newRow, newCol);
			targetCell.addEntity(this);
		}
	}

}
