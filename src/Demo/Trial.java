package Demo;

public class Trial {

	public static void main(String[] args) {

		/*
		 * int num = 5;
		 * 
		 * do { System.out.println(num-- + " "); } while (num == 0);
		 */
		String l_bankGSTN = "NBKGDFUTD";
		String l_lntGSTN = "00";
		String l_stateCdFlag = "";
		double l_cgst = 0.0;
		double l_sgst = 0.0;
		double l_gstVal = 0.0;
		System.out.println("hiiii    1    " + l_lntGSTN.length());
		System.out.println(l_bankGSTN.substring(0, 2).toString());
		if (l_bankGSTN.substring(0, 2).equals(l_lntGSTN.substring(0, 2))) {
			System.out.println("hiiii");
		}
		System.out.println("hiiii   2    " + l_lntGSTN.length());

	}

}
