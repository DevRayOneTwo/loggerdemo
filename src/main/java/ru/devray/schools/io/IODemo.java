package ru.devray.schools.io;

import jdk.jshell.spi.ExecutionControlProvider;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IODemo {
    public static void main(String[] args) throws Exception{
        nioDemoMethod();
    }

    //stream threads io-stream
    public static void readFile(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("myhappyfile.txt");
            int i = 0; //1 byte read from file
            while((i = fis.read()) != -1){
                System.out.print((char)i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readFileWithReader(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("myhappyfile.txt");
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

            int i = 0; //1 byte read from file
            while((i = isr.read()) != -1){
                System.out.print((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile() throws Exception {
        FileOutputStream fos = new FileOutputStream("myhappyfile.txt");
        String dataToWrite = "Проверка на запись 123132 fdgsdgsd latin";

        fos.write(dataToWrite.getBytes());
    }

    public static void writeToFileWithWriter() throws Exception{
        FileWriter fr = new FileWriter("myhappyfile1.txt", false);
        String dataToWrite = "Проверка на запись 123132 fdgsdgsd latin";
        fr.write(dataToWrite);
        fr.close();
    }

    public static void nioDemoMethod(){
        String filename = "myhappyfile1.txt";
        String dataToWrite = "Проверка на запись 666666666 fdgsdgsd latin";
        try {
            Files.writeString(Paths.get(filename), dataToWrite, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
