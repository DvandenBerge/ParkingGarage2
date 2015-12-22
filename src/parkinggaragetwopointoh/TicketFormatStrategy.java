package parkinggaragetwopointoh;

/**
 *
 * @author dvandenberge
 */
public interface TicketFormatStrategy {
    public static String garageName="Best Value Parking Garage";
    public abstract String printBody(int number);
}
