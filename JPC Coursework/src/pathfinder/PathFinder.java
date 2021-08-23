import java.util.*;

public class PathFinder extends {
	private Grid grid;
	List<Cell> unexploredCells;
	List<Cell> exploredCells;
	protected Cell origin;
	protected Cell target; 
	protected Deque<Cell> path;
	
	public PathFinder(int width, int height, Cell origin, Cell target) {
		this.grid = new Grid(width, height);
		this.origin = new Cell(origin);
		this.target = new Cell(target);
			
	}

	protected void calculatePath(Cell beginningLocation, Cell targetLocation) {
		if (beginningLocation.equals(targetLocation))
			return; 

		this.unexploredCells = new ArrayList<Cell>(
				this.grid.getWidth() * this.grid.getHeight());
		this.exploredCells = new ArrayList<Cell>(
				this.grid.getWidth() * this.floor.getHeight());

		this.unexploredCells.add(origin);

		searchForPath(targetLocation);

		// Populate the path with calculated route.
		this.path = PathFinder.convertLinkedCellsToPath(beginningLocation, targetLocation);
	}
		
	private void searchForPath(Cell targetLocation) {
		Cell targetLocation = grid.getCell(targetLocation.getRow(), targetLocation.getColumn());
		
		do {
			Collections.sort(this.unexploredCells);

			Cell currentCell = this.unexploredCells.get(0);

			if (currentCell.equals(targetLocation))
				break;

			int nextStepCost = currentCell.getNumberOfStepsFromStart() + 1;

			this.checkNodeForExplorationInDirection(nextStepCost, currentNode, targetNode, +0, -1); // ABOVE
			this.checkNodeForExplorationInDirection(nextStepCost, currentNode, targetNode, +1, +0); // RIGHT
			this.checkNodeForExplorationInDirection(nextStepCost, currentNode, targetNode, +0, +1); // BELOW
			this.checkNodeForExplorationInDirection(nextStepCost, currentNode, targetNode, -1, +0); // LEFT

			this.unexploredCells.remove(currentCell);
			this.exploredNodes.add(currentCell);

		} while (unexploredCells.size() > 0);
	}

	private void checkCellForExplorationInDirection(int nextStepCost, Cell previous,
			Cell target, int columnChange, int rowChange) {
		Cell current =
				grid.getCell(previous.getColumn() + columnChange, previous.getRow() + rowChange);
		if (current != null)
			this.checkCellorExploration(current, nextStepCost, previous, target);
	}

	private void checkCellForExploration(Cell current, int nextStepCost,
			Cell previous, Cell target) {
		if (!this.grid.isValidPosition(current.getRow(), current.getColumn()))
			return; 
		if (previous.getNumberOfStepsFromStart() == 0 && !grid.isValidPosition(current.getRow(), current.getColumn()))
			return; 
		
		if (nextStepCost < current.getNumberOfStepsFromStart()) {
			this.exploredCells.remove(current);
			this.unexploredCells.remove(current);
		}

		if (this.unexploredCells.contains(current) || this.exploredCells.contains(current))
			return; 
		
		current.setNumberOfStepsFromStart(nextStepCost);
		current.setDirectDistanceToTarget(current.getManhattanDistanceTo(target));
		current.setPreviousNodeInPath(previous);
		this.unexploredCells.add(current);
	}


	private static Deque<Cell> convertLinkedCellsToPath(Cell start,
			Cell end) {
		Deque<Cell> path = new LinkedList<Cell>();
		Cell currentCell = end;

		while (!currentCell.equals(start)) {
			path.addFirst(currentCell);
			currentCell = currentCell.getPreviousCellInPath();
		}

		return path;
	}
}
