package Bai1_QLSanPham;

import java.util.ArrayList;
import java.util.Scanner;

public class dsSanPham {
	ArrayList<Product> danhsach = new ArrayList<Product>();
	public void inputsp(Scanner sc) {
		
		System.out.println("Bạn muốn nhập loại sản phẩm nào ?");
		System.out.println("1: Product.");
		System.out.println("2: ImportedProduct.");
		System.out.println("------------------------------");
		
		Product sp;
		int loai;
		while(true) {
			try {
				System.out.print("- ");
				loai = sc.nextInt();
				sc.nextLine();
				break;
			}catch (Exception e) {
				System.out.println("Vui lòng nhập số!");
				sc.nextLine();
			}
		}
		
		boolean diTiep = true;
		do {
			if(loai == 1)
				sp = new Product();
			else
				sp = new ImportedProduct();
			
			sp.input(sc);
			danhsach.add(sp);
			
			while(true) {
				System.out.print("Bạn có muốn nhập nữa hay không (Y/N): ");
				String tiep = sc.nextLine().trim();
				if(tiep.equalsIgnoreCase("n")) {
					diTiep = false;
					break;
				}
				else if(tiep.equalsIgnoreCase("y")) {
					break;
				}else {
					System.out.println("Chỉ nhập Y hoặc N.");
				}
			}
			
		}while(diTiep);
	}
	
	public void giaCaoI() {
		if(danhsach.size() > 0) {
			Product max = danhsach.get(0);
			for(Product moi: danhsach) {
				if(moi.finalPrice() > max.finalPrice()) {
					max = moi;
				}
			}
			System.out.println(max);
		}else {
			System.out.println("Danh sách rỗng.");
		}
	}
	public void printSp() {
		for(Product moi: danhsach) {
			System.out.println(moi);
		}
	}
}
