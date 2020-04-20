<%-- 
    Document   : home
    Created on : Jan 14, 2020, 10:21:51 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <title>Home Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <c:if test="${param.action eq 'body'}">
            <jsp:include page="body.jsp"/>
        </c:if>
        <c:if test="${param.action eq 'bodySearch'}">
            <jsp:include page="body_search.jsp"/>
        </c:if>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
