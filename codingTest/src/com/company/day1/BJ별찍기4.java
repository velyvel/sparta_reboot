package com.company.day1;

import java.io.*;
import java.util.Scanner;

public class BJ별찍기4 {

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

        long case4Before = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int starNum4 = Integer.parseInt(br.readLine());
        br.close();

        for(int i = 0 ; i < starNum4 + 1; i++) {
            for(int j = 1; j <= i;  j++) {
                bw.write('*');
            }
            bw.newLine();
        }


        long case4After = System.currentTimeMillis();
        bw.flush();
        bw.close();

        System.out.println("4번 결과 : " + (case4After - case4Before)/1000);


    }
}
