




package filewizard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author dvandenberge
 */
public class TextFileWriter implements FileWriterStrategy{

    private TextFormatter formatter;
    
    public TextFileWriter(TextFormatter tf){
        this.formatter=tf;
    }
    
    @Override
    public TextFormatter getTextFormatter(){
        return this.formatter;
    }
    @Override
    public void setTextFormatter(TextFormatter tf){
        this.formatter=tf;
    }
    
    @Override
    public void convertFile(File f) { 
        try{
            File outputFile=new File("C:" + File.separatorChar + "temp" + File.separatorChar + "output.txt");
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile,false)));
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line=reader.readLine();
            while(line!=null){
                writer.write(formatter.encode(line));
                line=reader.readLine();
                formatter.clearOutputStream();
            }
            writer.close();
        }catch(IOException e){
            System.out.println("Cannot write that file");
        }
    }
    
    @Override
    public void writeToFile(HashMap m){
        try{
            File outputFile=new File("C:\\temp\\garagetotals.txt");
            PrintWriter writer=new PrintWriter(new BufferedWriter(new FileWriter(outputFile,true)));
            Set inputKeySet=m.keySet();
            String line="";
            for(Object o:inputKeySet){
                int day=(int)o;
                double profit=(double)m.get(o);
                line=day+","+profit+"\n";
                writer.write(line);
            }
            writer.close();
        }catch(FileNotFoundException ioe){
            System.out.println("Cannot append file");
        }catch(IOException ioe){
            System.out.println("Critical Failure");
        }
    }
}
