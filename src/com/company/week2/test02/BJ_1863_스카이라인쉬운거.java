package src.com.company.week2.test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1863_스카이라인쉬운거 {
    public static void main(String[] args) throws IOException {
        // x, y 불안하니 long으로 받자... int 도 된다.
        // 다른 높이가 나오면 count ++ 해주는 식으로 풀었
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 사실 내 로직에는 x 굳이 받아야 될까 싶다
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && y <= stack.peek() ) {

                if(stack.peek() > y) {
                    count++;
                }
                stack.pop();
            }
            stack.push(y);
        }

        // 높이가 0일 경우 처리.. 두개 합치고 싶다.....
        int y = 0;
        while (!stack.isEmpty() && stack.peek() >= y) {
            if (stack.peek() > y) {
                count++;
            }
            stack.pop();
        }
        // 0일 경우 0을 넣어준다.. 새로운 높이 추가갱신
        stack.push(y);

        System.out.println(count);

    }
}
