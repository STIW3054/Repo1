package generateResults;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class GenerateError {
    
    private String filePath;
    private PrintWriter writer;
    
    public GenerateError(){
        filePath = System.getProperty("user.dir") + File.separator + "STIW3054-Result" + File.separator + "Error.log";     
    }
    
    public void writeError(String outputMessage) throws FileNotFoundException, UnsupportedEncodingException{
        setupEnvironment check = new setupEnvironment(filePath);
        writer = check.setup();
        writer.println(outputMessage);
        writer.close();
    }
}
