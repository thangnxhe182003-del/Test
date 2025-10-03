/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CustomerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Cookie;
import java.io.IOException;
import model.Customer;

/**
 *
 * @author
 */
public class AddCustomer1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cid = request.getParameter("id");
        String comName = request.getParameter("cname");
        String addre = request.getParameter("addr");
        String dt = request.getParameter("phone");
        HttpSession session = request.getSession();
        if (cid.equals("")) {
            session.setAttribute("message", "Customer_ID_is_not_Allow_Null!");
            Cookie c = new Cookie("error", "Customer_ID_is_not_Allow_Null_Cookie");
            c.setMaxAge(60);
            response.addCookie(c); //trả về cho jsp
            request.getRequestDispatcher("insertc1.jsp").forward(request, response);
        }
        try {
            CustomerDAO dao = new CustomerDAO();
            //check trung lap rollNo
            Customer s = dao.findCustomerById(cid);
            if (s == null) {
                Customer eNew = new Customer(cid, comName, addre, dt);//, markParam
                dao.insertC(eNew);
                Cookie d = new Cookie("success", "Success_to_Add_Customer_Cookie");
                d.setMaxAge(60);
                response.addCookie(d);
                session.setAttribute("message", "Thêm khách hàng thành công! " + cid + "; " + comName + "; " + addre + "; " + dt);
                response.sendRedirect("listcustomers");
            } else {
                Cookie c1 = new Cookie("error1", "Customer_ID_is_Duplicate_Cookie");
                c1.setMaxAge(60);
                response.addCookie(c1);
                session.setAttribute("message", cid + " existed!");
                request.getRequestDispatcher("insertc1.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}
