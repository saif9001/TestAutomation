package utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;


import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Instant;

public class CommonUtilities {

    public static void takeScreenshot(ITestResult iTestResult, WebDriver driver){

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile , new File("Everifile_Automation/screenshots/screen_shots"+iTestResult.getMethod().getMethodName()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
            
            File screenShot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        }
    }
    public static void cleanDirectory(String directory) throws IOException {

        FileUtils.cleanDirectory(new File(directory));
    }

    public static void uploadFileWithRobot (String imagePath) {
        StringSelection stringSelection = new StringSelection(imagePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(150);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static boolean isFileDownloaded(String expectedFileName, String fileExtension, int timeOut) throws IOException
    {
        // Download Folder Path
        String folderName = System.getProperty("user.dir") + File.separator + "downloads";

        // Array to Store List of Files in Directory
        File[] listOfFiles;

        // Store File Name
        String fileName;

        //  Consider file is not downloaded
        boolean fileDownloaded = false;

        // capture time before looking for files in directory
        // last modified time of previous files will always less than start time
        // this is basically to ignore previous downloaded files
        long startTime = Instant.now().toEpochMilli();

        // Time to wait for download to finish
        long waitTime = startTime + timeOut;

        // while current time is less than wait time
        while (Instant.now().toEpochMilli() < waitTime)
        {
            // get all the files of the folder
            listOfFiles = new File(folderName).listFiles();

            // iterate through each file
            for (File file : listOfFiles)
            {
                // get the name of the current file
                fileName = file.getName().toLowerCase();

                // condition 1 - Last Modified Time > Start Time
                // condition 2 - till the time file is completely downloaded extension will be crdownload
                // Condition 3 - Current File name contains expected Text
                // Condition 4 - Current File name contains expected extension
                if (file.lastModified() > startTime && !fileName.contains("crdownload") &&   fileName.contains(expectedFileName.toLowerCase()) && fileName.contains(fileExtension.toLowerCase()))
                {
                    // File Found
                    fileDownloaded = true;
                    break;
                }
            }
            // File Found Break While Loop
            if (fileDownloaded)
                break;
        }
        // File Not Found
        return fileDownloaded;
    }
  
    public static Object[][] readDataFromSheet(String filePath, String SheetName) throws IOException {
        FileInputStream fileInputStream= new FileInputStream(filePath); //Excel sheet file location get mentioned here
        HSSFWorkbook workbook;
        HSSFSheet worksheet;
        DataFormatter formatter = new DataFormatter();
        
        workbook = new HSSFWorkbook (fileInputStream); //get my workbook 
        worksheet=workbook.getSheet(SheetName);// get my sheet from workbook
        HSSFRow Row=worksheet.getRow(0);   //get my Row which start from 0   

        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum 

        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array

        for(int i=0; i<RowNum-1; i++) //Loop work for Rows 
        {
            HSSFRow row= worksheet.getRow(i+1);

            for (int j=0; j<ColNum; j++) //Loop work for colNum
            {
                if(row==null)
                    Data[i][j]= "";
                else
                {
                    HSSFCell cell= row.getCell(j);
                    if(cell==null)
                        Data[i][j]= ""; //if it get Null value it pass no data 
                    else
                    {
                        String value=formatter.formatCellValue(cell);
                        Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                    }
                }
            }
        }

        return Data;
    }
        
        
        
    }
    
    
    


