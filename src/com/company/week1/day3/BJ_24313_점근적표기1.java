package src.com.company.week1.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_24313_점근적표기1 {
    // 틀맅코드인데 고쳐보겠음...
    // 팀코드로 대체
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 계산을 위한 변수 지정
        int a0 = Integer.parseInt(st.nextToken());
        int a1 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        // 요구하는 식이 충족하면 sum + 1 아니면 sum + 0
        int sum = 0;
        for (int i = n; i <= 100; i++) {
            sum = (a0 * i + a1 <= c * i) ? sum + 1 : sum;
        }

        // 101에서 n개를 뺀 값이 sum과 같다는 것은 모든 값이 조건과 충족된다는 것
        System.out.println(sum == 101 - n ? 1 : 0);
    }
}
