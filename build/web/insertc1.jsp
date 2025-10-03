<%-- 
    Document   : insert
    Created on : Jun 13, 2025, 10:54:58 AM
    Author     : SIEU THI SO 4G
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Customer Page</title>
    </head>
    
        <%
            Cookie[] cookies = request.getCookies(); //Lấy ra mảng cookie để dùng
    if(cookies != null){
        String tb = "";
        for(Cookie c: cookies){
            if("error".equals(c.getName())) {
            tb = c.getValue();
            }
            if("error1".equals(c.getName())) {
            tb = c.getValue();
            }
            if("success".equals(c.getName())) {
            tb = c.getValue();
            }
        }
    }
//            String msg = (String) session.getAttribute("message");
//            if (msg != null) {
        %>
        <%
    String tb = (String) session.getAttribute("tb");
    String msg = (String) session.getAttribute("message");
    if (msg != null || tb != null) {
        %>
        <h1><font color="red"><%= tb != null ? tb : "" %></font></h1>
        <script>
        alert("<%= msg != null ? msg : "" %>");
        </script>
        <%
                session.removeAttribute("message");
                session.removeAttribute("tb");
            }
        %>

        <h1>Fill the blank to insert Customer</h1>
        <form action="addcustomer" method="post" >
            Customer ID: <input type="text" name="id"/><!-- comment --><br>
            Company Name: <input type="text" name="cname"/><!-- comment --><br>
            Address: <input type="text" name ="addr"/><br>
            Phone: <input type="text" name="phone"/><br>
            <input type="submit" value="Add Customer">
        </form>
    

