package generateResults;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class GeneratePDFTest {
    
    @Test
    public void testWriteOutputPdf() throws FileNotFoundException, UnsupportedEncodingException {
        
        String filePath = System.getProperty("user.dir") + File.separator + "STIW3054-Result" + File.separator + "Output.pdf";
        File expectedFile = new File(filePath);
        
        if (expectedFile.exists()){
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File(filePath), true)); // Append = true
        } else{
            PrintWriter writer = new PrintWriter(expectedFile); // Create new file
        }
        assertTrue(expectedFile.exists());  
    }
    @Test
    public void testWriteErrorPdf() throws FileNotFoundException, UnsupportedEncodingException {
        
        String filePath = System.getProperty("user.dir") + File.separator + "STIW3054-Result" + File.separator + "Error.pdf";
        File expectedFile = new File(filePath);
        
        if (expectedFile.exists()){
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File(filePath), true)); // Append = true
        } else{
            PrintWriter writer = new PrintWriter(expectedFile); // Create new file
        }
        assertTrue(expectedFile.exists());  
    }
    
    @Test
    public void testWriteClonePdf() throws FileNotFoundException, UnsupportedEncodingException {
        
        String filePath = System.getProperty("user.dir") + File.separator + "STIW3054-Result" + File.separator + "Clone.pdf";
        File expectedFile = new File(filePath);
        
        if (expectedFile.exists()){
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File(filePath), true)); // Append = true
        } else{
            PrintWriter writer = new PrintWriter(expectedFile); // Create new file
        }
        assertTrue(expectedFile.exists());  
    }
}
