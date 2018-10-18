package ru.schepin.hiberntate.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;



@ToString
@EqualsAndHashCode

public class Car {
    private int id;
    private String marka;
    private String Model;
    private User user;

    public Car(int id, String marka, String model, User user) {
        this.id = id;
        this.marka = marka;
        Model = model;
        this.user = user;
    }

    public Car(String marka, String model, User user) {
        this.marka = marka;
        Model = model;
        this.user = user;
    }

    public Car() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
