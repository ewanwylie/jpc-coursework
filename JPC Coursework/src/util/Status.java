package util;

/**
 * Currently used in Order.
 * 
 * @author CJ Glue
 * @version 26/07/2021
 */

public enum Status {
	Unassigned, // Not been assigned to a robot to be completed
	Assigned, // Has been assigned to a robot to be completed
	Collected, // Is complete, ready to be processed
	Dispatched, // Has been packed 
	Charging,  // Applicable to robot only, is attached to a charging station or moving towards it.
}
    