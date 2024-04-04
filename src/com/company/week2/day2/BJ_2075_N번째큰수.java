package src.com.company.week2.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * PriorityQueue 사용해 풀었습니다.
 * 메모리 : 249368KB, 시간 1000ms
 * (N = 5라고 가정) : 5번째 숫자 찾기
 * 우선순위 큐에 숫자를 담고(가장 작은 수가 맨 앞에 있겠죠?)
 * 큐의 사이즈가 가로의 숫자(N)이 되면
 *  - 새로운 값이면 데이터 바꿔주고
 *  - 새로운 값이 작으면 그대로 유지
 --------------------------------------------------
 * 처음에 이차원 배열 풀어서 리스트에 저장 -> (treeSet에 -> 오름차순대로 저장되니까),
 * N 까지 while 문 쓰고 break; 하였으나 불필요한 탐색이 많아질 것 같아 우선순위 큐로 풀기로 결정
 */

public class BJ_2075_N번째큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 일단 선언만
        StringTokenizer st;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            // 토믄이 없을 때 까지
            while (st.hasMoreTokens()) {
                int numberElement = Integer.parseInt(st.nextToken());
                // 우선순위 큐에 한줄씩(자동 오름차순) 쌓는다
                priorityQueue.add(numberElement);

                if (priorityQueue.size() > N) {
                    // 가장 작은 값이 위로 가 있을 것이기 때문에, 끝까지 남은건 35,41,48,49,52
                    priorityQueue.poll(); // 우선순위 큐 크기를 N으로 유지
                }
            }
        }
        System.out.println(priorityQueue.peek());
    }
}
