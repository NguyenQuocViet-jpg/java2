package Bai2_QLNhanVien;

import java.util.Scanner;

public class Employee {
	private String id;
	private String name;
	private double basicSalary;
	
	public String getid() {
		return this.id;
	}
	public boolean setid(String id) {
		if(id != null && !id.isEmpty()) {
			this.id = id;
			return true;
		}
		else {
			this.id = "Error";
			return false;
		}
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getbasicSalary() {
		return this.basicSalary;
	}
	public boolean setbasicSalary(double basicSalary) {
		if(basicSalary >= 0) {
			this.basicSalary = basicSalary;
			return true;
		}
		else {
			System.out.print("Error");
			return false;
		}
			
	}
	
	public Employee() {}
	
	public Employee(String id, String name, double basicSalary) {
		setid(id);
		this.name = name;
		setbasicSalary(basicSalary);
	}
	
	public void input(Scanner sc) {
		while(true) {
			try {
				System.out.print("Nhập id: ");
				String Id = sc.nextLine().trim();
				sc.nextLine();
				if(setid(Id)) break;
				else System.out.println("Id không Được rỗng");
			} catch (Exception e) {
				System.out.println("Vui lòng nhập số!");
				sc.nextLine();
			}
		}
		
		System.out.print("Nhập Name: ");
		setName(sc.nextLine().trim());
		
		while(true) {
			try {
				System.out.print("Nhập basicSalary: ");
				double Salary = sc.nextDouble();
				sc.nextLine();
				if(setbasicSalary(Salary)) break;
				else System.out.println("BasicSalary >= 0");
			}catch (Exception e) {
				System.out.println("Vui lòng nhập số !");
				sc.nextLine();
			}
		}
		
	}
	
	public double incom() {
		return this.basicSalary;
	}
	
	public String toString() {
		return this.id + " | " + this.name + " | " + this.basicSalary;
	}

}
