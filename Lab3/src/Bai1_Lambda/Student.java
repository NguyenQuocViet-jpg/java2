package Bai1_Lambda;

public class Student {
	private String id;
	private String name;
	private double diem; 
	
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
	
	public double getDiem() {
		return this.diem;
	}
	public void setDiem(double diem) {
		this.diem = diem;
	}
	
	public Student() {}
	
	public Student(String id, String name, double diem) {
		this.id = id;
		this.name = name; 
		this.diem = diem;
	}
	
	@Override
	public String toString() {
		return String.format("%-10s | %-25s | %-15s", this.id, this.name, this.diem);
 	}
}
