package src.com.company.week3.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2293_동전 {
    /**
     * 메모리 : 14596KB, 시간 : 140ms
     * 해설은 주석 풀고 복사해서 출력해보세요..(사진첨부)
     * for (int coin : coins) {
     *             System.out.println("현재 " + coin + "원 동전을 사용하여 금액 만들기.");
     *
     *             for (int i = coin; i <= K; i++) {
     *                 System.out.println("금액 " + i + "을 만드는 방법의 수를 업데이트.");
     *                 int combinationsWithoutCoin = count[i - coin];
     *                 System.out.println("이전에 이미 만들어둔 금액 " + (i - coin) + "을 만드는 방법의 수: " + combinationsWithoutCoin);
     *                 count[K] += combinationsWithoutCoin;
     *                 System.out.println("따라서, 현재 금액 " + i + "을 만드는 방법의 수: " + count[i]);
     *                 System.out.println("============================================================");
     *             }
     *         }
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] coins = new int[N];
        int[] count = new int[K + 1]; // 동전 만드는 방법의 수 : 0원 ~ 10원 만들어야 하니까 공간 11개(즉 K+1개 필요함)

        // 값 넣기
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }
        // 0원을 만드는 방법은 아무것도 사용 안함..(한가지라 1도 설정)
        count[0] = 1;

        for (int coin : coins) {
            System.out.println("지금 고른 동전");
            for (int i = coin; i <= K; i++) {
                System.out.println("지금 계산할 동전 합 " + i);
                System.out.println("지금 까지 계산되었던 조합 :  " + count[i]);
                System.out.println("거기서 이미 만들어진 동전 조합이 있는지 확인 " + count[i - coin]);
                count[i] += count[i - coin]; // 현재 금액을 만드는 방법의 수에 동전을 추가하여 만들 수 있는 방법의 수를 누적
                System.out.println("======================================");
            }
        }

        System.out.println("count 배열 : " + Arrays.toString(count));
        // 출력 : count 배열 : [1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 10]
        System.out.println(count[K]);
    }
}
