package ddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class LoginDataProvider {

	// Variables to hold user credentials from Excel
	public String un;
	public String psw;
	public String wrong_un;
	public String wrong_psw;

	// Method to read data from Excel file
	public void dProv() throws EncryptedDocumentException, IOException {

		// Load Excel file using FileInputStream
		FileInputStream fs = new FileInputStream(
				"C:\\WorkEnvironment\\Projects_MKT\\project6\\project1-amazon-end-to-end\\testdata\\ashutosh.xlsx");

		// Create a Workbook instance from the input stream
		Workbook wb = WorkbookFactory.create(fs);

		// Read valid username from row 0, cell 0 and convert it to text
		un = NumberToTextConverter.toText(wb.getSheet("login").getRow(0).getCell(0).getNumericCellValue());

		// Read valid password from row 0, cell 1
		psw = wb.getSheet("login").getRow(0).getCell(1).getStringCellValue();

		// Read invalid username from row 1, cell 0 and convert it to text
		wrong_un = NumberToTextConverter.toText(wb.getSheet("login").getRow(1).getCell(0).getNumericCellValue());

		// Read invalid password from row 1, cell 1
		wrong_psw = wb.getSheet("login").getRow(1).getCell(1).getStringCellValue();

	}
}
