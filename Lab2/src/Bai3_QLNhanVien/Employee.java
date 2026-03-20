package Bai3_QLNhanVien;

public class Employee {
	private String id;
	private String name;
	private double salary;
	
	public Employee() {
		
	}
	public Employee(String id, String name, double salary) {
		this.setId(id);
		this.setName(name);
		this.setSalary(salary);
	}
	public String getId() {
		return id;
	}
	public boolean setId(String id) {
		if( id !="") {
			this.id = id;
			return true;
		} else return false;
		}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public boolean setSalary(double salary) {
		if( salary >= 0) {
			this.salary = salary;
			return true;
		}else return false;
		}
		

	public double finalsalary() {
		return this.salary;
	}
	@Override
	public String toString() {
		return String.format("%-10s | %-15s | %-15s", id,name,salary);
	}
}
