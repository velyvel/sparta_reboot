package src.com.company.week3.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1182_부분수열의합2 {

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

        generateSubsequences(0,0);

        System.out.println(count);

    }

    public static void generateSubsequences(int index, int sum) {
        if (index > 0 && sum == S) {
            count += 1;
        }

        // 즉 실행은 여기부터
        for (int i = index; i < N; i++) {
            // 다음 원소를 포함시킨 새로운 합으로 재귀 호출
            generateSubsequences(i + 1, sum + array[i]);

        }
    }

}
