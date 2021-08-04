package util;

public class PackingStation {

	private Order order;
	private int ticksWhenOrderPlaced;
	private int remainingTicks;
	private List<StorageShelf> shelvesVisited;
	private String uid;
	private Status status;
	
	public PackingStation(String uid) {
		this.uid = uid;
	}

	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	

	//need warehouse completed in order to implement packing methods 

}
