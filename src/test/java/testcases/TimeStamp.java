package testcases;

import java.util.Date;

public class TimeStamp {
	
	public static void main(String args[]) {
		
		
		Date d =  new Date();
		System.out.println(d);
		System.out.println(d.toString().replace(":", "_").replace(" ", "_")+".jpg");
		String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
	}

}
