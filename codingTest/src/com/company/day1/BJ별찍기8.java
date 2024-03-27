package com.company.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ별찍기8 {
    // 입출력 거꾸로 n = 1이면 * 나머지 공벡 + append 이 배열 거꾸로 뒤집은거
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // n이 5라면 10까지니까 : -1 해주는 이유는 ?
        int length = n * 2 -1;

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(int i = 1; i <= length; i++) {
            if(i <= n) {
                for(int j = 1; j <=i; j++) {
                    sb1.append("*");
                }
                for(int k = 1; k <= n-i; k++) {
                    sb1.append(" ");
                }
            }
            else if( i > n) {
                for(int j = 1; j <= (2 * n - i); j++) {
                    sb1.append("*");
                }
                for(int k = 1; k <= -(n - i); k++) {
                    sb1.append(" ");
                }
            }

            sb2.append(sb1.toString()).append(sb1.reverse().toString()).append("\n");
            sb1.delete(0,sb1.length());
         }
        System.out.println(sb2);

    }

}
