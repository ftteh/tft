<%-- 
    Document   : home
    Created on : Oct 5, 2022, 8:14:59 PM
    Author     : tft
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta name="robots" content="noindex, nofollow">
        <!-- Include CSS File Here -->
        <link rel="stylesheet" href="css/style.css"/>
        <!-- Include CSS File Here -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!--<script type="text/javascript" src="js/login.js"></script>-->
    </head>
    <body>
        <div >
            <div >
                <div >
                    <form  action="${pageContext.request.contextPath}/app/login" method="POST">
                        <div >

                            User Id; <input type="text" id="userId" name="userId">
                        </div>
                        <div >
                            Password: <input type="password" id="password"  name="password">
                        </div>
                        <div >
                            <button id="login" type="submit">Log In</button>
                        </div>
                    </form>

                </div>
                <!--                <form class="form" method="post" action=""http://localhost:8080/app/login" method="POST" >
                
                                    <label>User Id :</label>
                                    <input type="text" name="userId" id="userId">
                                    <br>
                                    <label>Password :</label>
                                    <input type="password" name="password" id="password">
                                    <br>
                                    <input type="button" name="login" id="login" value="Login">
                                </form>-->
            </div>
        </div>
    </body>
    <script>
        $(document).ready(function () {
            $("#login").click(function () {
                var userId = $("#userId").val();
                var password = $("#password").val();

                if (userId == '' || password == '') {

                    alert("Please fill all fields...!!!!!!");
                } else {
//                    window.location.replace("http://localhost:8080/app/records?userId=" + userId);
                }
            });
        });
    </script>
</html>