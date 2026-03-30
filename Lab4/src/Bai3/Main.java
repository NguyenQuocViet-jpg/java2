package Bai3;

public class Main {
	public static void main(String[] args) {
		GenericManager<Student> Students = new GenericManager<Student>();
		
		Students.add(new Student("48341", "Việt", 3));
		Students.add(new Student("48351", "khang", 2.3));
		
		System.out.println("--- Sinh viên ---");
		System.out.printf(" %-10s | %-20s | %s\n", "ID", "Name", "GPA");
		System.out.println("-----------------------------------------");
		Students.display();
		
		
		GenericManager<Employee> Employees = new GenericManager<Employee>();
		
		Employees.add(new Employee("48306", "Hải", 6000));
		Employees.add(new Employee("47406", "Quang", 20000));
		System.out.println("\n".repeat(5));
		System.out.println("--- Nhân viên ---");
		System.out.printf(" %-10s | %-20s | %-13s\n", "ID", "Name", "Salary");
		System.out.println("---------------------------------------------------");
		Employees.display();
	}
}
