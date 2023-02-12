package challenges.twosum;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {

        int[] result1 = findTwoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result1)); // EXPECTED: [0, 1]

        int[] result2 = findTwoSum(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(result2)); // EXPECTED: [1, 2]

        int[] result3 = findTwoSum(new int[]{3,3}, 6);
        System.out.println(Arrays.toString(result3)); // EXPECTED: [0, 1]

        int[] result4 = findTwoSum(new int[]{15, 11, 7, 2}, 9);
        System.out.println(Arrays.toString(result4)); // EXPECTED: [2, 3]

        int[] result5 = findTwoSum(new int[]{15, 11, 7, 2}, 17);
        System.out.println(Arrays.toString(result5)); // EXPECTED: [0, 3]


        int[] result6 = findTwoSum(new int[]{15, 11, 7, 2, 5, 9}, 16);
        System.out.println(Arrays.toString(result6)); // EXPECTED: [1, 4]

        int[] result7 = findTwoSum(new int[]{2,5,5,11}, 10);
        System.out.println(Arrays.toString(result7)); // EXPECTED: [1, 2]
    }

    private static int[] findTwoSum(int[] nums, int target) {
        int[] result = null;

        for(int i = 0; i < nums.length; i++) {
            int num1 = nums[i]; // gets the first number
            for(int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j]; // gets the second number
                int addedNumbers = num1 + num2; // adds both numbers
                if (addedNumbers == target) { // checks if both are the same
                    result = new int[]{i, j}; // sets the index values
                    break; // breaking out of j loop
                }
            }
            if (result != null) { // if result is not empty
                break; // breaking out of i loop
            }
        }
        return result;
    }
}
