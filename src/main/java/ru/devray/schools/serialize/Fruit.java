package ru.devray.schools.serialize;

import java.io.*;

public class Fruit implements Serializable {

    private static final long serialVersionUID = 3L;

    private String name;
    private int price;
    private int mass = 90;
    String supplier;


    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
