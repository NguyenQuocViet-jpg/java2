package Asm1;

import java.io.*;
import java.util.*;

public class LibraryService {
    private Map<String, Document> documents = new HashMap<>();
    private final String PATH = "data.dat";

    public void addDoc(Document d) throws DuplicateIdException {
        if (documents.containsKey(d.getId())) throw new DuplicateIdException("Trùng mã tài liệu!");
        documents.put(d.getId(), d);
    }

    public void updateDoc(String id, String newTitle) {
        if (documents.containsKey(id)) documents.get(id).setTitle(newTitle);
    }

    public void deleteDoc(String id) { documents.remove(id); }

    public void viewDocs() { documents.values().forEach(System.out::println); }

  
    public void addCopy(String docId, DocumentCopy c) throws DuplicateIdException {
        Document d = documents.get(docId);
        if (d != null) {
        	for (DocumentCopy existing : d.getCopies()) {
        	    if (existing.getIdCopy().equals(c.getIdCopy())) {
        	        throw new DuplicateIdException("Trùng mã bản sao!");
        	    }
        	}
            d.getCopies().add(c);
        }
    }

    public void updateCopyStatus(String docId, String copyId, DocumentCopyStatus newStatus) {
        Document d = documents.get(docId);
        if (d != null) {
            d.getCopies().stream()
                .filter(c -> c.getIdCopy().equals(copyId))
                .findFirst()
                .ifPresent(c -> c.setStatus(newStatus));
        }
    }

    public void deleteCopy(String docId, String copyId) {
        Document d = documents.get(docId);
        if (d != null) d.getCopies().removeIf(c -> c.getIdCopy().equals(copyId));
    }

    public void save() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH))) {
            oos.writeObject(documents);
        }
    }

    public void load() throws Exception {
        File f = new File(PATH);
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH))) {
                documents = (Map<String, Document>) ois.readObject();
            }
        }
    }
    
    public Document getDoc(String id) { return documents.get(id); }
}
