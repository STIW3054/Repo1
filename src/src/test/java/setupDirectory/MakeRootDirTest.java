package setupDirectory;

import java.io.File;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class MakeRootDirTest {

    @Test
    public void testMakeRootDir() {
        TargetRoot tar = new TargetRoot();
        String reposMainFolder = tar.getTarget();

        File mainDirectory = new File(reposMainFolder);
        
        assertFalse(mainDirectory.exists());

    }
}
