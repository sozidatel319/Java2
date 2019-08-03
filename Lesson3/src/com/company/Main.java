package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String [] words = new String[]{"привет","ежик","привет","лес","пресс","кекс",
        "река","мел","соль","ртуть","ежик","сель","ель","мышь","лес","пресс","кекс",
        "роль","тополь","собака"};

       HashMap<String,Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            String s = words[i];
            Integer curentNum = map.get(s);
            if (curentNum == null){
                curentNum = 1;
            }else {
                ++curentNum;
            }
            map.put(s,curentNum);

        }
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1)System.out.println(entry.getKey());
        }
    }
}
