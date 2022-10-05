<%-- 
    Document   : posts
    Created on : Oct 5, 2022, 8:14:59 PM
    Author     : tft
--%>

<%@page import="app.models.RecordModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>

<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog</title>
        <!-- Bootstrap core CSS -->
        <link href="resources/css/bootstrap.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300" rel="stylesheet">     
        <!-- Custom styles for this template -->
        <link href="css/cover.css" rel="stylesheet">
        <style>
            table, th, td {
                border: 1px solid;
            }
        </style>
    </head>
    <body>
        <%
//                    To get the department and the accumulated score
            ArrayList<RecordModel> records = (ArrayList) request.getAttribute("records");
            HashMap<String, Double> departments = (HashMap) request.getAttribute("departments");
            HashMap<String, Integer> depStudentCount = (HashMap) request.getAttribute("depStudentCount");
            String userId = (String) request.getAttribute("userId");
        %>
        Welcome: <c:out value = "${userId}" />
        <br>
        Click on the student id cell to get student name

        <div>
            <table>
                <tr>
                    <th>Department</th>
                    <th>Student ID</th>
                    <th>Marks</th>
                    <th>Pass %</th>
                </tr>


                <c:set var = "sameRow" scope = "session" value = "${true}"/>
                <c:forEach items="${departments}" var="department">


                    <c:set var = "totalStudent" scope = "session" value = "${0}"/>


                    <c:forEach  items="${records}" var="record">

                        <c:if test = "${record.department == department.getKey()}">

                            <c:if test = "${sameRow}">
                                <tr>  
                                    <td rowspan="${depStudentCount.get(department.getKey())}">${department.getKey()} </td>
                                </c:if>

                                <c:if test = "${!sameRow}">
                                <tr>
                                </c:if>

                                <td onclick='alert("${record.studentName}");'>${record.studentId} </td>
                                <td>${record.mark} </td>

                                <c:if test = "${!sameRow}">
                                </tr>
                            </c:if>

                            <c:if test = "${sameRow}">
                                <td  rowspan="${depStudentCount.get(department.getKey())}">${department.getValue()}</td>         
                                </tr>
                                <c:set var = "sameRow" scope = "session" value = "${false}"/>


                            </c:if>
                        </c:if>                                
                    </c:forEach>
                    <c:set var = "sameRow" scope = "session" value = "${true}"/>
                </c:forEach>







            </table>



        </main>


    </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="resources/js/jquery-slim.min.js"><\/script>')</script>
    <script src="resources/js/popper.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
