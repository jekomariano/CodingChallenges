package challenges.romantoint;

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
        String[] romanSymbols = convertValue.split(""); // splits the input
        int size = romanSymbols.length;
        // initialized the roman map values
        HashMap<String, Integer> romanValuesMap = initializeRomanValues();

        int result = 0; // starts the result as 0
        for (int i = 0; i < size; i++) {
            // gets the roman numral by index
            String currRoman = romanSymbols[i];
            int value = 0; // starts the value as 0

            // if the current roman numerals is not the last
            if ((i + 1) < size) {
                // gets the next roman numeral to be evaluated together
                String doubleRoman = currRoman + romanSymbols[i + 1];
                // get the value, if not present it will return as 0
                value = getValue(romanValuesMap, doubleRoman);
            }
            // Gets the value of the current roman numeral
            if (value == 0) {
                value = getValue(romanValuesMap, currRoman);
            } else {
                i++; // adds the index of the next roman numeral
            }
            // adds the value that has been evaluated to the current result
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
