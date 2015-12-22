package parkinggaragetwopointoh;

/**
 *
 * @author dvandenberge
 */
public interface FeeStrategy {
    public abstract double getMinCharge();
    public abstract double getMaxCharge();
    public abstract double getHourlyRate();
    public abstract double getTotalCost(double hours);
    public abstract void setMinCharge(double minCharge);
    public abstract void setMaxCharge(double maxCharge);
    public abstract void setHourlyRate(double hourlyRate);
}
