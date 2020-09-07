<%-- 
    Document   : reactregisterform
    Created on : Aug 22, 2020, 2:41:04 PM
    Author     : alexk
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>
    </head>
    <body>

        <form id="form" name="myForm">
            Name:     
            <input name="name"/><br><br>

            Surname:     
            <input name="surname"/><br><br>

            Gender:     
            <select name="gender">
                <option value = "NONE" label = "Select"/>
                <option value = "Male"/>
                <option value = "Female"/>
                <option value = "Other"/>
            </select> <br><br>

            Date of birth:     
            <input type="date" name="dateOfBirth"/><br><br>

            Email:     
            <input  name="email"/>
            <br><br>

            Phone Number:     
            <input name="phoneNumber"/> 
            <br><br>

            Mobile number:     
            <input  name="mobileNumber"/>
            <br><br>

            Username:     
            <input name="username"/> 
            <br><br>

            Password:     
            <input name="password" type="password"/>
            <br><br>

            Retype your password:     
            <input name="matchingPassword" type="password"/>
            <br><br>

            <radiobutton name="role" value="USER" />USER
            <radiobutton name="role" value="PREMIUM_USER" />PREMIUM USER
            <br><br>

            Enter Credit/Debit card number:     
            <input name="creditDebitCardNumber"/>
            <br><br>

            Enter Credit/Debit card full name:     
            <input name="creditDebitCardName"/>
            <br><br>

            Enter Credit/Debit card expiration month:     
            <input name="creditDebitCardExpMonth"/>
            <br><br>

            Enter Credit/Debit card expiration year:     
            <input name="creditDebitCardExpYear"/>
            <br><br>
            
<!--            <input name="usersPhoto" type="file"/>-->

            <button type="submit" class="btn btn-primary">Register</button>
        </form>
        <script>
            jQuery(function ($) {
            const form = document.getElementById("form");
            form.addEventListener('submit', function (e) {
                    e.preventDefault();
                    let formDataObject = Object.fromEntries(new FormData(this));
                    const body = JSON.stringify(formDataObject);
                    const options1 = {
                        method: "POST",
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: body
                    };
                    fetch('api/register', options1
                            )
                            .then(function (response) {
                                return response.text();
                            })
                            .then(function (res) {
                                let response = JSON.parse(res);
                                console.log(response.errors);
                            });
//-------------------------------------------------------------------------------------------------------------------------                            
//            e.preventDefault();
//            formData = new FormData();
//            formData.append("file", document.forms['myForm']['usersPhoto'].files[0]);
//            formData.append("properties", new Blob([JSON.stringify({
//            "name": document.getElementsByName("name").value,
//            "surname": document.getElementsByName("surname").value,
//            "gender": document.getElementsByName("gender").value,
//            "date": document.getElementsByName("date").value,
//            "email": document.getElementsByName("email").value,
//            "phoneNumber": document.getElementsByName("phoneNumber").value,
//            "mobileNumber": document.getElementsByName("mobileNumber").value,
//            "username": document.getElementsByName("username").value,
//            "password": document.getElementsByName("password").value,
//            "matchingPassword": document.getElementsByName("matchingPassword").value,
//            "role": $('input[name=gender]:checked', '#form').val(),
//            "creditDebitCardNumber": document.getElementsByName("creditDebitCardNumber").value,
//            "creditDebitCardName": document.getElementsByName("creditDebitCardName").value,
//            "creditDebitCardExpMonth": document.getElementsByName("creditDebitCardExpMonth").value,
//            "creditDebitCardExpYear": document.getElementsByName("creditDebitCardExpYear").value
//            })], {
//            type: "application/json"
//            }));
//            console.log(formData);
//            fetch('api/register',{
//                    method: "POST",
//                    headers: {
//                    "Content-Type": undefined
//                    },
//                    data: formData
//                })
//                    .then(function (response) {
//                    return response.text();
//                    })
//                    .then(function (res) {
//                   let response = JSON.parse(res);
//                    console.log(response);
//                    });
// ----------------------------------------------------------------------------------------------------------------------
//                $.ajax({
//                    url: 'api/createuser',
//                    type: "POST",
//                    contentType: "application/json; charset=utf-8",
//                    data: body, //Stringified Json Object
//                    async: false, //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
//                    cache: false, //This will force requested pages not to be cached by the browser  
//                    processData: false, //To avoid making query String instead of JSON
//                    success: function (x) {
//                        console.log(x);
//                    }
//                });
            });
            });
        </script>
    </body>
</html>
