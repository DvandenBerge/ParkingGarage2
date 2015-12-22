package parkinggaragetwopointoh;

/**
 *
 * @author Dan
 */
public class ConsoleParagraphOutput implements CustomerOutputStrategy{

    @Override
    public void displayCustomerOutput(int hours, Ticket t, double cost) {
        System.out.println("Thank you for parking at "+t.getGarageName());
        System.out.println("Ticket Number: "+t.getTicketNumber());
        System.out.println("Total Time Parked: "+hours+" hours");
        System.out.println("Total amount owed: $"+cost);
        System.out.println("Please stop by again!");
    }
    
}
