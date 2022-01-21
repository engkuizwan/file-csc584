<%@ page import="com.example.lab3jee.MySelf" %>
<%@ page import="java.util.UUID" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/7/2021
  Time: 8:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
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

<%--<jsp:include page="MySelfServlet"/>--%>

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




<%-- message to user --%>
<c:if test="${ empty param.myName or empty param.myAge or empty param.myHobbies}">

    <c:out value="pliss enter all field first"/>

</c:if>

<c:if test="${ not empty param.myName or not empty param.myAge or not empty param.myHobbies}">

    <c:out value="all field successfully entered!"/>

    <jsp:useBean id="setMyselfData" class="com.example.lab3jee.MySelf" >

        <jsp:setProperty name="setMyselfData" property="myName" param="myName"/>
        <jsp:setProperty name="setMyselfData" property="myAge" param="myAge"/>
        <jsp:setProperty name="setMyselfData" property="myHobbies" param="myHobbies"/>

    </jsp:useBean>

    <br><p>Name : <jsp:getProperty name="setMyselfData" property="myName"/> </p>
    <p>Age : <jsp:getProperty name="setMyselfData" property="myAge"/> </p>
    <p>Hobbies : <jsp:getProperty name="setMyselfData" property="myHobbies"/> </p><br><br>


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
