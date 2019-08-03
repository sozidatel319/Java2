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
            phonenumbers.add(number);

            for (HashMap.Entry<String, ArrayList<String>> ent : numbers.entrySet()) {
                if (ent.getKey().equals(family)) ent.getValue().add(number);
            }
        }
    }

    private static void get(String family) {
        for (HashMap.Entry<String, ArrayList<String>> entry : numbers.entrySet()) {
            if (entry.getKey().equals(family)) System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }


}
