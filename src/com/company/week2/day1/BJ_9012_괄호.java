package src.com.company.week2.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9012_괄호 {
    /**
     * Stack 사용해 풀었습니다.
     * 메모리 : 14348KB, 시간 136ms
     --------------------------------------------------
     * 1. 입력값을 받는
     * 2. '(' 라면 stack에 넣고, ')' 라면 stack에 넣지 않고!!! 있는 '('꺼낸다.
     * 3. stack이 안비었다면 -> 즉 짝이 안맞는다면 VPS 아니니까 false 준다
     * 4. 출력 : answer에 VPS 참, 거짓 넣어 출력했다.
     --------------------------------------------------
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트데이터의 수
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            // 한 줄씩 넣기 예 :(())())
            String input = br.readLine();
            // (())()) 넣기
            isVps(input);
            String answer = isVps(input) ? "YES" : "NO";
            System.out.println(answer);
        }

    }

    //() 괄호의 짝 맞추기(VPS)인지 판별하는 메서드
    // Stack<String>으로 풀었었다.
    public static boolean isVps(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) { // 문자열을 문자 배열로 변환하여 순회
            if (c == '(') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty()) {
                stack.pop();
            } else {
                // 닫는 괄호가 나왔는데 스택이 비어 있으면 VPS가 아님
                return false;
            }
        }
        // 모든 검사 후 스택이 비어 있어야 VPS
        return stack.isEmpty();
    }
}
