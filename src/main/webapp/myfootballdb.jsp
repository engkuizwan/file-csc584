<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 5/1/2022
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:if test="${ empty param.myTeam or empty param.myCoach or empty param.myPlayer or empty param.myFormation or empty param.myPosition}">

        <c:redirect url="MyFootball.jsp">

            <c:param name="errmsg" value="Please enter all fields"/>

        </c:redirect>

    </c:if>

    <c:if test="${ not empty param.myTeam or not empty param.myCoach or not empty param.myPlayer or not empty param.myFormation or not empty param.myPosition}">

        <c:redirect url="MyFootball.jsp">

            <c:param name="scssmsg" value="All data have been save successfully"/>

        </c:redirect>

    </c:if>


</body>
</html>
