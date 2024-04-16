package src.com.company.week3.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_5972_택배배송 {
    /**
     * 메모리 : 40509KB, 시간 : 460ms
     * 오직 여물만 비교한다 (모든 헛간을 방문할 의무x)
     * 다익스르타.. route 배열에 지금 위치에서 최소비용을 저장하고 최종적으로 N까지 도달한 비용을 출력한다
     * */

    static int N , M; // 헛간, 길
    static int[] route; // 현재까지 경로 중 최소비용 저장
    static List<List<Stable>> stables; // 인접리스트(연결정보)
    static PriorityQueue<Stable> priorityQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 헛간
        M = Integer.parseInt(st.nextToken()); // 길

        // 1번 헛간부터 시작, 공간 만들기
       stables = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            stables.add(new ArrayList<>());
        }

        // 양방향 값 넣기
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 각각 연결점과 비용 저장
            stables.get(start).add(new Stable(end, cost));
            stables.get(end).add(new Stable(start,cost));
        }


        route = new int[N + 1];
        // 최소비용 구하기라..
        Arrays.fill(route, Integer.MAX_VALUE);
        calculateCost(1);

        System.out.println(route[N]);
    }

    private static void calculateCost(int start) {
        priorityQueue = new PriorityQueue<>();
        // 시작 1부터(문제에서, 비용 0으로 시작)
        priorityQueue.add(new Stable(start, 0));
        route[start] = 0;

        while (!priorityQueue.isEmpty()) {
            // 현재까지 방문하지 않은 헛간 중 최소비용을 가진 헛간 꺼내기 (예; 1번 출발, 2번과 4번으로 가는 선택지 중 1번 선택)
            Stable now = priorityQueue.poll();
            int nowNum = now.stableNum;
            int nowCost = now.cost;

            // isVisited 처리, 이미 방문한 노드에 대해서는 해당 노드까지의 최단 경로가 이미 발견
            // 다른 경로들은 이미 최적의 경로가 아니므로 해당 노드를 건너뛰고 다음 노드를 탐색
            if(route[nowNum] < nowCost) {
                continue;
            }

            // 인접한 헛간을 순회, 최소비용 바꿔치기
            for(Stable stable : stables.get(nowNum)) {
                // 현재 위치에서 비용 + 내가 갈 수 있는 경로의 비용
                int cost = nowCost + stable.cost;
                // 새로 계산된 비용이 더 작은 경우에만 경로 바꿔치기, 우선순위 큐에 추가.
                if(cost < route[stable.stableNum]) {
                    // 해당 헛간까지 우선순위 큐에 추가
                    route[stable.stableNum] = cost;
                    priorityQueue.add(new Stable(stable.stableNum, cost));
                }
            }
        }

    }
}

class Stable implements Comparable<Stable>{
    int stableNum; // 헛간 번호
    int cost; // 소 몇명 = 비용

    public Stable(int stableNum, int cost) {
        this.stableNum = stableNum;
        this.cost = cost;
    }

    // 비용이 더 저렴한..
    @Override
    public int compareTo(Stable stable) {
        return this.cost - stable.cost;
    }
}
