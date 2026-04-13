package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import entity.Tree;

public class TreeRepository {
	public List<Tree> findAll(){
		List<Tree> list = new ArrayList<Tree>();
		try(Connection conn = DBConnect.getConnection()){
			String sql = "SELECT * FROM tree";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Tree tree = new Tree(
						rs.getInt("node_id"),
						rs.getString("node_name"),
						rs.getInt("parent_id"),
						rs.getInt("level"));
				list.add(tree);
			}
			return list;
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return null;
		}
	}
	
	public Tree findById(int id) {
		try(Connection conn = DBConnect.getConnection()){
			String sql = "SELECT * FROM tree where node_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Tree tree = new Tree(
					rs.getInt("node_id"),
					rs.getString("node_name"),
					rs.getInt("parent_id"),
					rs.getInt("level"));
			return tree;
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return null;
		}
	}
	
	public boolean save(Tree tree) {
		String sql = "INSERT INTO tree(node_name, parent_id, level) VALUES (?, ?, ?)";
		try(Connection conn = DBConnect.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, tree.getNodeName());
			ps.setInt(2, tree.getParentId());
			ps.setInt(3, tree.getLevel());
			
			return ps.executeUpdate() > 0;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean savve(String node_name, int parent_id, int level) {
		String sql = "INSERT INTO tree(node_name, parent_id, level) VALUES (?, ?, ?)";
		try(Connection conn = DBConnect.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, node_name);
			ps.setInt(2, parent_id);
			ps.setInt(3, level);
			
			return ps.executeUpdate() > 0;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Tree tree) {
		String sql = "UPDATE tree SET node_name = ?, parent_id = ?, level = ? WHERE node_id = ?";
		try(Connection conn = DBConnect.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, tree.getNodeName());
			ps.setInt(2, tree.getParentId());
			ps.setInt(3, tree.getLevel());
			ps.setInt(4, tree.getNodeId());
			
			return ps.executeUpdate() > 0;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
