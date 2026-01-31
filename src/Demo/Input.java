package Demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

	Input() {
		System.out.println("Hii Deepak Patil \n");
	}

	public static void main(String[] args) throws IOException {
		// Enter data using BufferReader
//		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
//		// Reading data using readLine
//		System.out.println("Enter your x amount");
//		String x = read.readLine();
//		// Printing the read line
//		System.out.println(x);

		String str = "Knowledge";
		String s = str;
		str = str.concat(" Base");
		System.out.println(str);

		String st = "deepak ";
		st.concat("patil");
		System.out.println(st);

		Input inpt = new Input();
	}
}
