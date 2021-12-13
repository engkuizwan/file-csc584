<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%@include file="Menu.html"%>
<h1 style="color: darkslategray">
    <%= "Hello, My Name Is " + session.getAttribute("MyName") %>
</h1>
<br/>

<div class = "serv" >

    <ul class="bottom" >
    <li><a href="hello-servlet">Hello Servlet</a> </li>
    <li><a href="MySelfServlet">MySelf Servlet</a></li>
    <li><a href="MyFamilyServlet">MyFamily Servlet</a></li>
    <li><a href="MyFootballServlet">MyFootball Servlet</a></li>
    <li><a href="MyStudentsServlet">MyStudent Servlet</a></li>
    </ul>

</div>


</body>
</html>