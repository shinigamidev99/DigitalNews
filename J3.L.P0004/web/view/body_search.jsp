<%-- 
    Document   : body_search
    Created on : Jan 24, 2020, 10:56:59 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/body.css" rel="stylesheet" type="text/css"/>
        <title>Body Search Page</title>
    </head>
    <body>
        <div class="my-body">
            <div class="my-digital">
                <c:if test="${empty error}">
                    <jsp:useBean id="p" class="bean.PagingBean"/>
                    <jsp:setProperty name="p" property="*"/>

                    <div class="main">
                        <table>
                            <c:forEach items="${p.list}" var="x">
                                <tr>
                                    <td colspan="2">
                                        <div class="title">
                                            <h1>                                            
                                                <a href="digital?id=${x.id}">      
                                                    ${x.title}
                                                </a>
                                            </h1>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="image_search">
                                            <img src="${x.imagePath}" alt=""/>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="shortNotes">
                                            ${x.shortNotes}
                                        </div>
                                    </td>
                                </tr> 
                            </c:forEach>
                        </table>
                        <div class="paging">
                            <c:forEach var="i" begin="1" end="${p.pages}" step="1">
                                <c:url value="" var="next">
                                    <c:param name="page" value="${i}"/>
                                    <c:param name="title" value="${param.title}"/>
                                </c:url>
                                <c:if test="${i != param.page}">
                                    <a href="${next}">${i}</a>
                                </c:if>
                                <c:if test="${i == param.page}">
                                    <a class="active">${i}</a>
                                </c:if>
                            </c:forEach>
                        </div>
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
