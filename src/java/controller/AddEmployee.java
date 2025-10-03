/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.EmployeeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Employ;

/**
 *
 * @author 
 */
public class AddEmployee extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String gid = request.getParameter("id");
        int id=0;
        String lname = request.getParameter("txtLastName");
        String fname = request.getParameter("txtFirstName");
        String tit = request.getParameter("txtTile");
        try{
            id=Integer.parseInt(gid);
            EmployeeDAO dao = new EmployeeDAO();
            //check trung lap rollNo
            Employ s = dao.findEmployById(gid);
            if(s==null){
                Employ eNew = new Employ(lname, fname,tit);//, markParam
                dao.insert(eNew);
                response.sendRedirect("employees");
            }else{
                request.setAttribute("error", gid + "existed!");
                request.getRequestDispatcher("insert.jsp").forward(request, response);
            }
        } catch(NumberFormatException e){
            System.out.println(e);
        }
    }
}