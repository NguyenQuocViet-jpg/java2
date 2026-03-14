package Bai1_QLSanPham;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Product> danhsach = new ArrayList<Product>();
		
		Product sp1 = new Product("G01", "Gạo ST25", 150);
		Product sp2 = new Product("G02", "Gạo ST90", 900);
		
		danhsach.add(sp1);
		danhsach.add(sp2);
		danhsach.add(new ImportedProduct("OT01", "Vinfat VF3", 350000, 0.2, 1500));
		danhsach.add(new ImportedProduct("OT02", "Vinfat VF7", 750000, 0.3, 2500));
		
		for(Product moi: danhsach)
			System.out.println(moi);
		
		Product max = danhsach.get(0);
		
		for(Product sp: danhsach) {
			if(max.finalPrice() < sp.finalPrice()) {
				max = sp;
			}
		}
		System.out.println("\n".repeat(2));
		System.out.println("--- Max finalPrice ---");
		System.out.println(max);
		
	}

}
