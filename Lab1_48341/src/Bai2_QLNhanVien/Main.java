package Bai2_QLNhanVien;

import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DanhSachNhanVien nhanvien = new DanhSachNhanVien();
		int chucnang;
		do {
			System.out.println("+------------------------------------------------------+");
			System.out.println("|                         MENU                         |");
			System.out.println("+------------------------------------------------------+");
			System.out.println("|   Chức Năng 1: Nhập Danh Sách Nhân Viên.             |");
			System.out.println("|   Chức Năng 2: Xuất Danh Sách Nhân Viên.             |");
			System.out.println("|   Chức Năng 3: Xuất Nhân Viên Có Income Cao nhất.    |");
			System.out.println("|   Chức Năng 0: Thoát Chương Trình.                   |");
			System.out.println("+------------------------------------------------------+");
			
			while(true) {
				try {
					System.out.print("Chức Năng: ");
					chucnang = sc.nextInt();
					sc.nextLine();
					break;
				}catch (Exception e) {
					System.out.println("Vui lòng nhập số !");
					sc.nextLine();
				}
			}
			
			switch(chucnang) {
			case 1: 
				System.out.println("--------------------");
				nhanvien.inputNV(sc);
			break;
			case 2:
				
				System.out.println("--------------------");
				nhanvien.print(sc);
			break;
			case 3:
				System.out.println("--------------------");
				nhanvien.timnvcoIncome();
			break;
			case 0:
				System.out.println("--------------------");
				System.out.println("Đang thoát chương trình.");
				System.out.println("Tạm biệt, hẹn gặp lại.");
			break;
			default:
				System.out.println("--------------------");
				System.out.println("Hiện chương trình chưa có chức năng này.");
			}
			
			if(chucnang != 0) {
				System.out.println("--------------------");
				System.out.println("Nhập phím 1 để quay lại menu.");
				int dung;
				do {
					dung = sc.nextInt();
					if(dung != 1)
						System.out.println("Phím nhập không đúng.");
				}while(dung != 1);
			}
			System.out.println("\n". repeat(20));
		}while(chucnang != 0);
	}

}
