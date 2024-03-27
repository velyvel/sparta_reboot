package com.company.day0;

import java.util.Scanner;
public class Main {
    /**
     * N개 정수 구하기
     * **/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 제공된 숫자
        int number = sc.nextInt();
        // 두번째 줄 숫자배열 초기화
        int arr[] = new int[number];

        // 순회하면서 두번째줄에 입력받은 원소 넣어준다
        for(int i = 0; i < number; i++) {
            arr[i] = sc.nextInt();
//            System.out.println(arr[i]);
        }

        //비교할 수
        int original = sc.nextInt();
        // 비교할 값 몇개인지 저장할 공간
        sc.close();

        int count = 0;
        for(int j = 0; j < arr.length; j++) {
            if(original == arr[j]) {
                count++;
            }
        }
//        System.out.println( "카운트 " + count);
        System.out.println(count);
    }
}

