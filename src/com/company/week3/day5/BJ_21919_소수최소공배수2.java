package src.com.company.week3.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_21919_소수최소공배수2 {
    /**
     * 메모리 15320KB, 시간 216ms
     * 자료구조 set을 사용하여 각 입력값에 대해 소수를 판별하고 중복 없이 저장할 수 있도록 하였다.
     * 그 후 반환된 소수들을 모두 곱해 최소공배수 구했다..
     * 추가로 하고싶은 것 : 소수/소수아님을 판별하는 로직에서 -1를 사용했는데, 이를 모두가 이해할 수 있도록 고치고싶다
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        Set<Integer> primeSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            // 소수 판별하는 메소드 호출
            int primeNumber = isPrimeNumber(numbers[i]);
            // 메소드 안에서 소수가 아닌 것들은 -1로 짰다.. 이부분 모두들 알아볼 수 있게 개선하고 싶지만 뇌용량 초과
            if (primeNumber != -1) {
                primeSet.add(primeNumber);
            }
        }
        // 정답 범위가 2^63이라 롱으로 줌
        long answer = calculateLCM(primeSet);

        System.out.println(answer);
    }

    private static int isPrimeNumber(int number) {
        if (number <= 1) {
            return -1; // 1은 소수 아님
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return -1; // 소수가 아닐 경우 -1 처리(1과 자기자신으로 나눠지지 않음)
            }
        }
        return number; // 소수일 경우 자기 자신을 반환
    }

    private static long calculateLCM(Set<Integer> primeSet) {
        if (primeSet.isEmpty()) {
            return -1; // 소수가 없는 경우 -1 반환
        }
        // 소수 구한걸 모두 다 곱하면 최소공배수가 된다
        long lcm = 1;
        for (int prime : primeSet) {
            lcm *= prime;
        }
        return lcm;
    }

}


