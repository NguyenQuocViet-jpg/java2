package Asm1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();
        Scanner sc = new Scanner(System.in);

        try {
            service.load();
        } catch (Exception e) {}

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Thêm Tài Liệu");
            System.out.println("2. Thêm Bản Sao");
            System.out.println("3. Xem Danh Sách");
            System.out.println("4. Lưu File");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    do {
                        try {
                            System.out.print("Mã tài liệu: ");
                            String id = sc.nextLine().trim();

                            System.out.print("Tên tài liệu: ");
                            String title = sc.nextLine().trim();

                            System.out.print("Tác giả: ");
                            String author = sc.nextLine().trim().trim();

                            System.out.print("Thể loại: ");
                            String category = sc.nextLine();

                            service.addDoc(new Document(id, title, author, category));
                            System.out.println("Thêm thành công!");
                        } catch (DuplicateIdException e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.print("Nhập tiếp? (Y/N): ");
                        String tiep = sc.nextLine().trim();
                        if(tiep.equalsIgnoreCase("n"))
                        	break;
                    } while (true);
                    break;

                case 2:
                    System.out.print("Nhập mã tài liệu: ");
                    String dId = sc.nextLine().trim();

                    if (service.getDoc(dId) != null) {
                        do {
                            try {
                                System.out.print("Mã bản sao: ");
                                String cId = sc.nextLine().trim();

                                System.out.println("Trạng thái:");
                                System.out.println("1. NEW");
                                System.out.println("2. DAMAGED");
                                System.out.println("3. GOOD");
                                System.out.println("4. LOST");

                                int st = Integer.parseInt(sc.nextLine());

                                DocumentCopyStatus status;
                                switch (st) {
                                    case 1: status = DocumentCopyStatus.NEW; break;
                                    case 2: status = DocumentCopyStatus.DAMAGED; break;
                                    case 3: status = DocumentCopyStatus.GOOD; break;
                                    case 4: status = DocumentCopyStatus.LOST; break;
                                    default:
                                        System.out.println("Trạng thái không hợp lệ!");
                                        continue; 
                                }

                                service.addCopy(dId, new DocumentCopy(cId, status));
                                System.out.println("Thêm bản sao thành công!");
                            } catch (Exception e) {
                                System.out.println("Lỗi!");
                            }

                            System.out.print("Thêm tiếp? (Y/N): ");
                        } while (sc.nextLine().equalsIgnoreCase("Y"));
                    } else {
                        System.out.println("Không tìm thấy tài liệu!");
                    }
                    break;

                case 3:
                    service.viewDocs();
                    break;

                case 4:
                    try {
                        service.save();
                        System.out.println("Đã lưu file!");
                    } catch (Exception e) {
                        System.out.println("Lỗi lưu file!");
                    }
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Chọn sai!");
            }
        }
        
        
    }
}