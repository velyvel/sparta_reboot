package src.com.company.week3.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 완전탐색, 동적계획, 분기한정 방법이 있지만 코드레벨 구현이 완탐밖에 되지 않아 => 아는방법이 완탐이라..
 */

public class BJ_10971_외판원순회2 {
    static int N;
    static int[][] island;
    static boolean[] isVisited;
    static int minCost = Integer.MAX_VALUE; // 쵀대값에서 줄여나가기..

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        island = new int[N][N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 여기 j = i?.?
            for (int j = 0; j < N; j++) {
                island[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 다리 수 조합문제라고 생각했다

        for (int i = 0; i < N; i++) {
            isVisited[i] = true;
            calculateDFS(i, i, 0, 1);
            isVisited[i] = false;
        }
        System.out.println(minCost);
    }

    private static void calculateDFS(int start, int node, int cost, int count){
        // 모든 섬을 방문했을 때 : 0: 내 섬에서 내 섬 못감 + 다리 없음
        if(count == N && island[node][start] != 0) {
            minCost = Math.min(minCost, cost + island[node][start]);
            return;
        }

        for( int i = 0; i < N; i++) {
            // 아직 방문전, 다리 있다
            if(!isVisited[i] && island[node][i] != 0) {
                isVisited[i] = true;
                calculateDFS(start, i, cost + island[node][i], count + 1);
                isVisited[i] = false;
            }
        }
    }
}
