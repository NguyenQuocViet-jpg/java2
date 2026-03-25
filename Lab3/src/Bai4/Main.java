package Bai4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
	 public static void main(String[] args) {
		List<Student> danhsach = new ArrayList<Student>(
				Arrays.asList(
						new Student("123", "viet", StudentType.INTERNATIONAL, 3.4),
				        new Student("124", "quang", StudentType.INTERNATIONAL, 2.1),
				        new Student("125", "anh", StudentType.PART_TIME, 3.8),
				        new Student("126", "linh", StudentType.PART_TIME, 3.2),
				        new Student("127", "tuan", StudentType.INTERNATIONAL, 2.9),
				        new Student("128", "hoa", StudentType.PART_TIME, 3.6),
				        new Student("129", "khanh", StudentType.INTERNATIONAL, 4.0),
				        new Student("130", "phuong", StudentType.REGULAR, 2.7),
				        new Student("131", "minh", StudentType.INTERNATIONAL, 3.9),
				        new Student("132", "trang", StudentType.REGULAR, 3.5)
						)
				);
		
		System.out.println("Sinh viên International có Gpa >= 3.2");
		System.out.printf(" %-10s | %-25s | %-10s | %s\n", "ID", "Name", "StudentType", "GPA");
		System.out.println("-----------------------------------------------------------------");
		danhsach.stream()
		.filter(s -> s.getType() == StudentType.INTERNATIONAL && s.getGpa() >= 3.2)
		.forEach(System.out::println);	
		System.out.println("-----------------------------------------------------------------");
		
		
		
		System.out.println("\nSắp xếp giảm dần theo GPA lấy top 3");
		System.out.printf(" %-10s | %-25s | %-10s | %s\n", "ID", "Name", "StudentType", "GPA");
		System.out.println("-----------------------------------------------------------------");
		danhsach.stream()
				.sorted(Comparator.comparing(Student::getGpa).reversed())
				.limit(3)
				.forEach(System.out::println);	
		
		System.out.println("-----------------------------------------------------------------");
		
		
		
		
		System.out.println("\nSinh viên Part_Time");
		List<String> sv_pt = danhsach.stream()
									.filter(s -> s.getType() == StudentType.PART_TIME)
									.map(Student::getName)
									.toList();
		System.out.println("-------------------");
		sv_pt.forEach(System.out::println);
			
	}
}
