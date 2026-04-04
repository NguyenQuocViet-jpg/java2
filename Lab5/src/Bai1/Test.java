package Bai1;

import java.io.BufferedReader;
//import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Test {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException{
		List<String> listName = Arrays.asList("Nguyen Van A", "Tran Van B");
		String filePath = "data.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
			for (String name : listName) {
				bw.write(name);
				bw.newLine();
			}
			System.out.println("Đã ghi file" + filePath);
			bw.close();
		}catch (IOException e) {
			System.out.println("Lỗi ghi file: " + e.getMessage());
		}finally {
			System.out.println("=> Kết thúc ghi file ");
		}
		BufferedReader br = null; 
		try {
			br = new BufferedReader(new FileReader(filePath));
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}catch (IOException e) {
			System.out.println("=> Đã đọc file" + filePath);
		}finally {
			br.close();
			System.out.println("Kết thúc đọc file");
		}
		
	}
}
