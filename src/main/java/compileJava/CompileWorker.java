package compileJava;

import generateResults.GenerateError;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompileWorker implements Runnable {

    private File file;
    private String filePath;

    private String cmd1;
    private String cmd2;
    
    private GenerateError error;

    public CompileWorker(String filePath) {
        this.file = new File(filePath);
        this.filePath = filePath;
        error = new GenerateError();
    }
    
    @Override
    public void run() {
        if (checkIsPackage()) {
            runTerminal(cmd1, cmd2, "javac");
        } else {
            runTerminal(cmd1, cmd2, "javac -d . ");
        }
    }

    public boolean checkIsPackage() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";

            while ((line = br.readLine()) != null) {
                if (line.contains("package ")) {
                    String[] items = line.split(" ");
                    int semicolon = items[1].lastIndexOf(';');
                    String packagename = items[1].substring(0, semicolon);
                    String packagePath = packagename.replace(".", File.separator);

                    String packageDir = filePath.replace(packagePath + File.separator, "");

                    int slash = packageDir.lastIndexOf(File.separator);
                    String fileName = packageDir.substring(slash + 1);

                    cmd1 = packageDir.replace(fileName, "");
                    cmd2 = packagePath + File.separator + fileName;

                    return true;
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CompileWorker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CompileWorker.class.getName()).log(Level.SEVERE, null, ex);
        }

        int slash = filePath.lastIndexOf(File.separator);
        String fileName = filePath.substring(slash + 1);
        
        cmd1 = filePath.replace(fileName, "");
        cmd2 = fileName;

        return false;
    }

    public void runTerminal(String cmd1, String cmd2, String action) {

        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd \"" + cmd1 + "\" && " + action + " " + cmd2);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                error.writeError(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

