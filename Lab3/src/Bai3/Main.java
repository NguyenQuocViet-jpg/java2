package Bai3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import Bai2.Employee;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Employee> nv = new ArrayList<Employee>(
				Arrays.asList(new Employee("48341", "Viet", 15000),
						new Employee("48351", "Khang", 14000),
						new Employee("47406", "Quang", 17000),
						new Employee("48306", "Alex", 12000),
						new Employee("49306", "anh", 20000),
						new Employee("47809", "An", 18000)
						)
				);
		
		double tong = nv.stream()
						.mapToDouble(s -> s.getSalary())
						.sum();
		
		int soluong = nv.size();
		
		Employee max = nv.stream()
						.max(Comparator.comparing(Employee::getSalary))
						.orElse(null);
		
		
		int luachon;
		do {
			System.out.println("1. Tính tổng lương toàn bộ nhân viên.");
			System.out.println("2. Lương trung bình của toàn bộ nhân viên.");
			System.out.println("3. nhân viên có lương cao nhất.");
			System.out.println("------------------------------------------");
			
			while(true) {
				try {
					System.out.print("chức năng: ");
					luachon = sc.nextInt();
					sc.nextLine();
					break;
				}catch (Exception e ) {
					System.out.println("Vui lòng nhập số!");
					sc.nextLine();
				}
			}
			
			switch(luachon) {
			case 1: 
				System.out.println("\n".repeat(10));
				System.out.println("tổng lương: " + tong);
			break; 
			case 2: 
				System.out.println("\n".repeat(10));
				System.out.println("Lương trung bình: " + (tong / soluong));
			break;
			case 3: 
				System.out.println("\n".repeat(10));
				System.out.println("--- Nhân viên có lương cao nhất ---");
				System.out.printf(" %-10s | %-25s | %s\n", "ID", "Name", "Salary");
				System.out.println("--------------------------------------------------");
				System.out.println(max);
			break; 
			case 0:
				System.out.println("\n".repeat(10));
				System.out.println("Đang thoát chương trình.");
			}
			if(luachon != 0) {
				System.out.println("------------------------------------");
				System.out.print("Bấm phím 1 để quay lại menu: ");
				int chon;
				do {
					chon = sc.nextInt();
					sc.nextLine();
					if(chon != 1) {
						System.out.println("phím chọnn không đúng.");
					}
				}while(chon != 1);
			}
			System.out.println("\n".repeat(50));
		}while(luachon != 0);
		
		sc.close();
	}
}
