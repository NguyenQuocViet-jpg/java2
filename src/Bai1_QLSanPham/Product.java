package Bai1_QLSanPham;

public class Product {
	private String id;
	private String name;
	private double basePrice;
	
	
	public String getid() {
		return this.id;
	}
	public void setid(String id) {
		if(id == null || id.isEmpty())
			System.out.println("ID Không được rỗng.");
		else 
			this.id = id;
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
	public void setBasePrice(double basePrice) {
		if(basePrice < 0)
			System.out.println("BasePrice < 0 ? ");
		else 
			this.basePrice = basePrice;
	}
	
	public Product() {}
	
	public Product(String id, String name, double basePrice) {
		this.id = id;
		this.name = name;
		this.basePrice = basePrice;
	}
	
	public double finalPrice() {
		return this.basePrice;
	}
	public String toString() {
		return this.id + " | " + this.name + " | " + this.basePrice;
	}
}
