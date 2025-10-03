/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.EmployeeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Employ;

/**
 *
 * @author 
 */
@WebServlet(name="EditEmployee", urlPatterns={"/edit"})
public class EditEmployee extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String roll = request.getParameter("id");
        EmployeeDAO sd = new EmployeeDAO();
        Employ s = sd.findEmployById(roll);
        request.setAttribute("s", s);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            String gid = request.getParameter("id");
            int id= Integer.parseInt(gid);
            String lname = request.getParameter("lname");
            String fname = request.getParameter("fname");
            String titl = request.getParameter("tit");
            Employ updateEmploy = new Employ(id, lname,fname, titl);//, mark
            EmployeeDAO sd = new EmployeeDAO();
            sd.editEmploy(updateEmploy);
            response.sendRedirect("employees");
        } catch (Exception e) {
            
        }
    }


}
