package parkinggaragetwopointoh;

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
}
