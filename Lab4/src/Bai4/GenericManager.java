package Bai4;

import java.util.ArrayList;
import java.util.List;

class GenericManager<T> {
    private List<T> list = new ArrayList<>();

    public void add(T item) {
        list.add(item);
    }

    public void display() {
        for (T item : list) {
            System.out.println(item);
        }
    }

    public int size() {
        return list.size();
    }
    public T getFirst() throws EmptyListException {
        if (list.isEmpty()) {
            throw new EmptyListException("Danh sách rỗng!");
        }
        return list.get(0);
    }
    public T getLast() throws EmptyListException {
        if (list.isEmpty()) {
            throw new EmptyListException("Danh sách rỗng!");
        }
        return list.get(list.size() - 1);
    }
}
