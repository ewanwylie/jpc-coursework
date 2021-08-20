package util;

/**
 * A class to represent a single charging pod within the simulation.
 * A charging pod is assigned to a single robot, and can only be used by 
 * that robot. It charges the robot that shares its location if they are
 * owned, which takes a set number of ticks.
 * @author CJ Glue
 * @version 09/08/2021
 */

public class ChargingPod extends Actor{

	public final int defaultChargeSpeed = 1;
	private Robot robot;
	private int chargeSpeed = defaultChargeSpeed;
	
	public ChargingPod(String id, Robot r) {
		super(id);
		
		if (r == null) {
			throw new IllegalArgumentException("You must connect a robot to the Charging Pod");
		}
		this.robot = r;
	}

	@Override
	public boolean shareSpace(Entity other) {
		// Can be occupied by a single Robot
		// If the ChargingPod is not owned by the Robot, they can pass through it.
		return other instanceof Robot;
	}
	
	public Robot getRobot() {
		return robot;
	}
	
	public int getChargeSpeed() {
		return chargeSpeed;
	}

}
