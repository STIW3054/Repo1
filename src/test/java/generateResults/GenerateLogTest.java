package generateResults;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class GenerateLogTest {
    
    @Test
    public void testWriteLog() throws FileNotFoundException, UnsupportedEncodingException {
        
        String filePath = System.getProperty("user.dir") + File.separator + "STIW3054-Result" + File.separator + "Clone.log";
        File expectedFile = new File(filePath);
        
        if (expectedFile.exists()){
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File(filePath), true)); // Append = true
        } else{
            PrintWriter writer = new PrintWriter(expectedFile, "UTF-8"); // Create new file
        }
        assertTrue(expectedFile.exists());  
    }
}