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
    <title>My </title>
</head>
<body>
<%@include file="Menu.html"%>
<h1>
    <%= "MY FAMILY" %> <%--JSP Expression--%>
</h1>



<%--<jsp:include page="/MyFamilyServlet"/>--%>

<form name="familyForm" method="post" action="MyFamily.jsp"><br/><br/>
    Father's name : <input type="text" name="myDad"><br/><br/>
    Mother's name : <input type="text" name="myMom"><br/><br/>
    Sibling's name: <input type="text" name="mySibling"><br/><br/>
    <br/><br/><br/>
    <input type="submit" value="submit">
</form>




<%-- message to user --%>
<c:if test="${ empty param.myDad or empty param.myMom or empty param.mySibling}">

    <c:out value="pliss enter all field first"/>

</c:if>

<c:if test="${ not empty param.myDad or not empty param.myMom or not empty param.mySibling}">

    <c:out value="all field successfully entered!"/>

    <jsp:useBean id="setMyFamilyData" class="com.example.lab3jee.MyFamily">

        <jsp:setProperty name="setMyFamilyData" property="myMyDad" param="myDad"/>
        <jsp:setProperty name="setMyFamilyData" property="myMom" param="myMom"/>
        <jsp:setProperty name="setMyFamilyData" property="mySiblings" param="mySibling"/>

    </jsp:useBean>

    <br><p>Dad : <jsp:getProperty name="setMyFamilyData" property="myDad"/> </p>
    <p>Mom : <jsp:getProperty name="setMyFamilyData" property="myMom"/> </p>
    <p>Sibling :  <jsp:getProperty name="setMyFamilyData" property="mySiblings"/> </p><br><br>

</c:if>

<%--JSP Declaration--%>
<%!
    private String getMessage()
    {
        return "Session Created from declaration";
    }
%>


<%--JSP Scriplet--%>
<%
    String myText = request.getParameter("myDad");

    if (myText == null){}

    else
    {
        session.setAttribute("MyDad", request.getParameter("myDad"));
        session.setAttribute("MyMom", request.getParameter("myMom"));
        session.setAttribute("MySibling", request.getParameter("mySibling"));

        out.println(getMessage());
    }
%>
</body>
</html>
