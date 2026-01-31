package Demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, String[]> file1Map = new HashMap<>();

		try {
			File myObj = new File("/home/credentek/Downloads/110823/RHINOCON_110823.csv");
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
		String rhinoStr = "";
		String prodStr = "";
		String finalStr = "GL_CD,RH_BUSINESS_DATE,RH_OPENING_BAL,RH_NET_DR_AMT,RH_NET_CR_AMT,RH_CLOSING_BAL,RH_CALCULATED_CLOSING_MATCH,PROD_OPENING_BAL,PROD_NET_DR_AMT,PROD_NET_CR_AMT,PROD_CLOSING_BAL,PROD_CALCULATED_CLOSING,rhVSprocOp,rhVSprodDR,rhVSprodCR,rhVSprodCL";
		try {
			File myObj = new File("/home/credentek/Downloads/110823/BOOK_BALANCE.csv");
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
					Double uatDrAmt = Double.parseDouble(uatData[5]);
					Double uatcrAmt = Double.parseDouble(uatData[6]);
					Double uatclBal = Double.parseDouble(uatData[7]);

					prodStr = prodOpBal + "," + prodDrAmt + "," + prodcrAmt + "," + prodclBal + ",";
					rhinoStr = uatOpBal + "," + uatDrAmt + "," + uatcrAmt + "," + uatclBal + ",";

					if (Math.round((prodOpBal - prodDrAmt + prodcrAmt - prodclBal)) != 0) {
						prodStr += "FALSE";
					} else {
						prodStr += "TRUE";
					}
					if (Math.round((uatOpBal - uatDrAmt + uatcrAmt - uatclBal)) != 0) {
						rhinoStr += "FALSE";
					} else {
						rhinoStr += "TRUE";
					}

					finalStr = data[0] + "," + data[2] + "," + rhinoStr + "," + prodStr;

					// " Opening Balance Mismatch Diff = " + NET DR AMT Mismatch Diff = NET CR AMT
					// Mismatch Diff = CLOSING Balance Mismatch Diff =
					finalStr += "," + Math.round((prodOpBal - uatOpBal));

					finalStr += "," + Math.round((prodDrAmt - uatDrAmt));
					
					finalStr += "," + Math.round((prodcrAmt - uatcrAmt));

					finalStr += "," + Math.round((prodclBal - uatclBal));

				} else {
					if (!data[2].contains("-28")) {

						finalStr += data[0] + "," + data[2] + ", , , , ,FALSE," + data[3] + "," + data[4] + ","
								+ data[5] + "," + data[6] + ",FALSE" + ",MISSING RECORD";
					}

				}
				if (!"".equals(finalStr)) {
					System.out.println(finalStr);
				}
				finalStr = "";
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}