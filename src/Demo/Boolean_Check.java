package Demo;

public class Boolean_Check {

	public static void main(String[] args) {

		boolean flag = true;
		int num1 = 8 + 1;

		if (num1 == 10) {
			flag = false;
		}

		if (!flag) {
			System.out.println("Right");
		}else {
			System.out.println("Wrong");
		}

	}

}
