package src.com.company.week1.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_24267_알고리즘수업6 {
    public static void main(String[] args) throws IOException {
        // for 문 넣고 돌렸더나 시간초과 떴음 : 문제 제한조건 확인하니

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        int count = 0;
//        시간 초과로 인해 주석걸어둠
//        for(int i = 1; i <= n-2; i++){
//            for(int j = i+1; j <= n-1; j++){
//                for(int k = j+1; k <= n; k++){
//                    count++;
//                }
//            }
//        }
        /** 카드 n장 주어졌을 때 3장뽑기(왜? for문이 3번 돌고 있으니까!
         * n!/(3! * (n-3)!)  : 여기서는 무조건 3장으로 고정되어 있으므로
         * (n * (n-1)*(n-2)*(n-3)!) / 3! * (n-3)!
         * 이거 약분 약분 하면 -> n*(n-1) * (n-2) / 3! => 3! 는 3*2*1
         */
        System.out.println(n * (n - 1) * (n -2) / 6);
        // 이건 for문을 몇번 반복해 ? 의 의미였고
        System.out.println(3);
    }

}
