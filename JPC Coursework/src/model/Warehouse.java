package model;

public class Warehouse {

	private Grid grid;
	private Robot robot;

	public Warehouse(Grid grid) {
		this.grid = grid;
	}

	public Grid getGrid() {
		return grid;
	}

	public Robot getRobot() {
		return robot;
	}

	public void addRobot(int row, int column) {
		robot = new Robot();
		grid.getGrid(row, column).addEntity(robot);
	}
	
}
