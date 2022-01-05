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


<c:if test="${ empty param.myName or empty param.myAge or empty param.myHobbies}">

    <c:redirect url="MySelf.jsp">

        <c:param name="serrmsg" value="Please enter all fields"/>

    </c:redirect>

</c:if>



<c:if test="${ not empty param.myName or not empty param.myAge or not empty param.myHobbies }">

    <c:redirect url="MySelf.jsp">

        <c:param name="sscssmsg" value="All data have been save successfully"/>

    </c:redirect>

</c:if>

</body>
</html>
