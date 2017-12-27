package determineFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileExecutors {
    
    private String reposMainFolder;
    private ArrayList<String> matricNums;
    private ArrayList<String> javaFiles;
    
    public FileExecutors(String reposMainFolder, ArrayList<String> matricNums){
        this.reposMainFolder = reposMainFolder;
        this.matricNums = matricNums;
        this.javaFiles = new ArrayList<>();
    }
    
    public void initExecutor(){
        List<Future<String[]>> list = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(matricNums.size());

        for (int i = 0; i < matricNums.size(); i++) {
            String repoDir = reposMainFolder + File.separator + matricNums.get(i);
            Future future = executor.submit(new FileWorker(repoDir));
            list.add(future);
        }

        for (Future<String[]> fut : list) {
            try {
                for (String fileName : fut.get()) {
                    javaFiles.add(fileName);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();  
    }
    
    public ArrayList<String> getJavaFiles(){
        return javaFiles;
    }   
}
