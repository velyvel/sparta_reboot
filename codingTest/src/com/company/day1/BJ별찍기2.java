package com.company.day1;

import java.util.Scanner;

public class BJ별찍기2 {

    /**
     * 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
     * case 1 : BufferedReader + System.out.println() 결과 : 5
     * case 2 : Scanner + System.out.println() 결과 : 1
     * ===================== 추가로 궁금해서 해봄.. =====================*
     * case 3 : BufferedReader + StringBuiler() 결과 2
     * case 4 : BufferedReader + BufferedWriter
     * 결과 :
     * **/

    public static void main(String[] args)  {

        // ===================== case 2 =====================

        long case2Before = System.currentTimeMillis();

        Scanner sc = new Scanner(System.in);
        int starNum2 = sc.nextInt();
        sc.close();

        for(int i = 0 ; i < starNum2 + 1; i++) {
            for(int j = 1; j <= i;  j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        long case2After = System.currentTimeMillis();

        System.out.println("2번 결과 : " + (case2After - case2Before)/1000);
    }
}
