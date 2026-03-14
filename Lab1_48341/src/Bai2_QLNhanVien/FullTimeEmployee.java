package Bai2_QLNhanVien;

import java.util.Scanner;

public class FullTimeEmployee extends Employee{
	private double bonus;
	private double penalty;
	
	public double getBonus() {
		return this.bonus;
	}
	public void setBonus(double bonus) {
		if(bonus < 0)
			System.out.println("Bonus < 0");
		else 
			this.bonus = bonus;
	}
	
	public double getpenalty() {
		return this.penalty;
	}
	public void setpenalty(double penalty) {
		if(penalty < 0)
			System.out.println("Penalty < 0");
		else 
			this.penalty = penalty;
	}
	
	public FullTimeEmployee() {}
	
	public FullTimeEmployee(String id, String name, double basicSalary, double bonus, double penalty) {
		super(id, name, basicSalary);
		this.bonus = bonus;
		this.penalty = penalty;
	}
	
	@Override 
	public void input(Scanner sc) {
		super.input(sc);
		while(true) {
			try {
				System.out.print("Nhập bonus: ");
				setBonus(sc.nextDouble());
				sc.nextLine();
				break;
			}catch (Exception e) {
				System.out.println("VUi lòng nhập số !");
				sc.nextLine();
			}
		}
		
		while(true) {
			try {
				System.out.print("Nhập penalty: ");
				setpenalty(sc.nextDouble());
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
		return getbasicSalary() + this.bonus - this.penalty;
	}
	
	@Override
	public String toString() {
		return super.toString() + " | " + this.bonus + " | " + this.penalty + " | " + incom();
	}

}
