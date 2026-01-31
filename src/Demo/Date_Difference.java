package Demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Date_Difference {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String start_date = "21-12-1999 01:10:20";
        String end_date = "04-06-2024 01:16:50";

        Date d1 = sdf.parse(start_date);
        Date d2 = sdf.parse(end_date);

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        calendar1.setTime(d1);
        calendar2.setTime(d2);

        int years = calendar2.get(Calendar.YEAR) - calendar1.get(Calendar.YEAR);
        int months = calendar2.get(Calendar.MONTH) - calendar1.get(Calendar.MONTH);

        if (months < 0) {
            years--;
            months += 12;
        }

        long difference_In_Time = d2.getTime() - d1.getTime();

        long difference_In_Minutes = (difference_In_Time / (1000 * 60)) % 60;

        long difference_In_Hrs = ((difference_In_Time / (1000 * 60)) / 60) % 60;

        long difference_In_Days = (difference_In_Hrs / 24);

        System.out.println("Difference between two date in years : " + years + " years \n");
        System.out.println("Difference between two date in months : " + months + " months \n");
        System.out.println("Difference between two date in days : " + difference_In_Days + " days \n");
        System.out.println("Difference between two date in hours : " + difference_In_Hrs + " hrs \n");
        System.out.println("Difference between two date in minutes : " + difference_In_Minutes + " minutes \n");

        System.out.println("Difference between two date is : " + years + " years, " + months + " months, " + difference_In_Days + " days, " + difference_In_Hrs + " hours, " + difference_In_Minutes + " minutes");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = formatter.format(date);
        System.out.println("Today's Date : " + strDate);

        StringBuilder sb = new StringBuilder();

    }
}
