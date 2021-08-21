<%@ page import="myPackage.Sample" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.io.*,java.lang.*" session="true" isErrorPage="false" buffer="16kb" info="Directive Test Example" autoFlush="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@taglib prefix="mytag" uri="WEB-INF/custom.tld" %>

<mytag:Greeting/>


</body>
</html>