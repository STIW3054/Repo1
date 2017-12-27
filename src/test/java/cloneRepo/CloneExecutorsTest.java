package cloneRepo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.Test;
import static org.junit.Assert.*;
import retrieveRepo.GitRepo;
import setupDirectory.TargetRoot;

public class CloneExecutorsTest {

    private int matricNums = 0;

    public void testCloneExecutors() throws InterruptedException, ExecutionException {
        int numOfThreads = 0;
        Callable<Long> task = new Callable<Long>() {
            @Override
            public Long call() {
                return null;
            }
        };
        List<Callable<Long>> tasks = Collections.nCopies(numOfThreads, task);
        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
        List<Future<Long>> futures = executorService.invokeAll(tasks);
        List<Long> resultList = new ArrayList<Long>(futures.size());
        for (Future<Long> future : futures) {
            resultList.add(future.get());
        }
        
        List<Long> expectedList = new ArrayList<Long>(numOfThreads);
        for (long i = 1; i <= numOfThreads; i++) {
            expectedList.add(i);
        }
        Collections.sort(resultList);

    }

    @Test
    public void testCloneExe() {
    
        TargetRoot tar = new TargetRoot();
        String reposMainFolder = tar.getTarget();
        
        GitRepo repo = new GitRepo();
        ArrayList<String> matricNums = repo.getMatrics();
        
        File tempDirectoy = new File(reposMainFolder + File.separator + matricNums);
        String expectedDir = reposMainFolder + File.separator + matricNums;
        int numOfThreads = 0;
        
        assertEquals(numOfThreads, this.matricNums);
        assertEquals(expectedDir,tempDirectoy.getAbsolutePath());
       
    }
}