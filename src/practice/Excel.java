package practice;


import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static String mobilename;

	public static void exceldataFetch()

	{

		try

		{

			FileInputStream fis = new FileInputStream(".\\utils\\exceldata.xlsx");

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet sheet = wb.getSheetAt(0);

			mobilename = sheet.getRow(0).getCell(0).getStringCellValue();

			wb.close();

		}

		catch (Exception e)

		{

			System.out.println(e.getMessage());

		}

	}
}
