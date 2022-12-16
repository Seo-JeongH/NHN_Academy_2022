<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JSTL - core</title>
</head>
<body>
<c:set var="email" value="dongmyo@nhndooray.com" scope="request" />
<c:set var="name">dongmyo</c:set>

<c:out value="1" /><br />
<c:out value="${email}" /><br />
<c:out value="${pageScope.email}" /><br />
<c:out value="${requestScope.email}" /><br />

<c:out value="${name}" /><br />
<c:remove var="name" />
<c:out value="${name}" /><br />

<c:if test="${ email.contains('@nhndooray.com') }" var="testResult">
    <c:out value="${email}" /> is one of dooray email addresses.
</c:if>
test result is <c:out value="${testResult}" />

<c:set var="role" value="admin" />
<c:choose>
    <c:when test="${role == 'member'}">
        멤버입니다.
    </c:when>
    <c:when test="${role =='guest'}">
        손님은 접근이 제한됩니다.
    </c:when>
    <c:when test="${role == 'admin'}">
        관리자 권한으로 실행됩니다.
    </c:when>
    <c:otherwise>
        로그인하세요.
    </c:otherwise>
</c:choose>

<c:set var="browsers" value="${['Chrome' , 'Safari', 'Firefox']}" />
<table>
    <tr>
        <th>Browser</th>
    </tr>
    <c:forEach var="br" items="${browsers}">
        <tr>
            <td>${br}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
