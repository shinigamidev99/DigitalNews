<%-- 
    Document   : error
    Created on : Feb 20, 2020, 9:02:57 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/body.css" rel="stylesheet" type="text/css"/>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <title>Error Page</title>
    </head>
    <body> 
        <jsp:include page="header.jsp"/>
        <div class="my-body">
            <div class="my-digital">
                <jsp:include page="error.jsp"/>
                <c:if test="${empty error}">
                    <h1 class="error">Not found page!</h1>
                </c:if>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
