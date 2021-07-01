package util;

public class Order {
	private String status;

	
	public Order(String status) {
		this.status = status;
		}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}

// Array of Items per order? + status of order
// Display all items + status