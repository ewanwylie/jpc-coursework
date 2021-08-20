package model;

public class Grid {

	private final Cell[] cells;
	private final int width;
	private final int height;

	public Grid(int width, int height) {
		this.width = width;
		this.height = height;

		cells = new Cell[width * height];
		for (int i = 0; i < cells.length; ++i) {
			cells[i] = new Cell(this, i / width, i % width);
		}
	}

	public Cell getCell(int row, int column) {
		return cells[row * width + column];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isValidPosition(int row, int column) {
		return row >= 0 && row < height && column >= 0 && column < width;
	}
}
