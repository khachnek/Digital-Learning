<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="home">DigiLearn</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		<div class="navbar-nav">
			<a class="nav-link " href="searchCourse">Search Course <span
				class="sr-only">(current)</span></a> <a class="nav-link" href="suggestedCourses">Suggested
				Courses</a> <a class="nav-link" href="learningPath">Learning Path</a><a class="nav-link"
				href="updateInterest">Update Interests</a>

		</div>
	</div>
</nav>
<title>Suggested Courses on interests</title>
</head>

<body>
		<div class="jumbotron text-center">
		<h1>Suggested courses based on your interests</h1>
	</div>
	
	<div class="container ">
		<form action="/showSuggestedCourses" method="post">
		
		  	  
			
			<input class="form-control" type="text" placeholder="Employee Id " name="id"><br>
			<input class="form-control" type="text" placeholder="Employee Name " name="name"><br>
			<!--<input class="form-control" type="text" placeholder="Interests separated by comma" name="interests"><br>-->
			
			<div class="form-row">
				<div class="col">
				<button type="submit" class="btn btn-primary btn-block">Get courses</button>
				</div>
			</div>

		</form>

	</div>
	
    
     <footer class="page-footer font-small ">
		<div class="footer text-center py-3 fixed-bottom bg-primary ">
			<p class="text-light ">Hacked@2020</p>
		</div>
	</footer>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>