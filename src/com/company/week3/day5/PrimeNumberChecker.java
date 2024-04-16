package src.com.company.week3.day5;

public class PrimeNumberChecker {

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 5, 6, 8};
        for (int num : array) {
            System.out.println(num + " is prime: " + isPrime(num));
        }
    }
}
