package Demo;

import java.util.Arrays;

public class FindPair {

	public static void main(String[] args) {

		int[] arr = { 0, 1, 5, 6, 2, 5, 11, 15 };
		int target = 9;
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				int newTemp = arr[j];
				int sum = temp + newTemp;
				if (sum == target) {
					System.out.println("Pair : " + temp + "," + newTemp);
					flag = true;
					break;
				}
			}
		}

		if (!flag) {
			System.out.println("Pair not found then : " + Arrays.toString(arr));
		}

	}

}
