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
		}
		return null;
	}
}
