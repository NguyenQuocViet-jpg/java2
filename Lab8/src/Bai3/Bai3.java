package Bai3;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Developer {
    String name();
    String version();
}

class Employee {
    @Deprecated
    public double getSalary() {
        return 5000;
    }
    
    public double calculateSalary() {
        return 5000;
    }
}

class Manager extends Employee {
    @Override
    public double calculateSalary() {
        return 10000;
    }
}

@Developer(name = "YourName", version = "1.0.0")
class BusinessService {
    public void execute() {
        System.out.println("Đang xử lý nghiệp vụ...");
    }
}

public class Bai3 {
    public static void main(String[] args) {
        Class<?> clazz = BusinessService.class;
        
        if (clazz.isAnnotationPresent(Developer.class)) {
            Developer devInfo = clazz.getAnnotation(Developer.class);
            System.out.println("Developer Name: " + devInfo.name());
            System.out.println("Version: " + devInfo.version());
        }
    }
}