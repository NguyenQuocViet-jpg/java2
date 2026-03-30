package Bai2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		EmployeeService Employees = new EmployeeService();
		
		do {
			try {
				Employee nv = new Employee();
				System.out.print("Nhập id: ");
				nv.setId(sc.nextLine().trim());
				System.out.print("Nhập name: ");
				nv.setName(sc.nextLine().trim());
				
				System.out.print("Nhập salary: ");
				nv.setSalary(Double.parseDouble(sc.nextLine()));
				
				Employees.inputEmployee(nv);
				System.out.println("Đã nhập thành công.");
			}catch (InvalidSalaryException e) {
				System.out.println("error: " + e.getMessage());
			}
			catch (Exception e) {
				System.out.println("error: " + e.getMessage());
			}
			
			System.out.print("Bạn có muốn nhập nữa hay không(Y/N): ");
			String tiep = sc.nextLine().trim();
			if(tiep.equalsIgnoreCase("n"))
				break;
		}while(true);
		System.out.println("\n".repeat(10));
		Employees.printEmployee();
		
		sc.close();
	}
}
