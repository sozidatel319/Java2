package com.company;

public class MyArrayDataExeption extends IllegalArgumentException {

    public MyArrayDataExeption(int i, int j){
       super("Ячейка ошибки " + i + " " + j);
    }
}
