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
import java.io.IOException;
import model.Customer;

/**
 *
 * @author 
 */
public class EditCustomer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String roll = request.getParameter("id");
        CustomerDAO sd = new CustomerDAO();
        Customer s = sd.findCustomerById(roll);
        request.setAttribute("s", s);
        request.getRequestDispatcher("updatec.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            String gid = request.getParameter("id");
            String lname = request.getParameter("comName");
            String fname = request.getParameter("addr");
            String titl = request.getParameter("phone");
            Customer updatec = new Customer(gid, lname,fname, titl);//, mark
            CustomerDAO sd = new CustomerDAO();
            sd.editCustomer(updatec);
            response.sendRedirect("listcustomers");
        } catch (Exception e) {
            
        }
    }


}
