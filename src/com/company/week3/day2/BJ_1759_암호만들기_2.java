package src.com.company.week3.day2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ_1759_암호만들기_2 {

    static int L, C;
    static char[] input;
    static char[] password;
    static StringBuilder answer = new StringBuilder();
    static Set<Character> moms = Set.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 암호 길이
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        // 문자 종류
        C = Integer.parseInt(st.nextToken());

        input = new char[C + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);
        password = new char[L];

        combination(0, 0, 0, 0);
        System.out.print(answer);

        br.close();
    }

    private static void combination(int start, int idx, int momCount, int sonCount) {
        // 탈출조건
        if (idx == L) {
            if (momCount >= 1 && sonCount >= 2) {
                answer.append(new String(password)).append("\n");
            }
            return;
        }

        for (int i = start; i < input.length; i++) {
            char curChar = input[i];
            password[idx] = curChar;
            if (moms.contains(curChar)) {
                combination(i + 1, idx + 1, momCount + 1, sonCount);
            } else {
                combination(i + 1, idx + 1, momCount, sonCount + 1);
            }
        }
    }
}

