package src.com.company.week2.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2346_풍선터트리기_1 {
    /**
     * Dequeue 사용하여 풀이하였습니다.
     * 메모리 초과 코드..
     --------------------------------------------------
     */
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Integer> deque = new LinkedList<>();
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 1; i <= N; i++) {
                int value = Integer.parseInt(st.nextToken());
                deque.addLast(i); // 풍선 번호를 Deque에 추가
                map.put(i, value); // 풍선 번호와 값을 Map에 저장
            }

            while (!deque.isEmpty()) {
                int current = deque.removeFirst(); // 현재 풍선을 Deque에서 제거
                System.out.print(current + " ");
                if (deque.isEmpty()) {
                    break; // 모든 풍선이 터졌으면 종료
                }

                int steps = map.get(current); // 이동해야 할 거리
                if (steps > 0) {
                    for (int i = 0; i < steps - 1; i++) { // 오른쪽으로 이동
                        deque.addLast(deque.removeFirst());
                    }
                } else {
                    for (int i = 0; i < Math.abs(steps); i++) { // 왼쪽으로 이동
                        deque.addFirst(deque.removeLast());
                    }
                }
            }
        }
}
