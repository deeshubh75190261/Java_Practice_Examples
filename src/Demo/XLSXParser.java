package Demo;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class XLSXParser {
	public static void main(String[] args) {
		String filePath = "/home/credentek/Downloads/Repair reference_11.08.2023.xlsx";
		FileInputStream fis = null;
		Workbook workbook = null;

		try {
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			

			Sheet sheet = workbook.getSheetAt(0);

			for (Row row : sheet) {
				for (Cell cell : row) {
					CellType cellType = cell.getCellType();
					switch (cellType) {
					case STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					case BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "\t");
						break;
					case BLANK:
						System.out.print("BLANK\t");
						break;
					default:
						System.out.print("UNKNOWN\t");
						break;
					}
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (workbook != null) {
					workbook.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
