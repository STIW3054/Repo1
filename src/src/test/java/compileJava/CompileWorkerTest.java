package compileJava;

import determineFile.FileExecutors;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import retrieveRepo.GitRepo;
import setupDirectory.TargetRoot;

public class CompileWorkerTest {
    
    private String filePath;
    
    public void testingCompileWorker(){
        
        TargetRoot tar = new TargetRoot();
        String reposMainFolder = tar.getTarget();
        GitRepo repo = new GitRepo();
        ArrayList<String> matricNums = repo.getMatrics();
         
        FileExecutors file = new FileExecutors(reposMainFolder, matricNums);
        ArrayList<String> fileNames = file.getJavaFiles();
        
        CompileExecutors com = new CompileExecutors(fileNames);

        this.filePath = filePath;
        CompileWorker cw = new CompileWorker(filePath);
    }
    
    @Test
    public void testCompileWorker(){
        boolean actualResult = true;
        assertTrue(true);
    }
}
