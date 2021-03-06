package parkinggaragetwopointoh;

import static java.lang.Math.toIntExact;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Dan
 */
public class TicketInputTerminal {
    private FeeStrategy rate;
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private int totalLoggedHours=0;
    private double totalGrossed=0;
    private CustomerOutputStrategy cos=new ConsoleParagraphOutput();
     
    public TicketInputTerminal(FeeStrategy fs,GarageOwner go){
        this.rate=fs;
        go.addTicketInputTerminal(this);
    }

    public CustomerOutputStrategy getCos() {
        return cos;
    }

    public void setCos(CustomerOutputStrategy cos) {
        this.cos = cos;
    }
    
    public FeeStrategy getRate(){
        return this.rate;
    }
    public void setRate(FeeStrategy fs){
        this.rate=fs;
    }

    public SimpleDateFormat getTimeFormat() {
        return timeFormat;
    }
    public void setTimeFormat(SimpleDateFormat timeFormat) {
        this.timeFormat = timeFormat;
    }

    public int getTotalLoggedHours() {
        return totalLoggedHours;
    }
    public void setTotalLoggedHours(int totalLoggedHours) {
        this.totalLoggedHours = totalLoggedHours;
    }

    public double getTotalGrossed() {
        return totalGrossed;
    }
    public void setTotalGrossed(double totalGrossed) {
        this.totalGrossed = totalGrossed;
    }
    
    
    
    /**
     * Method that gets the time of Ticket entry used to calculate total cost
     * @param t any Ticket object
     * @return an Int representing elapsed hours
     */
    public int getTicketElapsedTime(Ticket t){
        if(t instanceof Ticket && t!=null){
            Date d1=null;
            Date d2=null;
            try{
                d1=timeFormat.parse(t.getEnterTime());
                Calendar cal = Calendar.getInstance();
                String temp=timeFormat.format(cal.getTime());
                d2=timeFormat.parse(temp);
            }catch(ParseException pe){
                System.out.println("Time cannot be parsed!");
                d1=new Date();
            }
            return getElapsedHoursInt(d1,d2);
        }else{
            throw new IllegalArgumentException();
        }
    }
    
    /**
     * Method that takes two Date objects, and gets the time difference, rounded up
     * to the next whole hour
     * 
     * Method divides entryTime by 3600 to convert milliseconds to hours in order to speed up time
     * (Program does not run on real time, but can if this is adjusted)
     * @param entryTime date object provided by the Ticket object
     * @param exitTime date object that has the time of Ticket entry
     * @return a whole number representing the number of hours parked
     */
    private int getElapsedHoursInt(Date entryTime,Date exitTime){
        long t1=entryTime.getTime();
        long t2=exitTime.getTime();
        int intT1=(int)((t1/3600));
        int intT2=(int)(Math.round(((t2/3600))+0.5));
        return intT2-intT1;
    }
    
    /**
     * Calculates total cost of parking using the RateStrategy
     * @param hours elapsed parking hours
     * @return the cost of parking in accordance to the rate
     */
    public double getParkingCost(int hours){
        this.totalLoggedHours+=hours;
        double parkingCost=rate.getTotalCost(hours);
        this.totalGrossed+=parkingCost;
        return parkingCost;
    }
    
    /**
     * Uses the CustomerOutput to display information to the customer in whichever way is needed, be it console or gui
     * @param t any Ticket object
     */
    public void enterTicket(Ticket t){
        cos.displayCustomerOutput(getTicketElapsedTime(t),t,getParkingCost(getTicketElapsedTime(t)));
    }

    @Override
    public String toString() {
        return "This is a terminal to input tickets and output parking cost";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TicketInputTerminal other = (TicketInputTerminal) obj;
        if (!Objects.equals(this.rate, other.rate)) {
            return false;
        }
        if (!Objects.equals(this.timeFormat, other.timeFormat)) {
            return false;
        }
        if (!Objects.equals(this.cos, other.cos)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.rate);
        hash = 17 * hash + Objects.hashCode(this.timeFormat);
        hash = 17 * hash + Objects.hashCode(this.cos);
        return hash;
    }
    
}
