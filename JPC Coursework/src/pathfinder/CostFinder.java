import java.util.*;

public class CostEstimator<F extends Enum<F>> {
  private final HashMap<F, Double> costFactors;
  private Cell currentLocation;
  private Double estimatedCost = 0.0;

  public CostEstimator(Cell currentLocation) {
    this.costFactors = new HashMap<F, Double>();
    this.currentLocation = currentLocation;
  }

  public void addCost(F factor, Double value) throws Exception {
    if (factor == null)
      throw new Exception("The parameter 'factor' must not be null.");

    if (value == null)
      throw new Exception("The parameter 'value' must not be null.");

    this.costFactors.put(factor, value);
  }

  public void addCell(Cell location, F factor) throws Exception {
    if (location == null)
      throw new Exception("The parameter 'location' must not be null.");

    if (factor == null)
      throw new Exception("The parameter 'factor' must not be null.");

    if (!this.costFactors.containsKey(factor))
      throw new Exception(
          "Cost factor '" + factor.name() + "' has not been set.");

    Double costValue = this.costFactors.get(factor);
    this.estimatedCost += this.currentLocation.getManhattanDistanceTo(location) * costValue;
    this.currentLocation = location;
  }

  public double getEstimatedCost() {
    return this.estimatedCost;
  }

}