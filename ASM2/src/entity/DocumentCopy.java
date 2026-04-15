package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentCopy {
	private int copy_id;
	private String status;
	private int document_id;
	
	@Override 
	public String toString() {
		return String.format(" %-7d | %-20s | %d", copy_id, status, document_id);
	}
}
