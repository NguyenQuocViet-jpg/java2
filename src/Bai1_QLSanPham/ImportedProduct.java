package Bai1_QLSanPham;

public class ImportedProduct extends Product{
	private double importTaxRate;
	private double shipPingFee;
	
	public double getimpotTaxRate() {
		return this.importTaxRate;
	}
	public void setimportTaxRate(double importTaxRate) {
		if(importTaxRate < 0 || importTaxRate > 1)
			System.out.println("not importTaxRate");
		else 
			this.importTaxRate = importTaxRate;
	}
	
	public double getshipPingFee() {
		return this.shipPingFee;
	}
	public void setshipPingFee(double shipPingFee) {
		if(shipPingFee < 0)
			System.out.println("ShipPingFee < 0");
		else 
			this.shipPingFee = shipPingFee;
	}
	
	public ImportedProduct() {}
	
	public ImportedProduct(String id, String name, double basePrice, double importTaxRate, double shipPingFee) {
		super(id, name, basePrice);
		this.importTaxRate = importTaxRate;
		this.shipPingFee = shipPingFee;
	}
	
	@Override public double finalPrice() {
		return getBasePrice() + getBasePrice() * this.importTaxRate + this.shipPingFee;
	}
	
	@Override public String toString() {
		return super.toString() + " | " + this.importTaxRate + " | " + this.shipPingFee;
	}
	
}