package src.com.company.week2.day1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class DequeExeptionExample {
    public static void main(String[] args) {
        // Deque 선언 (ArrayDeque 사용)
        Deque<Integer> deque = new ArrayDeque<>();

        // 요소 추가
        deque.addFirst(1);
        deque.addFirst(2);
        System.out.println("Deque: " + deque);

        // removeFirst() 메서드를 사용하여 요소 제거
        int removedElement = deque.removeFirst();
        System.out.println("Removed element using removeFirst(): " + removedElement);
        System.out.println("Deque after removeFirst(): " + deque);

        // pollFirst() 메서드를 사용하여 요소 제거
        Integer polledElement = deque.pollFirst();
        System.out.println("Polled element using pollFirst(): " + polledElement);
        System.out.println("Deque after pollFirst(): " + deque);

        // Deque가 비어있는 경우 removeFirst()와 pollFirst()의 동작 비교
        System.out.println("Removing element from empty deque:");
        try {
            int removedElement2 = deque.removeFirst(); // Deque가 비어있는 경우 NoSuchElementException 발생
        } catch (NoSuchElementException e) {
            System.out.println("Caught exception: " + e);
        }

        Integer polledElement2 = deque.pollFirst(); // Deque가 비어있는 경우 null 반환
        System.out.println("Polled element from empty deque using pollFirst(): " + polledElement2);
    }
}
