package Bai3_QLNhanVien;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
	private List<Employee> listEmployees = new ArrayList<Employee>();
	
	public void addEmployee( Employee them) {
		if( them != null && them.getId() != null) {
			listEmployees.add(them);
			System.out.println("Đã thêm nhân viên");
			
		}else {
			System.out.println("Thêm thất bại");
		}
	}
	public void hienthidanhsach() {
		if( listEmployees.isEmpty()) {
			System.out.println("--- Danh sách trống ---");
			return;
		}
		System.out.println("--- Danh sách nhân viên ---");
		System.out.printf("%-10s | %-15s | %-15s\n", "Mã NV"," Tên"," Mức Lương");
		System.out.println("-----------------------------------------");
		for( Employee them: listEmployees) {
			System.out.println(them);
		}
		System.out.println("-----------------------------------------");
	}
	public Employee timMaNV(String id) {
		for( Employee them : listEmployees) {
			if( them.getId().equalsIgnoreCase(id)) {
				return them;
			}
		}return null;
	}
	public boolean capNhatLuong( String id, double newSalary) {
		Employee them = timMaNV(id);
		if( them != null) {
			if( them.setSalary(newSalary)) {
				return true;
			}else {
				System.out.println(" Lương >= 0");
				return false;
			}
		}return false;
	}
}
