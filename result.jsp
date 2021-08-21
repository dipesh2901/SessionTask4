<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int amount=Integer.parseInt(request.getParameter("loan")); 
	int years=Integer.parseInt(request.getParameter("years"));
	int roi=Integer.parseInt(request.getParameter("roi"));
%>
<%! double findEmi(int amount,int years,int roi){ 
	double emi=(amount+roi)/years;
	return emi;
}
%>
<h2>Your monthly EMi will be : <%=findEmi(amount,years,roi) %></h2>
</body>
</html>