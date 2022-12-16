<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
  <title>JSTL - function</title>
</head>
<body>
<c:if test="${fn:startsWith('Dooray', 'Do')}">true</c:if><br />
<c:if test="${fn:endsWith('Dooray', 'Do')}">false</c:if><br />
<c:if test="${fn:contains('Dooray', 'or')}">true</c:if><br />
<c:out value="${fn:trim('   abc ')}" />==abc<br />
<c:out value="${'abc'.toUpperCase()}" />==ABC<br />
</body>
</html>
