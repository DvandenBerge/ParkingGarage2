package parkinggaragetwopointoh;

import java.util.Objects;

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
    
    /**
     * Uses the TicketFactory to produce a formatted ticket
     * @return a formatted ticket object
     */
    public Ticket printTicket(){
        return ticketPrinter.generateTicket(tfs.garageName,tfs.printBody(++ticketNumber),ticketNumber);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.ticketPrinter);
        hash = 23 * hash + Objects.hashCode(this.tfs);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TicketDispenser other = (TicketDispenser) obj;
        if (!Objects.equals(this.ticketPrinter, other.ticketPrinter)) {
            return false;
        }
        if (!Objects.equals(this.tfs, other.tfs)) {
            return false;
        }
        return true;
    }
    
    
}
