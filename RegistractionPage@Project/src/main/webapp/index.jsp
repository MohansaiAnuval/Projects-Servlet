<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Regform" method="post">
Name:<input type="text" name="name1" ><br><br>
Email:<input type="text" name="email" ><br><br>
Password:<input type="password" name="password" ><br><br>
Gender:<input type="radio" name="gender" value="male">Male<input type="radio" name="gender" value="female">Female<br><br>
Country:<select name="country">
 <option >Select your city</option>
  <option value="Mumbai">Mumbai</option>
  <option value="Delhi">Delhi</option>
  <option value="Bangalore">Bangalore</option>
  <option value="Hyderabad">Hyderabad</option>
  <option value="Chennai">Chennai</option>
  <option value="Kolkata">Kolkata</option>
  <option value="Ahmedabad">Ahmedabad</option>
  <option value="Pune">Pune</option>
  <option value="Jaipur">Jaipur</option>
  <option value="Surat">Surat</option>
</select><br><br>
<input type="submit" value="Register">



</form>

</body>
</html>