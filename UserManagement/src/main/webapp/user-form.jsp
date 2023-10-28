<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Booking tickets</title>
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
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="<%=request.getContextPath()%>/list" class="navbar-brand">Booking Ticket</a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit Booking
            		</c:if>
						<c:if test="${user == null}">
            			Add new Booking
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

			
				<fieldset class="form-group">
					<label>User Email</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control" required="required"
						name="email">
				</fieldset>

				
                    <fieldset class="form-group">
                        <label>Event Name</label><br>
                        <input type="radio" name="eventName" value="Enchanted Masquerade Ball"> Enchanted Masquerade Ball<br>
                        <input type="radio" name="eventName" value="Neon Nights Dance Party"> Neon Nights Dance Party<br>
                        <input type="radio" name="eventName" value="Salsa Fiesta: Rhythms of the World"> Salsa Fiesta: Rhythms of the World<br>
                        <input type="radio" name="eventName" value="Glamour Gala: A Night of Elegance"> Glamour Gala: A Night of Elegance
                     
                    </fieldset>

			<fieldset class="form-group">
    <label>Ticket Count</label>
    <input type="number" class="form-control" name="ticketCount" min="0" required="required" value="<c:out value='${user.ticketCount}' />">
       </fieldset>

				
                    <fieldset class="form-group">
                        <label>Ticket Type</label><br>
                        <input type="radio" name="ticketType" value="Regular"> Regular<br>
                        <input type="radio" name="ticketType" value="VIP"> VIP
                    </fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
