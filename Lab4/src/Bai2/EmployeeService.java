package Bai2;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
	List<Employee> Employees = new ArrayList<Employee>();
	public void inputEmployee(Employee nv) {
		for(Employee moi: Employees) {
			if(nv.getId().equals(moi.getId())) {
				throw new DuplicateEmployeeException("Id đã tồn tại: " + nv.getId());
			}
			
		}
		if(nv.getSalary() < 0) {
			throw new InvalidSalaryException("Salary >= 0: " + nv.getSalary());
		}
		
		Employees.add(nv);
	}
	
	public void printEmployee() {
		System.out.printf(" %-10s | %-20s | %-13s\n", "ID", "Name", "Salary");
		System.out.println("---------------------------------------------------");
		for(Employee moi: Employees) {
			moi.inThongTin();
		}
	}
}
