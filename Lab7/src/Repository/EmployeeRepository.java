 package Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Connect.DBConnect;
import Entity.Employee;

public class EmployeeRepository {
	public List<Employee> findAll() {
		List<Employee> list = new ArrayList<Employee>();
		Connection connection = DBConnect.getConnection();
		if(connection == null) {
			return Collections.emptyList();
		}
		
		String sql = "SELECT * FROM employee";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Employee(
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getDouble("salary")));
			}
			return list;
		}catch (SQLException e) {
			logDataAcessException(e);
			return null;
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return null;
		}
	}
	
	public boolean addEmployee(Employee employee) {
		Connection connection = DBConnect.getConnection();
		if(connection == null) {
			return false;
		}
		String sql = "INSERT INTO employee VALUES(?, ?, ?)";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setDouble(3, employee.getSalary());
			ps.executeUpdate();
			return true;
		}catch (SQLException e) {
			logDataAcessException(e);
			return false;
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return false;
		}
	}
	
	public boolean updateEmployee(Employee employee) {
		Connection connection = DBConnect.getConnection();
		if(connection == null) {
			return false;
		}
		String sql = "UPDATE employee SET name = ?, salary = ? where id = ?";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, employee.getName());
			ps.setDouble(2, employee.getSalary());
			ps.setInt(3, employee.getId());
			int rows = ps.executeUpdate();
			if(rows == 0) {
				System.err.println("Cập nhật: không có dòng nào khớp id = " + employee.getId() + " (id không tồn tại).");
				return false;
			}
			return true;
		}catch (SQLException e ) {
			logDataAcessException(e);
			return false;
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return false;
		}
	}
	
	public boolean deleteEmployee(int id) {
		Connection connection = DBConnect.getConnection();
		if(connection == null) {
			return false;
		}
		String sql = "DELETE FROM employee WHERE id = ?";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			if(rows == 0) {
				System.out.println("Không tìm thấy nhân viên này");
				return false;
			}
			return true;
		}catch (SQLException e) {
			logDataAcessException(e);
			return false;
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return false;
		}
	}
	
	public Employee findByID(int id) {
		Connection connection = DBConnect.getConnection();
		if(connection == null) {
			return null;
		}
		String callSql = "{call sp_getEmployeeByID(?)}";
		try(CallableStatement cs = connection.prepareCall(callSql)){
			cs.setInt(1, id);
			try (ResultSet rs = cs.executeQuery()){
				if(rs.next()) {
					return new Employee(
							rs.getInt("id"), 
							rs.getString("name"), 
							rs.getDouble("salary"));
				}
			}
			return null;
		}catch(SQLException e) {
			logDataAcessException(e);
			return null;
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return null;
		}
	}
	
	private static void logDataAcessException(SQLException e) {
		if(e instanceof SQLIntegrityConstraintViolationException) {
			System.err.println("Vi phạm ràng buộc: trùng khóa chính (INSERT), khóa ngoại, UNIQUE hoặc NOT NULL.");
		}else if(e instanceof SQLSyntaxErrorException) {
			System.err.println("Lỗi cú pháp SQL hoặc đối tượng CSDL không tồn tại (bảng/cột/thủ tục sai tên).");
		}else {
			String state = e.getSQLState();
			int code = e.getErrorCode();
			if("42S02".equals(state)) {
				System.err.println("Bẳng hoặc view không tồn tại (SQLState 42S02). Kiểm tra tên bảng employee.");
			}else if("42000".equals(state) || code == 1305) {
				System.err.println("Thủ tục lưu trữ không tồn tại hoặc sai tham số (ví dụ SPgetEmployeeByID).");
			}else if("08S01".equals(state) || "08000".equals(state)) {
				System.err.println("Mất kết nối với MySQL trong lúc thực thi (connection reset / network).");
			}else {
				System.err.println("Lỗi JDBC [SQLState= " + state + ", errorCode= " + code + "]: " + e.getMessage());
			}
		}
		SQLException next = e.getNextException();
		if(next != null) {
			System.err.println("(nguyên nhân kèm theo) " + e.getMessage());
		}
	}
}


