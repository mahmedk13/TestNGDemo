package testcases;

import java.util.Date;

public class TimeStamp {

	public static void main(String[] args) {


		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";

	}

}
