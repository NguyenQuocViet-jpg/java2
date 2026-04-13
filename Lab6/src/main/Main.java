package main; 

import entity.Student;
import entity.Tree;
import repository.StudentRepository;
import repository.TreeRepository;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static StudentRepository studentRepo = new StudentRepository();
    private static TreeRepository treeRepo = new TreeRepository();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n========= QUẢN LÝ HỆ THỐNG =========");
            System.out.println("1. Hiển thị tất cả sinh viên");
            System.out.println("2. Tìm kiếm sinh viên theo ID");
            System.out.println("3. Thêm sinh viên mới");
            System.out.println("4. Quản lý cây (Tree - Hiển thị & Tìm)");
            System.out.println("0. Thoát");
            System.out.print("Mời bạn chọn: ");
            
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    showAllStudents();
                    break;
                case 2:
                    findStudent();
                    break;
                case 3:
                    addStudent();
                    break;
                case 4:
                    manageTrees();
                    break;
                case 0:
                    System.out.println("Đang thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            if(choice != 0) {
            	System.out.print("Bấm phím 1 để quay lại menu: ");
            	int tiep;
            	do {
            		tiep = sc.nextInt();
            		sc.nextLine();
            		if(choice != 1) System.out.println("Phím nhập không đúng.");
            	}while(tiep != 1);
            }
        } while (choice != 0);
    }

    private static void showAllStudents() {
        System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
        studentRepo.findAll().forEach(System.out::println);
    }

    private static void findStudent() {
        System.out.print("Nhập ID sinh viên cần tìm: ");
        int id = sc.nextInt();
        Student stu = studentRepo.findById(id);
        if (stu != null) {
            System.out.println("Kết quả: " + stu);
        } else {
            System.out.println("=> Không tìm thấy sinh viên!");
        }
    }

    private static void addStudent() {
        System.out.println("\n--- THÊM SINH VIÊN MỚI ---");
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập giới tính: ");
        String gender = sc.nextLine();
        System.out.print("Nhập GPA: ");
        double gpa = sc.nextDouble();

        Student newStu = new Student(0, name, gender, gpa);
        studentRepo.save(newStu);
    }

    private static void manageTrees() {
        System.out.println("\n--- DANH SÁCH CÂY (TREE) ---");
        treeRepo.findAll().forEach(System.out::println);
        System.out.print("\nNhập ID cây cần tìm: ");
        int id = sc.nextInt();
        Tree tre = treeRepo.findById(id);
        if (tre != null) {
            System.out.println("Kết quả: " + tre);
        } else {
            System.out.println("=> Không tìm thấy cây!");
        }
    }
}