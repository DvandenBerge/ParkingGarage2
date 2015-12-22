/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinggaragetwopointoh;

/**
 *
 * @author dvandenberge
 */
public class ParagraphFormatter implements TicketFormatStrategy{
    @Override
    public String printBody(int number) {
        String body="";
        body+="Hello! Welcome to "+TicketFormatStrategy.garageName+"!"+"\n";
        body+="Your ticket number is "+number+"\n";
        body+="Insert this ticket into the gate at the end to finalize payment"+"\n";
        return body;
    }
}
