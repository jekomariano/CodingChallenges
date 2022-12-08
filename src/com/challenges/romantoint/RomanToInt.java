package com.challenges.romantoint;

import java.util.HashMap;

public class RomanToInt {

    public static void main(String[] args) {

        // EXPECTED: 3
        System.out.println(romanToInt("III"));

        // EXPECTED: 4
        System.out.println(romanToInt("IV"));

        // EXPECTED: 29
        System.out.println(romanToInt("XXIX"));
    }

    public static int romanToInt(String convertValue) {
        String[] romanSymbols = convertValue.split("");
        int size = romanSymbols.length;
        HashMap<String, Integer> romanValuesMap = initializeRomanValues();

        // start of evaluation
        int result = 0;
        for (int i = 0; i < size; i++) {
            String currRoman = romanSymbols[i];
            int value = 0;

            if ((i + 1) < size) {
                String doubleRoman = currRoman + romanSymbols[i + 1];
                value = getValue(romanValuesMap, doubleRoman);
            }

            if (value == 0) {
                value = getValue(romanValuesMap, currRoman);
            } else {
                i++;
            }
            result = result + value;

        }
        return result;
    }

    private static HashMap<String, Integer> initializeRomanValues() {
        HashMap<String, Integer> romanValues = new HashMap<String, Integer>();
        romanValues.put("I",1);
        romanValues.put("IV",4);
        romanValues.put("IX",9);
        romanValues.put("V",5);
        romanValues.put("X",10);
        romanValues.put("XL",40);
        romanValues.put("XC",90);
        romanValues.put("L",50);
        romanValues.put("C",100);
        romanValues.put("CD",400);
        romanValues.put("CM",900);
        romanValues.put("D",500);
        romanValues.put("M",1000);

        return romanValues;
    }

    private static Integer getValue(HashMap<String, Integer> romanValuesMap, String key) {
        return romanValuesMap.get(key) == null? 0 : romanValuesMap.get(key);

    }
}
