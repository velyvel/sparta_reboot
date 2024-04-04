package src.com.company.week1.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_24265_알고리즘수업4 {

    public static void main(String[] args) throws IOException {
        /**
         *  1) 첫째 줄 수행횟수 출력
         *  2) 둘째 줄 수행횟수 최고차항??? : 틀렸지만 제출!
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //int n = Integer.parseInt(br.readLine());
        long n = Long.parseLong(br.readLine());
        int count = 0;
        //long count = 0;

        for(int i = 1; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                count++;
            }
        }

        /**
         * 시간복잡도라는 개념이 어려웠음 for 문을 진지하게 팠
         * n = 1
         * i = 1 -> 종료 (1회)
         * ====================
         * n = 2
         * i = 1, j : 2 -> 종료 (1회)
         * ====================
         * n = 3
         * i = 1, j : 2,3(2회)
         * i = 2, j = 3(1회) -> 종료 (2 + 1 3회)
         * ====================
         * n = 4
         * i = 1, j : 2,3,4(3회)
         * i = 2, j : 3,4(2회)
         * i = 3, j : 4(1회)
         * i = 4, j : 0(0회) -> 종료(3 + 2 + 1 6회)
         * ====================
         * 아.. 등차수열의 합...n(n−1)/2 -> 를 시간복잡도로 표현하면 가장 높은 항이 n2이니까 가장 높은 항만 고려한다..
         * 그래서 2로 고정
         * */
        System.out.println("총 수행된 수: " + count);
        System.out.println(2);
    }

}
