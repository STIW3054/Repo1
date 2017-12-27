package generateResults;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;

public class GeneratePDF {
    
    private String[] pdfPathArray;
    private List<File> fileList;
    private String workDir;
    private String cloneLog, errorLog, outputLog;
    private Font heading, body;    
    
    public GeneratePDF(){
        pdfPathArray = new String[3];
        fileList = new ArrayList<>();
        
        workDir = System.getProperty("user.dir");
        cloneLog = workDir + File.separator + "STIW3054-Result" + File.separator + "Clone.log";
        errorLog = workDir + File.separator + "STIW3054-Result" + File.separator + "Error.log";
        outputLog = workDir + File.separator + "STIW3054-Result" + File.separator + "Output.log";
        
        pdfPathArray[0] = workDir + File.separator + "STIW3054-Result" + File.separator + "Clone.pdf";
        pdfPathArray[1] = workDir + File.separator + "STIW3054-Result" + File.separator + "Error.pdf";
        pdfPathArray[2] = workDir + File.separator + "STIW3054-Result" + File.separator + "Output.pdf";
        
        heading = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
        body = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
    }
    
    public void generatePdf() throws DocumentException, IOException, FileNotFoundException, InterruptedException{
        checkExist();
        writeClonePdf();
        writeErrorPdf();
        writeOutputPdf();
    }
    
    public void checkExist(){
        for (int x=0; x<pdfPathArray.length; x++){
            fileList.add(new File(pdfPathArray[x]));
        }

        for(File item : fileList){
            if(item.exists()){
                item.delete();
            }
        }
    }
    
    public void writeClonePdf() throws FileNotFoundException, DocumentException, IOException, InterruptedException{
        sleep(1000);
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(pdfPathArray[0]));
        document.open();

        BufferedReader br = new BufferedReader(new FileReader(cloneLog));
        String currentLine;
        Paragraph para1, para2;

        para1 = new Paragraph("Team 1 - Clone Log File", heading);
        para1.add(new Paragraph(" "));
        para1.add(new Paragraph(" "));
        document.add(para1);

        while ((currentLine = br.readLine()) != null) {

            para2 = new Paragraph(currentLine, body);
            para2.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(para2);

        }
        document.close();
    }
    
    public void writeErrorPdf() throws FileNotFoundException, DocumentException, IOException, InterruptedException{
        sleep(1000);
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(pdfPathArray[1]));
        document.open();

        BufferedReader br = new BufferedReader(new FileReader(errorLog));
        String currentLine;
        Paragraph para1, para2;

        para1 = new Paragraph("Team 1 - Error Log File", heading);
        para1.add(new Paragraph(" "));
        para1.add(new Paragraph(" "));
        document.add(para1);

        while ((currentLine = br.readLine()) != null) {

            para2 = new Paragraph(currentLine, body);
            para2.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(para2);

        }
        document.close();
    }
    
    public void writeOutputPdf() throws FileNotFoundException, DocumentException, IOException, InterruptedException{
        sleep(1000);
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(pdfPathArray[2]));
        document.open();

        BufferedReader br = new BufferedReader(new FileReader(outputLog));
        String currentLine;
        Paragraph para1, para2;

        para1 = new Paragraph("Team 1 - Output Log File", heading);
        para1.add(new Paragraph(" "));
        para1.add(new Paragraph(" "));
        document.add(para1);

        while ((currentLine = br.readLine()) != null) {

            para2 = new Paragraph(currentLine, body);
            para2.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(para2);

        }
        document.close();
    } 
}
