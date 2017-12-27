package setupDirectory;


import java.io.File;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import retrieveRepo.GitRepo;

public class MakeRepoDirTest {

    @Test
    public void testMakeRepoDir() {
        
        TargetRoot tar = new TargetRoot();
        String reposMainFolder = tar.getTarget();
        GitRepo repo = new GitRepo();
        ArrayList<String> matricNums = repo.getMatrics();

        for (int a = 0; a < matricNums.size(); a++) {
            String tempMat = matricNums.get(a);
            File expectedrepoDir = new File(reposMainFolder + File.separator + tempMat);

            assertTrue(expectedrepoDir.exists());
        }
    }

}
