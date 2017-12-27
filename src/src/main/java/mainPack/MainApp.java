package mainPack;

import retrieveRepo.GitRepo;
import cloneRepo.CloneExecutors;
import com.itextpdf.text.DocumentException;
import compileJava.CompileExecutors;
import determineFile.FileExecutors;
import generateResults.GeneratePDF;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import runJava.RunExecutors;
import setupDirectory.MakeRepoDir;
import setupDirectory.MakeRootDir;
import setupDirectory.TargetRoot;

public class MainApp {
    public static void main (String []args) throws IOException, DocumentException, FileNotFoundException, InterruptedException{
        
        System.out.println("Setting up directories......");
        TargetRoot tar = new TargetRoot();
        String reposMainFolder = tar.getTarget();
        
        MakeRootDir dir = new MakeRootDir(reposMainFolder);
        dir.checkDir();
        
        GitRepo repo = new GitRepo();
        repo.readRepoInfo();
        ArrayList<String> repoURIs = repo.getURIs();
        ArrayList<String> matricNums = repo.getMatrics();
        
        MakeRepoDir repoDir = new MakeRepoDir(reposMainFolder, matricNums);
        repoDir.checkRepoDir();
        
        String resultPath = System.getProperty("user.dir") + File.separator + "STIW3054-Result";
        File resultFolder = new File(resultPath);
        if (resultFolder.exists()){
            FileUtils.forceDelete(new File(resultPath));
        }

        System.out.println("Setup completed!");
        System.out.println("------------------------------------\n");
        
        CloneExecutors clone = new CloneExecutors(reposMainFolder, repoURIs, matricNums);
        System.out.println("Cloning in process......");
        clone.initExecutor();
        System.out.println("Clone completed!");
        System.out.println("------------------------------------\n");
        
        FileExecutors file = new FileExecutors(reposMainFolder, matricNums);
        file.initExecutor();
        ArrayList<String> fileNames = file.getJavaFiles();
        
        System.out.println("Compiling in process......");
        CompileExecutors com = new CompileExecutors(fileNames);
        com.initExecutor();
        System.out.println("Compilation completed!");
        System.out.println("------------------------------------\n");
        
        System.out.println("Running in process......");
        RunExecutors run = new RunExecutors(fileNames);
        run.initExecutor();
        System.out.println("Run completed!");
        System.out.println("------------------------------------\n");
        
        System.out.println("Generating PDF reports......");
        GeneratePDF generate = new GeneratePDF();
        generate.generatePdf();
        System.out.println("PDF report generation completed!");
        System.out.println("------------------------------------\n");
        
        System.exit(0);
    }  
}
