package Demo;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PerfectSqure {

	public static void main(String[] args) {

		// Find Perfect Square From List

		int arrSize = 0;
		int[] num;
		int i = 0;
		int j = 0;
		int count = 0;
		String regExp = "[0-9]{1,20}";
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		Scanner sc1 = new Scanner(new InputStreamReader(System.in));

		try {
			System.out.println("Enter array size");
			arrSize = sc.nextInt();
			num = new int[arrSize];

			if (arrSize >= 7) {
				System.out.println("Please enter array size less than 7 ");
				return;
			}

			for (i = 0; i < arrSize; i++) {
				System.out.println("Enter Array Element");
				Pattern pattern = Pattern.compile(regExp);
				String checkInt = sc1.nextLine();
				Matcher matcher = pattern.matcher(checkInt);
				if (matcher.matches()) {
					i--;
					continue;
				} else {

					num[i] = Integer.parseInt(checkInt);
				}
				checkInt = "";
			}

			System.out.println();
			for (int k = 0; k < num.length; k++) {
				for (j = 0; j < 7; j++) {
					if (num[k] == j * j) {
						System.out.println("Perfect Number Is = " + num[k]);
						count++;
					}
				}
			}
			System.out.println("\n*****************************");
			System.out.println("Total Perfect Number Is = " + count);
			System.out.println("*****************************");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
