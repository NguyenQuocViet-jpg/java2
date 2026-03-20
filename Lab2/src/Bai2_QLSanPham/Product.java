package Bai2_QLSanPham;

public class Product {
	private String id;
	private String name;
	private double price;
	private ProductCasegory casegory;
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public ProductCasegory getCasegory() {
		return this.casegory;
	}
	public void setCasegory(ProductCasegory casegory) {
		this.casegory = casegory;
	}
	
	public Product() {}
	
	public Product(String id, String name, double price, ProductCasegory casegory) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.casegory = casegory;
	}
	
	public String toString() {
		return String.format("%-10s | %-15s | %-10s | %.2f\n", this.id, this.name, this.casegory, this.price);
	}
}
