package Demo;

public class Pattern {

	public static void main(String[] args) {
		
		int n = 5, temp = 0, k = 1;
		for (int i = 1; i <= n + 2; i++) {
			if (i == 1 || i == n + 2)
				System.out.print(" ");
			else
				System.out.print("*");

			for (int j = temp; j <= n + temp - 1; j++) {
				if (i == 1 || i == n + 2)
					System.out.print("* ");
				else if (j < 10)
					System.out.print(" " + k++);
				else
					System.out.print(" " + j);
			}
			System.out.println();
		}

	}

}
