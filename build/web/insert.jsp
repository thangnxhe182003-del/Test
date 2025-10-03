<%-- 
    Document   : insert
    Created on : Jun 13, 2025, 10:54:58 AM
    Author     : SIEU THI SO 4G
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Employee Page</title>
    </head>
    <body>
        <h1>Fill the blank to insert Employee:</h1>
        <form action="addemploy" method="post" >
           Employee ID: <input type="text" name="id"/><!-- comment --><br>
           LName: <input type="text" name="txtLastName"/><!-- comment --><br>
           FName: <input type="text" name ="txtFirstName"/><br>
           Title: <input type="text" name ="txtTile"/><br>
           Date of Birth: <input type="date" name="btDate"/><br>
            <input type="submit" value="Add Employee">
        </form>
    </body>
</html>
