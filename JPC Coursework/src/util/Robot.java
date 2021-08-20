package util;
import java.util.Queue;


/**
 * Class to represent a single robot within the simulation.
 * @author CJ Glue
 * @version 09/08/2021
 */

public class Robot extends Actor {
	
	private final int minCharge = 1;
	private final int emptyPowerUse = 1;
	private final int fullPowerUse = 2;
	private final int defaultMaxCharge = 10;
	
	private State state;
	
	public int getPowerUsage(State state) {
		if (state == State.Waiting) {
			return emptyPowerUse;
		}
		else if (state == State.Charging) {
			return emptyPowerUse;
		}
		else if (state == State.toShelf) {
			return emptyPowerUse;
		}
		else if (state == State.toStation) {
			return fullPowerUse;
		}
		else if (state == State.toPod) {
			return emptyPowerUse;
		}
		return 0;
	}
	
	private int maxCharge = defaultMaxCharge;
	private Queue<Integer> currentCharge;
	
	public Robot(String id) {
		super(id);
		currentCharge.add(maxCharge);
	}

	@Override
	public boolean shareSpace(Entity other) {
		// Cannot be in the same space as another robot.
		return !(other instanceof Robot);
	}

	
}
