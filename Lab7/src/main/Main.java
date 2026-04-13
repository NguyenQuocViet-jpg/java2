package main;

import java.util.Scanner;

import Entity.Employee;
import Repository.EmployeeRepository;

public class Main {
	public static void main(String[] args) {
//		EmployeeRepository Employees = new EmployeeRepository();
//		System.out.println("read");
//		Employees.findAll().stream().forEach(System.out::println);
//		System.out.println("\n".repeat(5));
//		
//		System.out.println("create");
//		Employee viet = new Employee(48341, "viet", 4000);
//		Employees.addEmployee(viet);
//		Employees.findAll().stream().forEach(System.out::println);
//		System.out.println("\n".repeat(5));
//		
//		System.out.println("update");
//		Employee viet1 = new Employee(48341, "nguyen quoc viet", 5000);
//		Employees.updateEmployee(viet1);
//		Employees.findAll().stream().forEach(System.out::println);
//		System.out.println("\n".repeat(5));
//		
//		System.out.println("delete");
//		Employees.deleteEmployee(viet1);
//		Employees.findAll().stream().forEach(System.out::println);
//		System.out.println("\n".repeat(5));
//		
//		System.out.println("Tìm kiếm nhân viên theo id.");
//		int id = 3;
//		Employee tim = Employees.findByID(id);
//		System.out.println(tim.toString());
		
		try(Scanner sc = new Scanner(System.in)) {
			EmployeeRepository Employees = new EmployeeRepository();
			int choice;
			do {
				System.out.println("--- Quản Lý Nhân Viên ---");
				System.out.println("0. Thoát Chương Trình.");
				System.out.println("1. Truy Xuất Danh Sách Nhân Viên.");
				System.out.println("2. Thêm Nhân Viên Mới.");
				System.out.println("3. Thay Đổi Thông Tin Nhân Viên.");
				System.out.println("4. Xóa Nhân Viên.");
				System.out.println("5. Tìm Nhân Viên theo Mã.");
				
				while(true) {
					try {
						System.out.print("Chọn: ");
						choice = sc.nextInt();
						sc.nextLine();
						break;
					}catch (Exception e) {
						System.out.println("Vui Lòng Nhập Số!");
						sc.nextLine();
					}
				}
				
				switch(choice) {
				case 0: 
					System.out.println("---------------------------------");
					System.out.println("Đang thoát chương trình.");
					System.out.println("Tạm Biệt, hẹn gặp lại.");
				break;
				
				case 1: 
					System.out.println("---------------------------------");
					System.out.println("--- Danh sách nhân viên ---");
					System.out.printf(" %-5s | %-20s | %-13s\n", "ID", "Name", "Salary");
					System.out.println("----------------------------------------");
					Employees.findAll().stream().forEach(System.out::println);
				break;
				
				case 2: 
					System.out.println("---------------------------------");
					System.out.println("--- Thêm nhân viên mới ---");
					Employee moi = new Employee();
					
					while(true) {
						try {
							System.out.print("Nhập id: ");
							moi.setId(sc.nextInt());
							sc.nextLine();
							break;
						}catch (Exception e) {
							System.out.println("Vui Lòng Nhập Số!");
							sc.nextLine();
						}
					}
					
					System.out.print("Nhập Name: ");
					moi.setName(sc.nextLine().trim());
					
					while(true) {
						try {
							System.out.print("Nhập salary: ");
							moi.setSalary(sc.nextDouble());
							sc.nextLine();
							break;
						}catch (Exception e) {
							System.err.println("Vui Lòng Nhập Số!");
							sc.nextLine();
						}
					}
					
					if(Employees.addEmployee(moi)) System.out.println("Thêm nhân viên thành công.");
					else System.out.println("Thêm nhân viên thất bại.");
				break;
				
				case 3:
					System.out.println("---------------------------------");
					System.out.println("--- Tìm nhân viên theo id ---");
					System.out.printf(" %-5s | %-20s | %-13s\n", "ID", "Name", "Salary");
					System.out.println("----------------------------------------");
					Employees.findAll().stream().forEach(System.out::println);
					System.out.println("----------------------------------------");
					System.out.println("--- Thay đổi thông tin nhân viên ---");
					Employee nv = new Employee();
					
					while(true) {
						try {
							System.out.print("id của nhân viên muốn sửa: ");
							nv.setId(sc.nextInt());
							sc.nextLine();
							break;
						}catch (Exception e) {
							System.out.println("Vui Lòng Nhập Số!");
							sc.nextLine();
						}
					}
					
					System.out.print("Nhập Name: ");
					nv.setName(sc.nextLine().trim());
					
					while(true) {
						try {
							System.out.print("Nhập salary: ");
							nv.setSalary(sc.nextDouble());
							sc.nextLine();
							break;
						}catch (Exception e) {
							System.err.println("Vui Lòng Nhập Số!");
							sc.nextLine();
						}
					}
					if(Employees.updateEmployee(nv)) System.out.println("Chỉnh sửa thông tin thành công.");
					else System.out.println("Chỉnh sửa thất bại.");
				break;
				
				case 4: 
					System.out.println("---------------------------------");
					System.out.println("--- Tìm nhân viên theo id ---");
					System.out.printf(" %-5s | %-20s | %-13s\n", "ID", "Name", "Salary");
					System.out.println("----------------------------------------");
					Employees.findAll().stream().forEach(System.out::println);
					System.out.println("----------------------------------------");
					System.out.println("--- Xóa thông tin nhân viên ---");
					int id;
					while(true) {
						try {
							System.out.print("Nhập id nhân viên muốn xóa: ");
							id = sc.nextInt();
							sc.nextLine();
							break;
						}catch (Exception e) {
							System.out.println("Vui Lòng Nhập Số!");
							sc.nextLine();
						}
					}
					if(Employees.deleteEmployee(id)) System.out.println("Đã xóa nhân viên thành công.");
					else System.out.println("Xóa nhân viên thất bại.");
				break;
				
				case 5: 
					System.out.println("---------------------------------");
					System.out.println("--- Tìm nhân viên theo id ---");
					System.out.printf(" %-5s | %-20s | %-13s\n", "ID", "Name", "Salary");
					System.out.println("----------------------------------------");
					Employees.findAll().stream().forEach(System.out::println);
					System.out.println("----------------------------------------");
					int id1;
					while(true) {
						try {
							System.out.print("id nhân viên muốn tìm: ");
							id1 = sc.nextInt();
							sc.nextLine();
							break;
						}catch (Exception e) {
							System.out.println("Vui Lòng Nhập Số!");
							sc.nextLine();
						}
					}
					Employee tim = Employees.findByID(id1);
					if(tim != null) {
						System.out.printf(" %-5s | %-20s | %-13s\n", "ID", "Name", "Salary");
						System.out.println("----------------------------------------");
						System.out.println(tim);
					}
					else System.out.println("Không tìm được nhân viên này.");
				break;
				}
				if(choice != 0) {
					System.out.println("---------------------------------");
					System.out.println("Ấn enter để quay lại menu.");
					sc.nextLine();
				}
				System.out.println("\n".repeat(50));
			}while(choice != 0);
		}
	}
}
