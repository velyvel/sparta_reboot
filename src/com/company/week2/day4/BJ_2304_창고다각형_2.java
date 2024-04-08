package src.com.company.week2.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
/**
 * 메모리 : 15312KB, 시간 : 144ms
 * 입력값을 이차원 배열[인덱스][x좌표, y좌표]형식으로 받았다 : columns[index][2,4]
 * 1. 정렬 :입력받은 배열을 그림처럼 나열하기 위해(x좌표 기준으로 탐색할꺼니까)
 * 2. 현재 위치 :i (2,4 중 4)와 다음 위치: j(4,6 중 6) 의 높이 비교, 더 낮은거 나올 때 까지 반복 : columns[j][1]이런식으로..
 *  즉, 사이사이 값 넓이 찾아서 더해주는 식으로 구현함
 * */

public class BJ_2304_창고다각형_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //이차원 배열로 풀었다. x, y좌표 기록용
        int[][] columns = new int[N][2];

        // 입력 : columns[index][2,4] 이렇게 저장되게 -> columns[0][2,4]
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            // x좌표
            columns[i][0] = Integer.parseInt(input[0]);
            // y 좌표
            columns[i][1] = Integer.parseInt(input[1]);
        }

        //x 좌표를 기준으로 정렬하기(if (columns[i][0] > columns[i + 1][0]) : 바꿔치기
        Arrays.sort(columns, Comparator.comparingInt(x -> x[0]));
        // 그.. 네모 넓이 초기화
        int area = 0;
        // i 의 값이 안변하는 이유 : max로 잡아놓을 때만 바꿔야 네모를 그릴 수 있기 때문에
        for (int i = 0; i < N;) {
            int j = i + 1; // 현재 기둥 다음 기둥부터 시작
            int maxIndex = j; // 최대 높이의 기둥 인덱스

            // 현재 기둥보다 높이가 낮은 기둥이 나올 때까지 반복
            // j가 1000(범위) 안넘을때, [0][2,4]와 [1][4,6] -> 즉 4와 6을 비교 / 6,3을 비교
            while ((j < N) && (columns[i][1] > columns[j][1])) {
                // 최대 높이 바꿔치기 : 최대 높이 아직 6
                if (columns[maxIndex][1] < columns[j][1])
                    maxIndex = j;
                j++;
            }
            // 마지막 기둥의 경우
            if (j == N) {
                // 현재 기둥의 높이만큼 면적 추가
                area += columns[i][1];
                // 큰게 또 나올 경우
                if (maxIndex < N) {
                    area += columns[maxIndex][1] * (columns[maxIndex][0] - columns[i][0] - 1);
                }
                i = maxIndex;
            } else { // 다음 기둥이 있는 경우
                // 현재 기둥과 다음 기둥 사이의 너비 * 현재 기둥 높이로 면적 추가 2 * 4
                area += columns[i][1] * (columns[j][0] - columns[i][0]);
                i = j;
            }
        }
        System.out.println(area);
    }
}
