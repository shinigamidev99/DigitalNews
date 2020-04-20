<%-- 
    Document   : right
    Created on : Jan 20, 2020, 7:59:47 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/right.css" rel="stylesheet" type="text/css"/>
        <title>Right Page</title>
    </head>
    <body>
        <div class="right-page">
            <div class="digital-new">
                <div class="title">
                    <h1>Digital News</h1>
                </div>
                <div class="shortNotes">
                   ${digital_new.shortNotes}
                </div>
            </div>
            <div class="search">
                <div class="title">
                    <h1>Search</h1>
                </div>
                <form action="search">
                    <input type="text" name="title" value="" class="txt-search" required/>
                    <input type="hidden" name="page" value="1" class="txt-search"/>
                    <input type="submit" value="Go" class="submit"/>
                </form>
            </div>
            <div class="last-articles">
                <div class="title">
                    <h1>Last Articles</h1>
                </div>
                <c:forEach var="l" items="${lastArticles}">
                    <p><a href="digital?id=${l.id}">${l.title}</a></p>
                </c:forEach>
            </div>
        </div> 
    </body>
</html>
