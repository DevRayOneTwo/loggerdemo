package ru.devray.schools.serialize;

import java.io.*;

public class SerializerDemo {

    public static void main(String[] args) {
        Fruit fruit1 = new Fruit("Apple", 10);
        Fruit fruit2 = new Fruit("Orange", 15);

        Fruit[] fruits = {fruit1, fruit2};

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("fruits.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(fruits);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close file
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
