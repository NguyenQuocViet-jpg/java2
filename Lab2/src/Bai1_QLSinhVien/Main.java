package Bai1_QLSinhVien;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Student> DanhSach = new ArrayList<Student>();
		
		Student sv1 = new Student("PS48341", "Nguyễn Quốc Việt", StudentType.INTERNATIONAL);
		Student sv2 = new Student("PS47406", "Trần Đức Quang", StudentType.PART_TIME);
		Student sv3 = new Student("PS48351", "Nguyễn Tuấn Khang", StudentType.REGULAR);
		Student sv4 = new Student("PS48306", "Nguyễn Ngọc Hải", StudentType.REGULAR);
		Student sv5 = new Student("PS48390", "Nguyễn Trương Minh Khôi", StudentType.PART_TIME);
		Student sv6 = new Student("PS43899", "Nguyễn Thanh Bình", StudentType.INTERNATIONAL);
		
		DanhSach.add(sv1);
		DanhSach.add(sv2);
		DanhSach.add(sv3);
		DanhSach.add(sv4);
		DanhSach.add(sv5);
		DanhSach.add(sv6);
		
		System.out.println("--- Toàn bộ sinh viên ---");
		System.out.printf("%-10s | %-25s | %-15s\n", "id", "Name", "StudentType");
		System.out.println("------------------------------------------------------");
		for(Student moi: DanhSach) {
			System.out.println(moi);
		}
		
		System.out.println("\n");
		
		int international = 0, part_time = 0, regular = 0;
		
		System.out.println("--- Sinh viên International ---");
		System.out.printf("%-10s | %-25s | %-15s\n", "id", "Name", "StudentType");
		System.out.println("------------------------------------------------------");
		for(Student inter: DanhSach) {
			if(inter.getType() == StudentType.INTERNATIONAL) {
				System.out.println(inter);
				international++;
			}
		}
		
		System.out.println("\n");
		
		System.out.println("--- Sinh viên Part_Time ---");
		System.out.printf("%-10s | %-25s | %-15s\n", "id", "Name", "StudentType");
		System.out.println("------------------------------------------------------");
		for(Student part: DanhSach) {
			if(part.getType() == StudentType.PART_TIME) {
				System.out.println(part);
				part_time++;
			}
		}
		
		System.out.println("\n");
		
		System.out.println("--- Sinh viên Regular ---");
		System.out.printf("%-10s | %-25s | %-15s\n", "id", "Name", "StudentType");
		System.out.println("------------------------------------------------------");
		for(Student reg: DanhSach) {
			if(reg.getType() == StudentType.REGULAR) {
				System.out.println(reg);
				regular++;
			}
		}
		
		System.out.println("\n");
		System.out.println("--- Số lượng sinh viên ---");
		System.out.println("International: " + international);
		System.out.println("Part_Time: " + part_time);
		System.out.println("Regular: " + regular);
	}
}
