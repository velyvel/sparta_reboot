package src.com.company.week3.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_10282_해킹 {
    /**
     * 메모리 148792KB, 시간 872ms
     * 가중치가 주어져서 다익스트라 알고리즘을 생각했다
     * 양방향? 단방향? 인지 고민했는데 2번 예제에서 이어진 노드가 있으면 진행시켜! 라는걸 알고
     * 출발부터 가중치를 times 배열에 넣고,계속 갱신되게끄음.. 하는 방향으로 잡고 시작
     * 시간이 촉박해서 코드가 정돈되지 않았음
     * */
    static int T, N, D, hackingComputerNumber, computerA, computerB, second;
    static int[] times; // 감염된 컴퓨터 시간 저장
    static List<List<Computer>> computers = new ArrayList<>(); // 인접리스트, 컴퓨터
    static PriorityQueue<Computer> priorityQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 테스트케이스 수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 컴퓨터 수
            D = Integer.parseInt(st.nextToken()); // 의존성 개수
            hackingComputerNumber = Integer.parseInt(st.nextToken()); // 해킹 컴퓨터 번호
            times = new int[N + 1];

            computers.clear(); // 이전 테스트케이스 정보 초기화..를 안해줬구나 내가.. 다음 테케에서도 재활용 할꺼임
            for(int i = 0; i <= N; i++) {
                computers.add(new ArrayList<>());
            }
           // Arrays.fill(times, Integer.MAX_VALUE);

            for(int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                computerA = Integer.parseInt(st.nextToken());
                computerB = Integer.parseInt(st.nextToken());
                second = Integer.parseInt(st.nextToken());

                computers.get(computerB).add(new Computer(computerA, second));
            }
            // 해킹컴퓨터 번호를 시작으로 다익스트라 구현하기
            calculateTotalComAneTimes(hackingComputerNumber);
        }
    }

    private static void calculateTotalComAneTimes(int start) {
        // hackingComputerNumber = start;
        priorityQueue = new PriorityQueue<>();
        Arrays.fill(times, Integer.MAX_VALUE); // 이따가 maxvalue인건 안바뀐거로 체크할꺼임, isVisited
        times[start] = 0;
        priorityQueue.offer(new Computer(start, times[start]));

        int infectedComputerCount = 0;
        int lastInfectedTime = 0;

        while (!priorityQueue.isEmpty()) {
            Computer now = priorityQueue.poll();
            int nowComputer = now.start;
            int nowTime = now.time;

            // 방문처리! 지나온 자리
            if (nowTime > times[nowComputer]) {
                continue;
            }

            // 시작노드는 이미 감염되었으니 ++, 시간도 지났
            infectedComputerCount++;
            lastInfectedTime = nowTime;

            for (Computer next : computers.get(nowComputer)) {
                int nextComputer = next.start;
                int nextTime = nowTime + next.time;
                // 시작컴 감염시간 > 바꿔치기
                if (times[nextComputer] > nextTime) {
                    times[nextComputer] = nextTime;
                    // 다음 감염 컴퓨터 값 넣어준다 -> 이게 다시 시작컴으로 된
                    priorityQueue.offer(new Computer(nextComputer, nextTime));
                }
            }
        }
        System.out.println(infectedComputerCount + " " + lastInfectedTime);
    }
}
class Computer implements Comparable<Computer>{
    int start, time;

    public Computer(int start, int time) {
        this.start = start;
        this.time = time;
    }

    @Override
    public int compareTo(Computer computer) {
        return this.time - computer.time;
    }
}
