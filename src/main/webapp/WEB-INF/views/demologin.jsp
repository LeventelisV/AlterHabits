<%-- 
    Document   : demo-login
    Created on : Aug 6, 2020, 6:06:35 PM
    Author     : alexk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form method="POST" action="preregisterform">
            <p>
                User name: <input type="text" name="username"/>
            </p>
            <p>
                Password: <input type="password" name="password"/>
            </p>
            <input type="submit" value="Login"/>
        </form:form>
    </body>
</html>
