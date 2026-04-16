package Bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập 5 điểm kiểm tra (gõ 'null' hoặc Enter nếu chưa có điểm):");
        for (int i = 0; i < 5; i++) {
            System.out.print("Điểm thứ " + (i + 1) + ": ");
            String input = scanner.nextLine().trim();
            
            if (input.isEmpty() || input.equalsIgnoreCase("null")) {
                scores.add(null);
            } else {
                try {
                    scores.add(Integer.parseInt(input));
                } catch (NumberFormatException e) {
                    System.out.println("Dữ liệu không hợp lệ, tự động gán null.");
                    scores.add(null);
                }
            }
        }

        System.out.println("\nDanh sách điểm: " + scores);

        double sum = 0;
        int count = 0;
        for (Integer score : scores) {
            if (score != null) {
                sum += score;
                count++;
            }
        }

        double average = 0;
        String phanLoai = "Chưa xác định";

        if (count > 0) {
            average = sum / count;
            
            if (average >= 8) {
                phanLoai = "Giỏi";
            } else if (average >= 6.5) {
                phanLoai = "Khá";
            } else {
                phanLoai = "Trung bình";
            }

            String ketQua = """
                ------------------------------------
                BÁO CÁO KẾT QUẢ HỌC TẬP
                ------------------------------------
                Danh sách điểm (bao gồm cả null): %s
                Điểm trung bình hợp lệ: %.2f
                Xếp loại sinh viên: %s
                ------------------------------------
                """.formatted(scores.toString(), average, phanLoai);

            System.out.println(ketQua);
            
        } else {
            System.out.println("Không có điểm hợp lệ nào để tính toán báo cáo.");
        }
        
        scanner.close();
    }
}