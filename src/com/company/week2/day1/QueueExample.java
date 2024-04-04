package src.com.company.week2.day1;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Queue 선언
        Queue<String> queue = new LinkedList<>();

        // 요소 추가
        queue.offer("짜장면"); // 작업 추가
        queue.offer("치킨"); // 작업 추가
        queue.offer("떡볶이"); // 작업 추가

        // 작업 대기열 출력
        System.out.println("내가 지금 먹고싶은건 " + queue);
        // 출력 : 내가 지금 먹고싶은건 [짜장면, 치킨, 떡볶이]


        // 작업 처리 (처음에 추가된 작업부터 처리됨)
        while (!queue.isEmpty()) {
            String task = queue.poll(); // 작업 꺼내기
            System.out.println("지금 먹고있는 것은?: " + task);
        }
        /**
         * 출력
         * 지금 먹고있는 것은?: 짜장면
         * 지금 먹고있는 것은?: 치킨
         * 지금 먹고있는 것은?: 떡볶이
         * */


        /** 요소 다 빼고 나서는 ? */
        System.out.println("내가 지금 먹고싶은건 " + queue);
        // 출력 : 내가 지금 먹고싶은건 []

    }
}
