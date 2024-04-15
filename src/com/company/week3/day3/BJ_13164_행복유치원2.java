package src.com.company.week3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_13164_행복유치원2 {
    /**
     * 우선순위 큐에서 빼는 방법도 있을까 해 고민하다가 풀어봤습니다
     * 메모리 : 54420KB, 시간 : 588ms
     *
     *
     이 부분은 다음과 같은 방식으로 작동합니다:

     우선순위 큐에는 각 학생들 사이의 키 차이가 저장되어 있습니다. 이 우선순위 큐는 내림차순으로 정렬되어 있으므로 가장 큰 차이를 가진 학생부터 먼저 나옵니다.
     그런 다음에는 우선순위 큐에서 K-1번째로 큰 차이를 가진 학생부터 하나씩 꺼내면서 버립니다. 이렇게 하면 K개의 조가 생기게 됩니다.
     나머지 학생들의 키 차이만 남게 되고, 이를 모두 더하여 최소 비용을 계산합니다.
     *
     * */
    static int N, K;
    static int[] heights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        heights = new int[N];
        for(int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int minCost = calculateMinCost();
        System.out.println(minCost);
    }

    public static int calculateMinCost() {

        //차이를 저장하는 우선순위 큐 (내림차순으로 정렬)
        PriorityQueue<Integer> difference =
                new PriorityQueue<>((cost1, cost2) -> cost2 - cost1);

        int cost = 0;

        // 각 학생들의 키 차이를 우선순위 큐에 저장
        for (int i = 0; i < heights.length - 1; i++) {
            difference.offer(heights[i + 1] - heights[i]);
        }

        // 가장 차이가 많이 나는 학생을 K-1번 제외하고 나머지를 합산
        for (int i = 0; i < K - 1; i++) {
            difference.poll();
        }

        // 나머지 차이들을 합산하여 최소 비용 계산
        while (!difference.isEmpty()) {
            cost += difference.poll();
        }

        return cost;
    }
}
