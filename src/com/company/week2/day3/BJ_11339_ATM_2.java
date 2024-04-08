package src.com.company.week2.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11339_ATM_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람의 수(int 범위)
        int N = Integer.parseInt(br.readLine());
        // 누적합(최소시간)을 저장할 변수
        int minTime = 0;
        // 배열
        int[] times = new int[N];

        //큐에 값 담기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            times[i] = (Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(times);

        int prev = 0;
        //순서대로 담았으니 그대로 누적합 구하기
        for(int i = 0; i < N; i++) {
            minTime += prev + times[i];
            prev += times[i];
        }

        System.out.println(minTime);

    }
}
