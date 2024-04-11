package src.com.company.week3.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1107_리모콘_2 {
    static boolean[] broken = new boolean[10]; // 고장난 버튼을 체크하기 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 이동하려는 채널
        int M = Integer.parseInt(br.readLine()); // 고장난 버튼의 수

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int brokenButton = Integer.parseInt(st.nextToken());
                broken[brokenButton] = true; // 고장난 버튼 체크
            }
        }

        // +,- 버튼만 사용하여 이동하는 경우의 최소 횟수
        int result = Math.abs(N - 100);

        // 5만
        for (int channel = 0; channel <= 500002; channel++) {
            int count = check(channel);
            if (count > 0) {
                int press = Math.abs(channel - N);
                result = Math.min(result, count + press);
            }
        }

        System.out.println(result);
    }

    public static int check(int channel) {
        if (channel == 0) {
            return broken[0] ? 0 : 1;
        }
        int count = 0;
        while (channel > 0) {
            if (broken[channel % 10]) {
                return 0;
            }
            count++;
            channel /= 10;
        }
        return count;
    }
}

