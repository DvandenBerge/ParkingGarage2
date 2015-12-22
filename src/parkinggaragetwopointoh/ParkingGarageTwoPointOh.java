package parkinggaragetwopointoh;

import filewizard.FileWizard;

/**
 *
 * @author dvandenberge
 */
public class ParkingGarageTwoPointOh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception{
        
        GarageOwner owner1 = new GarageOwner();
        
        TicketFactory tf=new TicketFactory();
        Ticket t=tf.generateTicket("A", "B", 5);
        Thread.sleep(5000);
        TicketInputTerminal ti1=new TicketInputTerminal(new MinimumNoMaximumRate(),owner1);
        ti1.enterTicket(t);
        owner1.logSalesInfo();
        owner1.retrieveSalesInfo();
        
    }
    
}
