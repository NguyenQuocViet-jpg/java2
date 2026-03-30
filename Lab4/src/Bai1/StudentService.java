package Bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {
	List<Student> DanhSachSinhVien = new ArrayList<Student>();
	
	public void inputStudent(Scanner sc) {
		do {
			Student sv = new Student();
			String id;
			while(true) {
				try {
					System.out.print("Nhập id: ");
					id = sc.nextLine().trim();
					sv.setId(id);
					break;
				}catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
			
			String name;
			while(true) {
				try {
					System.out.print("Nhập tên: ");
					name = sc.nextLine().trim();
					sv.setName(name);
					break;
				}catch (IllegalArgumentException e ) {
					System.out.println(e.getMessage());
				}
			}
			
			double gpa;
			while(true) {
				try {
					System.out.print("Nhập GPA: ");
					gpa = sc.nextDouble();
					sc.nextLine();
					sv.setGpa(gpa);
					break;
				}catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}catch (Exception e) {
					System.out.println("Vui lòng nhập số");
					sc.nextLine();
				}
			}
			DanhSachSinhVien.add(sv);
			System.out.println("Bạn có muốn nhập nữa hay không(Y/N)");
			String tiep = sc.nextLine().trim();
			if(tiep.equalsIgnoreCase("n"))
				break;
		}while(true);

	}
	
	public void printStudent() {
		for(Student moi: DanhSachSinhVien) {
			moi.inThongTin();
		}
	}
}
