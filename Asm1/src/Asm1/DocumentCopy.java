package Asm1;

public class DocumentCopy {
	private String idCopy;
	private DocumentCopyStatus status;
	public DocumentCopy(String idCopy, DocumentCopyStatus status) {
		super();
		this.idCopy = idCopy;
		this.status = status;
	}
	public DocumentCopy() {
		super();
	}
	public String getIdCopy() {
		return idCopy;
	}
	public void setIdCopy(String idCopy) {
		this.idCopy = idCopy;
	}
	public DocumentCopyStatus getStatus() {
		return status;
	}
	public void setStatus(DocumentCopyStatus status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return String.format(" %-10s | %-20s", getIdCopy(), getStatus());
	}
	
}
