package service;

import java.util.ArrayList;

public class DataManager<T> {
    private final ArrayList<T> dataList = new ArrayList<>();

    public void addData(T data) {
        dataList.add(data);
    }

    public void showData() {
        for (T d : dataList) {
            System.out.println(d);
        }
    }
}