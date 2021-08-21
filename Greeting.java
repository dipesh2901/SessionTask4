package myPackage;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Greeting extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out=getJspContext().getOut();
		LocalTime t1 = LocalTime.parse("12:00:00");
		LocalTime t2 = LocalTime.parse("16:00:00");
		LocalTime t3 = LocalTime.parse("19:30:00");
		int val = java.time.LocalTime.now().compareTo(t1);
		if (val < 0) {
			out.write("Good Morning");
		} else {
			int val2 = java.time.LocalTime.now().compareTo(t2);
			if (val2 < 0) {
				out.write("Good Afternoon");
			} else {
				int val3 = java.time.LocalTime.now().compareTo(t3);
				if (val3 < 0) {
					out.write("Good Evening");
				} else {
					out.write("Good Night");
				}
			}
		}
	}
}
