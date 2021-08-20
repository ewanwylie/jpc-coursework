package util;
import util.Entity;

/**
 * Base interface for all objects within the simulation.
 * @author CJ Glue
 * @version 09/08/2021     
 */ 

public interface Entity {
	
	// Returns the ID of the entity.
	String getID();
	
	// Returns true if the entity can be placed in the same cell
	// as another entity, or false otherwise.
	boolean shareSpace(Entity other);

}
