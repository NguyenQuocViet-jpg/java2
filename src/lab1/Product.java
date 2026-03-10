package lab1;

public class Product {
	private String id;
	private String name;
	private double basePrice;
	
	public String getId() {
		return this.id;
	}
	public void setId(String Id) {
		if(Id == null || Id.trim().isEmpty()) {
			System.out.println("ID không được rỗng");
		}else {
			this.id = Id;
		}
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String Name) {
		this.name = Name;
	}
	
	
	public void setbasePrice(double Price) {
		if(Price < 0) {
			System.out.println("Giá sản phẩm đang bé hơn 0");
		}else {
			this.basePrice = Price;
		}
	}
	public double getbasePrice() {
		return this.basePrice;
	}
	
	public Product () {
		
	}
	
	public Product(String id, String name, double baseprice) {
		this.id = id;
		this.name = name;
		this.basePrice = baseprice;
	}
	
	@Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Base Price: " + basePrice +
               ", Final Price: " + finalPrice();
    }
	
	public double finalPrice() {
		return this.basePrice;
	}
	
}
