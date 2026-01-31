package Demo;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class XlsWriter {
	public static void main(String[] args) {
		String filePath = "/home/ltfadmin.brs/work/fileNew.xlsx";

		try {
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("Sheet1");

			// Create header row
			Row headerRow = sheet.createRow(0);
			String[] headers = { "Name", "Age", "Country" };
			for (int i = 0; i < headers.length; i++) {
				Cell headerCell = headerRow.createCell(i);
				headerCell.setCellValue(headers[i]);
			}

			// Sample data
			String[][] data = { { "John Doe", "25", "USA" }, { "Jane Smith", "30", "Canada" },
					{ "Alice Johnson", "28", "UK" } };

			// Populate data rows
			for (int rowIndex = 0; rowIndex < data.length; rowIndex++) {
				Row dataRow = sheet.createRow(rowIndex + 1);
				for (int colIndex = 0; colIndex < data[rowIndex].length; colIndex++) {
					Cell dataCell = dataRow.createCell(colIndex);
					dataCell.setCellValue(data[rowIndex][colIndex]);
				}
			}

			// Write the workbook to a file
			try (FileOutputStream fos = new FileOutputStream(filePath)) {
				workbook.write(fos);
			}

			System.out.println("XLSX file created successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
