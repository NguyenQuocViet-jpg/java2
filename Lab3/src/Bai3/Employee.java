package Bai3;

public class Employee {
	private String id;
	private String name;
	private double salary;
	
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
		this.name= name;
	}
	
	public double getSalary() {
		return this.salary;
	}
	public boolean setSalary(double salary) {
		if(salary >= 0) {
			this.salary = salary;
			return true;
		}else {
			this.salary = -1;
			return false;
		}
	}
	
	public Employee() {}
	
	public Employee(String id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
//	@Override
//	public String toString() {
//		return String.format(" %-10s | %-25s | %.2f\n", this.id, this.name, this.salary);
//	}
}
