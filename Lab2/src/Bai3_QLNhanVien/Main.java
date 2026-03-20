package Bai3_QLNhanVien;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
		Scanner sc = new Scanner(System.in);
		int chon;
		do {
            System.out.println("--- MENU QUẢN LÝ ---");
            System.out.println("Chức năng 1: Thêm nhân viên mới");
            System.out.println("Chức năng 2: Hiển thị danh sách");
            System.out.println("Chức năng 3: Tìm nhân viên theo mã");
            System.out.println("Chức năng 4: Cập nhật lương nhân viên");
            System.out.println("Chức năng 0: Thoát chương trình");
            System.out.println("-------------------------------------");
            
            while(true) {
            	try {
            		System.out.print("chức năng: ");
                    chon = sc.nextInt();
                    sc.nextLine();
                    break;
            	}catch (Exception e) {
            		System.out.println("Vui lòng nhập số!");
            		sc.nextLine();
            	}
            }
            
            switch (chon) {
            case 1:
            	System.out.println("-------------------------------------");
                String tiepTuc;
                do {
                    System.out.println("Nhập thông tin nhân viên");
                    Employee nvMoi = new Employee();   
                    
                     while(true) {
                		 System.out.print("Nhập id: ");
                         String id = sc.nextLine().trim();
                         if(nvMoi.setId(id)) break;
                         else System.out.println("ID không được rỗng.");
                     }
//                    nvMoi.setId(id);
                    
                    System.out.print("Nhập tên: "); 
                    String name = sc.nextLine().trim();
                    nvMoi.setName(name);
                    
                    while(true) {
                    	try{
                    		System.out.print("Nhập lương: ");
                            double salary = sc.nextDouble();
                            sc.nextLine();
                            if(nvMoi.setSalary(salary)) break;
                            else System.out.println("Lương >= 0");
                    	}catch (Exception e) {
                    		System.out.println("Vui lòng nhập số!");
                    		sc.nextLine();
                    	}
                    }
                    
                    service.addEmployee(nvMoi);
                    System.out.println("-------------------------------------");
                    System.out.print("Bạn có muốn nhập thêm nhân viên nữa không? (Y/N): ");
                    tiepTuc = sc.nextLine().trim();
                    if(tiepTuc.equalsIgnoreCase("n"))
                    	break;
                    
                } while (true);
                break;
			case 2:
				System.out.println("-------------------------------------");
				service.hienthidanhsach();
				break;
			case 3:
				System.out.println("-------------------------------------");
				service.hienthidanhsach();
				System.out.print("nhập mã nhân viên cần tìm: ");
				String maTim = sc.nextLine().trim();
				Employee ketQua = service.timMaNV(maTim);
				System.out.println("-------------------------------------");
				if( ketQua != null) {
					System.out.printf("%-10s | %-15s | %-15s\n", "Mã NV"," Tên"," Mức Lương");
					System.out.println("-----------------------------------------");
					System.out.println(ketQua);
					
				}else {
					System.out.println("Không thấy mã nhân viên: " + maTim);
				} break;
			case 4:
				System.out.println("-------------------------------------");
				service.hienthidanhsach();
				System.out.println("-------------------------------------");
				System.out.print("Nhập mã nhân viên cần sửa lương: ");
				String maSua = sc.nextLine().trim();
				
				System.out.print("nhập lương mới: ");
				double luongMoi = sc.nextDouble();
				sc.nextLine();
				
				if( service.capNhatLuong(maSua, luongMoi))
					System.out.println("Đã cập nhật lương");
			
				 else {
					System.out.println("Cập nhật thất bại");
			 	} 
			break;
			case 0:
				System.out.println("Thoát chương trình");
				break;
				
			default:
				System.out.println("Lựa chọn không hợp lệ");
            }
            if(chon != 0) {
            	System.out.println("Bấm phím 1 để quay lại menu.");
            	int tiep;
            	do {
            		tiep = sc.nextInt();
            		sc.nextLine();
            		if(tiep != 1) {
            			System.out.println("Phím chọn không đúng.");
            			System.out.println("Bấm phím 1 để quay lại menu.");
            		}
            	}while(tiep != 1);
            }
            System.out.println("\n". repeat(100));
		} while ( chon != 0);
		sc.close();
	
	}

}
