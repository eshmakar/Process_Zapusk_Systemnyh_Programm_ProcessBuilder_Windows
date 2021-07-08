package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
//      new ProcessBuilder("calc").start(); - для запуска  каких-то программ хватит и эта строка
        String[] command = "ping google.com -t".split(" ");//здесь команды делим на массивы
        ProcessBuilder processBuilder = new ProcessBuilder(command);

        try {
            Process process = processBuilder.start(); //запуск команды (программы)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "IBM866"));//читаем из данные из cmd
            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);//выводим на консоль в java

            int exitCode = process.waitFor();//если что-то пойдет не так
            System.out.println("Error " + exitCode);//выводим ошибку
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
