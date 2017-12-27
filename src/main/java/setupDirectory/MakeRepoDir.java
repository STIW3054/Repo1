package setupDirectory;

import java.io.File;
import java.util.ArrayList;

public class MakeRepoDir {
    
    private String reposMainFolder;
    private ArrayList<String> matricNums;
    
    public MakeRepoDir(String reposMainFolder, ArrayList<String> matricNums){
        this.reposMainFolder = reposMainFolder;
        this.matricNums = matricNums;
    }
    
    public void checkRepoDir(){
        // Create folders for every matric number
        for (int a=0; a<matricNums.size(); a++){
            String tempMat = matricNums.get(a);
            File repoDir = new File (reposMainFolder + File.separator + tempMat);
            if (! repoDir.exists()){
                repoDir.mkdirs();
            }
        }
    }
}
