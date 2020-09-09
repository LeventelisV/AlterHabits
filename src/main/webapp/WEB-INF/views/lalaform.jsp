<%-- 
    Document   : lalaform
    Created on : Aug 22, 2020, 4:19:44 PM
    Author     : alexk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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
        <form id="form" method="POST" action="api/registerlala">
            <input name="koko"/>
            <input name="mimi"/>
<!--            <input type="file" name="file"/>-->
            <button id="submit">Submit</button>
        </form>

        <script>
//     $(document).ready(function(){
//         const form = $('#form')[0];
//         console.log(form);
//         $("#submit").click(function(){
//         let formData = new FormData(form);
//         
//         let jsonDataObj = {
//           "koko": document.getElementsByName("koko").value,
//           "mimi": document.getElementsByName("mimi").value
//         };
//         formData.append("jsonData",JSON.stringify(jsonDataObj));
//         $.ajax({
//                 type:"POST",
//                 enctype:"multipart/form-data",
//                 url:"api/registerlala",
//                 data:formData,
//                 processData:false,
//                 contentType:false,
//                 cache:false,
//                 success:function(data){
//                     console.log(data);
//                 }
//             });
//         });
//     });
        </script>
    </body>
</html>
