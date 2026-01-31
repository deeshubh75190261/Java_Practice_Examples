package Demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReceivedFiles {

	public static String receivedFiles = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, String[]> file1Map = new HashMap<>();

		try {
			File myObj = new File(
					"/home/credentek/Music/BALANCE_CHECK/04-CONSOLIDATED/RHINOCON_CONSOLIDATE_BOOK_BALANCE.csv");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {

				try {
					String data[] = myReader.nextLine().split("\\,");

					file1Map.put(data[2] + "-" + data[3], data);

				} catch (Exception e) {
					System.out.println(e);

				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		DecimalFormat formatter = new DecimalFormat("0.######");

		Map<String, Integer> file2Map = new HashMap<>();
		String missingRecords = "";
		try {
			File myObj = new File("/home/credentek/Music/BALANCE_CHECK/04-CONSOLIDATED/BOOK_BALANCE.csv");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String[] data = myReader.nextLine().split("\\,");

				String key = data[0] + "-" + data[2];

				if (file1Map.containsKey(key)) {

					String opStr = "";

					Double prodOpBal = Double.parseDouble(data[3]);
					Double prodDrAmt = Double.parseDouble(data[4]);
					Double prodcrAmt = Double.parseDouble(data[5]);
					Double prodclBal = Double.parseDouble(data[6]);

					String[] uatData = file1Map.get(key);

					Double uatOpBal = Double.parseDouble(uatData[4]);
					Double uatclBal = Double.parseDouble(uatData[5]);
					Double uatDrAmt = Double.parseDouble(uatData[6]);
					Double uatcrAmt = Double.parseDouble(uatData[7]);

					// Closing Balance Calculation

					if (Math.round((prodOpBal - uatOpBal)) != 0) {
						opStr += " Opening Balance Mismatch Diff = " + Math.round((prodOpBal - uatOpBal));
					}
					if (Math.round((prodDrAmt - uatDrAmt)) != 0) {
						opStr += " NET DR AMT Mismatch Diff =" + Math.round((prodDrAmt - uatDrAmt));
					}
					if (Math.round((prodcrAmt - uatcrAmt)) != 0) {
						opStr += " NET CR AMT Mismatch Diff =" + Math.round((prodcrAmt - uatcrAmt));
					}
					if (Math.round((prodclBal - uatclBal)) != 0) {
						opStr += " CLOSING Balance Mismatch  Diff = " + Math.round((prodclBal - uatclBal));
					}

					if (!"".equals(opStr)) {
						System.out.println(opStr + " -----key " + data[0] + "-" + data[2]);
						System.out.println("PROD-  " + formatter.format(prodOpBal) + "," + formatter.format(prodDrAmt)
								+ "," + formatter.format(prodcrAmt) + "," + formatter.format(prodclBal));
						System.out.println("RHINO- " + formatter.format(uatOpBal) + "," + formatter.format(uatDrAmt)
								+ "," + formatter.format(uatcrAmt) + "," + formatter.format(uatclBal));
						System.out.println();
					}

				} else {
					if (!data[2].contains("-28")) {
						if (Math.round(Double.parseDouble(data[4])) != 0) {
							System.out.println(" -----key " + key);
							System.out.println(
									"NET DR AMT Mismatch Diff =" + formatter.format(Double.parseDouble(data[4])));
						} else {

							System.out.println(
									"Record Is Missing in the Rhinocon for :-" + data[0] + "-" + data[2] + "\n");
						}
						if (Math.round(Double.parseDouble(data[5])) != 0) {
							System.out.println(" -----key " + key);
							System.out.println(
									"NET CR AMT Mismatch Diff =" + formatter.format(Double.parseDouble(data[5])));
						} else {

							System.out.println(
									" Record Is Missing in the Rhinocon for :-" + data[0] + "-" + data[2] + "n");
						}
					}

				}

			}
			myReader.close();
			System.out.println(missingRecords);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}