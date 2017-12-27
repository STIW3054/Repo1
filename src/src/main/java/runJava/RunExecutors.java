package runJava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RunExecutors {
    
    ArrayList<String> fileNames;
    
    public RunExecutors(ArrayList<String> fileNames){
        this.fileNames = fileNames;
    }
    
    public void initExecutor(){
        final int WAITTIME = 10;
        List<Future> list = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(fileNames.size());
        for (int i = 0; i < fileNames.size(); i++) {
            Future future = executor.submit(new RunWorker(fileNames.get(i)));
            list.add(future);
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(WAITTIME, TimeUnit.SECONDS)) {
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).cancel(true); 
                }
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executor.shutdownNow();
        } finally {
            executor.shutdownNow();
        }
    }  
}
