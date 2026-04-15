package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
	private int document_id;
	private String title;
	private String author;
	private String category;
	
	@Override
	public String toString() {
		return String.format(" %-5d | %-30s | %-20s | %s", document_id, title, author, category);
	}
}
