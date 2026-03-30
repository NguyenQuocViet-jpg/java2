package Bai1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int chucnang;
		StudentService Students = new StudentService();
		
		do {
			System.out.println("1. Nhập Thông Tin Sinh Viên.");
			System.out.println("2. Xuất Thông Tin Sinh Viên.");
			System.out.println("0. Thoát Chương Trình.");
			
			while(true) {
				try {
					System.out.print("Chức Năng: ");
					chucnang = sc.nextInt();
					sc.nextLine();
					break;
				}catch (Exception e) {
					System.out.println("Vui lòng nhập số");
					sc.nextLine();
				}
			}
			
			switch(chucnang) {
			case 1: 
				System.out.println("----------------------------");
				Students.inputStudent(sc);
			break;
			case 2: 
				System.out.println("----------------------------");
				Students.printStudent();
			break;
			case 0: 
				System.out.println("Đang thoát chương trình.");
			break;
			default:
				System.out.println("Chương trình chưa có chức năng này.");
			}
			
			if (chucnang != 0) {
			    System.out.print("Bấm phím 1 để quay lại menu: ");
			    int tiep;
			    do {
			        tiep = sc.nextInt();
			        sc.nextLine();

			        if (tiep != 1) {
			            System.out.println("Phím nhập không đúng");
			        }

			    } while (tiep != 1);
			}
			System.out.println("\n".repeat(50));
		}while(chucnang != 0);
		sc.close();
	}
}
