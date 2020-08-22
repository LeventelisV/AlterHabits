<%-- 
    Document   : updatephoto
    Created on : Aug 21, 2020, 4:55:32 PM
    Author     : alexk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <springform:form method="POST" action="updatephoto" enctype="multipart/form-data" modelAttribute="newPhoto">
                <springform:input type="file" path="userPhoto"/>
                <springform:errors path="userPhoto"/>
                <input type="submit"/>
            </springform:form>
        </body>
    </html>
