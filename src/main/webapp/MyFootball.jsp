<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>My Football</title>
</head>
<body>
<%@include file="Menu.html"%>
<h1>
    <%--JSP Expression--%>
    <%= "MY FOOTBALL" %>
</h1>
<jsp:include page="/MyFootballServlet"/>

<form name="footballForm" method="post" action="MyFootballServlet">

    Favourite Team : <input type="text" name="myTeam"><br/><br/>
    Favourite Coach : <input type="text" name="myCoach"><br/><br/>
    Favourite Player : <input type="text" name="myPlayer"><br/><br/>
    Favourite Formation : <input type="text" name="myFormation"><br/><br/>
    Favourite Position : <input type="text" name="myPosition"><br/><br/>
    <br/><br/><br/>
    <input type="submit" value="submit">

</form>



<%-- message to user --%>
<c:if test="${not empty param.errmsg}">

    <c:out value="${param.errmsg}"/>

</c:if>

<c:if test="${not empty param.scssmsg}">

    <c:out value="${param.scssmsg}"/>

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
    String myText = request.getParameter("myTeam");

    if(myText == null){}

    else
    {
        session.setAttribute("MyTeam", request.getParameter("myTeam"));
        session.setAttribute("MyCoach", request.getParameter("myCoach"));
        session.setAttribute("MyPlayer", request.getParameter("myPlayer"));
        session.setAttribute("MyFormation", request.getParameter("myFormation"));
        session.setAttribute("MyPosition", request.getParameter("myPosition"));
        out.println(getMessage());
    }
%>



</body>
</html>
