<%-- 
    Document   : error
    Created on : Mar 11, 2020, 10:13:47 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <c:if test="${not empty error}">
            <div class="error">
                ${error}
            </div>
        </c:if>
    </body>
</html>
