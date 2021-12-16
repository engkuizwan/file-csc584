<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/7/2021
  Time: 8:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Self</title>
</head>
<body>
<%@include file="Menu.html"%>
<h1>
    <%--JSP Expression--%>
    <%= "MY SELF" %>
</h1>

<jsp:include page="MySelfServlet"/>

<form style="text-align: center" name="MyselfForm" method="post" action="MySelf.jsp">

    <br/>
    <br/>

    <div>
        Name : <input type="text" name="myName"> <br/><br/>
        Age : <input type="text" name="myAge"> <br/><br/>
        Hobbies : <input type="text" name="myHobbies"> <br/><br/>
    </div>

    <br/>
    <input type="submit" value="submit">
    <br/>

</form>




<%--JSP Declaration--%>
<%!
    private String getMessage()
    {
        return "Session Created in declaration";
    }
%>


<%--JSP Scriplet--%>
<%
    String mytext = request.getParameter("myName");

    if (mytext == null){}

    else
    {
        session.setAttribute("MyName", request.getParameter("myName"));
        session.setAttribute("MyAge", request.getParameter("myAge"));
        session.setAttribute("MyHobbies", request.getParameter("myHobbies"));

        out.println(getMessage());
    }

%>





</body>
</html>
