package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Class that represents a single order in the system, as the collection of
 * the shelves that need to be visited. The shelves cannot be changed once this
 * object is created. 
 * @author CJ Glue
 * @version 26/07/2021
 */

public class Order {
	private Status status; // Status of order pertains to whether it is 'Unassigned', 'Assigned', 'Collected' or 'Dispatched'.
	private List<String> shelfUIDs; // List of shelfUIDs refers to the UIDs of the StorageShelf objects where the 'item' is being held and can be collected from.
	private int packingTicks; // Number of ticks it will take to complete the order.
	private int packingProgress; // To keep track of how many ticks have passed when being packed.


	
	public Order(List<String> shelfUIDs, int packingTicks) {
		if (shelfUIDs == null || shelfUIDs.isEmpty()) {
			// If no UIDs have been introduced, the Order cannot be created.
			throw new IllegalArgumentException("An order requires at least one StorageShelf UID to demonstrate the items to be collected.");
		}
		this.shelfUIDs = Collections.unmodifiableList(new ArrayList<String>(shelfUIDs));
		// Prevents the List from being edited once an order has been created.
		this.packingTicks = packingTicks;
		status = Status.Unassigned;
		}
	
	// Return the Status of the Order.
	public Status getStatus() {
		return status;
	}
	
	// Allows the Status of the Order to be changed depending on the Simulation.
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public int getTicks() {
		return packingTicks;
	}
	
	// Return the StorageShelf UIDs relating to the Order.
	public List<String> getUIDs() {
		return shelfUIDs;
	}
	
	public void pack() {
		packingProgress++;
		if (packingProgress == packingTicks) {
			this.status = Status.Dispatched;
		}
	}
	
	// A string representation of the Order.
	//@Override
	//public String toString() {
	//	String result = "Order Status:" + status + "Storage Shelves: " + String.join(", ", shelfUIDs);
	//	return result;
	//}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order: [");
		builder.append("Status: ");
		builder.append(status.toString());
		if (shelfUIDs != null) {
			builder.append("Shelves: ");
			builder.append(String.join(", ",  shelfUIDs));
			builder.append("] ");
		}
		builder.append("[Number of Ticks: ");
		builder.append(packingTicks);
		builder.append("]");
		return builder.toString();
	}
}
