<%@ page contentType="text/plain;charset=UTF-8" trimDirectiveWhitespaces="true" language="java" %>
<jsp:useBean id="hb" class="com.nhnacademy.domain.HtmlBeautifier">
    <jsp:setProperty name="hb" property="html" />
</jsp:useBean>

<jsp:getProperty name="hb" property="html" />
