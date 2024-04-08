package src.com.company.week2.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 틀린코드 !!
 * */

public class BJ_1072_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 승률계산, 승률이 바뀌면 count 출력
        String[] input = br.readLine().split(" ");
        int X = Integer.parseInt(input[0]);
        int Y = Integer.parseInt(input[1]);
        long Z = (Y / X) * 100;

        // 한판씩 올라가면서 탐색
        if(Z >= 100) {
            System.out.println(-1);
        } else {
            int answer = searchTimeToIncreaseWinRate(X, Y, Z);
            System.out.println(answer);
        }
    }

    public static int searchTimeToIncreaseWinRate(int X, int Y, long Z) {
        int answer = 0;
        while (true) {
            // 현재 승률을 계산

            int currentWinRate = (int)(((double)Y / X) * 100);

            // 만약 현재 승률이 목표 승률보다 크거나 같다면 종료
            if (currentWinRate > Z) {
                break;
            }
            // 게임을 한 번 진행할 때마다 X와 Y를 1씩 증가시킴
            X++;
            Y++;
            answer++;
        }
        return answer;
    }
}
