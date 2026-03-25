package Bai4;

public class Student {
	private String id;
	private String name;
	private StudentType type;
	private double gpa;
	
	public Student(String id, String name, StudentType type, double gpa) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.gpa = gpa;
	}
	
	public String getId() {
		return this.id;
	}
	public boolean setId(String id) {
		if(id != null && !id.isEmpty()) {
			this.id = id;
			return true;
		}else {
			this.id = null;
			return false;
		}
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
	
	public double getGpa() {
		return this.gpa;
	}
	public boolean setGpa(double gpa) {
		if(gpa > 0 && gpa <= 4) {
			this.gpa = gpa;
			return true;
		}else {
			this.gpa = -1;
			return false;
		}
	}
	@Override
	public String toString() {
		return String.format(" %-10s | %-25s | %-15s | %.1f", this.id, this.name, this.type, this.gpa);
	}
}
