package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ProductDAO extends DBContext {

    //doc tat ca cac ban ghi tu StudentDB
    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Products";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product s = new Product(rs.getInt("ProductID"), rs.getString("ProductName"), rs.getString("QuantityPerUnit"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
//    check trung rollno

//    public Student findStudentByRollNo(String rollNo) {
//        String sql = "select * from Student where RollNo = ?";
//        Student s = null;
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, rollNo);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                s = new Student();
//                s.setRollNo(rs.getString("rollNo"));
//                s.setName(rs.getString("name"));
//                s.setMark(rs.getFloat("mark"));
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return s;
//    }
//
////    insertStudent
//    public void insert(Student student) {
//        String sql = "INSERT INTO Student (RollNo, Name, Mark) VALUES (?,?,?)";
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, student.getRollNo());
//            ps.setString(2, student.getName());
//            ps.setFloat(3, student.getMark());
//            ps.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//    public void deleteStudent(String roll) {
//        String sql = "DELETE from student where RollNo = ?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, roll);
//            ps.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//       public void editStudent(Student st) {
//        String sql = "UPDATE STUDENT SET name = ?, mark = ? where RollNo = ?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, st.getName());
//            ps.setFloat(2, st.getMark());
//            ps.setString(3, st.getRollNo());
//            ps.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//    
////    public static void main(String[] args) {
//        StudentDAO sd = new StudentDAO();
//        sd.deleteStudent("12");
//    }
}
