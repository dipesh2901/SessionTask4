<%@page import="myPackage.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="WithdrawException.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 
Double withdraw_amount=Double.parseDouble(request.getParameter("withdraw"));
Account account=new Account();
if(Integer.parseInt(request.getParameter("withdraw"))>Account.acc_balance){
	throw new Exception();
}
else{
	out.print(account.withdraw(Integer.parseInt(request.getParameter("withdraw")))+"<br>");
	out.print(account.showBalance());
}
%>
</body>
</html>