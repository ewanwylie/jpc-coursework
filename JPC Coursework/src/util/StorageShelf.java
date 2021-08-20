package util;

/**
 * A class to represent a single storage shelf within the simulation.
 * This does not take any actions, and acts as a marker for the robots
 * when completing orders.
 * @author CJ Glue 
 * @version 09/08/2021 
 */

public class StorageShelf extends Actor{

	public StorageShelf(String id) {
		super(id);
	}

	@Override
	public boolean shareSpace(Entity other) {
		// Can share space with a single robot.
		return other instanceof Robot;
	}
	
	

} 
