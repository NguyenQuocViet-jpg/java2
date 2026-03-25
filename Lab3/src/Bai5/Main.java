package Bai5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


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
		
		Map<StudentType, Long> result = danhsach.stream()
			    .collect(Collectors.groupingBy(
			        Student::getType,
			        Collectors.counting()
			    ));
		
		System.out.println("Số lượng sinh viên theo từng loại:");
		result.forEach((t, u) -> 
			System.out.printf("%s: %d\n", t, u)
				);
		
		System.out.println("\nTính GPA trung bình theo từng loại:");
		Map<StudentType, Double> result1 = danhsach.stream()
				.collect(Collectors.groupingBy(Student::getType,
						Collectors.averagingDouble(Student::getGpa)));
		result1.forEach(((t, u) -> 
			System.out.printf("%s: %.1f\n", t,u)
				));
		
		System.out.println("\nSinh viên có GPA cao nhất");
		Optional<Student> maxGpa = danhsach.stream()
				.max(Comparator.comparing(Student::getGpa));
		
		System.out.printf("%-10s | %-25s | %-10s | %s\n", "ID", "Name", "Type", "GPA");
		System.out.println("----------------------------------------------------------");
		maxGpa.ifPresent(s -> 
		 System.out.printf("%-10s | %-25s | %-10s | %.1f\n",
			        s.getId(), s.getName(), s.getType(), s.getGpa())
				);
		
	}
}
