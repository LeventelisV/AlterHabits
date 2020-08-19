<%-- 
    Document   : updateinfo
    Created on : Aug 18, 2020, 7:59:53 PM
    Author     : alexk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>asd</title>
    </head>
    <body>
        <springform:form  method="post" action="${pageContext.request.contextPath}/update"
                          modelAttribute="updateUser">

            <springform:input path="userId" type="hidden"/>    

            Name:     
            <springform:input path="name"/> 
            <springform:errors path="name" cssClass="error"/> <br><br>

            Surname:     
            <springform:input path="surname"/>
            <springform:errors path="surname" cssClass="error"/><br><br>

            Gender:     
            <springform:select path="gender">
                <springform:option value = "NONE" label = "Select"/>
                <springform:option value = "Male"/>
                <springform:option value = "Female"/>
                <springform:option value = "Other"/>
            </springform:select> 
            <springform:errors path="gender" cssClass="error"/> <br><br>

            Date of birth:     
            <springform:input type="date" path="dateOfBirth"/>
            <springform:errors path="dateOfBirth" cssClass="error"/><br><br>

            Email:     
            <springform:input  path="email"/>
            <springform:errors path="email" cssClass="error"/>
            <br><br>

            Phone Number:     
            <springform:input path="phoneNumber"/> 
            <springform:errors path="phoneNumber" cssClass="error"/> 
            <br><br>

            Mobile number:     
            <springform:input  path="mobileNumber"/>
            <springform:errors path="mobileNumber" cssClass="error"/>
            <br><br>

            <button type="submit" class="btn btn-primary">Register</button>
        </springform:form>
    </body>
</html>
