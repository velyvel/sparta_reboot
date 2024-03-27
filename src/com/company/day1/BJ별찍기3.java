package com.company.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ별찍기3 {

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


        // ===================== case 3 =====================

        long case3Before = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int starNum3 = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < starNum3 + 1; i++) {
            for(int j = 1; j <= i;  j++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.print(sb);



        long case3After = System.currentTimeMillis();

        System.out.println("3번 결과 : " + (case3After - case3Before)/1000);

    }
}
