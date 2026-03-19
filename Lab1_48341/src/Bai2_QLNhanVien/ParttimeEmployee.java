package Bai2_QLNhanVien;

import java.util.Scanner;

public class ParttimeEmployee extends Employee{
	private double workingHours;
	 private double hourlyRate;
	 
	 public double getworkingHourse() {
		 return this.workingHours;
	 }
	 public boolean setworkingHourse(double workingHourse) {
		 if(workingHourse >= 0) {
			 this.workingHours = workingHourse;
			 return true;
		 }
		 else {
			 System.out.print("Error");
			 return false;
		 }
			 
	 }
	 
	 public double gethourlyRate() {
		 return this.hourlyRate;
	 }
	 public boolean sethourlyRate(double hourlyRate) {
		 if(hourlyRate < 0) {
			 this.hourlyRate = hourlyRate;
			 return true;
		 }
		 else {
			 System.out.print("Error");
			 return false;
		 }
	 }
	 
	 public ParttimeEmployee() {}
	 
	 public ParttimeEmployee(String id, String name, double basicSalary, double workingHours, double hourlyRate) {
		 super(id, name, basicSalary);
		 setworkingHourse(workingHours);
		 sethourlyRate(hourlyRate);
	 }
	 
	 @Override
	 public void input(Scanner sc) {
		 super.input(sc);
		 while(true) {
				try {
					System.out.print("Nhập workingHourse: ");
					double workinghourse = sc.nextDouble();
					sc.nextLine();
					if(setworkingHourse(workinghourse)) break;
					else System.out.println("WorkingHourse >= 0");
				}catch (Exception e) {
					System.out.println("Vui lòng nhập số !");
					sc.nextLine();
				}
			}
		 
		 while(true) {
				try {
					System.out.print("Nhập hourlyRate: ");
					double hourlyrate = sc.nextDouble();
					sc.nextLine();
					if(sethourlyRate(hourlyrate)) break;
					else System.out.println("HourlyRate >= 0");
				}catch (Exception e) {
					System.out.println("Vui lòng nhập số !");
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
