package com.company;

import java.util.*;

public class Phonebook {

    private static HashMap<String, ArrayList<String>> numbers = new HashMap<>();

    public static void main(String[] args) {
        add("Богатиков", "89283786923");
        add("Рогачев", "89095553322");
        add("Богатиков", "89032224055");
        get("Богатиков");
    }

    private static void add(String family, String number) {

        ArrayList<String> phonenumbers = new ArrayList<>();
        if (numbers.get(family) == null) {
            phonenumbers.add(number);
            numbers.put(family, phonenumbers);
        } else {
            numbers.get(family).add(number);
        }
    }

    private static void get(String family) {
        if (numbers.containsKey(family)) {
            System.out.println(family + " " + numbers.get(family));
        }
    }


}
