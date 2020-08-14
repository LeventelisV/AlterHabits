<%-- 
    Document   : trainerform
    Created on : Jun 25, 2020, 12:13:11 PM
    Author     : vaggelis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <springform:form  method="post" action="${pageContext.request.contextPath}/register"
                          modelAttribute="registerUser" >
            Name:     <springform:input path="name"/> 
            <springform:errors path="name" cssClass="error"/> <br><br>
            
            surname:     <springform:input path="surname"/>
            <springform:errors path="surname" cssClass="error"/><br><br>
            
            gender:     <springform:input path="gender"/> 
            <springform:errors path="gender" cssClass="error"/> <br><br>
            
            Date of birth:     <springform:input type="date" path="dateOfBirth"/>
            <springform:errors path="dateOfBirth" cssClass="error"/><br><br>
            
            Address:     <springform:input path="address"/> 
            <springform:errors path="address" cssClass="error"/><br><br>
            
            Address number:     <springform:input type="number" path="addressnumber"/>
            <springform:errors path="addressnumber" cssClass="error"/><br><br>
            
            City:     <springform:input path="city"/> 
            <springform:errors path="city" cssClass="error"/> <br><br>
            
            Postal Code:     <springform:input type="number" path="postalcode"/>
            <springform:errors path="postalcode" cssClass="error"/><br><br>
            
            State:     <springform:input path="state"/> 
            <springform:errors path="state" cssClass="error"/> <br><br>
            
            Country:     <springform:input  path="country"/>
            <springform:errors path="country" cssClass="error"/><br><br>
            
            Email:     <springform:input  path="email"/>
            <springform:errors path="email" cssClass="error"/><br><br>
            
            Phone Number:     <springform:input path="phonenumber"/> 
            <springform:errors path="phonenumber" cssClass="error"/> <br><br>
            
            Mobile number:     <springform:input  path="mobilenumber"/>
            <springform:errors path="mobilenumber" cssClass="error"/><br><br>
            
             Username:     <springform:input path="username"/> 
            <springform:errors path="name" cssClass="error"/> <br><br>
            
            Password:     <springform:input path="password"/>
            <springform:errors path="password" cssClass="error"/><br><br>
            Retype your password:     <springform:input path="matchingpassword"/>
            <springform:errors path="matchingpassword" cssClass="error"/><br><br>
            
            

            <button type="submit" class="btn btn-primary">Register</button>
        </springform:form>
    </body>
</html>
