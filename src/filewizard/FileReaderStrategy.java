package filewizard;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dan
 */
public interface FileReaderStrategy {
    public abstract List readFile(File inputFile);
    public abstract TextFormatter getTextFormatter();
    public abstract void setTextFormatter(TextFormatter tf);
}
