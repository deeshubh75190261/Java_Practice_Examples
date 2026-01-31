package Demo;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Rectangle {

	public static void main(String[] args) {
		String[] language = new String[3];
		String[] num = new String[3];
		int i;
		for (i = 0; i < 3; i++) {

			@SuppressWarnings("resource")
			Scanner sc = new Scanner(new InputStreamReader(System.in));
			System.out.println("Enter Language");
			language[i] = sc.nextLine();
			System.out.println("Enter Number");
			num[i] = sc.nextLine();

		}
		System.out.println("============================\n");
		for (int j = 0; j < i; j++) {
			int len = language[j].length();
			int numLen = num[j].length();
			String zero = "";
			if (numLen == 1) {
				zero = "00";
			} else if (numLen == 2) {
				zero = "0";
			} else if (numLen == 0) {
				zero = "";
			}

			if (len < 16) {
				boolean flag = true;
				for (int k = len; k < 16; k++) {
					if (flag == true) {
						System.out.print(language[j]);
						flag = false;
					} else {
						System.out.print(" ");
					}
				}
				System.out.println(zero + "" + num[j]);
			}
		}
		System.out.println();
		System.out.println("============================");

	}
}
