<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 5/1/2022
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:if test="${ empty param.myDad or empty param.myMom or empty param.mySibling}">

    <c:redirect url="MyFamily.jsp">

        <c:param name="error" value="Please enter all fields"/>

    </c:redirect>

</c:if>



<c:if test="${ not empty param.myDad or not empty param.myMom or not empty param.mySibling }">

    <c:redirect url="MyFamily.jsp">

        <c:param name="success" value="All data have been save successfully"/>

    </c:redirect>

</c:if>

</body>
</html>
