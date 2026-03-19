package Bai2_QLNhanVien;

import java.util.Scanner;

public class FullTimeEmployee extends Employee{
	private double bonus;
	private double penalty;
	
	public double getBonus() {
		return this.bonus;
	}
	public boolean setBonus(double bonus) {
		if(bonus >= 0) {
			this.bonus = bonus;
			return true;
		}
		else {
			System.out.print("Error");
			return false;
		}
	}
	
	public double getpenalty() {
		return this.penalty;
	}
	public boolean setpenalty(double penalty) {
		if(penalty >= 0) {
			this.penalty = penalty;
			return true;
		}
		else {
			System.out.print("Error");
			return false;
		}
	}
	
	public FullTimeEmployee() {}
	
	public FullTimeEmployee(String id, String name, double basicSalary, double bonus, double penalty) {
		super(id, name, basicSalary);
		setBonus(bonus);
		setpenalty(penalty);
	}
	
	@Override 
	public void input(Scanner sc) {
		super.input(sc);
		while(true) {
			try {
				System.out.print("Nhập bonus: ");
				double boNus = sc.nextDouble();
				sc.nextLine();
				if(setBonus(boNus)) break;
				else System.out.println("Bonus >= 0");
			}catch (Exception e) {
				System.out.println("Vui lòng nhập số !");
				sc.nextLine();
			}
		}
		
		while(true) {
			try {
				System.out.print("Nhập penalty: ");
				double penalTy = sc.nextDouble();
				sc.nextLine();
				if(setpenalty(penalTy)) break;
				else System.out.println("Penalty >= 0");
			}catch (Exception e) {
				System.out.println("Vui lòng nhập số !");
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
