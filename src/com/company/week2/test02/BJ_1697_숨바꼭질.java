package src.com.company.week2.test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ_1697_숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        // 수빈이 위치(start)
        int N = Integer.parseInt(input[0]);
        // 동생의 위치(target)
        int K = Integer.parseInt(input[1]);

        // 방문 여부를 저장할 배열 : N의 범위가 주어져서......
        boolean[] isVisited = new boolean[100001]; // 범위 설정

        int result = BFS(N, K, isVisited);

        System.out.println(result);
    }

    public static int BFS(int N, int K, boolean[] isVisited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {N, 0}); // 현재 위치와 이동 횟수를 함께 저장

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int moveX = now[0];
            int count = now[1]; // 이동 횟수

            if(moveX == K) {
                return count;
            }

            // 왼쪽으로 한 칸 이동한 경우
            if(moveX - 1 >= 0 && !isVisited[moveX - 1]) {
                queue.add(new int[]{moveX - 1, count + 1});
                isVisited[moveX - 1] = true;
            }
            // 오른쪽으로 한 칸 이동한 경우
            if(moveX + 1 <= 100000 && !isVisited[moveX + 1]) {
                queue.add(new int[]{moveX + 1, count + 1});
                isVisited[moveX + 1] = true;
            }
            // 순간이동 한 경우
            if(moveX * 2 <= 100000 && !isVisited[moveX * 2]) {
                queue.add(new int[]{moveX * 2, count + 1});
                isVisited[moveX * 2] = true;
            }
        }
        // 빼도 상관 없음
        return -1; // 도착하지 못한 경우 -1 반환
    }

}
