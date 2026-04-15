package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import DBConnect.DBConnect;
import entity.Document;

public class DocumentRepository {
	public List<Document> findAll(){
		List<Document> list = new ArrayList<Document>();
		Connection conn = DBConnect.getConnection();
		
		if(conn == null) return Collections.emptyList();
		
		String sql = "SELECT * FROM document";
		
		try(PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				Document a = new Document(
						rs.getInt("document_id"),
						rs.getString("title"),
						rs.getString("author"),
						rs.getString("category"));
				list.add(a);
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
	
	public boolean addDocument(Document d) {
		Connection conn = DBConnect.getConnection();
		if(conn == null) return false;
		String sql = "INSERT INTO document VALUES(?, ?, ?, ?)";
		try (PreparedStatement kt = conn.prepareStatement(sql)) {
			kt.setInt(1, d.getDocument_id());
			kt.setString(2, d.getTitle());
			kt.setString(3, d.getAuthor());
			kt.setString(4, d.getCategory());
			kt.executeUpdate();
			return true;
		}catch (SQLException e) {
			logDataAcessException(e);
			return false;
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return false;
		}
	}
	
	public boolean updateDocument(Document d) {
		Connection conn = DBConnect.getConnection();
		if(conn == null) return false;
		
		String sql = "SELECT * FROM document WHERE document_id = ?";
		try(PreparedStatement a = conn.prepareStatement(sql)){
			a.setInt(1, d.getDocument_id());
			ResultSet b = a.executeQuery();
			if(b != null) {
				String sql1 = "UPDATE document SET title= ?, author= ?, category= ? WHERE document_id= ?";
				try(PreparedStatement m = conn.prepareStatement(sql1)){
					m.setString(1, d.getTitle());
					m.setString(2, d.getAuthor());
					m.setString(3, d.getCategory());
					m.setInt(4, d.getDocument_id());
					int rows = m.executeUpdate();
					if(rows == 0) {
						System.err.println("[Cập nhật thất bại] -> ID không tồn tại:" + d.getDocument_id());
						return false;
					}
					
				
				}
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
	
	public boolean deleteDocument(int id) {
		Connection conn = DBConnect.getConnection();
		if(conn == null) return false;
		
		String sql = "DELETE FROM document WHERE document_id= ?";
		try(PreparedStatement p = conn.prepareStatement(sql)){
			p.setInt(1, id);
			int rows = p.executeUpdate();
			if(rows == 0) {
				System.err.println("[Xóa thất bại] -> Không tìm thấy id: " + id);
				return false;
			}
			return true;
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return false;
		}
	}
	
	public Document findByID(int document_id) {
		Connection conn = DBConnect.getConnection();
		if(conn == null) return null;
		
		String sql = "SELECT * FROM document WHERE document_id = ?";
		try (PreparedStatement a =conn.prepareStatement(sql)) {
			a.setInt(1, document_id);
			try(ResultSet b = a.executeQuery()){
				if(b.next()) {
					return new Document(b.getInt("document_id"),
							b.getString("title"),
							b.getString("author"),
							b.getString("category"));
				}
			}
			return null;
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return null;
		}
	}
	
	public Document findByTitle(String title) {
		Connection conn = DBConnect.getConnection();
		if(conn == null) return null;
		
		String sql = "select * from document where title like ?";
		try (PreparedStatement a =conn.prepareStatement(sql)) {
			a.setString(1, title);
			try(ResultSet b = a.executeQuery()){
				if(b.next()) {
					return new Document(b.getInt("document_id"),
							b.getString("title"),
							b.getString("author"),
							b.getString("category"));
				}
			}
			return null;
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return null;
		}
	}
	
	public Document findByAuthor(String author) {
		Connection conn = DBConnect.getConnection();
		if(conn == null) return null;
		
		String sql = "SELECT * FROM document WHERE author like ?";
		try (PreparedStatement a =conn.prepareStatement(sql)) {
			a.setString(1, author);
			try(ResultSet b = a.executeQuery()){
				if(b.next()) {
					return new Document(b.getInt("document_id"),
							b.getString("title"),
							b.getString("author"),
							b.getString("category"));
				}
			}
			return null;
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return null;
		}
	}
	
	public Document findByCategory(String category) {
		Connection conn = DBConnect.getConnection();
		if(conn == null) return null;
		
		String sql = "SELECT * FROM document WHERE author like ?";
		try (PreparedStatement a =conn.prepareStatement(sql)) {
			a.setString(1, category);
			try(ResultSet b = a.executeQuery()){
				if(b.next()) {
					return new Document(b.getInt("document_id"),
							b.getString("title"),
							b.getString("author"),
							b.getString("category"));
				}
			}
			return null;
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return null;
		}
	}
	
	public List<Document> sort(int loai){  // 1: title   2: author   3: category
		List<Document> list = new ArrayList<Document>();
		Connection conn = DBConnect.getConnection();
		
		if(conn == null) return Collections.emptyList();
		
		String sql1 = "SELECT * FROM document ORDER BY ";
		
		String sqlT = "title ";
		String sqlA ="author ";
		String sqlC = "category ";
		
		String sql2 = "ASC";
		
		if(loai == 1){
			try (PreparedStatement a = conn.prepareStatement(sql1 + sqlT + sql2);
					ResultSet b = a.executeQuery()) {
				while(b.next()) {
					list.add(new Document(b.getInt("document_id"),
							b.getString("title"),
							b.getString("author"),
							b.getString("category")));
				}
				return list;
			} catch (SQLException e) {
				logDataAcessException(e);
				return null;
			}catch (Exception e) {	
				System.err.println("Error: " + e.getMessage());
				return null;
			}
		}else if(loai == 2) {
			try (PreparedStatement a = conn.prepareStatement(sql1 + sqlA + sql2);
					ResultSet b = a.executeQuery()) {
				while(b.next()) {
					list.add(new Document(b.getInt("document_id"),
							b.getString("title"),
							b.getString("author"),
							b.getString("category")));
				}
				return list;
			} catch (SQLException e) {
				logDataAcessException(e);
				return null;
			}catch (Exception e) {	
				System.err.println("Error: " + e.getMessage());
				return null;
			}
		}else if(loai == 3) {
			try (PreparedStatement a = conn.prepareStatement(sql1 + sqlC + sql2);
					ResultSet b = a.executeQuery()) {
				while(b.next()) {
					list.add(new Document(b.getInt("document_id"),
							b.getString("title"),
							b.getString("author"),
							b.getString("category")));
				}
				return list;
			} catch (SQLException e) {
				logDataAcessException(e);
				return null;
			}catch (Exception e) {	
				System.err.println("Error: " + e.getMessage());
				return null;
			
			}
		}else {
			System.out.println("Không tìm thấy thông tin này.");
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
