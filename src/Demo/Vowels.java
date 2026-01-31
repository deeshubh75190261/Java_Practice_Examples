package Demo;

import java.util.Scanner;

public class Vowels {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String newInputString = null;
		int totalVowels = 0;
		char[] finalCharArray = new char[10];
		StringBuilder tFinalCharArray = new StringBuilder();
		try {
			System.out.println("Enter your word");
			String inputWord = sc.nextLine();
			// There is nothing so useless as doing efficiently that which should not be done at all.

			// System.out.println("\n" + inputWord);
			System.out.println("\nInput String length is : " + inputWord.length());
			newInputString = inputWord.replace(" ", ",");
			String splitString[] = newInputString.split(",");

			for (String str : splitString) {

				char[] charArray = str.toCharArray();
				for (char c : charArray) {

					if (c == 'a') {
						tFinalCharArray.append(c + ",");
						totalVowels++;
					} else if (c == 'e') {
						tFinalCharArray.append(c + ",");
						totalVowels++;
					} else if (c == 'i') {
						tFinalCharArray.append(c + ",");
						totalVowels++;
					} else if (c == 'o') {
						tFinalCharArray.append(c + ",");
						totalVowels++;
					} else if (c == 'u') {
						tFinalCharArray.append(c + ",");
						totalVowels++;
					}
				}
				str = "";
			}
			System.out.println("\nTotal vowels in the input string is : " + totalVowels + "\n");

			System.out.println(tFinalCharArray);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
