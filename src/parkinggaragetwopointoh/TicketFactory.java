/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinggaragetwopointoh;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author dvandenberge
 */
public class TicketFactory {
    
    
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    
    /**
     * Method that returns the entry time of a printed ticket
     * @return A string containing the entry time of a ticket
     */
    private String getTicketEntryTime(){
        //Calendar singleton
        Calendar cal = Calendar.getInstance();
        return timeFormat.format(cal.getTime());
    }
    
    /**
     * Method that generates a ticket with all correct information
     * @param garageName the name of the garage
     * @param body the printed body of the ticket containing ticket number and entry time
     * @param ticketNumber the issued ticket number
     * @return a properly formatted Ticket object
     */
    public Ticket generateTicket(String garageName,String body,int ticketNumber){
        return new Ticket(garageName,body,getTicketEntryTime(),ticketNumber);
    }
}
