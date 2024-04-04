package src.com.company.week1.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1018_체스판다시칠하기 {
    public static void main(String[] args) throws IOException {
        // for문 이렇게 많아도 되나요 ?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // 체스판 가로세로
        String[][] chess = new String[N][M];

        // 체스판 입력 받기
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                chess[i][j] = row[j];
            }
        }

        // 최소 색칠 수를 저장하는 변수 초기화
        // 기준이 점점 더 작은 수라 max 로 잡아둠
        int minPaint = Integer.MAX_VALUE;

        // 8*8 채점판이 있다고 생각하고 거기를 짤라서 .
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                // 아직 비교 전이라 색칠할 거 없음..
                int paint = 0;
                // i,j의 위치(현재 위치) 에서 8 * 8 패턴이 맞니..? bwbwbwbw || wbwbwbwb
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        /** 현재 위치의 색 chess[i + k][j + l]이 흰색을 칠해야 하는지 깜장을 칠해야 하는지 구별
                         * 1. (k + l) % 2 == 0 : 인덱스의 합이 짝수이거나
                         * 2. !chess[i + k][j + l].equals("W") : 문자 WB 만 있으니까..흰섹이 아닌경우
                         * */
                        if ((k + l) % 2 == 0 && !chess[i + k][j + l].equals("W")) {
                            paint++;
                        } else if ((k + l) % 2 == 1 && !chess[i + k][j + l].equals("B")) {
                            paint++;
                        }
                    }
                }

                /**
                 * 현재 위치에서의 최소 색칠 수와 최소값 비교 : 검정색으로 칠할까? 흰색으로 칠할까 ? 생각하기
                 * 1. paint : 지금 칠한 페인트(현재 위치에서의 색상 변경 횟수)
                 * 2. 64 - white : 검정색 체스판 수
                 * 미리 저장해놓은 값하고 비교
                 * */
                minPaint = Math.min(minPaint, Math.min(paint, 64 - paint));
            }
        }
        System.out.println(minPaint); // 최소 색칠 수 출력
    }
}
