package parkinggaragetwopointoh;

import filewizard.CSVFormatter;
import java.util.List;
import filewizard.FileWizard;
import filewizard.TextFileReader;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author dvandenberge
 */
public class GarageOwner {
    private List<TicketDispenser> ticketDispensers;
    private List<TicketInputTerminal> ticketInputTerminals;
    private static int DAY_NUMBER=1;
    private FileWizard fw=new FileWizard();
    
    /**
     * Initialize the ArrayLists of entry and exit terminals
     */
    public GarageOwner(){
        this.ticketDispensers = new ArrayList<TicketDispenser>();
        this.ticketInputTerminals = new ArrayList<TicketInputTerminal>();
    }

    /**
     * Method to add terminals to the ArrayList properties of the owner
     * This method is called any time a terminal is created
     * @param td any ticketDispenser
     */
    public void addTicketDispenser(TicketDispenser td){
        if(td instanceof TicketDispenser && td!=null){
            ticketDispensers.add(td);
        }else{
            throw new IllegalArgumentException();
        }
    }
    /**
     * Method to add terminals to the ArrayList properties of the owner
     * This method is called any time a terminal is created
     * @param terminal any TicketInputTerminal
     */
    public final void addTicketInputTerminal(TicketInputTerminal terminal){
        ticketInputTerminals.add(terminal);
    }
    
    /**
     * Allows the garage owner to change all FormatStrategies for every
     * terminal belonging to them
     * @param tfs any TicketFormatStrategy
     */
    public void editDispenserFormatStrategy(TicketFormatStrategy tfs){
        for(TicketDispenser td:ticketDispensers){
            td.setTicketFormatStrategy(tfs);
        }
    }
    /**
     * Allows the garage owner to change the rate structure for each
     * input terminal they own
     * @param fs 
     */
    public void editInputTerminalRate(FeeStrategy fs){
        if(fs instanceof FeeStrategy && fs!=null){
            for(TicketInputTerminal t:ticketInputTerminals){
                t.setRate(fs);
            }
        }
    }
    
    /**
     * Reads and displays a formatted list to the console of the total sales per day
     * the garage has accumulated
     */
    public void retrieveSalesInfo(){
        File salesInfoTargetFile=new File("C:\\temp\\garagetotals.txt");
        fw.setInputFile(salesInfoTargetFile);
        //Create a TextFileReader
        fw.setFrs(new TextFileReader(new CSVFormatter()));
        fw.readFile();
    }
    
    /**
     * Adds a record or records to the txt file containing prior
     * sales info
     */
    public void logSalesInfo(){
        
    }

}
