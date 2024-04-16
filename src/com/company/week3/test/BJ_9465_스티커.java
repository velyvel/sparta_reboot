package src.com.company.week3.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9465_스티커 {
    /**
     * 메모리 : 114852KB, 시간 732ms
     * */
    static int T, N;
    static int[][] stickers, nowCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 테스트케이스의 수

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            stickers = new int[2][N + 1];
            nowCost = new int[2][N + 1];

            // 값 넣기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                stickers[0][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                stickers[1][i] = Integer.parseInt(st.nextToken());
            }
            // 초기값 설정
            nowCost[0][1] = stickers[0][1];
            nowCost[1][1] = stickers[1][1];

            // 탐색 로직 만들기
            int answer = calculateMaxSum();
            System.out.println(answer);
        }
    }

    private static int calculateMaxSum() {
        for (int i = 2; i <= N; i++) {
            //첫번째 칸 선택할 경우에는 아래와 오른쪽만 계산하면 되서 i > 2 조건을 추가했다
            nowCost[0][i] = Math.max(nowCost[1][i-1], (i > 2 ? nowCost[1][i-2] : 0)) + stickers[0][i];
            nowCost[1][i] = Math.max(nowCost[0][i-1], (i > 2 ? nowCost[0][i-2] : 0)) + stickers[1][i];
        }
        int answer = Math.max(nowCost[0][N], nowCost[1][N]);
        return answer;
        /**
         * 부가설명 :
         * 1) i > 2 ? nowCost[1][i-2] : 0) 삼항연산자 사용하여 첫번째 칸일때 왼쪽 탐색 빼주기
         * 2) nowCost[1][i-1] : 선택한 칸의 윗면 스티커 선택 안함
         * 3) nowCost[1][i-2] : 선택한 칸의 윗면 스티커 선택함
         * 4) + stickers[0][i] : 스티커 뗄 때 아래쪽 비용도 더해줌,
         *  -> 즉 2번 vs 3번 비교해 최대값 저장해둠
         * */
    }
}

