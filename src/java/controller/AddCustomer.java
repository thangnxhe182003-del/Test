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
public class AddCustomer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cid = request.getParameter("id");
        String comName = request.getParameter("cname");
        String addre = request.getParameter("addr");
        String dt = request.getParameter("phone");
        if(cid==null || comName==null){
            request.setAttribute("error", cid + "existed!");
            request.getRequestDispatcher("insertc.jsp").forward(request, response);
        }
        try{
            CustomerDAO dao = new CustomerDAO();
            //check trung lap rollNo
            Customer s = dao.findCustomerById(cid);
            if(s==null){
                Customer eNew = new Customer(cid,comName,addre,dt);//, markParam
                //dao.insert(eNew);
                response.sendRedirect("listcustomers");
            }else{
                request.setAttribute("error", cid + "existed!");
                request.getRequestDispatcher("insertc.jsp").forward(request, response);
            }
        } catch(NumberFormatException e){
            System.out.println(e);
        }
    }
}