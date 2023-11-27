package Examples;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yy");
		System.out.println(sdf.format(d).toString());
		System.out.println(d.toString());
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
		System.out.println(cal.get(Calendar.AM_PM));

	}

}
