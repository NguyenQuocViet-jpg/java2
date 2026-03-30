package Bai4;

public class Main {
	 public static void main(String[] args) {

	        GenericManager<Student> students = new GenericManager<>();

	        try {
	            System.out.println("Phần tử đầu: " + students.getFirst());
	        } catch (EmptyListException e) {
	            System.out.println("Lỗi: " + e.getMessage());
	        }

	        students.add(new Student("48341", "việt", 3.4));
	        students.add(new Student("43851", "khang", 2));

	        System.out.println("\nDanh sách:");
	        students.display();

	        try {
	            System.out.println("\nPhần tử đầu: " + students.getFirst());
	            System.out.println("Phần tử cuối: " + students.getLast());
	        } catch (EmptyListException e) {
	            System.out.println("Lỗi: " + e.getMessage());
	        }
	    }
}
