package src.com.company.week2.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_탑_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] towers = new int[N];
        for (int i = 0; i < N; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }
        // 6,9,5,7,4 -> 이거 stack으로 그냥 선언하고 그냥 for 문 돌려도 되나 ? :
        int[] receiveHeights = new int[N]; // 수신한 높이를 저장할 배열
        Stack<Integer> stack = new Stack<>(); // 수신을 기다리는 탑의 인덱스를 저장하는 스택
        // 4-> 7이니까 스택 push
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && towers[stack.peek()] < towers[i]) {
                // 현재 탑이 수신할 수 있는 경우
                receiveHeights[stack.pop()] = i + 1; // 현재 탑의 높이를 수신한 높이로 설정
            }
            stack.push(i); // 현재 탑의 인덱스를 스택에 추가
        }

        StringBuilder sb = new StringBuilder();
        for (int height : receiveHeights) {
            sb.append(height).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
