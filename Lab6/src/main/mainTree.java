package main;

import java.util.List;
import java.util.Scanner;

import entity.Student;
import entity.Tree;
import repository.StudentRepository;
import repository.TreeRepository;

public class mainTree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentRepository stur = new StudentRepository();
		TreeRepository treeR = new TreeRepository();
		
		int choice; 
		do {
			System.out.println("1. Xem Danh Sách Sinh Viên.");
			System.out.println("2. Tìm kiếm Sinh Viên Theo ID.");
			System.out.println("3. Thêm Sinh Viên mới.");
			System.out.println("4. Cấu Trúc Phân Cấp.");
			System.out.println("5. Tìm Tree Theo Id.");
			
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
				System.out.println("Đang thoát chương trình.");
			break;
			case 1: 
				System.out.println("=== DANH SÁCH SINH VIÊN ===");
				List<Student> listStu = stur.findAll();
				listStu.forEach(System.out::println);
			break;
			
			case 2: 
				System.out.print("\nNhập ID sinh viên cần tìm: ");
				int searchStuId = sc.nextInt();
				sc.nextLine();
				Student stu = stur.findById(searchStuId);
				if(stu != null) {
					System.out.println("Kết quả: " + stu.toString());
				} else {
					System.out.println("Không tìm thấy sinh viên có ID: " + searchStuId);
				}
			break;
			
			case 3: 
				System.out.println("\nThêm sinh viên mới...");
				Student them = new Student();
				System.out.print("Nhập tên: ");
				them.setStudent_name(sc.nextLine());
				System.out.print("Nhập gender: ");
				them.setGender(sc.nextLine());
				System.out.print("Nhập GPA: ");
				them.setGpa(sc.nextDouble());
				sc.nextLine();
				stur.save(them);
				stur.showAll();
			break;
			
			case 4: 
			    System.out.println("\n" + "-".repeat(30));
			    System.out.println("=== CẤU TRÚC PHÂN CẤP CÂY ===");
			    
			    List<Tree> listTree = treeR.findAll();

			    if (listTree.isEmpty()) {
			        System.out.println("Danh sách cây trống!");
			    } else {
			        for (Tree t : listTree) {
			            String prefix = "";
			            if (t.getLevel() > 1) {
			                for (int i = 1; i < t.getLevel(); i++) {
			                    prefix += "   "; 
			                }
			                prefix += "|_ ";
			            }
			            
			            System.out.println(prefix + "[" + t.getNodeId() + "] " + t.getNodeName() 
			                + " (Level: " + t.getLevel() + ", Parent: " + t.getParentId() + ")");
			        }
			    }
		    break;
		    
			case 5: 
			    System.out.print("\nNhập ID Tree cần tìm: ");
			    if (sc.hasNextInt()) {
			        int searchTreeId = sc.nextInt();
			        sc.nextLine(); 

			        Tree tre = treeR.findById(searchTreeId);
			        if (tre != null) {
			            System.out.println("Kết quả tìm thấy: " + tre.toString());
			        } else {
			            System.out.println("=> Không tìm thấy Node cây có ID: " + searchTreeId);
			        }
			    } else {
			        System.out.println("ID phải là một số nguyên!");
			        sc.nextLine(); 
			    }
		    break;
			}
			if(choice != 0) {
				System.out.println("Bấm enter để quay lại menu.");
				sc.nextLine();
				System.out.println("\n".repeat(50));
			}
			
		}while(choice != 0);
	
		sc.close();
	}
}
