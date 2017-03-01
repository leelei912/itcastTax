package cn.itcastTax.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class TestPoi {

	@Test
	public void testWriteExcel() throws Exception {
		XSSFWorkbook XSSFWorkbook = new XSSFWorkbook();
		XSSFSheet createSheet = XSSFWorkbook.createSheet("helloWorld");
		XSSFRow createRow = createSheet.createRow(3);
		XSSFCell createCell = createRow.createCell(3);
		createCell.setCellValue("helloWorld");
		//输出到硬盘
		FileOutputStream fileOutputStream = new FileOutputStream("D:\\21.xlsx");
		XSSFWorkbook.write(fileOutputStream);
		XSSFWorkbook.close();
		fileOutputStream.close();
	}
	
	@Test
	public void testReadExcel() throws Exception {
		FileInputStream fileInputStream = new FileInputStream("D:\\21.xls");
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet createSheet = hssfWorkbook.getSheet("helloWorld");
		HSSFRow createRow = createSheet.getRow(3);
		HSSFCell createCell = createRow.getCell(3);
		System.out.println(createCell.getStringCellValue());
		hssfWorkbook.close();
		fileInputStream.close();
	}
	
	@Test
	public void testRead03And07Excel() throws Exception {
		FileInputStream fileInputStream = new FileInputStream("D:\\21.xls");
		boolean is03 = true;
		Workbook wb = is03?new HSSFWorkbook(fileInputStream):new XSSFWorkbook(fileInputStream);
		Sheet createSheet = wb.getSheet("helloWorld");
		Row createRow = createSheet.getRow(3);
		Cell createCell = createRow.getCell(3);
		System.out.println(createCell.getStringCellValue());
		wb.close();
		fileInputStream.close();
	}

}
