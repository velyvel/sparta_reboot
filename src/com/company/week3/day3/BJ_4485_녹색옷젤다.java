package src.com.company.week3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_4485_녹색옷젤다 {
    /**
     * 입, 출력 부분이 기존과 달라 어려웠다
     * 0,0에서 목적지까지 가는 가중치가 있는 최단거리를 구하는 문제기 때문에 다익스트라로 풀었다
     * 동굴과 동굴의 사이즈를 계속 갱신하며 체크하도록 구현함
     * */
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean[][] isVisited;
    static int[][] cave;
    static int[][] size;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testNum = 1;
        while (true) {
        //while ((N = Integer.parseInt(br.readLine())) != 0) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            cave = new int[N][N];
            isVisited = new boolean[N][N];
            size = new int[N][N];

            for (int row = 0; row < N; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int column = 0; column < N; column++) {
                    cave[row][column] = Integer.parseInt(st.nextToken());
                    size[row][column] = Integer.MAX_VALUE;
                }
            }

            makeBFS(0, 0, cave[0][0]);
            // 출력부분도 어려웠다..
            System.out.println("Problem " + testNum + ": " + size[N - 1][N - 1]);
            testNum++;
        }
    }

    private static void makeBFS(int row, int column, int rupeeSize) {
        PriorityQueue<BlackRupee> rupees = new PriorityQueue<>();
        isVisited[row][column] = true;

        rupees.offer(new BlackRupee(row, column, rupeeSize));

        while (!rupees.isEmpty()) {
            BlackRupee currentSize = rupees.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = currentSize.row + dx[i];
                int nowY = currentSize.column + dy[i];

                // 다음 좌표가 유효한 범위 내에 있는지 확인
                if (nowX < 0 || nowY < 0 || nowX >= N || nowY >= N)
                    continue;

                // 다음 좌표가 이미 방문한 곳이거나, 현재 경로로 가는 것이 더 큰 크기를 가질 경우에는 skip
                if (isVisited[nowX][nowY] || size[nowX][nowY] <= cave[nowX][nowY] + currentSize.size)
                    continue;


                size[nowX][nowY] = cave[nowX][nowY] + currentSize.size;
                isVisited[nowX][nowY] = true;
                rupees.offer(new BlackRupee(nowX, nowY, size[nowX][nowY]));

            }
        }
    }
}

class BlackRupee implements Comparable<BlackRupee> {
    int row;
    int column;
    int size;

    public BlackRupee(int row, int column, int size) {
        this.row = row;
        this.column = column;
        this.size = size;
    }

    @Override
    public int compareTo(BlackRupee blackRupee) {
        return size - blackRupee.size;
    }
}

