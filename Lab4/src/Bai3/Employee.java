package Bai3;

public class Employee {
	private String id;
	private String name;
	private double salary;
	
	public Employee() {}
	
	public Employee(String id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		if(id == null || id.isEmpty()) {
			throw new IllegalArgumentException("ID không được rỗng");
		}
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name không được rỗng");
		}
		this.name = name;
	}
	
	public double getSalary() {
		return this.salary;
	}
	public void setSalary(double salary) {
		if(salary < 0) {
			throw new IllegalArgumentException("Salary >= 0");
		}
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return String.format(" %-10s | %-20s | %-13.0f", getId(), getName(), getSalary());
	}
}
