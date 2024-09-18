<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:powderblue;">

<form action="regForm" method="post">

<hr> <h1 style="color:blue;" align="center" ><b>Registeration Page</b></h1> <hr>

<h2  align="center" >

	Enter Name <input type="text" name="name1" placeholder="enter name"> <br> <br>
	Enter E-Mail <input type="email" name="email1" placeholder="enter email"> <br> <br>
	Enter Password <input type="password" name="pass1" placeholder="enter password"> <br> <br>
	Choose Gender <input type="radio" name="gender1" value="male"> Male <input type="radio" name="gender1" value="female" > Female <br> <br>
	Choose City <select name="city1" >
					<option>select city</option>
					<option>New Delhi</option>
					<option>Mumbai</option>
					<option>Hyderabad</option>
					<option>Bangalore</option>
					<option>Kolkata</option>
					<option>Pune</option>
					<option>Punjab</option>
				</select> 
				<br> <br>
			
		<input type="submit" value="click here to register" >
</h2>
</form>

</body>
</html>