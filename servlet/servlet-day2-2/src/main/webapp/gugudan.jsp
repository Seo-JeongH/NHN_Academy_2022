<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>구구단</title>
</head>
<body>
<%
    for (int i = 2; i <= 9; i++) {
%>
<!-- <%= i %>단 시작 -->
<%-- <%= i %>단 시작 --%>
<%
    for (int j = 1; j <= 9; j++) {
%>
<%= i %> * <%= j %> = <%= i * j %><br />
<%
    }
%>
<%-- <%= i %>단 끝 --%>
<!-- <%= i %>단 끝 -->
<br />
<%
    }
%>
</body>
</html>
