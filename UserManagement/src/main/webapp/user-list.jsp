<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
          
          <style>
        body {
            background-color: #ADD8E6;
        }

        .container {
            background-color: #ADD8E6;
            padding: 20px;
        }

        .navbar {
            background-color: blue;
        }

        .form-group label {
            color: blue; /* Change label text color */
        }

        .form-control {
            background-color: #E0FFFF; /* Change input field background color */
        }

        .btn-success {
            background-color: green; /* Change button background color */
            color: white; /* Change button text color */
        }
    </style>
          
          
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
        <div>
            <a href="https://www.xadmin.net" class="navbar-brand">Booking Tickets</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Bookings</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <div class="container">
        <h3 class="text-center">List of Booking Tickets</h3>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Booking</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Email</th>
                    <th>Event Name</th>
                    <th>Ticket Count</th>
                    <th>Ticket Type</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${listUser}">
                    <tr>
                        <td><c:out value="${user.id}" /></td>
                        <td><c:out value="${user.email}" /></td>
                        <td><c:out value="${user.eventName}" /></td>
                        <td><c:out value="${user.ticketCount}" /></td>
                        <td><c:out value="${user.ticketType}" /></td>
                        <td>
                            <a href="edit?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
							
								<a href="delete?id=<c:out value='${user.id}' />">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                
               
            </tbody>
        </table>
    </div>
</div>

 <div class="container text-left">
            <a href="" class="btn btn-success">Confirm Booking</a>
        </div>

</body>
</html>
