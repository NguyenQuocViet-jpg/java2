package main;

import java.util.List;

import entity.Student;
import repository.StudentRepository;

public class Main {
	public static void main(String[] args) {
		StudentRepository stru = new StudentRepository();
		
		List<Student> list = stru.findAll();
		list.stream().forEach(System.out::println);
	}
}