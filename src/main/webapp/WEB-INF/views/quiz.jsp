<%-- 
    Document   : quiz
    Created on : Aug 7, 2020, 11:59:25 PM
    Author     : alexk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <script
			  src="https://code.jquery.com/jquery-3.5.1.js"
			  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
			  crossorigin="anonymous"></script>
            <title>JSP Page</title>
            
        </head>
        <body>
            <div id="question1">
            Do you like exercising as a group?<br>
            <input type="radio" name="question1" id="q1a1" value="yes" class="question1"/>
            <label for="q1a1">Yes.</label><br>
            <input type="radio" name="question1" id="q1a2" value="no" class="question1"/>
            <label for="q1a2">No.</label><br>
            <input type="radio" name="question1" id="q1a3" value="both" class="question1"/>
            <label for="q1a3">Don't care.</label>
            </div>
            <div id="question2">
            How much do you exercise?<br>
            <input type="radio" name="question2" id="q2a1" value="2" class="question2"/>
            <label for="q2a1">Quite a lot.</label><br>
            <input type="radio" name="question2" id="q2a2" value="1" class="question2"/>
            <label for="q2a2">Not quite much.</label><br>
            <input type="radio" name="question2" id="q2a3" value="0" class="question2"/>
            <label for="q2a3">Not at all.</label><br>
            </div>
            <div id="question3">
            What are you seeking of your activities?<br>
            <input type="radio" name="question3" id="q3a1" value="strength" class="question3"/>
            <label for="q3a1">Strength</label><br>
            <input type="radio" name="question3" id="q3a2" value="endurance" class="question3"/>
            <label for="q3a2">Endurance</label><br>
            <input type="radio" name="question3" id="q3a3" value="relaxation" class="question3"/>
            <label for="q3a3">Relaxation</label><br>
            </div>
            <div id="question4">
            Where is your favourite place to exercise?<br>
            <input type="radio" name="question4" id="q4a1" value="indoor" class="question4"/>
            <label for="q4a1">Indoors</label><br>
            <input type="radio" name="question4" id="q4a2" value="outdoor" class="question4"/>
            <label for="q4a2">Outdoors</label><br>
            <input type="radio" name="question4" id="q4a3" value="both" class="question4"/>
            <label for="q4a3">Wherever</label><br>
            </div>
            <button id="answers">
                Submit
            </button>
            <script>
                
                $(document).ready(function(){
                    
                let answer1;
                let answer2;
                let answer3;
                let answer4;
                let answers; 
                 
                 $('.question1').click(function(){
                     answer1 = this.value;
                 });
                 $('.question2').click(function(){
                     answer2 = this.value;
                 });
                 $('.question3').click(function(){
                     answer3 = this.value;
                 });
                 $('.question4').click(function(){
                     answer4 = this.value;
                 });
                 
                 $('#answers').click(function(){
                     answers = "quiz/answers?answer1=" + answer1 + "&answer2=" + answer2 + "&answer3=" + answer3 + "&answer4=" +answer4;
                     $.ajax({
                         url: answers,
                         success: function(data){
                             let activities = JSON.parse(data);
                             activities.forEach(activity => console.log(activity));
                         }
                     });
                 });
                 
                 
                });
                
            </script>
        </body>
    </html>

