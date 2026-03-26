package Bai1_Lambda;

public class Student {
	private String id;
	private String name;
	private double diem; 
	
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
	
	public double getDiem() {
		return this.diem;
	}
	public boolean setDiem(double diem) {
		if(diem >= 0 & diem <= 10) {
			this.diem = diem;
			return true;
		}else {
			this.diem = -1;
			return false;
		}
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
