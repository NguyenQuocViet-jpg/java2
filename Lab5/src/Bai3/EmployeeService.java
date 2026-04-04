package Bai3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
	private List<Employee> list = new ArrayList<>();
    private final String FILE_NAME = "employee.dat";

    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            list = (List<Employee>) ois.readObject();
            System.out.println("Đã load dữ liệu từ file!");
        } catch (Exception e) {
            System.out.println("Lỗi đọc file!" + e.getMessage());
        }
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(list);
            System.out.println("Đã lưu dữ liệu vào file!");
        } catch (Exception e) {
            System.out.println("Lỗi ghi file!" +e.getMessage());
        }
    }

    public void add(Employee e) {
        list.add(e);
    }

    public void display() {
        if (list.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        System.out.println("ID        | Name                 | Salary");
        for (Employee e : list) {
            System.out.println(e);
        }
    }

    public boolean remove(String id) {
        if(list.removeIf(e -> e.getId().equalsIgnoreCase(id)))  return true;
        else return false;
    }
    
    public Employee findById(String id) {
        for (Employee e : list) {
            if (e.getId().equalsIgnoreCase(id)) {
                return e;
            }
        }
        return null;
    }
}
