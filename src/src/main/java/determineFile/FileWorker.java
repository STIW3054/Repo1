package determineFile;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class FileWorker implements Callable<String[]> {

    private ArrayList<String> fileNames;
    private File folder;

    public FileWorker(String pathFolder) {
        fileNames = new ArrayList<>();
        this.folder = new File(pathFolder);
    }
    
    @Override
    public String[] call() throws Exception {
        getList(folder);
        
        String[] list = new String[fileNames.size()];
        for (int i = 0; i < fileNames.size(); i++) {
            list[i] = fileNames.get(i);
        }
        
        return list;
    }

    public FileWorker getList(File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                getList(fileEntry);
            } else {
                checkJava(fileEntry.getAbsolutePath());
            }
        }
        return this;
    }
    
    public void checkJava(String absolutePath) {
        int dot = absolutePath.lastIndexOf('.');
        String extention = absolutePath.substring(dot + 1);
        
        if (extention.equalsIgnoreCase("java")) {
            fileNames.add(absolutePath);
        }
    }
}
