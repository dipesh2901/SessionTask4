<%@page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String name=request.getParameter("name"); 
	String gender=request.getParameter("gender");
	String person;
	if(gender.equals("male")){
		 person="Sir";
	}
	else{
		 person="Madam";
	}
	out.print("Hi,"+name+"<br>");
	LocalTime t1 = LocalTime.parse("12:00:00");
	LocalTime t2 = LocalTime.parse("16:00:00");
	LocalTime t3 = LocalTime.parse("19:30:00");
	int val = java.time.LocalTime.now().compareTo(t1);
	if (val < 0) {
		out.write("Good Morning "+person);
	} else {
		int val2 = java.time.LocalTime.now().compareTo(t2);
		if (val2 < 0) {
			out.write("Good Afternoon "+person);
		} else {
			int val3 = java.time.LocalTime.now().compareTo(t3);
			if (val3 < 0) {
				out.write("Good Evening "+person);
			} else {
				out.write("Good Night "+person);
			}
		}
	}
%>
</body>
</html>