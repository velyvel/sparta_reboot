package src.com.company.week2.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Comparator;

public class BJ_11286_절댓값힙2 {
    static class AbsoluteValueComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            // 먼저 절댓값을 기준으로 비교
            if (abs1 == abs2) {
                // 절댓값이 같다면 실제 값을 비교
                return o1 - o2;
            }
            return abs1 - abs2;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new AbsoluteValueComparator());

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                if (priorityQueue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(priorityQueue.poll());
                }
            }
            else {
                priorityQueue.offer(x);
            }
        }
    }
}
