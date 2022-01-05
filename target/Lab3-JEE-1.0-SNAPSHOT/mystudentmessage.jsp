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


<c:if test="${ empty param.myCampus or empty param.myMatric or empty param.myProgramCode}">

    <c:redirect url="MyStudent.jsp">

        <c:param name="sterrmsg" value="Please enter all fields"/>

    </c:redirect>

</c:if>



<c:if test="${ not empty param.myCampus or not empty param.myMatric or not empty param.myProgramCode }">

    <c:redirect url="MyStudent.jsp">

        <c:param name="stscssmsg" value="All data have been save successfully"/>

    </c:redirect>

</c:if>

</body>
</html>
