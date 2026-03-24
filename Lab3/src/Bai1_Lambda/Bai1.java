package Bai1_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;



public class Bai1 {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>(
				Arrays.asList("Viet", "Quang", "Khang", "khoy", "hai")
				);
		System.out.println("--- In hoa ---");
		names.stream()
			.map(s -> s.toUpperCase())
			.forEach(System.out::println);
		
		
		System.out.println("--- 1. Xuất toàn bộ tên ---");
		names.forEach(System.out::println);
		
		System.out.println("--- 2. Xuất tên có đọ dài > 5 ---");
		names.stream()
			.filter(x -> x.length() > 5)
			.forEach(System.out::println);
		
		System.out.println("--- 3. Xếp theo bảng chữ cái ---");
		names.stream()
			.sorted()
			.forEach(System.out::println);
		
		System.out.println("--- 4. xếp ngược chiều bảng chữ cái ---");
		names.stream()
		.sorted(Comparator.reverseOrder())
		.forEach(System.out::println);
	}
}
