package src.com.company.week2.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * PriorityQueue 사용해 풀었습니다.
 * 메모리 : 15240KB, 시간 176ms
 * 우선순위 큐 사용했고(자동정렬), 가장 앞에 있는 수 2개 더한게 가장 작은 수라..
 --------------------------------------------------
 */

public class BJ_15903_카드합체놀이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 카드의 개수
        int count = Integer.parseInt(st.nextToken()); // 카드 합체 횟수

        //(1 ≤ ai ≤ 1,000,000) 의 범위가 100만이라 long..
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            priorityQueue.offer(Long.parseLong(st.nextToken())); // 각 카드의 숫자를 우선순위 큐에 추가
        }

        // 카드 합체 횟수(count)만큼 반복하여 합체 수행
        for (int i = 0; i < count; i++) {
            long first = priorityQueue.poll(); // 가장 작은 숫자 2개를 꺼내서
            long second = priorityQueue.poll();
            priorityQueue.offer(first + second); // 두 숫자를 합친 값을 다시 우선순위 큐에 추가
            priorityQueue.offer(first + second);
        }

        // 합체가 완료된 우선순위 큐의 모든 카드의 숫자를 더하기
        long result = 0;
        while (!priorityQueue.isEmpty()) {
            result += priorityQueue.poll();
        }

        System.out.println(result);
    }

}

