package src.com.company.week1.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2738_행렬덧셈 {
    public static void main(String[] args) throws IOException {
        // 2차원 배열 for문 두번 안쓰는 방법은 ?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int [][] arrayA = new int[N][M];
        int [][] arrayB = new int[N][M];
        int [][] resultArray = new int[N][M];

        // arrayA input
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" "); // 각 행에 대한 입력을 공백으로 분리
            for (int j = 0; j < M; j++) {
                arrayA[i][j] = Integer.parseInt(row[j]); // 분리된 값을 arrayA에 저장
            }
        }

        // arrayB input
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" "); // 각 행에 대한 입력을 공백으로 분리
            for (int j = 0; j < M; j++) {
                arrayB[i][j] = Integer.parseInt(row[j]); // 분리된 값을 arrayB에 저장
            }
        }

        // resultArray에 저장 + 연산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                resultArray[i][j] = arrayA[i][j] + arrayB[i][j];
                System.out.print(resultArray[i][j] + " ");
            }
            //붙어서 나와서 추가
            System.out.println();
        }

    }
}
