<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/7/2021
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Student</title>
</head>
<body>
<%@include file="Menu.html"%>
<h1>
    <%--JSP Expression--%>
    <%= "MY STUDENT" %>
</h1>
<jsp:include page="/MyStudentsServlet"/>

<form name="studentForm" method="post" action="MyStudentsServlet">

    Campus : <input type="text" name="myCampus"><br/><br/>
    Matric No. : <input type="text" name="myMatric"><br/><br/>
    Program code : <input type="text" name="myProgramCode"><br/><br/>
    <br/><br/><br/>
    <input type="submit" value="submit">
</form>



<%-- message to user --%>
<c:if test="${not empty param.sterrmsg}">

    <c:out value="${param.sterrmsg}"/>

</c:if>

<c:if test="${not empty param.stscssmsg}">

    <c:out value="${param.stscssmsg}"/>

</c:if>



<%--JSP Declaration--%>
<%!
    private String getMessage()
    {
        return "Session Created in declaration";
    }
%>



<%--JSP Scriplet--%>
<%
    String myText = request.getParameter("myCampus");

    if(myText == null){}

    else
    {
        session.setAttribute("MyCampus", session.getAttribute("myCampus"));
        session.setAttribute("MyMatric", session.getAttribute("myMatric"));
        session.setAttribute("MyProgramCode", session.getAttribute("myProgramCode"));
        out.println(getMessage());
    }
%>

</body>
</html>
