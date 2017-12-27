package cloneRepo;

import java.io.File;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import retrieveRepo.GitRepo;
import setupDirectory.TargetRoot;

public class JGitCloneWorkerTest {
    
    @Test
    public void testJDitCloneWorker(){
    
        TargetRoot tar = new TargetRoot();
        String reposMainFolder = tar.getTarget();
        
        GitRepo repo = new GitRepo();
        ArrayList<String> matricNums = repo.getMatrics();
        
        File tempDirectoy = new File(reposMainFolder + File.separator + matricNums);
        String expectedDir = reposMainFolder + File.separator + matricNums;
        
        
        assertEquals(expectedDir,tempDirectoy.getAbsolutePath());
    }
}
