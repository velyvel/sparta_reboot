package src.com.company.week2.day2;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueExample1 {

    // priorityQueue : 반대로 내림차순 정렬하기
    public static void main(String[] args) {
        // 우선순위 큐 생성, Comparator.reverseOrder()를 사용하여 내림차순(최대값 우선)으로 정렬
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        // 우선순위 큐에 숫자 추가
        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(5);
        priorityQueue.add(3);
        priorityQueue.add(7);

        // 우선순위 큐가 비어있지 않는 동안 요소를 꺼내어 출력
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
            /** 출력
             * 20
             * 10
             * 7
             * 5
             * 3
             * */
        }
    }

}
