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
<%--<jsp:include page="/MyFootballServlet"/>--%>

<form name="footballForm" method="post" action="MyFootball.jsp">

    Favourite Team : <input type="text" name="myTeam"><br/><br/>
    Favourite Coach : <input type="text" name="myCoach"><br/><br/>
    Favourite Player : <input type="text" name="myPlayer"><br/><br/>
    Favourite Formation : <input type="text" name="myFormation"><br/><br/>
    Favourite Position : <input type="text" name="myPosition"><br/><br/>
    <br/><br/><br/>
    <input type="submit" value="submit">

</form>



<%-- message to user --%>
<c:if test="${ empty param.myTeam or empty param.myCoach or empty param.myPlayer or  empty param.myFormation or  empty param.myPosition}">

    <c:out value="pliss enter all field first"/>

</c:if>

<c:if test="${ not empty param.myTeam or not empty param.myCoach or not empty param.myPlayer or not empty param.myFormation or not empty param.myPosition}">

    <c:out value="all field successfully entered!"/>

    <jsp:useBean id="setMyFootballData" class="com.example.lab3jee.MyFootball">

        <jsp:setProperty name="setMyFootballData" property="myTeam" param="myTeam"/>
        <jsp:setProperty name="setMyFootballData" property="myCoach" param="myCoach"/>
        <jsp:setProperty name="setMyFootballData" property="myPlayer" param="myPlayer"/>
        <jsp:setProperty name="setMyFootballData" property="myFormation" param="myFormation"/>
        <jsp:setProperty name="setMyFootballData" property="myPosition" param="myPosition"/>

    </jsp:useBean>

    <br><p>Team : <jsp:getProperty name="setMyFootballData" property="myTeam"/> </p>
    <p>Coach : <jsp:getProperty name="setMyFootballData" property="myCoach"/> </p>
    <p>Player : <jsp:getProperty name="setMyFootballData" property="myPlayer"/> </p>
    <p>Formation : <jsp:getProperty name="setMyFootballData" property="myFormation"/> </p>
    <p>Position :  <jsp:getProperty name="setMyFootballData" property="myPosition"/> </p><br><br>

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
