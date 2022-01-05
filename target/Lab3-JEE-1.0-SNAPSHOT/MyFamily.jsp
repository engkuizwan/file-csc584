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



<jsp:include page="/MyFamilyServlet"/>

<form name="familyForm" method="post" action="familymessage.jsp"><br/><br/>
    Father's name : <input type="text" name="myDad"><br/><br/>
    Mother's name : <input type="text" name="myMom"><br/><br/>
    Sibling's name: <input type="text" name="mySibling"><br/><br/>
    <br/><br/><br/>
    <input type="submit" value="submit">
</form>




<%-- message to user --%>
<c:if test="${not empty param.error}">

    <c:out value="${param.error}"/>

</c:if>

<c:if test="${not empty param.success}">

    <c:out value="${param.success}"/>

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
