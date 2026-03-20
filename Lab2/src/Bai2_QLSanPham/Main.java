package Bai2_QLSanPham;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		List<Product> DanhSach = new ArrayList<Product>();
		
		Product sp1 = new Product("fod01", "Bánh mỳ", 25000, ProductCasegory.FOOD);
		Product sp2 = new Product("fod02", "Xôi mặn", 20000, ProductCasegory.FOOD);
		Product sp3 = new Product("Elec01", "Laptop", 15000000, ProductCasegory.ELECTRONIC);
		Product sp4 = new Product("Elec02", "Smartphone", 5000000, ProductCasegory.ELECTRONIC);
		Product sp5 = new Product("clo01", "áo dài", 500000, ProductCasegory.CLOTHING);
		Product sp6 = new Product("clo02", "suit", 5000000, ProductCasegory.CLOTHING);
		Product sp7 = new Product("fod03", "caffe", 25000, ProductCasegory.FOOD);
		Product sp8 = new Product("Elec03", "tai nghe", 5000000, ProductCasegory.ELECTRONIC);
		
		DanhSach.add(sp1);
		DanhSach.add(sp2);
		DanhSach.add(sp3);
		DanhSach.add(sp4);
		DanhSach.add(sp5);
		DanhSach.add(sp6);
		DanhSach.add(sp7);
		DanhSach.add(sp8);
		
		System.out.println("\n");
		System.out.println("--- Danh Sách Sản Phẩm ---");
		for(Product moi: DanhSach)
			System.out.print(moi);
		
		Map<ProductCasegory, Double> sumMap = new HashMap<>();
		Map<ProductCasegory, Integer> countMap = new HashMap<>();

		for (Product p: DanhSach) {
		    sumMap.put(
		        p.getCasegory(),
		        sumMap.getOrDefault(p.getCasegory(), 0.0) + p.getPrice()
		    );
		    countMap.put(
			        p.getCasegory(),
			        countMap.getOrDefault(p.getCasegory(), 0) + 1
			    );

		}
		
		
		System.out.println("\n");
		
		System.out.println("--- Số lượng ---");
		for (Map.Entry<ProductCasegory, Integer> e : countMap.entrySet()) {
		    System.out.println(e.getKey() + ": " + e.getValue());
		}
		
		System.out.println("\n");

		System.out.println("--- Tổng giá ---");
		for (Map.Entry<ProductCasegory, Double> e : sumMap.entrySet()) {
		    System.out.println(e.getKey() + ": " + e.getValue());
		}
 	}
}
