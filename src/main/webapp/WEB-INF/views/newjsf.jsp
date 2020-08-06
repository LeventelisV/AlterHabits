<%-- 
    Document   : newjsf
    Created on : Aug 5, 2020, 5:14:34 PM
    Author     : vaggelis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <form:form method="POST" action="${pageContext.request.contextPath}/logout">
                <input type="submit" value="Logout"/>
            </form:form>
        </body>
    </html>
