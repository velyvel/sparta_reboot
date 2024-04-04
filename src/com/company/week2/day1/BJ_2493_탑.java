package src.com.company.week2.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2493_탑 {
    /**
     * Dequeue 사용하여 풀이하였습니다.
     * 메모리 초과 코드..
     *
     --------------------------------------------------
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 맵으로 하고싶었다.
        Stack<int[]> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        //String[] input = br.readLine().split(" ");
        StringTokenizer st = new StringTokenizer(br.readLine());


        //for(int i = 1; i < N + 1; i++) {
        // 탑은 항상 1번부터 인덱스는 0번부터
        for(int i = 1; i <= N; i++) {

            int position = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if(stack.peek()[1] < position) {
                    stack.pop();
                } else {
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
            }
            if(stack.isEmpty()) {
                System.out.print("0 ");
            }

            stack.push(new int[] {i, position});
        }
    }
}
