<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="ru_Ru" scope="session"/>
<html>
<head>
    <title>CARS</title>
</head>
<body>
<c:forEach var="pst" items="${carList}">
    <h1>${pst}</h1>
</c:forEach>
</body>
</html>
