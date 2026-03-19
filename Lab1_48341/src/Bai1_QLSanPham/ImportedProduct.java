package Bai1_QLSanPham;

import java.util.Scanner;

public class ImportedProduct extends Product{
	private double importTaxRate;
	private double shippingFee;
	
	public double getimportTaxRate() {
		return this.importTaxRate;
	}
	public boolean setimportTaxRate(double importTaxRate) {
		if(importTaxRate >= 0 && importTaxRate <= 1) {
			this.importTaxRate = importTaxRate;
			return true;
		}
		else 
			return false;
	}
	
	public double getshippingFee() {
		return this.shippingFee;
	}
	public boolean setshipPingFee(double shipPingFee) {
		if(shipPingFee >=  0) {
			this.shippingFee = shipPingFee;
			return true;
		}
		else 
			return false;
	}
	
	public ImportedProduct() {}
	
	public ImportedProduct(String id, String name, double basePrice, double importTaxRate, double shippingFee) {
		super(id, name, basePrice);
		if(setimportTaxRate(importTaxRate))
			this.importTaxRate = importTaxRate;
		else 
			this.importTaxRate = -1;
		
		if(setshipPingFee(shippingFee))
			this.shippingFee = shippingFee;
		else 
			this.shippingFee = -1;
	}
	@Override public void input(Scanner sc) {
		super.input(sc);
		
		while(true) {
			try {
				System.out.print("Nhập thuế: ");
				double tax = sc.nextDouble();
				sc.nextLine();
				if(setimportTaxRate(tax)) break;
				else System.out.println("Thuế Nhập không đúng.");
			}catch (Exception e) {
				System.out.println("Vui lòng nhập số!");
				sc.nextLine();
			}
		}
		
		while(true) {
			try {
				System.out.print("Phí vận chuyển: ");
				double ship = sc.nextDouble();
				sc.nextLine();
				if(setshipPingFee(ship)) break;
				else System.out.println("Tiền ship >= 0");
			}catch (Exception e) {
				System.out.println("Vui lòng nhập số!");
				sc.nextLine();
			}
		}
	}
	
	@Override public double finalPrice() {
		return getBasePrice() + getBasePrice() * this.importTaxRate + this.shippingFee;
	}
	
	@Override public String toString() {
		return super.toString() + " | " + this.importTaxRate + " | " + this.shippingFee + " | " + finalPrice();
	}

}
