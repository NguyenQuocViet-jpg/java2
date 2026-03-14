package Bai2_QLNhanVien;

import java.util.Scanner;

public class ParttimeEmployee extends Employee{
	private double workingHours;
	 private double hourlyRate;
	 
	 public double getworkingHourse() {
		 return this.workingHours;
	 }
	 public void setworkingHourse(double workingHourse) {
		 if(workingHourse < 0)
			 System.out.println("workingHourse < 0");
		 else 
			 this.workingHours = workingHourse;
	 }
	 
	 public double gethourlyRate() {
		 return this.hourlyRate;
	 }
	 public void sethourlyRate(double hourlyRate) {
		 if(hourlyRate < 0)
			 System.out.println("hourlyRate < 0");
		 else 
			 this.hourlyRate = hourlyRate;
	 }
	 
	 public ParttimeEmployee() {}
	 
	 public ParttimeEmployee(String id, String name, double basicSalary, double workingHours, double hourlyRate) {
		 super(id, name, basicSalary);
		 this.workingHours = workingHours;
		 this.hourlyRate = hourlyRate;
	 }
	 
	 @Override
	 public void input(Scanner sc) {
		 super.input(sc);
		 while(true) {
				try {
					System.out.print("Nhập workingHourse: ");
					setworkingHourse(sc.nextDouble());
					sc.nextLine();
					break;
				}catch (Exception e) {
					System.out.println("VUi lòng nhập số !");
					sc.nextLine();
				}
			}
		 
		 while(true) {
				try {
					System.out.print("Nhập hourlyRate: ");
					sethourlyRate(sc.nextDouble());
					sc.nextLine();
					break;
				}catch (Exception e) {
					System.out.println("VUi lòng nhập số !");
					sc.nextLine();
				}
			}
		 
		 
	 }
	 
	 @Override
	 public double incom() {
		 return this.workingHours * this.hourlyRate;
	 }
	 
	 @Override
	 public String toString() {
		 return super.toString() + " | " + this.workingHours + " | " + this.hourlyRate + " | " + incom();
	 }

}
