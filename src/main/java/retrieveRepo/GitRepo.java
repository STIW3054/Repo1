package retrieveRepo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GitRepo {
    
    private ArrayList<String> repoURIs = new ArrayList();
    private ArrayList<String> matricNums = new ArrayList();
    
    public void readRepoInfo(){
        String fileSeperator = System.getProperty("file.separator");    
        String workingDirectory = System.getProperty("user.dir");
        String filePath = workingDirectory + fileSeperator + "GithubRepositories.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                int slash = sCurrentLine.lastIndexOf('/');
                matricNums.add(sCurrentLine.substring(slash+1, slash+7));
                repoURIs.add(sCurrentLine);
            }
        }catch (IOException e) {
            System.out.println("Error, file cannot be read.");
        }
    }
    
    public ArrayList<String> getURIs(){
        return repoURIs;
    }
    
    public ArrayList<String> getMatrics(){
        return matricNums;
    }  
}
