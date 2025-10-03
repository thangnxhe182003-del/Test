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
        <title>Insert Customer Page</title>
    </head>
    <body>
        <h1>Fill the blank to insert Customer</h1>
        <form action="addc" method="post" >
           Customer ID: <input type="text" name="id"/><!-- comment --><br>
           Company Name: <input type="text" name="cname"/><!-- comment --><br>
           Address: <input type="text" name ="addr"/><br>
           Phone: <input type="text" name="phone"/><br>
            <input type="submit" value="Add Customer">
        </form>
    </body>
</html>
