package parkinggaragetwopointoh;

/**
 *
 * @author dvandenberge
 */
public class TicketDispenser {
    
    private TicketFactory ticketPrinter=new TicketFactory();
    private static int ticketNumber=0;
    private TicketFormatStrategy tfs;
    
    public TicketDispenser(TicketFormatStrategy tfs, GarageOwner go){
        this.tfs=tfs;
        go.addTicketDispenser(this);
    }
    
    public void setTicketFormatStrategy(TicketFormatStrategy tfs){
        if(tfs!=null && tfs instanceof TicketFormatStrategy){
            this.tfs=tfs;
        }else{
            throw new IllegalArgumentException();
        }
    }
    
    public Ticket printTicket(){
        return ticketPrinter.generateTicket(tfs.garageName,tfs.printBody(++ticketNumber),ticketNumber);
    }
}
