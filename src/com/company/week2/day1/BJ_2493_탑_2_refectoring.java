package src.com.company.week2.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_탑_2_refectoring {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 탑의 수
        st = new StringTokenizer(br.readLine());

        Stack<Tower> stack = new Stack<>(); // 탑을 저장하는 스택

        // 첫 번째 탑은 무조건 수신할 수 없으므로 바로 스택에 저장
        stack.push(new Tower(1, Integer.parseInt(st.nextToken())));
        sb.append("0").append(" ");

        // 두 번째 탑부터 시작하여 왼쪽으로 빛을 쏴 부딪히는 탑을 구함
        for (int i = 1; i < N; i++) {
            int currentHeight = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek().height < currentHeight) {
                // 현재 탑이 수신할 수 있는 경우
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(stack.peek().index + " ");
            }
            stack.push(new Tower(i + 1, currentHeight)); // 현재 탑의 인덱스와 높이를 스택에 추가
        }
        System.out.println(sb);
    }

    // 탑을 나타내는 클래스
    static class Tower {
        int index; // 탑의 인덱스
        int height; // 탑의 높이

        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
