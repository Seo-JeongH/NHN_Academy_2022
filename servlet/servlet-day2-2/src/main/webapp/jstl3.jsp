<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>JSTL - formatting</title>
</head>
<body>
<fmt:setLocale value="ko" />
<fmt:setBundle basename="message" var="message" />
<fmt:message key="hello" bundle="${message}" />
<br />

<fmt:bundle basename="message">
    i say dooray, you say <fmt:message key="hello" />
</fmt:bundle>
<br />

<fmt:setLocale value="en_US" />
<c:set var="price" value="12000" />
<fmt:formatNumber value="${price}" type="currency" /><br />

<fmt:setLocale value="ko_KR" />
<fmt:formatNumber value="${price}" type="currency" /><br />

<fmt:formatNumber value="123000000" type="number" maxFractionDigits="3" /><br />

<c:set var="today" value="<%= new java.util.Date() %>"/>
<fmt:formatDate value="${today}" type="date" dateStyle="short" /><br />
<fmt:formatDate value="${today}" type="time" timeStyle="medium" /><br />
<fmt:formatDate value="${today}" type="both" dateStyle="long" timeStyle="long" /><br />
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm:ss" /><br />
</body>
</html>
