package filewizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author dvandenberge
 */
public class CSVFormatter implements TextFormatter{

    private ArrayList<List> formattedArray;
    private String outputStream;
    public CSVFormatter(){
        this.formattedArray=new ArrayList();
        this.outputStream="";
    }
    
    @Override
    public List decode(String data) {
        String[] dataParts=data.split(",");
        List<String> newEntry=new Vector();
        for(int i=0;i<dataParts.length;i++){
            newEntry.add(i,dataParts[i]);
        }
        formattedArray.add(newEntry);
        return formattedArray;
    }
    
    @Override
    public List getFormattedText(){
        return formattedArray;
    }
    
    @Override
    public String encode(String data){
        String[] dataParts=data.split(" ");
        for(String s:dataParts){
            outputStream+=s+",";
        }
        return outputStream;
    }
   
    public void clearOutputStream(){
        outputStream="";
    }
}
