
package cloneRepo;

import generateResults.GenerateLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CloneExecutors {
    
    private String reposMainFolder;
    private ArrayList<String> repoURIs;
    private ArrayList<String> matricNums;
    
    public CloneExecutors(String reposMainFolder, ArrayList<String> repoURIs, ArrayList<String> matricNums){
        this.reposMainFolder = reposMainFolder;
        this.repoURIs = repoURIs;
        this.matricNums = matricNums;
    }
    
    public void initExecutor() throws IOException{
        final int WAITTIME = 60;        
        int numOfThreads = matricNums.size();
        GenerateLog log = new GenerateLog();
        
        List<Future> list = new ArrayList<>();
        ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(numOfThreads);
        
        for(int i=0; i< numOfThreads; i++){
            Runnable worker = new JGitCloneWorker(reposMainFolder, repoURIs.get(i), matricNums.get(i));
            Future future = executor.submit(worker);
            list.add(future);
        }        
        executor.shutdown();
        
        try {
            if (!executor.awaitTermination(WAITTIME, TimeUnit.SECONDS)) {
                for (int i = 0; i < list.size(); i++) {
                    if (!list.get(i).isDone()) {
                        list.get(i).cancel(true);
                        log.writeLog("Cloning of repo " + matricNums.get(i) +
                                     " has been terminated prior to completion. (Clone time exceed 1 minute)");
                    }
                }
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }  
}
