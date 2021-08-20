package util;

import java.util.Set;

/**
 * Base abstract class for all objects within the simulation.
 * @author CJ Glue  
 * @version 09/08/2021 
 */

public abstract class Actor implements Entity {
	private String ID;
	
	public Actor(String id) {
		this.ID = id;
	}
	
	@Override
	public String getID() {
		return ID;
	}
	
	public Position getPosition() {
		// Returns the position of the Actor in the warehouse.
		// Requires Simulation and Warehouse setup.
		return null;
	}
	
	public Set<Entity> getAllActors() {
		// Returns all Actors in the same cell including itself.
		// Requires Simulation and Warehouse setup.
		return null;
	}
}
