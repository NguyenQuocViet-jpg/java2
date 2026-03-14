package Bai2_QlNhanVien;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	ArrayList<Employee> danhsach = new ArrayList<Employee>();
	public void inputNV(Scanner sc) {
		Employee nv;
		System.out.print("Bạn Muốn Nhập Loại Nhân Viên Nào (Fulltime | Parttime): ");
		String loai = sc.nextLine().trim();
		if(loai.equalsIgnoreCase("fulltime")) {
			do {
				nv = new FullTimeEmployee();
				nv.input(sc);
				danhsach.add(nv);
				System.out.print("Bạn có muốn nhập nữa hay không (Y/N): ");
				String tiep = sc.nextLine().trim();
				if(tiep.equalsIgnoreCase("n"))
					break;
			}while(true);
		}else if(loai.equalsIgnoreCase("parttime")) {
			
			do {
				nv = new PartTimeEmployee();
				nv.input(sc);
				danhsach.add(nv);
				System.out.print("Bạn có muốn nhập nữa hay không (Y/N): ");
				String tiep = sc.nextLine().trim();
				if(tiep.equalsIgnoreCase("n"))
					break;
			}while(true);
		}else {
			System.out.println("Không tìm thấy loại nhân viên này.");
		}
	}
	
	public void print(Scanner sc) {
		System.out.print("Bạn Muốn Xuất Danh Sách Nào (Fulltime | Parttime | All): ");
		String xuat = sc.nextLine().trim();
		if(xuat.equalsIgnoreCase("fulltime")) {
			System.out.printf("%-5s | %-20s | %-13s | %-13s | %-13s | %-13s\n", "ID", "Họ và Tên", "Lương Cơ Bản", "Tiền Thưởng", "Tiền Phạt", "Tổng Lương");
			System.out.println("--------------------------------------------------------------------------------");
			for(Employee moi: danhsach)
				if(moi instanceof FullTimeEmployee) 
					System.out.printf("%-5s | %-20s | %-13.2f | %-13.2f | %-13.2f | %-13.2f\n", 
							moi.getid(), 
							moi.getName(), 
							moi.getbasicSalary(), 
							((FullTimeEmployee)moi).getBonus(), 
							((FullTimeEmployee)moi).getpenalty(),
							moi.incom());
		}else if(xuat.equalsIgnoreCase("parttime")) {
			System.out.printf("%-5s | %-20s | %-13s | %-13s | %-20s | %-13s\n", "ID", "Họ và Tên", "Lương Cơ Bản", "Giờ Làm", "Mức Lương Theo Giờ", "Tổng Lương");
			System.out.println("--------------------------------------------------------------------------------");
			for(Employee moi: danhsach)
				if(moi instanceof PartTimeEmployee)
					System.out.printf("%-5s | %-20s | %-13.2f | %-13.2f | %-20.2f | %-13.2f\n", 
							moi.getid(), 
							moi.getName(), 
							moi.getbasicSalary(), 
							((PartTimeEmployee)moi).getworkingHourse(),
							((PartTimeEmployee)moi).gethourlyRate(),
							moi.incom()
							);
		}else if(xuat.equalsIgnoreCase("all")) {
			System.out.println("--- Nhân viên FullTime ---");
			System.out.printf("%-5s | %-20s | %-13s | %-13s | %-13s | %-13s\n", "ID", "Họ và Tên", "Lương Cơ Bản", "Tiền Thưởng", "Tiền Phạt", "Tổng Lương");
			System.out.println("--------------------------------------------------------------------------------");
			for(Employee moi: danhsach)
				if(moi instanceof FullTimeEmployee) 
					System.out.printf("%-5s | %-20s | %-13.2f | %-13.2f | %-13.2f | %-13.2f\n", 
							moi.getid(), 
							moi.getName(), 
							moi.getbasicSalary(), 
							((FullTimeEmployee)moi).getBonus(), 
							((FullTimeEmployee)moi).getpenalty(),
							moi.incom());
					
			System.out.println("\n". repeat(5));
			System.out.println("--- Nhân viên PartTime ---");
			System.out.printf("%-5s | %-20s | %-13s | %-13s | %-20s | %-13s\n", "ID", "Họ và Tên", "Lương Cơ Bản", "Giờ Làm", "Mức Lương Theo Giờ", "Tổng Lương");
			System.out.println("--------------------------------------------------------------------------------");
			for(Employee moi: danhsach)
				if(moi instanceof PartTimeEmployee)
					System.out.printf("%-5s | %-20s | %-13.2f | %-13.2f | %-20.2f | %-13.2f\n", 
							moi.getid(), 
							moi.getName(), 
							moi.getbasicSalary(), 
							((PartTimeEmployee)moi).getworkingHourse(),
							((PartTimeEmployee)moi).gethourlyRate(),
							moi.incom()
							);
					
		}else {
			System.out.println("Không tìm thấy loại nhận viên này.");
		}
	}
	
	public void timnvcoIncome() {
		Employee max = danhsach.get(0);
		for(Employee a: danhsach) {
			if(a.incom() > max.incom())
				max = a;
		}
		if(max instanceof FullTimeEmployee) {
			System.out.printf("%-5s | %-20s | %-13s | %-13s | %-13s | %-13s\n", "ID", "Họ và Tên", "Lương Cơ Bản", "Tiền Thưởng", "Tiền Phạt", "Tổng Lương");
			System.out.println("--------------------------------------------------------------------------------");
		}else if(max instanceof PartTimeEmployee) {
			System.out.printf("%-5s | %-20s | %-13s | %-13s | %-20s | %-13s\n", "ID", "Họ và Tên", "Lương Cơ Bản", "Giờ Làm", "Mức Lương Theo Giờ", "Tổng Lương");
			System.out.println("--------------------------------------------------------------------------------");
		}
		
		System.out.printf("%-5s | %-20s | %-13.2f | %-13.2f | %-13.2f | %-13.2f\n", 
				max.getid(), 
				max.getName(), 
				max.getbasicSalary(), 
				((FullTimeEmployee)max).getBonus(), 
				((FullTimeEmployee)max).getpenalty(),
				max.incom());
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Main nhanvien = new Main();
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
			case 0:
				System.out.println("--------------------");
				System.out.println("Đang thoát chương trình.");
				System.out.println("Tạm biệt, hẹn gặp lại.");
			break;
			case 3:
				System.out.println("--------------------");
				nhanvien.timnvcoIncome();
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
