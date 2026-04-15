package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

import DBConnect.DBConnect;
import entity.Document;
import entity.DocumentCopy;

public class DocumentCopyRepository {
	public List<DocumentCopy> findAllCopy(){
		List<DocumentCopy> list = new ArrayList<DocumentCopy>();
		
		Connection conn = DBConnect.getConnection();
		if(conn == null) return null;
		
		String sql = "SELECT * FROM document_copy";
		try(PreparedStatement a = conn.prepareStatement(sql);
				ResultSet b = a.executeQuery()){
			while(b.next()) {
				DocumentCopy dc = new DocumentCopy(
						b.getInt("copy_id"),
						b.getString("status"),
						b.getInt("document_id"));
				list.add(dc);
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
	
	public boolean addCopy(DocumentCopy dc) {
		Connection conn = DBConnect.getConnection();
		if(conn == null) return false;
		
		String sql = "INSERT INTO document_copy VALUES (?, ?, ?)";
		try(PreparedStatement a = conn.prepareStatement(sql)){
			a.setInt(1, dc.getCopy_id());
			a.setString(2, dc.getStatus());
			a.setInt(3, dc.getDocument_id());
			a.executeUpdate();
			return true;
		}catch (SQLException e) {
			logDataAcessException(e);
			return false;
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return false;
		}
	}
	
	public boolean updateCopy(DocumentCopy dc) {
		Connection conn = DBConnect.getConnection();
		if(conn == null) return false;
		
		String sql = "UPDATE document_copy SET status= ? WHERE copy_id= ?";
		try(PreparedStatement a = conn.prepareStatement(sql)){
			a.setString(1, dc.getStatus());
			a.setInt(2, dc.getCopy_id());
			int rows = a.executeUpdate();
			if(rows == 0) {
				System.err.println("[Update thất bại] -> id không tồn tại: " + dc.getCopy_id());
				return false;
			}
			return true;
		}catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
			return false;
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return false;
		}
	}
	
	public boolean deleteCopy(int id) {
		Connection conn = DBConnect.getConnection();
		if(conn == null) return false;
		
		String sql = "DELETE FROM document_copy WHERE copy_id= ?";
		try(PreparedStatement a = conn.prepareStatement(sql)){
			a.setInt(1, id);
			int rows = a.executeUpdate();
			if(rows == 0) {
				System.err.println("[DELETE thất bại] -> không tìm thấy id: " + id);
				return false;
			}
			return true;
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return false;
		}
	}
	
	public List<Document> showStatus(String status) {
		List<Document> list = new ArrayList<Document>();
		Connection conn = DBConnect.getConnection();
		if(conn == null) return null;
		
		String sql = "SELECT d.* FROM document d JOIN document_copy dc on d.document_id = dc.document_id WHERE dc.copy_id IN "
				+ "(SELECT document_id FROM document_copy WHERE status like ?)";
		try(PreparedStatement a = conn.prepareStatement(sql)){
			a.setString(1, status);
			ResultSet b = a.executeQuery();
			while(b.next()) {
				list.add(new Document(b.getInt("document_id"),
						b.getString("title"),
						b.getString("author"),
						b.getString("category")));
			}
			return list;
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
