package com.company.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ문자열반복 {

    public static void main(String[] args) throws IOException {
        //tokenizer < split <
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 개수
        int T = Integer.parseInt(br.readLine());
        // 반복
        int R;
        // 문자형 배열 strArr[0]: 반복횟수, strArr[1]: 반복문자열
        String[] strArr;
        // 문자열
        String S;

        for(int i = 0; i < T; i++) {
            strArr = br.readLine().split(" ");
            R = Integer.parseInt(strArr[0]);
            S = strArr[1];

            for(int j = 0; j < S.length(); j++) {
                for(int k = 0; k < R; k++) {
                    System.out.print(S.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
