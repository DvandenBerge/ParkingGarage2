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
        
        //Creating a dispenser and an input for ticket production and input
        TicketDispenser td1=new TicketDispenser(new ParagraphFormatter(),owner1);
        TicketInputTerminal ti1=new TicketInputTerminal(new MinimumNoMaximumRate(),owner1);
        
        //creating a ticket and displaying the body info
        Ticket t1=td1.printTicket();
        System.out.println(t1.getBody());
        
        //creating another ticket a few "hours" later
        Thread.sleep(500);
        Ticket t2=td1.printTicket();
        //and printing the body
        System.out.println(t2.getBody());
        
        //the car is parked for a another couple of "hours"
        Thread.sleep(5000);
        //and the first one is submitted
        ti1.enterTicket(t1);
        
        //sales info is logged for that transaction
        owner1.logSalesInfo();
        
        //more waiting
        Thread.sleep(5000);
        ti1.enterTicket(t2);
        
        //entry logged
        owner1.logSalesInfo();
        
        //retrieval
        owner1.retrieveSalesInfo();
        
    }
    
}
