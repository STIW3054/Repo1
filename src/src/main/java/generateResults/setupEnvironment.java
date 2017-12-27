package generateResults;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class setupEnvironment {
    
    private File file;
    private String filePath;
    private PrintWriter writer;
    
    public setupEnvironment(String filePath){
        this.filePath = filePath;
    }
    
    public PrintWriter setup() throws FileNotFoundException, UnsupportedEncodingException{
        checkResultDir();
        setupWriter();
        
        return writer;
    }
    
    public void checkResultDir(){
        file = new File(filePath);
        File dir = file.getParentFile();

        // Create STIW3054-Result folder if not exist
        if (! dir.exists()){
            dir.mkdirs();  
        }  
    }
    
    public void setupWriter() throws FileNotFoundException, UnsupportedEncodingException{
        if (file.exists()){
            writer = new PrintWriter(new FileOutputStream(new File(filePath), true)); // Append = true
        } else{
            writer = new PrintWriter(file, "UTF-8"); // Create new file
        }
    } 
}
