package src.com.company.week2.day1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {
    public static void main(String[] args) {
        // Deque 선언 (ArrayDeque 사용)
        Deque<Integer> deque1 = new ArrayDeque<>();

        // Deque에 요소 추가 (양쪽 끝에 추가)
        deque1.offerFirst(1); // 맨 앞에 추가
        deque1.offer(2);
        deque1.offer(3);
        deque1.offerLast(4);  // 맨 뒤에 추가


        // Deque 출력
        System.out.println("데큐 1번: " + deque1);
        // 출력 : 데큐 1번: [1, 2, 3, 4]

        // Deque1에서 요소 제거 (양쪽 끝에서 제거)
        int pollFirst = deque1.pollFirst(); // 맨 앞에서 제거
        int pollLast = deque1.pollLast();   // 맨 뒤에서 제거

        // 제거된 요소 출력
        System.out.println("첫번째로 제거된것 ? " + pollFirst);
        // 출력 : 첫번째로 제거된것 ? 1
        System.out.println("마지막 제거 요소 ? " + pollLast);
        // 출력 : 마지막 제거 요소 ? 4

        // 남아있는 deque ?
        System.out.println("맨 앞 맨 뒤 제거 후?  " + deque1);
        // 출력 : 맨 앞 맨 뒤 제거 후?  [2, 3]


        System.out.println("============================================");

        Deque<String> deque2 = new LinkedList<>();

        deque2.addFirst("I am first");
        deque2.add("first 다음으로 넣음");
        deque2.addLast("I am Last");


        // Deque 출력
        System.out.println("데큐 2번: " + deque2);
        // 출력 : 데큐 2번: [I am first, first 다음으로 넣음, I am Last]

        // Deque2에서 요소 제거 (양쪽 끝에서 제거)
        String removeFirst = deque2.removeFirst(); // 맨 앞에서 제거
        String removeLast = deque2.removeLast();   // 맨 뒤에서 제거

        // 제거된 요소 출력
        System.out.println("첫번째로 제거된것 ? " + removeFirst);
        // 출력 :첫번째로 제거된것 ? I am first
        System.out.println("마지막 제거 요소 ? " + removeLast);
        // 출력 : 마지막 제거 요소 ? I am Last

        // 남아있는 deque ?
        System.out.println("맨 앞 맨 뒤 제거 후?  " + deque2);
        // 출력 : 맨 앞 맨 뒤 제거 후?  [first 다음으로 넣음]

    }
}
