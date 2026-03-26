package Bai3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Main {
	public static void main(String[] args) {
		List<Employee> nv = new ArrayList<Employee>(
				Arrays.asList(new Employee("48341", "Viet", 15000),
						new Employee("48351", "Khang", 14000),
						new Employee("47406", "Quang", 17000),
						new Employee("48306", "Alex", 20000),
						new Employee("49306", "anh", 20000),
						new Employee("47809", "An", 18000)
						)
				);
		
		double tong = nv.stream()
						.mapToDouble(s -> s.getSalary())
						.sum();
		System.out.println("tổng lương: " + tong);
		
		
		System.out.println("Lương trung bình: " + (tong / nv.size()));
		
		Employee max = nv.stream()
						.max(Comparator.comparing(Employee::getSalary))
						.orElse(null);
//		System.out.println(max);
		
		List<Employee> luongCaoI = nv.stream()
				.filter(s -> s.getSalary() == max.getSalary())
				.toList();
		
		nv.stream()
		.filter(s -> s.getSalary() == max.getSalary())
		.limit(1)
		.forEach(System.out::println);
		System.out.println("--- Nhân viên có lương cao nhất ---");
		System.out.printf(" %-10s | %-25s | %s\n", "ID", "Name", "Salary");
		System.out.println("--------------------------------------------------");
		luongCaoI.forEach(e -> 
		    System.out.printf("%-10s | %-15s | %-10.2f\n",
		        e.getId(),
		        e.getName(),
		        e.getSalary()
		    )
		);		
	}
}
