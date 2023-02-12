package challenges.steps2zero;

public class StepsToZero {

    public static void main(String[] args) {
        System.out.println(numberOfStepsToZero(14)); // EXPECTED: 6
        System.out.println(numberOfStepsToZero(8));  // EXPECTED: 4
        System.out.println(numberOfStepsToZero(123));  // EXPECTED: 12
    }

    public static int numberOfStepsToZero(int number) {
        int result = 0; // steps counter
        int currentNumber = number;
        while (currentNumber != 0) { // checks if the current number is not equal to 0
            if (currentNumber % 2 == 0) { // checks if the number is divisible by 2
                currentNumber = currentNumber / 2;
            } else {
                currentNumber--; // subtract 1 to the current number
            }
            result++;
        }
        return result;
    }
}
