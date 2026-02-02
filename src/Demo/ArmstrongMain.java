package Demo;

import java.util.Scanner;

public class ArmstrongMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int number = sc.nextInt();

		int temp = 0, ref = 0, sum = 0;

		temp = number;
		if (number > 0) {
			while (number > 0) {
				ref = number % 10;
				number = number / 10;
				sum = sum + (ref * ref * ref);
			}

			if (temp == sum) {
				System.out.println("Number is armstrong : " + temp);
			} else {
				System.out.println("Number is not armstrong : " + temp);
			}
		} else {
			System.out.println("Number should be greater than 0");
		}

	}

}
