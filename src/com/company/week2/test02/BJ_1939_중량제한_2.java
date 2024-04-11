package src.com.company.week2.test02;

import java.io.*;
import java.util.*;

public class BJ_1939_중량제한_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 섬의 수
        int N = Integer.parseInt(st.nextToken());
        // 다리의 수
        int M = Integer.parseInt(st.nextToken());

        // 다리 연결 공간
        List<List<Integer>> bridges = new ArrayList<>();
        // 다리 클래스로 빼두기
        List<Island> islandList = new ArrayList<>();

        //다리 연결 자리 만들어주기
        for(int i = 0;i <= N; i++){
            bridges.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int island1 = Integer.parseInt(st.nextToken());
            int island2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 인접 그래프 그려주기.......
            bridges.get(island1).add(island2);
            bridges.get(island2).add(island1);


        }

        //공장 위치 받기 : 공장은 무조건 2개....
        st = new StringTokenizer(br.readLine());
        int factory1 = Integer.parseInt(st.nextToken());
        int factory2 = Integer.parseInt(st.nextToken());

        int result = search(factory1, factory2, N);

        System.out.println(result);
    }


    static int search(int factory1, int factory2, int N){

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];

        // 시작 저장
        priorityQueue.add(new int[]{factory1, N});

        while(priorityQueue.isEmpty()){

            int[] island = priorityQueue.poll();
            int now = island[0];
            int weight = island[1];

            //도착섬에 왔을 때
            if(now == factory2){
                return weight;
            }

            if(isVisited[now]){
                isVisited[now] = true;
                continue;
            }

            // for문 돌리기.. 배열 탐색은 하지도 못함
        }
        return 0;
    }

    public class Island {
        // 이어주는 점
        int start;
        // 끝나는 점
        int end;
        // 무개
        int weight;
    }

}
