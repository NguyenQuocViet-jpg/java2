package bai2;

import java.util.ArrayList;
import java.util.List;

public record Student(String id, String name, double gpa) {

    public Student {
        if (gpa < 0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA không hợp lệ (Phải từ 0.0 đến 4.0)!");
        }
    }

    public boolean isScholarshipEligible() {
        return gpa >= 3.2;
    }
    
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("SV01", "Nguyễn Văn A", 3.5));
        students.add(new Student("SV02", "Trần Thị B", 2.8));
        students.add(new Student("SV03", "Lê Văn C", 3.9));

        System.out.println("Danh sách sinh viên đủ điều kiện học bổng:");
        for (Student s : students) {
            if (s.isScholarshipEligible()) {
                System.out.println("ID: " + s.id() + ", Name: " + s.name() + ", GPA: " + s.gpa());
            }
        }
    }
}