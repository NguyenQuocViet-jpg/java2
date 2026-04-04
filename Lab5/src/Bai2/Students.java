package Bai2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Students {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<Student>(
        		Arrays.asList(
                		new Student("SV01", "Nguyen Van A", 3.5),
                		new Student("SV02", "Tran Van B", 3.8)
                		)
        		);


        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("students.dat"))) {

            oos.writeObject(list);
            System.out.println("Ghi file thành công");

        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("students.dat"))) {

            ArrayList<Student> data = (ArrayList<Student>) ois.readObject();

            System.out.println("Danh sách đọc từ file:");
            for (Student s : data) {
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy class: " + e.getMessage());
        }
    }
}
