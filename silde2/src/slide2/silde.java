package slide2;

import java.awt.List;
import java.util.ArrayList;

public class silde {
	public static void main(String[] args) {
		enum level {
			Low,
			Medium,
			HIGH
		}
		
		level myVar = level.Medium;
		
		level temp = level.valueOf("HIGH");
		System.out.println("Giá trị của temp: " + temp);
		
		System.out.println("Giá trị của myvar: " + myVar);
		
		
		System.out.println("+ Danh sách level: ");
		for(Object o: level.values()) {
			System.out.println("* " + o);
		}
		
		
		
		
	}
}
