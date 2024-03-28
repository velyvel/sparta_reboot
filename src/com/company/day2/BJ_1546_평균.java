package src.com.company.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1546_평균 {
    public static void main(String[] args) throws IOException {
        /**
         * 최댓값 M, 점수 = 점수 / M * 100
         * 새로운 평균 구하기 : ((40+80+60) / 80 ) * 100 / 3 해주는 공식 이용해 구했다
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 시험 본 과목의 개수
        int N = Integer.parseInt(br.readLine());

        // 두 번째 줄에서 점수들을 공백을 기준으로 분리하여 읽어들임
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        // 최대 점수 저장공간
        int max = 0;
        // 평균 소수점으로 나와야 하니까 일단 double 형으로 선언해둠 큰박스로 만들어두
        double sum = 0.0;

        // 배열에 숫자 저장하면서 max 값 갱신
        for (int i = 0; i < N; i++) {
            // 점수 하나씩 가지고오기
            int score = Integer.parseInt(st.nextToken());
            //점수가 더 크면 max 값 치환
            if(max < score) {
                max = score;
            }
            sum += score;
        }

        System.out.println(((sum / max) * 100.0) / N);




    }
}
