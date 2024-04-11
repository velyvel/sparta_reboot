package src.com.company.week3.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class BJ_21610_마법사상어와비바라기 {

    // ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    static final int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static final int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    static int N, M;
    static int[][] grid = new int[50][50];
    static boolean[][] isVisited = new boolean[50][50];
    static ArrayList<Cloud> clouds = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 문제에 나온대로 구름 위치 찍어두기
        clouds.add(new Cloud(N - 1, 0));
        clouds.add(new Cloud(N - 1, 1));
        clouds.add(new Cloud(N - 2, 0));
        clouds.add(new Cloud(N - 2, 1));


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            // move clouds 와 do magic 은 연속적으로 일어나야 한다고 생각했다
            // 구름 아동 + 물 증가 + 구름 사라지기
            moveClouds(D, S);
            doMagic();
            makeClouds();
        }
        int count = countWater();
        System.out.println(count);
    }


    // 1, 2번 로직 + 3
    static void moveClouds(int D, int S) {

        // 사실 5가 무한대니까.. 약간 구처럼.. 만약 S가 6이면... 1 자리에 들어간다
        S = S % N;
        for (Cloud cloud : clouds) {
            // 구름의 지금 위치 + (이동해야 하는 위치) + 그리드 가로넓이 : 약간 구 형식이니까 나머지처럼 구한다고 생각했따
            cloud.row = (cloud.row + S * dx[D] + N) % N;
            cloud.column = (cloud.column + S * dy[D] + N) % N;

            // 해당 위치의 물 증가가가가가..., 구름 지워주기
            grid[cloud.row][cloud.column]++;
            isVisited[cloud.row][cloud.column] = true;
        }
    }

    static void doMagic() {
        for (Cloud cloud : clouds) {
            int water = 0;
            // 화살표 모양이 두번에 한번씩 대각선 모양이라 for문을 이렇게 작성했다
            for (int arrow = 2; arrow <= 8; arrow += 2) {
                int nextX = cloud.row + dx[arrow];
                int nextY = cloud.column + dy[arrow];
                // 지도 안, N값 범위라면 킵고잉!
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
                    continue;
                // 물이 증가하였느냐 ?
                if (grid[nextX][nextY] > 0)
                    water++;
            }
            // 바구니에 물 채워주기..
            grid[cloud.row][cloud.column] += water;
        }
    }

    static void makeClouds() {
        ArrayList<Cloud> basketList = new ArrayList<>(clouds);
        clouds.clear();
        for (int row = 0; row < N; row++) {
            for (int column = 0; column < N; column++) {
                // 지금.. 그리드 안에 저장되어 있는 물이 2 이상이더냐 ?
                if (isVisited[row][column] || grid[row][column] < 2)
                    continue;

                // 그러면 구름 만들고
                clouds.add(new Cloud(row, column));
                // 물양을 빼거라!
                grid[row][column] -= 2;
            }
        }

        for (Cloud cloud : basketList) {
            isVisited[cloud.row][cloud.column] = false;
        }
        basketList.clear();
    }

    static int countWater() {
        int count = 0;
        for (int row = 0; row < N; row++) {
            for (int column = 0; column < N; column++) {
                count += grid[row][column];
            }
        }
        return count;
    }

    static class Cloud {
        int row;
        int column;

        Cloud(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}

