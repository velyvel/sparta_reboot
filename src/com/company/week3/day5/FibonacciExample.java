package src.com.company.week3.day5;

public class FibonacciExample {

    // 다이나믹 프로그래밍을 사용하여 피보나치 수열을 구하는 함수
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10; // 피보나치 수열의 n번째 항을 구하기 위한 입력값
        int result = fibonacci(n);
        System.out.println("피보나치 수열의 " + n + "번째 항: " + result);
        /**
         * 출력
         * 피보나치 수열의 10번째 항: 55
         * */
    }
}

