package generateResults;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class GenerateLog {
    
    private String filePath;
    private PrintWriter writer;
    
    public GenerateLog(){
        filePath = System.getProperty("user.dir") + File.separator + "STIW3054-Result" + File.separator + "Clone.log";     
    }
    
    public void writeLog(String logMessage) throws FileNotFoundException, UnsupportedEncodingException{
        setupEnvironment check = new setupEnvironment(filePath);
        writer = check.setup();
        writer.println(logMessage);
        writer.close();
    }
}
