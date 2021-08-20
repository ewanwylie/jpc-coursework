package util;

/**
 * Represents a single position within the warehouse grid.
 * @author CJ Glue
 * @version 09/08/2021
 */

public class Position {
	private int column;
	private int row;
	
	public Position(int x, int y) {
		if (x < 0) {
			throw new IllegalArgumentException("Input should not be negative: " + x);
		} else if (y < 0) {
			throw new IllegalArgumentException("Input should not be negative: " + y);
		}
		this.column = x;
		this.row = y;
	}
	
	public int getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	@Override
	public String toString() {
		return String.format("(%d, %d)", column, row);
	}
}