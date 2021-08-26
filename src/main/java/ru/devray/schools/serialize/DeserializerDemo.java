package ru.devray.schools.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class DeserializerDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("fruits.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Fruit[] fruits = (Fruit[]) ois.readObject();
            System.out.println(Arrays.toString(fruits));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
