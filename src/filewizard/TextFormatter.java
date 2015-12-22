package filewizard;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dvandenberge
 */
public interface TextFormatter {
    //Writing
    public List decode(String data);
    public List getFormattedText();
    
    public String encode(String data);
    public void clearOutputStream();
}
