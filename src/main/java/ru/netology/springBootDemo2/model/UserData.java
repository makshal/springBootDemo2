package ru.netology.springBootDemo2.model;

import java.util.ArrayList;
import java.util.List;

public class UserData {

    String name;
    String password;
    List<Authorities> data = new ArrayList<>();

    public UserData() {
    }

    public UserData(String name, String password, List<Authorities> data) {
        this.name = name;
        this.password = password;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getData() {
        return data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setData(List<Authorities> data) {
        this.data = data;
    }

}
