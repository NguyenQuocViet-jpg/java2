package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import entity.Student;

public class StudentRepository {
	public List<Student> findAll(){
		List<Student> list = new ArrayList<Student>();
		try (Connection conn = DBConnect.getConnection()){
			String sql = "SELECT * FROM student";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student stu = new Student(
						rs.getInt("student_id"),
						rs.getString("student_name"),
						rs.getString("gender"),
						rs.getDouble("gpa"));
				list.add(stu);
			}
			return list;
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return null;
		}
	}
	
	public void showAll() {
		this.findAll().stream().forEach(System.out::println);
	}
	
	public Student findById(int id) {
		try (Connection conn = DBConnect.getConnection()){
			String sql = "SELECT * FROM student WHERE student_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Student stu = new Student(
					rs.getInt("student_id"),
					rs.getString("student_name"),
					rs.getString("gender"),
					rs.getDouble("gpa"));
			return stu;
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return null;
		}
	}
	public boolean save(Student stu) {
		String sql = "INSERT INTO student(student_name, gender, gpa) VALUES(?, ?, ?)";
		try(Connection conn = DBConnect.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, stu.getStudent_name());
			ps.setString(2, stu.getGender());
			ps.setDouble(3, stu.getGpa());
			
			return ps.executeUpdate() > 0;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean save(String student_name, String gender, double gpa) {
		String sql = "INSERT INTO student (student_name, gender, gpa) VALUES (?, ?, ?)";
		try(Connection conn = DBConnect.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, student_name);
			ps.setString(2, gender);
			ps.setDouble(3, gpa);
			return ps.executeUpdate() > 0;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Student stu) {
		String sql = "UPDATE student SET student_name = ?, gender = ?, gpa = ? WHERE student_id = ?";
		try(Connection conn = DBConnect.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, stu.getStudent_name());
			ps.setString(2, stu.getGender());
			ps.setDouble(3, stu.getGpa());
			ps.setInt(4, stu.getStudent_id());
			
			return ps.executeUpdate() > 0;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean delete(int id) {
		String sql = "DELETE FROM student WHERE student_id = ?";
		try(Connection conn = DBConnect.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
