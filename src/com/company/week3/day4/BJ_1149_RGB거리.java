//package src.com.company.week3.day4;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class BJ_1149_RGB거리 {
//    /**
//     * 양 옆의 집끼리는 색깔 같지 않게 ( 빨 - 초 - 빨) 가능
//     * */
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        // 집 몇채?
//        int N = Integer.parseInt(br.readLine());
//
//        // 배열들에 넣어주기
//        // RGB 초기값 설정해주기 R : 0/ G : 1/ B : 2
//        int R = 0, G = 1, B = 2;
//        int[][] house = new int[N][3];
//        int[][] memo = new int[N][3];
//        char[] colors = {'R','G','B'};
//
//        StringTokenizer st;
//        for (int i = 0; i < N; i++) {
//
//            st = new StringTokenizer(br.readLine());
//            house[i][R] = Integer.parseInt(st.nextToken());
//            house[i][G] = Integer.parseInt(st.nextToken());
//            house[i][B] = Integer.parseInt(st.nextToken());
//        }
//
//        // 비교할 배열도 초기화한다.
//        memo[0][R] = house[0][R];
//        memo[0][G] = house[0][G];
//        memo[0][B] = house[0][B];
//
//        for(char color : colors) {
//            switch (color) {
//                case 'R' : memo[N][R] = calculateMin()
//            }
//        }
//
//    }
//}
//
