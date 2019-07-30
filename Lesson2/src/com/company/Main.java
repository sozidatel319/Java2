package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String[][] arr = {{"5", "2", "3", "4"},
                {"1", "2", "4", "5"},
                {"1", "2", "4", "4"},
                {"1", "2", "3", "2"}};
        try {
            method(arr);
        } catch (MyArraySizeException a) {
            System.out.println("Поймал MyArraySize");
            a.printStackTrace();
        } catch (MyArrayDataExeption e) {
            System.out.println("Поймал MyArrayDataExeption");
            e.printStackTrace();
        }
    }

    public static void method(String[][] arr) throws MyArrayDataExeption, MyArraySizeException {

        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i].length != 4 || arr.length != 4) throw new MyArraySizeException();
                try {
                    count = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataExeption("ячейка ошибки " + "i " + i + " j " + j);
                }
                sum += count;
            }
        }
        System.out.println("Сумма: " + sum);
    }
}


