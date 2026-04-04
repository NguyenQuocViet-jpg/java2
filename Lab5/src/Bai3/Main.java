package Bai3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        EmployeeService Employees = new EmployeeService();
        Scanner sc = new Scanner(System.in);

        Employees.loadFromFile();

        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. Tìm theo ID");
            System.out.println("0. Thoát");
            
            while(true) {
            	try {
                    System.out.print("Chọn: ");
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
            	}catch (Exception e) {
            		System.out.println("Vui lòng nhập số");
            		sc.nextLine();
            	}
            }

            switch (choice) {
                case 1:
                	System.out.println("--------------------------------------");
                	do {
                		Employee nhanVien = new Employee();
                    	String id;
                        while(true) {
                        	try {
                        		System.out.print("Nhập ID: ");
                                id = sc.nextLine().trim();
                                nhanVien.setId(id);
                                break;
                        	}catch (Exception e) {
                        		System.out.println("Error: " + e.getMessage());
                        	}
                        }
                        
                        String name;
                        while(true) {
                        	try {
                        		System.out.print("Nhập tên: ");
                                name = sc.nextLine().trim();
                                nhanVien.setName(name);
                                break;
                        	}catch (IllegalArgumentException e) {
                        		System.out.println("Error: " + e.getMessage());
                        	}catch (Exception e) {
                        		System.out.println("Vui lòng nhập số!");
                        	}
                        }
                        
                        double salary;
                        while(true) {
                        	try {
                        		System.out.print("Nhập lương: ");
                                salary = sc.nextDouble();
                                sc.nextLine();
                                nhanVien.setSalary(salary);
                                break;
                        	}catch (Exception e) {
                        		System.out.println("Error: " + e.getMessage());
                        	}
                        }

                        if(Employees.findById(id) != null) {
                        	System.out.println("ID đã tồn tại");
                        }else {
                        	Employees.add(nhanVien);
                        	System.out.println("Đã thêm thành công");
                        }
                        
                        System.out.print("Bạn có muốn nhập nữa hay không(Y/N): ");
                        String tiep = sc.nextLine().trim();
                        if(tiep.equalsIgnoreCase("n"))
                        	break;
                	}while(true);
                break;
                
                case 2:
                	System.out.println("--------------------------------------");
                	Employees.display();
                break;

                case 3:
                    System.out.print("Nhập ID cần xóa: ");
                    String idRemove = sc.nextLine().trim();
                    
                    if(Employees.remove(idRemove)) {
                    	System.out.println("Đã xóa Thành công.");
                    }else {
                    	System.out.println("Xóa thất bại");
                    }
                    break;

                case 4:
                    System.out.print("Nhập ID cần tìm: ");
                    String idFind = sc.nextLine().trim();
                    Employee found = Employees.findById(idFind);

                    if (found != null) {
                        System.out.println("Tìm thấy: " + found);
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 0:
                	Employees.saveToFile();
                    System.out.println("Đã lưu và thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            System.out.print("Ấn enter để quay lại menu: ");
            sc.nextLine();
        } while (choice != 0);
        
        sc.close();
    }
}
