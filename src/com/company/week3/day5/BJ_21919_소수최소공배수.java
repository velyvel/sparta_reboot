package src.com.company.week3.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ_21919_소수최소공배수 {
    /**
     * 소수 구하고, 최데공약수 구하고, 최소공배수 구하는 로직으로 풀었다
     * */
    static int[] numbers;
    static Set<Integer> primeNumbers = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        // 값 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int num : numbers) {
            // 소수인지 찾는 메서드 호출
            if (findPrimeNumber(num)) {
                primeNumbers.add(num);
            }
        }

        if (primeNumbers.isEmpty()) {
            System.out.println(-1);
        } else {
            int answer = calculateLCM(primeNumbers);
            System.out.println(answer);
        }
    }

    // 소수 판별 메소드
    public static boolean findPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        // 제곱근만큼
        for (int i = 2; i <= Math.sqrt(number); i++) {
            // 1과 자기가신만이니까..
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 최대공약수(GCD) 계산 메소드
    private static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 최소공배수(LCM) 계산 메소드
    private static int calculateLCM(Set<Integer> primeNumbers) {
        int lcm = primeNumbers.iterator().next(); // 첫 번째 요소를 초기값으로 설정
        for (int num : primeNumbers) {
            int gcd = calculateGCD(lcm, num);
            lcm = lcm * num / gcd;
        }
        return lcm;
    }
}
