<%@page import=" java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
    <title>Consultant Requests</title>
</head>
<body>
    <h2>Consultant Requests</h2>
    <form action="ConsultantRequest" method="post">
        UserName<input type="text" name="user"><br><br>
        Password<input type="password" name="pass"> <br><br>
        <input type="submit" value="submit"> 
    </form>
    
</body>
</html>