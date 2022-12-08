package com.challenges.plusone;

public class PlusOne {

    public static void main (String[] args) {
        // EXPECTS: 88999999999999999999999999999999999999999999999900000000000000000000000000
        System.out.println(addOne("88999999999999999999999999999999999999999999999899999999999999999999999999"));

        // EXPECTS: 100000000000000000000000000000000000000000000000000000000000000000000000000
        System.out.println(addOne("99999999999999999999999999999999999999999999999999999999999999999999999999"));

        // EXPECTS: 124
        System.out.println(addOne("123"));

        // EXPECTS: 3
        System.out.println(addOne("2"));

        // EXPECTS: 4999
        System.out.println(addOne("4998"));
    }

    public static String addOne(String input) {
        // splits the numbers into its own on a String array
        String[] inputs = input.split("");
        int length = inputs.length;

        String result = "";
        StringBuilder converted = new StringBuilder();

        for (int i = length - 1; i >= 0; i--) {
            // this will be the one to be evaluated
            String current = inputs[i];
            if (current.equals("9")) {
                if (i == 0) {
                    // converts it to 10 and add it to the start of the string
                    converted.insert(0, "10");
                    result = converted.toString();
                } else {
                    // converts it to 9 and add it in the start of the converted
                    converted.insert(0, "0");
                }
            } else {
                // adds one to the current number
                int plusOne = Integer.parseInt(current) + 1;
                // adds it to the current processed numbers
                converted.insert(0, plusOne);

                if (i != 0) {
                    int index = input.lastIndexOf(current); // gets the last index of the current number
                    String prefixNumber = input.substring(0, index); // gets all the numbers before the current number
                    result = prefixNumber + converted; // adds all the unprocessed numbers and the converted numbers
                } else {
                    result = converted.toString();
                }
                break;
            }
        }
        return result;
    }
}

