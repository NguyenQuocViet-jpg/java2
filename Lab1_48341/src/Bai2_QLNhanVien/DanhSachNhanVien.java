package Bai2_QLNhanVien;

import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachNhanVien {
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
				nv = new ParttimeEmployee();
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
			System.out.println("-----------------------------------------------------------------------------------------");
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
			System.out.println("------------------------------------------------------------------------------------------------");
			for(Employee moi: danhsach)
				if(moi instanceof ParttimeEmployee)
					System.out.printf("%-5s | %-20s | %-13.2f | %-13.2f | %-20.2f | %-13.2f\n", 
							moi.getid(), 
							moi.getName(), 
							moi.getbasicSalary(), 
							((ParttimeEmployee)moi).getworkingHourse(),
							((ParttimeEmployee)moi).gethourlyRate(),
							moi.incom()
							);
		}else if(xuat.equalsIgnoreCase("all")) {
			System.out.println("--- Nhân viên FullTime ---");
			System.out.printf("%-5s | %-20s | %-13s | %-13s | %-13s | %-13s\n", "ID", "Họ và Tên", "Lương Cơ Bản", "Tiền Thưởng", "Tiền Phạt", "Tổng Lương");
			System.out.println("-----------------------------------------------------------------------------------------");
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
			System.out.println("------------------------------------------------------------------------------------------------");
			for(Employee moi: danhsach)
				if(moi instanceof ParttimeEmployee)
					System.out.printf("%-5s | %-20s | %-13.2f | %-13.2f | %-20.2f | %-13.2f\n", 
							moi.getid(), 
							moi.getName(), 
							moi.getbasicSalary(), 
							((ParttimeEmployee)moi).getworkingHourse(),
							((ParttimeEmployee)moi).gethourlyRate(),
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
			System.out.println("-----------------------------------------------------------------------------------------");
		}else if(max instanceof ParttimeEmployee) {
			System.out.printf("%-5s | %-20s | %-13s | %-13s | %-20s | %-13s\n", "ID", "Họ và Tên", "Lương Cơ Bản", "Giờ Làm", "Mức Lương Theo Giờ", "Tổng Lương");
			System.out.println("------------------------------------------------------------------------------------------------");
		}
		
		System.out.printf("%-5s | %-20s | %-13.2f | %-13.2f | %-13.2f | %-13.2f\n", 
				max.getid(), 
				max.getName(), 
				max.getbasicSalary(), 
				((FullTimeEmployee)max).getBonus(), 
				((FullTimeEmployee)max).getpenalty(),
				max.incom());
	}
}
