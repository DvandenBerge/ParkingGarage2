package filewizard;

import java.io.File;
import java.util.HashMap;

/**
 *
 * @author dvandenberge
 */
public interface FileWriterStrategy {
    public abstract void convertFile(File f);
    public abstract TextFormatter getTextFormatter();
    public abstract void setTextFormatter(TextFormatter tf);
    public abstract void writeToFile(HashMap m);
}
