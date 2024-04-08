package src.com.company.week2.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



public class BJ_3079_입국심사 {
    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // 심사대 갯수 N과 인원 수 M을 입력 받음
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]); // 심사대 갯수
            int M = Integer.parseInt(input[1]); // 인원 수

            // 각 심사대별 걸리는 시간을 저장하는 배열
            long[] time = new long[N];

            // 가장 오래 걸리는 심사 시간을 저장하는 변수
            long max = 0;

            // 결과를 저장하는 변수
            long result = 0;

            // 각 심사대별 걸리는 시간을 입력 받으면서 가장 오래 걸리는 시간을 찾음
            for(int i = 0; i < N; i++) {
                time[i] = Integer.parseInt(br.readLine());
            }
            max = time[N-1];

            // 걸리는 시간의 최대값은 가장 오래 걸리는 검사 시간 * 인원 수
            long high = M * max;
            long low = 0;

            // 최소시간이 최대값과 같아질때까지 반복
            while(low <= high) {
                long middle = (high + low) / 2;

                long count = 0; // mid시간 만큼 걸릴 때 통과되는 인원 수

                // 각 심사대별로 통과되는 인원 수를 계산
                for(int i = 0; i < N; i++) {
                    count += middle / time[i];

                    if(count >= M) break; // 통과해야되는 인원을 채웠으면 더이상 계산하지 않고 탈출
                }

                // 통과되는 인원 수에 따라 범위를 조절
                if(count >= M) {
                    result = middle; // 모든 인원이 통과될 때의 시간을 저장
                    high = middle - 1; // 최대 범위를 줄임
                }
                else {
                    low = middle + 1; // 최소 범위를 늘림
                }
            }

            // 결과 출력
            System.out.println(result);
        }
}
