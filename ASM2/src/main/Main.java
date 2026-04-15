package main;


import java.util.Scanner;

import Repository.DocumentCopyRepository;
import Repository.DocumentRepository;
import entity.Document;
import entity.DocumentCopy;

public class Main {
	static DocumentRepository documents = new DocumentRepository();
	static DocumentCopyRepository documentCopys = new DocumentCopyRepository();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int choice;
		do {
			System.out.println("0. Thoát Chương Trình.");
			System.out.println("1. DOCUMENT.");
			System.out.println("2. DOCUMENT COPY.");
			System.out.println("----------------------");
			
			while(true) {
				try {
					System.out.print("Chọn: ");
					choice = sc.nextInt();
					sc.nextLine();
					break;
				}catch (Exception e) {
					System.out.println("Vui lòng nhập số");
					sc.nextLine();
				}
			}
			
			switch(choice) {
			case 1:{
				int choiceD;
				do {
					System.out.println("0. Thoát Chương Trình.");
					System.out.println("1. Quay Lại Menu Chính.");
					System.out.println("2. Xem Toàn Bộ Tài Liệu.");
					System.out.println("3. Thêm Tài Liệu Mới.");
					System.out.println("4. Tìm kiếm Tài Liệu Theo ID.");
					System.out.println("5. Xóa Tài Liệu Theo ID.");
					System.out.println("6. Chỉnh Sửa Tài Liệu.");
					System.out.println("7. Tìm Kiếm Tên Tài liệu.");
					System.out.println("8. Tìm kiếm Tên Tác Giả.");
					System.out.println("9. Tìm kiếm Loại tài liệu.");
					System.out.println("10. Sắp Xếp Tài Liệu.");
					System.out.println("-----------------------------");
					
					while(true) {
						try {
							System.out.print("Chọn: ");
							choiceD = sc.nextInt();
							sc.nextLine();
							break;
						}catch (Exception e) {
							System.out.println("Vui lòng nhập số");
							sc.nextLine();
						}
					}
					
					switch(choiceD) {
					case 0:
						System.out.println("-----------------------------");
						System.out.println("Đang thoát chương trình.");
						break;
					case 1: 
						System.out.println("-----------------------------");
						System.out.println("đang quay lại menu chính");
						break;
					case 2:
						System.out.println("-----------------------------");
						System.out.println("--- Toàn bộ tài liệu ---");
						headerDocument();
						showAll();
						break;
					case 3: 
						System.out.println("-----------------------------");
						createDocument();
						break;
					case 4: 
						System.out.println("-----------------------------");
						headerDocument();
						showAll();
						searchId();
						break;
					case 5: 
						System.out.println("-----------------------------");
						headerDocument();
						showAll();
						deleteId();
						break;
					case 6: 
						System.out.println("-----------------------------");
						fixDocument();
						break;
					case 7: 
						System.out.println("-----------------------------");
						headerDocument();
						showAll(); 
						searchTitle();
						break;
					case 8: 
						System.out.println("-----------------------------");
						headerDocument();
						showAll();
						searchAuthor();
						break;
					case 9: 
						System.out.println("-----------------------------");
						headerDocument();
						showAll();
						searchCategory();
						break;
					case 10: 
						System.out.println("-----------------------------");
						sortDocument();
						default: 
							System.out.println("Chương trình chưa có chức năng này.");
					}
					
					if(choiceD != 0) {
						System.out.print("Bấm enter để mở lại menu Document: ");
						sc.nextLine();
						System.out.println("\n".repeat(50));
					}
				}while(choiceD != 0 && choiceD != 1);
				break;
			}
			case 2: {
				int choiceC;
				
				do {
					System.out.println("0. Thoát Chương Trình.");
					System.out.println("1. Quay Lai Menu chính.");
					System.out.println("2. Xem Toàn Bộ Tài Liệu đã copy.");
					System.out.println("3. Chỉnh Sửa Bản Sao.");
					System.out.println("4. Xóa Bản Sao.");
					System.out.println("5. Tìm kiếm Tài liệu Theo Trạng thái.");
					System.out.println("-------------------------------------");
					while(true) {
						try {
							System.out.print("Chọn: ");
							choiceC = sc.nextInt();
							sc.nextLine();
							break;
						}catch (Exception e) {
							System.out.println("Vui lòng nhập số");
							sc.nextLine();
						}
					}
					
					switch(choiceC) {
					case 0:
						System.out.println("-------------------------------------");
						System.out.println("Đang thoát chương trình.");
						break;
					case 1:
						System.out.println("-------------------------------------");
						System.out.println("Đang quay lại menu chính.");
						break;
					case 2: 
						System.out.println("-------------------------------------");
						headerCopy();
						showCopy();
						break;
					case 3: 
						System.out.println("-------------------------------------");
						fixCopy();
						break;
					case 4: 
						System.out.println("-------------------------------------");
						deleteCopy();
						break;
					case 5: 
						System.out.println("-------------------------------------");
						searchStatic();
						break;
						default: 
							System.out.println("Chương trình chưa có chức năng này.");
					}
					if(choiceC != 0 && choiceC != 1) {
						System.out.print("Bấm enter để mở lại menu Document: ");
						sc.nextLine();
						System.out.println("\n".repeat(50));
					}
				}while(choiceC != 0 && choiceC != 1);
				break;
			}
			default: 
				System.err.println("Chương trình chưa có chức năng này.");
			}
			if(choice != 0) {
				System.out.print("Bấm enter để mở lại menu Document: ");
				sc.nextLine();
				System.out.println("\n".repeat(50));
			}
		}while(choice != 0);
		
	}
	
	// DOCUMENT COPY 
	public static void headerCopy() {
		System.out.printf(" %-7s | %-20s | %s\n", "ID Copy", "Status", "ID Document");
		System.out.println("---------------------------------------------");
	}
	
	public static void showCopy() {
		documentCopys.findAllCopy().stream().forEach(System.out::println);
	}
	
	public static void fixCopy() {
		DocumentCopy fix = new DocumentCopy();
		System.out.print("Nhập id copy: ");
		fix.setCopy_id(sc.nextInt());
		sc.nextLine();
		System.out.print("Nhập Staus; ");
		fix.setStatus(sc.nextLine().trim());
		System.out.print("Nhập Id document: ");
		fix.setDocument_id(sc.nextInt());
		sc.nextLine();
		
		if(documentCopys.updateCopy(fix)) System.out.println("Cập nhật tài liệu thành công.");
		else System.out.println("Cập nhật thất bại.");
	}
	
	public static void deleteCopy() {
		System.out.print("Nhập id muốn xóa: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		if(documentCopys.deleteCopy(id)) System.out.println("Xóa bản sao thành công.");
		else System.out.println("Xóa thất bại.");
	}
	
	public static void searchStatic() {
		System.out.print("Nhập Status Document muốn tìm: ");
		String status = sc.nextLine().trim();
		
		documentCopys.showStatus(status).stream().forEach(System.out::println);
	}
	//-------------------------------------------------
	
	// DOCUMENT
	public static void headerDocument() {
		System.out.printf(" %-5s | %-30s | %-20s | %s\n", "ID", "Title", "Author", "Category");
		System.out.println("----------------------------------------------------------------------------");
	}
	
	public static void showAll() {
		documents.findAll().stream().forEach(System.out::println);
	}
	
	public static void createDocument() {
		Document add = new Document();
		
		System.out.print("Nhập Title: ");
		add.setTitle(sc.nextLine().trim());
		System.out.print("Nhập Author: ");
		add.setAuthor(sc.nextLine().trim());
		System.out.print("Nhập Category: ");
		add.setCategory(sc.nextLine().trim());
		
		if(documents.addDocument(add)) System.out.println("Thêm tài liệu mới thành công.");
		else System.out.println("Thêm tài liệu mới thất bại.");
	}
	
	public static void searchId() {
		System.out.print("Nhập id cần tìm: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		Document tim = documents.findByID(id);
		if(tim != null) {
			headerDocument();
			System.out.println(tim);
		}else {
			System.out.println("Không tìm thấy tài liệu.");
		}
	}
	
	public static void deleteId() {
		System.out.print("Nhập id muốn xóa: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		if(documents.deleteDocument(id)) System.out.println("Xóa Tài liệu thành công.");
		else System.out.println("Xóa tài liệu thất bại.");
	}
	
	public static void fixDocument() {
		Document fix = new Document();
		
		System.out.print("Nhập id: ");
		fix.setDocument_id(sc.nextInt());
		sc.nextLine();
		System.out.print("Nhập title: ");
		fix.setTitle(sc.nextLine().trim());
		System.out.print("Nhập author: ");
		fix.setAuthor(sc.nextLine().trim());
		System.out.print("Nhập category: ");
		fix.setCategory(sc.nextLine().trim());
		
		if(documents.updateDocument(fix)) System.out.println("Update tài liệu thành công.");
		else System.out.println("Update tài liệu thất bại.");
	}
	
	public static void searchTitle() {
		System.out.print("Nhập title; ");
		String title = sc.nextLine().trim();
		
		Document tim = documents.findByTitle(title);
		if(tim != null) System.out.println(title);
		else System.out.println("Không tìm thấy tên tài liệu này.");
	}
	
	public static void searchAuthor() {
		System.out.print("Nhập title; ");
		String author = sc.nextLine().trim();
		
		Document tim = documents.findByAuthor(author);
		if(tim != null) System.out.println(author);
		else System.out.println("Không tìm thấy tên tác giả này.");
	}
	
	public static void searchCategory() {
		System.out.print("Nhập title; ");
		String category = sc.nextLine().trim();
		
		Document tim = documents.findByCategory(category);
		if(tim != null) System.out.println(category);
		else System.out.println("Không tìm thấy loại tài liệu này.");
	}
	
	public static void sortDocument() {
		System.out.println("1. Sắp Xếp theo Title.");
		System.out.println("2. Sắp Xếp theo Author.");
		System.out.println("3. Sắp Xếp theo Category.");
		System.out.print("Chọn: ");
		int chon = sc.nextInt();
		sc.nextLine();
		
		documents.sort(chon).stream().forEach(System.out::println);
	}
}
