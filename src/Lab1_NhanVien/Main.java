package Lab1_NhanVien;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Product> danhsach = new ArrayList<>();
		
		danhsach.add(new Product("ST25", "Gạo 25",150000));
		danhsach.add(new Product("ST13", "Gạo 13", 100000));
		danhsach.add(new ImportedProduct("tai01", "huydai", 150000000, 0.1, 1500000));
		danhsach.add(new ImportedProduct("hoi01", "Toyota", 350000000, 0.5, 1000000));
		
		
		System.out.println("--- Danh sách sản phẩm ---");
		for(Product moi: danhsach)
			System.out.println(moi);
		
		Product max = danhsach.get(0);

		for(Product p : danhsach){
		    if(p.finalPrice() > max.finalPrice()){
		        max = p;
		    }
		}
		
		System.out.println("--- Sản phẩm có giá cuối cùng cao nhất ---");
		System.out.println(max);
	}
}