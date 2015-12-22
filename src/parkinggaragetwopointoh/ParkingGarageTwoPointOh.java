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
        
        TicketDispenser td1=new TicketDispenser(new ParagraphFormatter(),owner1);
        TicketInputTerminal ti1=new TicketInputTerminal(new MinimumNoMaximumRate(),owner1);
        
        Ticket t1=td1.printTicket();
        System.out.println(t1.getBody());
        Thread.sleep(500);
        Ticket t2=td1.printTicket();
        System.out.println(t2.getBody());
        
        Thread.sleep(5000);
        ti1.enterTicket(t1);
        
        owner1.logSalesInfo();
        
        Thread.sleep(5000);
        ti1.enterTicket(t2);
        
        owner1.logSalesInfo();
        
        owner1.retrieveSalesInfo();
        
    }
    
}
