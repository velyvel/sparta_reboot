package src.com.company.week3.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1182_부분수열의합 {

    static int N;
    static int S;
    static int count = 0;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정수의 개수
        N = Integer.parseInt(st.nextToken());
        // 조합해서 나올 수
        S = Integer.parseInt(st.nextToken());
        // 담아둘 array
        array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int  i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        // count 때리는 메소드 호출
        //calculateSum(0, 0);
        calculateSumDFS(0, 0);
        System.out.println(count);
    }

    // count 증가 : 조합과 재귀로 풀었다
    public static void calculateSum(int index, int sum) {

        System.out.println("지금 sum 해서 나온 값? " + sum);

        // 0보다 커야 두개 더하기 시작이니까!
        if (index > 0 && sum == S) {
            count += 1;
        }


        // 즉 실행은 여기부터
        for (int i = index; i < N; i++) {
            // 다음 원소를 포함시킨 새로운 합으로 재귀 호출
            calculateSum(i + 1, sum + array[i]);

        }

    }

    public static void calculateSumDFS(int index, int sum) {
        // 두 수를 합한 결과가 S와 같고, 두 수가 모두 선택된 경우
        if (sum == S && index == N) {
            count += 1;
            return;
        }
        System.out.println("case2 " + sum);


        // 현재 원소를 선택하지 않고 다음 원소로 이동
        if (index < N) {
            calculateSumDFS(index + 1, sum);
            // 현재 원소를 선택하고 다음 원소로 이동
            calculateSumDFS(index + 1, sum + array[index]);
        }
    }


}
