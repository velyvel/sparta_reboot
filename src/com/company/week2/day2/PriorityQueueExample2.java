package src.com.company.week2.day2;

import java.util.PriorityQueue;

public class PriorityQueueExample2 {

    // priorityQueue : 숫자 오름차순(작은것 부터), 문자 알파벳순서가 기본 정렬이다.
    public static void main(String[] args) {
        // 우선순위 큐 생성
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // 우선순위 큐에 숫자 추가
        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(5);
        priorityQueue.add(3);
        priorityQueue.add(7);

        // 우선순위 큐가 비어있지 않는 동안 요소를 꺼내어 출력
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        /**
         * 출력
         * 3
         * 5
         * 7
         * 10
         * 20
         * */

        System.out.println("꺼낸 뒤 pq 의 상태? " + priorityQueue);
        // 출력 : 꺼낸 뒤 pq 의 상태? []


    }
}
