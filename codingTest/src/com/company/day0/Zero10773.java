package com.company.day0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Zero10773 {

    public static void main(String[] args) {

        /**
         * 르탄이 : 배열에서 0 앞에 숫자 빼고 누적합 구하기
         * 10
         * 1 3 5 4 0 0 7 0 0 6
         * **/

//        // 풀이 1 : arrayList로 풀기
        Scanner sc = new Scanner(System.in);
//
//        // 첫번째 스캐너의 값 : 배열의 개수
        int count = sc.nextInt();
        // 공간 만들어두기: arrayList로 할꺼임 빼고 추가하고 할꺼나까 -> 순회하면서 추가;
        List<Integer> numbers = new ArrayList<Integer>();
        // 출력한 sum 변수
        int sum = 0;

        for (int i = 0; i < count; i++) {
            // 재현이가 부르는 숫자 넣기
            int number = sc.nextInt();
            // 0 아닌것만 리스트 추가
            if(number != 0) {
                numbers.add(number);
            }

            if(number == 0) {
                numbers.remove(numbers.size() -1);
            }
        }

        System.out.println("최종 배열" + numbers.toString());

        // 최종 : sum 구하기
        for(int number : numbers) {
            sum += number;
        }
        System.out.println(sum);

        // 풀이 2 : Stack(자료구조) 사용
//        Stack<Integer> stack = new Stack<Integer>();
//
//        for(int i = 0; i < count; i++) {
//            int number = sc.nextInt();
//
//            if(number == 0) {
//                stack.pop();
//            } else {
//                stack.push(number);
//            }
//        }
//
//        int sum = 0;
//        for(int i : stack) {
//            sum += i;
//        }
//        System.out.println(sum);
    }
}
