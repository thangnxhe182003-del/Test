/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

/**
 *
 * @author SIEU THI SO 4G
 */

public class CustomerDAO extends DBContext {  
    public List<Customer> getAll() {
        List<Customer> list = new ArrayList<>();
        String sql = "select * from Customers";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Customer s = new Customer(rs.getString("CustomerID"), rs.getString("CompanyName"), rs.getString("Address"), rs.getString("Phone"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    //    check trung rollno

    public Customer findCustomerById(String rollNo) {
        String sql = "select * from Customers where CustomerID = ?";
        Customer s = null;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, rollNo);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                s = new Customer();
                s.setCustomerID(rs.getString("CustomerID"));
                s.setCompanyName(rs.getString("CompanyName"));
                s.setAddress(rs.getString("Address"));
                s.setPhone(rs.getString("Phone"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return s;
    }
//
//    insertStudent
    public void insertC(Customer e)  {//throws ParseException
        String sql = "INSERT INTO Customers(CustomerID,CompanyName,Address,Phone) VALUES(?,?,?,?)";        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, e.getCustomerID());
            ps.setString(2, e.getCompanyName());
            ps.setString(3, e.getAddress());
            ps.setString(4, e.getPhone());
            System.out.println("SQL: " + sql);
//            Date sDate= formatter.parse(e.getBirthDate().toString());
//            java.sql.Date sqlDate;
//            sqlDate= java.sql.Date(sDate);
//            ps.setDate(1, e.sqlDate);
            ps.executeUpdate();
        } catch (SQLException em) {
            System.out.println(em);
        }
    }
//
    public void deleteCustomer(String id) {
        String sql = "DELETE from Customers where CustomerID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
       public void editCustomer(Customer st) {
        String sql = "UPDATE Customers SET CompanyName = ?, Address = ?,Phone = ? where CustomerID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, st.getCompanyName());
            ps.setString(2, st.getAddress());
            ps.setString(3, st.getPhone());
            ps.setString(4, st.getCustomerID());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
