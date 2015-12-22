package filewizard;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Dan
 */
public class FileWizard {

    private FileReaderStrategy frs;
    private FileWriterStrategy fws;
    //Can be a readable/writable file. Not really anything else
    private File inputFile;

    public void createNewFileService(FileReaderStrategy frs,FileWriterStrategy fws,TextFormatter tf){
        this.frs=frs;
        this.fws=fws;
        frs.setTextFormatter(tf);
        fws.setTextFormatter(tf);
    }
    
    public FileReaderStrategy getFrs() {
        return frs;
    }
    public void setFrs(FileReaderStrategy frs) {
        this.frs = frs;
    }

    public FileWriterStrategy getFws() {
        return fws;
    }

    public void setFws(FileWriterStrategy fws) {
        this.fws = fws;
    }
    
    public File getInputFile() {
        return inputFile;
    }
    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }
    
    /**
     * outputs a decoded file (first set an input file to be read)
     * also needs a FileReaderStrategy passed in for formatting
     */
    public void readFile(){
        List entries=frs.readFile(inputFile);
        for(int i=0;i<entries.size();i++){
            List entry=(List)entries.get(i);
            for(Object l:entry){
                l=(String)l;
                System.out.print(l+" ");
            }
            //carriage return because reasons
            System.out.println("");
        }
    }
    
    public void convertFile(){
        fws.convertFile(inputFile);
    }
    
    public void writeToFile(HashMap input){
        fws.writeToFile(input);
    }
}
