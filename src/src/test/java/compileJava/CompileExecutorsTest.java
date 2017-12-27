package compileJava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class CompileExecutorsTest {
    
    private ArrayList<String> fileNames;
     
    public void testingCompileExecutor(){
        
        List<Future> list = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(fileNames.size());
        
        for (int i = 0; i < fileNames.size(); i++) {
            Future future = executor.submit(new CompileWorker(fileNames.get(i)));
            list.add(future);
        }
        
        executor.shutdown();
    }
    
    @Test
    public void testCompileExecutor(){
        assertFalse(true&&false);
    }
}
