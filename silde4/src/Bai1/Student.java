package Bai1;

public class Student {
	private String id;
	private String name;
	private double gpa;
	
	public Student(String id, String name, double gpa) {
		this.id = id;
		this.name = name;
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
	
	public double getGpa() {
		return this.gpa;
	}
	public void setGpa(double gpa) {
		if(gpa >= 0 && gpa <=4) {
			this.gpa = gpa;
		}else {
			throw new IllegalArgumentException("");
		}
	}
}
