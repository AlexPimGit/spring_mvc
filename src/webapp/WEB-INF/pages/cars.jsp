<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--<%@ page language="java" contentType="text/html;charset=cp1251"%>--%>
<%--pageEncoding – это кодировка текущего файла JSP--%>
<%--charset – это принципиально другое: кодировка страницы, полученной в результате работы JSP.--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="cars.title"/></title>
</head>
<body>
<c:forEach var="pst" items="${carList}">
    <h1>${pst}</h1>
</c:forEach>

<h2>Заголовок: <spring:message code="cars.title"/></h2>
<p>Local Parameter: <%= request.getParameter("locale") %>
</p>
Current Locale : ${pageContext.response.locale}
</body>
</html>
