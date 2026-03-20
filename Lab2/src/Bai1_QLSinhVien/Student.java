package Bai1_QLSinhVien;

public class Student {
	private String id;
	private String name;
	private StudentType type; 
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public StudentType getType() {
		return this.type;
	}
	public void setType(StudentType type) {
		this.type = type;
	}
	
	public Student() {}
	
	public Student(String id, String name, StudentType type) {
		this.id = id;
		this.name = name; 
		this.type = type;
	}
	
	public String toString() {
		return String.format("%-10s | %-25s | %-15s", this.id, this.name, this.type);
 	}
}
