package runJava;

import determineFile.FileExecutors;
import java.io.File;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import retrieveRepo.GitRepo;

public class RunExecutorsTest {
    
    @Test
    public void testGetJavaFiles() {
        String reposMainFolder = System.getProperty("user.home") + File.separator +"Desktop" + File.separator +"STIW3054-A171";
        GitRepo repo = new GitRepo();
        repo.readRepoInfo();
        ArrayList<String> matricNums = repo.getMatrics();
        
        FileExecutors file = new FileExecutors(reposMainFolder, matricNums);
        file.initExecutor();
        ArrayList<String> fileNames = file.getJavaFiles();
        RunExecutors run = new RunExecutors(fileNames);

        assertTrue(fileNames.isEmpty());
    }
}
