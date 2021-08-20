package util;

/**
 * Class to represent a single packing station within the simulation.
 * @author CJ Glue
 * @version 09/08/2021  
 */

	public class PackingStation extends Actor {
		
		/*
		 * private Order order; private int ticksWhenOrderPlaced; private int
		 * remainingTicks; private List<StorageShelf> shelvesVisited; private String
		 * uid; private Status status;
		 * 
		 * public PackingStation(String uid) { this.uid = uid; }
		 * 
		 * public Status getStatus() { return status; }
		 * 
		 * public void setStatus(Status status) { this.status = status; }
		 */
		
		public PackingStation(String id) {
			super(id);
		}

		@Override
		public boolean shareSpace(Entity other) {
			// Can only share space with a single Robot.
			return other instanceof Robot;
		}
	}

