package parkinggaragetwopointoh;

import java.util.Objects;

/**
 *
 * @author dvandenberge
 */
public class Ticket {
    private String garageName;
    private String enterTime;
    private String body;
    private int ticketNumber;
    
    public Ticket(String name,String body,String entryTime,int number){
        setGarageName(name);
        setBody(body);
        setEnterTime(entryTime);
        setTicketNumber(number);
    }

    
    public void setEnterTime(String entryTime) {
        if(entryTime!=null){
            this.enterTime=entryTime;
        }else{
            throw new IllegalArgumentException();
        }
    }
    public String getEnterTime(){
        return enterTime;
    }
    
    public String getGarageName() {
        return garageName;
    }
    public void setGarageName(String garageName) {
        if(garageName==null||garageName.length()==0){
            throw new IllegalArgumentException();
        }
        this.garageName = garageName;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }
    public void setTicketNumber(int ticketNumber) {
        if(ticketNumber<0){
            throw new IllegalArgumentException();
        }
        this.ticketNumber = ticketNumber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.garageName);
        hash = 97 * hash + Objects.hashCode(this.enterTime);
        hash = 97 * hash + this.ticketNumber;
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
        final Ticket other = (Ticket) obj;
        if (!Objects.equals(this.enterTime, other.enterTime)) {
            return false;
        }
        if (this.ticketNumber != other.ticketNumber) {
            return false;
        }
        return true;
    }
    
    
}
