package Demo;

import java.util.HashMap;
import java.util.Scanner;

public class WordFind {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, String> matchString = new HashMap<Integer, String>();
		int key = 0;
		int key1 = 1111;

		try {
			System.out.println("Enter your sentense :");
			String sentense = sc.nextLine();

			System.out.println("Enter your word which is you want to find.......\n");
			String findWord = sc.nextLine();

			String sentense1 = sentense.replace(" ", ",");
			String sentenceArrayList[] = sentense1.split(",");

			System.out.println(sentense1);

			for (String str : sentenceArrayList) {
				if (!str.isEmpty() && str != null) {
					if (str.equals(findWord)) {
						matchString.put(key1, str);
					} else {
						key++;
						matchString.put(key, str);
					}
				}
			}

			if (matchString.containsKey(1111)) {
				System.out.println("String match with given sentense");
			} else {
				System.out.println("String not match with given sentense");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
