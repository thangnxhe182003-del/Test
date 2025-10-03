package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Employ;

public class EmployeeDAO extends DBContext {

    //doc tat ca cac ban ghi tu StudentDB
    public List<Employ> getAll() {
        List<Employ> list = new ArrayList<>();
        String sql = "select * from Employees";
        //chay lenhj truy van
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Employ s = new Employ(rs.getInt("EmployeeID"), rs.getString("LastName"), rs.getString("FirstName"), rs.getString("Title"), rs.getDate("BirthDate"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
//    check trung rollno

    public Employ findEmployById(String rollNo) {
        String sql = "select * from employees where EmployeeID = ?";
        Employ s = null;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, rollNo);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                s = new Employ();
                s.setId(rs.getInt("EmployeeID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return s;
    }
//
//    insertStudent
    public void insert(Employ e)  {//throws ParseException
        String sql = "INSERT INTO Employees(LastName,FirstName, Title) VALUES (?,?,?)";
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, e.getLastName());
            ps.setString(2, e.getFirstName());
            ps.setString(3, e.getTitle());
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
    public void deleteEmploy(int id) {
        String sql = "DELETE from Employees where EmployeeID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
       public void editEmploy(Employ st) {
        String sql = "UPDATE Employees SET FirstName = ?, LastName = ?,Title = ? where EmployeeID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, st.getFirstName());
            ps.setString(2, st.getLastName());
            ps.setString(3, st.getTitle());
            ps.setInt(4, st.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
//    
////    public static void main(String[] args) {
//        StudentDAO sd = new StudentDAO();
//        sd.deleteStudent("12");
//    }
}
