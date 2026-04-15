package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private static final String URL = "jdbc:mysql://localhost:3307/Document";
	private static final String USE = "root";
	private static final String PASSWORD = "root123";
	public static Connection getConnection() {
		Connection conn = null;
		try {
			return DriverManager.getConnection(URL, USE, PASSWORD);
		}catch (SQLException e) {
			logConnectionFailure(e);
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return conn;
	}
	
	private static void logConnectionFailure(SQLException e) {
		int code = e.getErrorCode();
		String msg = e.getMessage() != null ? e.getMessage() : "";
		
		if(code == 1045) {
			System.err.println("MySQL từ chối đăng nhập (1045): sai USER/PASSWORD hoặc user không có quyền.");
		}else if(code == 1049) {
			System.err.println("Không có database tên trong URL (1049): Kiểm tra tên Schema (ví dụ lab07_jdbc).");
		}else if(code == 0 && msg.contains("Communications link failure")) {
			System.err.println("Khổng kết nối được tới MySQL: server chưa chạy, sai host/port, hoặc firewall chặn.");
		}else if(msg.contains("Unknow database")) {
			System.err.println("Database chưa tạo hoặc tên sai trong chuôi JDBC URL.");
		}else {
			System.err.println("Lỗi kết nối JDBC[SQLState = " + e.getSQLState() + ", errorCode= " + code + "]: " + msg);
		}
	}
}
