package com.company.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2007년 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

         int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};
         String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        int n = 0;
        for (int i = 0; i < m; i++) {
            n += months[i];
        }
        n += d-1;
        System.out.print(days[n%7]);
    }

}
