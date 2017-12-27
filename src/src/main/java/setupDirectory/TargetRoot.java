
package setupDirectory;

public class TargetRoot {
    
    private String targetDirectory;
    
    public String getTarget(){
        String fileSeperator = System.getProperty("file.separator");        
        targetDirectory = System.getProperty("user.home") + fileSeperator +"Desktop" + fileSeperator +"STIW3054-A171";
        
        return targetDirectory;
    }
}
