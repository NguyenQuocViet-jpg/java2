package Bai1_QLSanPham;

import java.util.Scanner;

public class Product {
	private String id;
	private String name;
	private double basePrice;
	
	
	public String getId() {
		return this.id;
	}
	public boolean setId(String id) {
		if(id != null && !id.trim().isEmpty()) {
			this.id = id;
			return true;
		}
		else 
			return false;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getBasePrice() {
		return this.basePrice;
	}
	public boolean setBasePrice(double basePrice) {
		if(basePrice >= 0) {
			this.basePrice = basePrice;
			return true;
		}else
			return false;			
	}
	
	public Product() {}
	
	public Product(String id, String name, double basePrice) {
		if(setId(id))
			this.id = id;
		else 
			this.id = null;
		this.name = name;
		if(setBasePrice(basePrice))
			this.basePrice = basePrice;
		else 
			this.basePrice = -1;
	}
	
	public void input(Scanner sc) {
		while(true) {
				System.out.print("Nhập id: ");
				String Name = sc.nextLine().trim();
				if(setId(Name)) break;
				else System.out.println("Id không được rỗng");
		}
		
		System.out.print("Nhập tên: ");
		setName(sc.nextLine().trim());
		
		while(true) {
			try {
				System.out.print("Nhập giá: ");
				double price = sc.nextLong();
				sc.nextLine();
				if(setBasePrice(price))break;
				else System.out.println("Giá phải >= 0");
			}catch (Exception e) {
				System.out.println("Vui lòng nhập số!");
				sc.nextLine();
			}
		}

	}
	
	public double finalPrice() {
		return this.basePrice;
	}
	public String toString() {
		return this.id + " | " + this.name + " | " + finalPrice();
	}

}
