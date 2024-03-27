package com.company.day1;

import java.io.*;
import java.util.StringTokenizer;

public class BJ주사위세개 {
    //BFS 쌩기초 ?

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n3 = Integer.parseInt(st.nextToken());

        int count;
        // 숫자 세개 같을 때 : 10000 + n * 1000
        if(n1 == n2 && n2 == n3) {
            bw.write((10000 + n1 * 1000) + "\n");
        }
        // 숫자 두개 같을 때
        else if(n1 == n2 || n2 == n3 || n1 == n3) {
            if(n1 == n2) {
                count = n1;
            } else if (n2 == n3) {
                count = n2;
            } else {
                count = n3;
            }
            bw.write((1000 + count * 100) + "\n");
        }
        else {
            count = Math.max(Math.max(n1,n2),n3);
            bw.write((count * 100) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();

    }
}
