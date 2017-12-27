package setupDirectory;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class MakeRootDir {
    
    private String targetDir;

    public MakeRootDir(String reposMainFolder) {
        targetDir = reposMainFolder;
    }
    
    public void checkDir() throws IOException{
        File mainDirectory = new File(targetDir);
        
        // Create STIW3054-A171 folder if not exist
        if (! mainDirectory.exists()){
            mainDirectory.mkdirs();
        } else{
            // Empty the target folder
            FileUtils.cleanDirectory(mainDirectory);
        }
    }  
}
