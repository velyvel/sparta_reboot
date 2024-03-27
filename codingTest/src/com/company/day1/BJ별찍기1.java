package com.company.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ별찍기1 {

    /**
     * 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
     * case 1 : BufferedReader + System.out.println() 결과 : 5
     * case 2 : Scanner + System.out.println() 결과 : 1
     * ===================== 추가로 궁금해서 해봄.. =====================*
     * case 3 : BufferedReader + StringBuiler() 결과 2
     * case 4 : BufferedReader + BufferedWriter
     * 결과 :
     * **/

    public static void main(String[] args) throws IOException {

        long case1Before = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        for(int i = 0 ; i < N + 1; i++) {
            for(int j = 1; j <= i;  j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        long case1After = System.currentTimeMillis();
        System.out.println("1번 결과 : " + (case1After - case1Before)/1000);

    }
}
