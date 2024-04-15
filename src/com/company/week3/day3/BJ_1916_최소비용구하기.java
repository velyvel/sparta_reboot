package src.com.company.week3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BJ_1916_최소비용구하기 {
    /**
     * 메모리: 61416KB, 시간: 648ms
     * 다익스트라 알고리즘으로 풀었다 : start 에서 end 까지 가는 최적의 경로를 찾는 문제이다
     * Bus 객체를 만들어서 Bus 도착지와 요금을 저장해둔다
     * busList 에 각 도시에서 출발하는 버스 목록을 저장해둔다 : 해당 도시와 연결된 버스의 정보를 쉽게 접근 가능!
     * 최소비용을 갱신
     *  - 아직 방문 전,
     *  - 현재까지의 최소 비용 + 해당 버스를 타고 도착 도시에 도착하는 비용 < 이전 최소 비용
     * */
    static List<Bus>[] busList;
    static boolean[] isVisited;
    // 최소비용 저장 배열
    static int[] minCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1번 인덱스 부터 사용하기 위해(문제 도시 범위 보기)
        int N = Integer.parseInt(br.readLine()) + 1;
        int M = Integer.parseInt(br.readLine());

        // 초기화
        busList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            busList[i] = new ArrayList<>();
        }

        isVisited = new boolean[N];
        minCost = new int[N];
        Arrays.fill(minCost, Integer.MAX_VALUE);  // 최대 값으로 초기화 : 계속 갱신하기 위해

        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int startCity = Integer.parseInt(input[0]);
            int endCity = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            busList[startCity].add(new Bus(endCity, cost));
        }

        // 구해야 할 시작도시, 도착도시
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        // 최소비용 계산
        calculateMinCost(start);
        System.out.println(minCost[end]);
    }

    public static void calculateMinCost(int start) {
        PriorityQueue<Bus> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Bus(start, 0));
        minCost[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Bus currentBus = priorityQueue.poll();

            // 이미 버스 지나갔을떄는 넘어가도 된다
            if (isVisited[currentBus.endCity]) continue;

            // 이제 지나갈 도시에는 방문표시 해 두고
            isVisited[currentBus.endCity] = true;

            //
            for (Bus bus : busList[currentBus.endCity]) {
                // 아직 방문전이고, 현재까지의 최소 비용과 해당 버스를 타고 도착 도시에 도착하는 비용을 더한 값이
                // 이전에 발견된 최소 비용보다 작다면
                if (!isVisited[bus.endCity] &&
                        minCost[currentBus.endCity] + bus.cost < minCost[bus.endCity]) {

                    // 최소비용을 갱신해줍니다.-> 우선순위 큐에 갱신하여 다음에 이어지는 경로를 탐색할 수 있도록 한다
                    minCost[bus.endCity] = minCost[currentBus.endCity] + bus.cost;
                    priorityQueue.offer(new Bus(bus.endCity, minCost[bus.endCity]));
                }
            }
        }
    }

    static class Bus implements Comparable<Bus> {
        int endCity;
        int cost;

        public Bus(int endCity, int cost) {
            this.endCity = endCity;
            this.cost = cost;
        }

        // 비용이 적은 순서대로 정렬하기 위해 사용
        @Override
        public int compareTo(Bus bus) {
            return this.cost - bus.cost;
        }
    }
}
