package src.com.company.week2.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BJ_11339_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람의 수(int 범위)
        int N = Integer.parseInt(br.readLine());
        // 누적합(최소시간)을 저장할 변수
        int minTime = 0;
        // 사람 - 시간 짝지어서 생각 안해도 괜찮다고 생각헤서 + 자동정렬에 속도도 빠른 우선순위 큐 선언
        PriorityQueue<Integer> times = new PriorityQueue<>();

        //큐에 값 담기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            times.offer(Integer.parseInt(st.nextToken()));
        }
        System.out.println(times);
        // 근데 제출은 맞음..?
        // 출력 : 1,2,4,3,3 -> 같은게 있으면 왜 ? 뒤로 정렬되는지..궁금합니다 -> 질문

        int prev = 0;
        //순서대로 담았으니 그대로 누적합 구하기
        System.out.println("큐2? " + times);
        while (!times.isEmpty()) {
            int current = times.poll();
            minTime += prev + current; // 이전 값과 현재 값을 더하여 누적합 계산
            prev += current; // 현재 값을 이전 값으로 저장

            System.out.println("최소시간 변화는 ? " + minTime + " 큐의 상태 ? " + times);
        }

        System.out.println(minTime);

    }
}
