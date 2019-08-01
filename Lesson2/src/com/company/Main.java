package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String[][] arr = {{"5", "2", "3", "4"},
                {"1", "2", "4", "5"},
                {"1", "2", "4", "4"},
                {"1", "2", "3", "4"}};
        try {
            method(arr);
        } catch (MyArraySizeException a) {
            a.printStackTrace();
        } catch (MyArrayDataExeption e) {
            e.printStackTrace();
        }
    }

    public static void method(String[][] arr) throws MyArrayDataExeption, MyArraySizeException {

        int sum = 0;
        int count;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i].length != 4 || arr.length != 4) throw new MyArraySizeException("Поймал MyArraySize");
                try {
                    count = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataExeption(i,j);
                }
                sum += count;
            }
        }
        System.out.println("Сумма: " + sum);
    }
}


