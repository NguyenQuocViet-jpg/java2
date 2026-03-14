package Bai2_QLNhanVien;

import java.util.Scanner;

public class Employee {
	private String id;
	private String name;
	private double basicSalary;
	
	public String getid() {
		return this.id;
	}
	public void setid(String id) {
		if(id == null || id.isEmpty())
			System.out.println("Id NULL");
		else
			this.id = id;
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
	public void setbasicSalary(double basicSalary) {
		if(basicSalary < 0)
			System.out.println("basicSalary đang âm");
		else
			this.basicSalary = basicSalary;
	}
	
	public Employee() {}
	
	public Employee(String id, String name, double basicSalary) {
		this.id = id;
		this.name = name;
		this.basicSalary = basicSalary;
	}
	
	public void input(Scanner sc) {
		System.out.print("Nhập id: ");
		setid(sc.nextLine().trim());
		System.out.print("Nhập Name: ");
		setName(sc.nextLine().trim());
		
		while(true) {
			try {
				System.out.print("Nhập basicSalary: ");
				setbasicSalary(sc.nextDouble());
				sc.nextLine();
				break;
			}catch (Exception e) {
				System.out.println("VUi lòng nhập số !");
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
