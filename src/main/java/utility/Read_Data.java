package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_Data 
{
	// value will store username, url , password , browser of config.properties file
	public static String ReadPropertyFile(String value) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("G:\\JAR FILES\\eclipse-workspace\\Selenium_Framework_Project\\TestData\\config.properties");
		prop.load(file);
		return prop.getProperty(value); // it will return the data
	}
	// WHOLE CODE ABOVE IS ABOUT EXCEL FILE
	// public isliye ki through out the framework Use kr sake
	// static isliye ki koi or class isko use na kare
	// String isliye kuki humre data me varibales honge alphabet + numbers
	public static String readExcel(int rowNum, int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("G:\\JAR FILES\\eclipse-workspace\\Selenium_Framework_Project\\TestData\\Book1.xlsx");
		// need workbookFactory which is a pre-Define Class  jo Apcha.poi se mila
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;
	}
}
