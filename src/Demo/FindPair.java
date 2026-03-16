package Demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPair {

	public static void main(String[] args) {

		int[] arr = { 1, 5, 46, 2, 6, 11, 15 };
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

		System.out.println("====================================================");

		Map<Integer, Integer> pairMap = new HashMap<>();

		boolean flage = false;

		for (int i = 0; i < arr.length; i++) {

			int secValue = target - arr[i];

			if (pairMap.containsKey(secValue)) {
				flage = true;
				System.out.println(Arrays.toString(new int[] { secValue, arr[i] }));
				break;
			}
			pairMap.put(arr[i], i);
		}

		if (!flage) {
			System.out.println(Arrays.toString(new int[] {}));
		}
	}

}
