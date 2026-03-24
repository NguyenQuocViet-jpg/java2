package Bai1_Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class Lambda {
	public static void main(String[] args) {
		List<Student> DanhSach = new ArrayList<Student>();
		
		DanhSach.add( new Student("PS48341", "Nguyễn Quốc Việt", 6)); 
		DanhSach.add( new Student("PS47406", "Trần Đức Quang", 5));
		DanhSach.add( new Student("PS48351", "Nguyễn Tuấn Khang", 2));
		DanhSach.add( new Student("PS48306", "Nguyễn Ngọc Hải", 8));
		DanhSach.add( new Student("PS48390", "Nguyễn Trương Minh Khôi", 4));
		DanhSach.add( new Student("PS43899", "Nguyễn Thanh Bình", 3));
		
		System.out.println("--- Danh Sách Đậu ---");
		for(Student sv: DanhSach) {
			if(sv.getDiem() >= 5) {
				System.out.println(sv + "Đậu");
			}
		}
		
		Predicate<Student> checkdiem = sv -> sv.getDiem() >= 5;
		
		System.out.println("--- Danh Sách Đậu ---");
		for(Student sv: DanhSach) {
			if(checkdiem.test(sv)) {
				System.out.println(sv + "Đậu");
			}
		}
		
		System.out.println("-------------------------------------");
		Consumer<Student> checkandprint = sv -> {
			if(checkdiem.test(sv))
				System.out.println(sv.toString() + "Đậu");
		};
		
		DanhSach.forEach(checkandprint);
		
		System.out.println("-------------------------------------");
		Function<Student, String> getInfo = sv -> sv.getDiem() >= 5 ? sv.toString() +  "Đậu" : sv.toString() + "Rớt";
		
		for(Student s: DanhSach) {
			System.out.println(getInfo.apply(s));
		}
		
		System.out.println("-------------------------------------");
		DanhSach.stream()
			.map(s -> s.getDiem() >= 5 ? s.toString() + " true" : s.toString() + " false")
			.forEach(System.out::println);
		
		
		DanhSach.stream()
			.map(s -> s.getName().toUpperCase())
			.forEach(System.out::println);
		
		DanhSach.forEach(System.out::println);
	}
}







