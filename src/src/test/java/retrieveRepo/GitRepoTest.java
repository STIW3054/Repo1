package retrieveRepo;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

public class GitRepoTest {
    
    @Test
    public void testGitRepo(){

        String fileSeperator = System.getProperty("file.separator");    
        String workingDirectory = System.getProperty("user.dir");
        String expectedFilePath = workingDirectory + fileSeperator + "GithubRepositories.txt";

        File actualFilePath = new File (workingDirectory + fileSeperator + "GithubRepositories.txt");
        assertEquals (expectedFilePath,actualFilePath.getAbsolutePath());
    }
}