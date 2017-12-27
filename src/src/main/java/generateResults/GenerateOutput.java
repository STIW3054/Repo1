package generateResults;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class GenerateOutput {
    
    private String filePath;
    private PrintWriter writer;
    
    public GenerateOutput(){
        filePath = System.getProperty("user.dir") + File.separator + "STIW3054-Result" + File.separator + "Output.log";     
    }
    
    public void writeOutput(String outputMessage) throws FileNotFoundException, UnsupportedEncodingException{
        setupEnvironment check = new setupEnvironment(filePath);
        writer = check.setup();
        writer.println(outputMessage);
        writer.close();
    }
}
