package util;

import java.util.List;

public class Order {
	private String status;
	private List<String> shelfUIDs;
	// ^ Status of order pertains to whether it is 'Unassigned', 'Assigned' or 'Dispatched'.
	// List of shelfUIDs refers to the UIDs of the StorageShelf objects where the 'item' is being held and can be collected from.

	
	public Order(String status, List<String> shelfUIDs) {
		if (shelfUIDs == null || shelfUIDs.isEmpty()) {
			// If no UIDs have been introduced, the Order cannot be created.
			throw new IllegalArgumentException("An order requires at least one StorageShelf UID to demonstrate the items to be collected.");
		}
		this.status = status;
		this.shelfUIDs = shelfUIDs;
		}
	
	// Return the Status of the Order.
	public String getStatus() {
		return status;
	}
	
	// Allows the Status of the Order to be changed depending on the Simulation.
	public void setStatus(String status) {
		this.status = status;
	}
	
	// Return the StorageShelf UIDs relating to the Order.
	public List<String> getUIDs() {
		return shelfUIDs;
	}
	
	// A string representation of the Order.
	@Override
	public String toString() {
		String result = "Order Status:" + status + "Storage Shelves: " + String.join(", ", shelfUIDs);
		return result;
	}
}
