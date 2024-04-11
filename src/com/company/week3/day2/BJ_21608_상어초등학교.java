package src.com.company.week3.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_21608_상어초등학교 {
    static int N;
    static int[][] isVisited, relation;
    static int[] dx = {-1, 0 , 1, 0};
    static int[] dy = {0, 1 , 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        isVisited = new int[N + 1][N + 1];
        relation = new int[N * N + 1][4];

        for(int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());

            for(int j = 0; j < 4; j++) {
                 relation[student][j] = Integer.parseInt(st.nextToken());
             }
            
            simulate(student);
        }
        calculateScore();
    }

    private static void calculateScore() {
        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int student = isVisited[i][j];
                int likeCount = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }

                    for (int l = 0; l < 4; l++) {
                        if (isVisited[nx][ny] == relation[student][l]) {
                            likeCount++;
                        }
                    }
                }

                answer += Math.pow(10, likeCount - 1);
            }
        }

        System.out.println(answer);

    }

    private static void simulate(int student) {
        int maxEmptyCount = 0;
        int maxLikeCount = 0;
        int x = 0;
        int y = 0;

        for(int i =N-1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (isVisited[i][j] != 0) {
                    continue;
                }

                int likeCount = 0;
                int emptyCount = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = i + dy[k];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }

                    if (isVisited[nx][ny] == 0) {
                        emptyCount++;
                    } else {
                        for (int l = 0; l < 4; l++) {
                            if (isVisited[nx][ny] == relation[student][l]) {
                                likeCount++;
                            }
                        }
                    }
                }

                if (likeCount > maxLikeCount || (likeCount == maxLikeCount && maxEmptyCount <= emptyCount)) {
                    maxLikeCount = likeCount;
                    maxEmptyCount = emptyCount;
                    x = i;
                    y = j;
                }
            }
        }

        isVisited[x][y] = student;

            }
        }

