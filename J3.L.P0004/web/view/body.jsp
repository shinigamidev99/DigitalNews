<%-- 
    Document   : body
    Created on : Jan 20, 2020, 7:40:19 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/body.css" rel="stylesheet" type="text/css"/>
        <title>Body Page</title>
    </head>
    <body>
        <div class="my-body">
            <div class="my-digital">
                <c:if test="${empty error}">
                    <div class="title">
                        <h1>${digital.title}</h1>
                    </div>
                    <div class="image">
                        <img src="${digital.imagePath}" alt="img"/>
                    </div>
                    <div class="notes">
                        ${digital.notes}
                    </div>
                    <div class="end-digital">
                        <div class="icon1"></div>
                        <div class="icon2"></div>
                        By ${digital.author} | ${digital.dateFormat}
                    </div>
                </c:if>
                <jsp:include page="error.jsp"/>
            </div>
            <div class="right">
                <jsp:include page="right.jsp"/>
            </div>
        </div>
    </body>
</html>
