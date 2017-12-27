package setupDirectory;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TargetRootTest {
    
    @Test
    public void testTargetRoot(){
        TargetRoot tr = new TargetRoot();
        String fileSeperator = System.getProperty("file.separator");        
        String expectedTR =  System.getProperty("user.home") + fileSeperator +"Desktop" + fileSeperator +"STIW3054-A171";
        
        assertEquals(expectedTR, tr.getTarget());
    }
}
