package Bai2;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private double gpa;
	
	public Student () {}
	
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
			throw new IllegalArgumentException("ID không được rỗng.");
		}
	}
	
	public String getName() {
		return this.name;
	}
	public boolean setName(String name) {
		if(name != null && !name.isEmpty()) {
			this.name = name;
			return true;
		}else {
			throw new IllegalArgumentException("Name Không được rỗng.");
		}
	}
	
	public double getGpa() {
		return this.gpa;
	}
	public boolean setGpa(double gpa) {
		if(gpa >= 0 && gpa <= 4) {
			this.gpa = gpa;
			return true;
		}else {
			throw new IllegalArgumentException("GPA >= 0 hoặc GPA <= 4");
		}
	}
	
	@Override
	public String toString() {
		return String.format(" %-10s | %-20s | %-2.1f", getId(), getName(), getGpa());
	}
	
}
