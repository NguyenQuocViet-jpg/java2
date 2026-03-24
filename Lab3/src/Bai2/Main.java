package Bai2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Employee> nv = new ArrayList<Employee>(
				Arrays.asList(new Employee("48341", "Viet", 15000000),
						new Employee("48351", "Khang", 14000000),
						new Employee("47406", "Quang", 17000000),
						new Employee("48306", "Hai", 12000000),
						new Employee("49306", "Khoy", 20000000),
						new Employee("47809", "Binh", 18000000)
						)
				);
		
		System.out.println("- Nhân viên có lương >= 15000000");
		nv.stream()
			.filter(s -> s.getSalary() >= 15000000)
			.forEach(System.out::println);
		
		System.out.println("- Sắp Xếp theo lương giảm dần");
		nv.stream()
			.sorted(Comparator.comparing(Employee::getSalary).reversed())
			.forEach(System.out::println);
		
		System.out.println("- Lấy danh sách tên nhân viên từ danh sách nhân viên");
		nv.stream()
			.map(s -> s.getName())
			.forEach(System.out::println);
		
		
	}
}
