package src.com.company.week3.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11722_가장긴감소하는부분수열 {
    /**
     * 메모리 : 14524KB 시간 : 144ms
     * 부분집합(하위 결과 재사용)이 있어서 다이나믹 프로그래밍이라는 힌트를얻을 수 있음
     * {30,20}. {30,20,10} 등의 결과를 계속 재사용함
     * 처음에 맵으로 어떻게 풀어볼까 하다가 결국 배열 두개 사용했다
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        // 원본정렬, 기억할 배열 선언
        int[] numbers = new int[A];
        int[] memorization = new int[A];

        for (int i = 0; i < A; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        // 질문 ? 가장 긴 감소하는 부분수열 찾기 : 반복문이 1부터 시작하는 이유는 부분집합의 개수 최소 1개 이상이라서
        // 1부터 반복문을 돌렸는데 어떤 케이스때문에 안되는 것일까 ?
        for (int i = 0; i < A; i++) {
        //for (int i = 1; i < A; i++) {
            memorization[i] = 1; // 자기 자신을 마지막으로 하는 수열의 길이는 최소 1 위랑 같은 이유이기도 함
            for (int j = 0; j < i; j++) { // 예제로 따지면
                if (numbers[j] > numbers[i]) { // 이전 수가 현재 수보다 크면
                    memorization[i] = Math.max(memorization[i], memorization[j] + 1); // 현재 위치의 부분수열 길이 갱신
                }
            }
        }
        System.out.println("원본 배열" + Arrays.toString(numbers)); // 원본 배열[10, 30, 10, 20, 20, 10]
        System.out.println("저장 배열" + Arrays.toString(memorization)); // 저장 배열[0, 1, 2, 2, 2, 3]

        int count = 0;
        for(int i = 0; i < A; i++) {
            // 부분수열 저장한 배열 중 max 값 구하기
            count = Math.max(count, memorization[i]);
        }
        System.out.println(count);
    }
}
