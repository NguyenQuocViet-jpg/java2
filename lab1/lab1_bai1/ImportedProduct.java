package lab1_bai1;

public class ImportedProduct extends Product{
	private double importTaxRate;
	private double shipPingFee;
	
	public double getimportTaxRate() {
		return this.importTaxRate;
	}
	public void setimportTaxRate(double ImportTaxRate) {
		if(ImportTaxRate < 0 || ImportTaxRate > 1)
			System.out.println("Thuế nhập không đúng");
		else
			this.importTaxRate = ImportTaxRate;
	}
	
	public double getshipPingFee() {
		return this.shipPingFee;
	}
	public void setshipPingFee(double ShipPingFee) {
		if(ShipPingFee < 0)
			System.out.println("Phí vận chuyển không đúng");
		else
			this.shipPingFee = ShipPingFee;
	}
	
	public ImportedProduct() {
		
	}
	public ImportedProduct(String id, String name, double baseprice, double Importtaxrate, double Shippingfee) {
		super(id, name, baseprice);
		this.importTaxRate = Importtaxrate;
		this.shipPingFee = Shippingfee;
	}
	
	@Override public double finalPrice() {
		return getbasePrice() + getbasePrice() * this.importTaxRate + this.shipPingFee;
	}
	@Override
    public String toString() {
        return super.toString() +
                ", Import Tax: " + importTaxRate +
                ", Shipping Fee: " + shipPingFee;
    }
}
