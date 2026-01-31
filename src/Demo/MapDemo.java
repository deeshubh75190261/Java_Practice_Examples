package Demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class MapDemo {

	public static void main(String[] args) {

		Map<String, Integer> myMay = new HashMap<>();

		myMay.put("Name", 1);
		myMay.put("Last", 2);
		myMay.put("Mid", 3);
		myMay.put("Name", 4);

		myMay.forEach((key, value) ->

		System.out.println("Key is : " + key + " and value is : " + value)

		);

		System.out.println("********************************\n");
		for (Map.Entry<String, Integer> entry : myMay.entrySet()) {
			System.out.println("Key is : " + entry.getKey() + " and value is : " + entry.getValue());
		}

		System.out.println("***************************");
		Map<Integer, String> treeMap = new TreeMap<>();

		treeMap.put(1, "Apple");
		treeMap.put(2, "Mango");
		treeMap.put(5, "Pineapple");
		treeMap.put(4, "Banana");
		treeMap.put(3, "Guava");

		treeMap.forEach((k, v) -> System.out.println("Key is : " + k + " and value is : " + v));

		System.out.println("***************************");

		List<String> firstList = new ArrayList<>();

		firstList.add("A");
		firstList.add("B");
		firstList.add("C");
		firstList.add("D");

		System.out.println("firstList is " + firstList);

		CopyOnWriteArrayList<String> secondList = new CopyOnWriteArrayList<>();
		secondList.add("E");
		secondList.add("A");
		secondList.add("D");

		System.out.println("second is " + secondList);

		secondList.addAllAbsent(firstList);

		System.out.println("Updated second list : " + secondList);

	}

}
