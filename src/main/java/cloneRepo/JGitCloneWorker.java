
package cloneRepo;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.impl.StaticLoggerBinder; // NEEDED!
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class JGitCloneWorker implements Runnable{
    private String targetFolder;
    private String repoURI;
    private String matricNum;
        
    public JGitCloneWorker(String reposMainFolder, String repoURI, String matricNum){
        targetFolder = reposMainFolder;
        this.repoURI = repoURI;
        this.matricNum = matricNum;
    }
    
    @Override
    public void run() {
        // Clone github repositories into folders created
        File tempDirectoy = new File(targetFolder + File.separator + matricNum);
           
        try {
            Git git = Git.cloneRepository()
                    .setURI(repoURI)
                    .setDirectory(tempDirectoy)
                    .setCloneAllBranches(true) 
                    .call();
        } catch (GitAPIException ex) {
            Logger.getLogger(JGitCloneWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
