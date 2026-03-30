package Bai3;

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
}