package generateResults;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class setupEnvironmentTest {
    @Test
    public void testcheckResultDir() throws FileNotFoundException, UnsupportedEncodingException {
        
        String filePath = System.getProperty("user.dir") + File.separator + "STIW3054-Result";
        File expectedDir = new File(filePath);
        
        if (! expectedDir.exists()){
            expectedDir.mkdirs();  
        }
        assertTrue(expectedDir.exists());  
    }
}
