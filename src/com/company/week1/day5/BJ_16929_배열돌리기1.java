package src.com.company.week1.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16929_배열돌리기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int count = Integer.parseInt(input[2]);
        int squareCount = Math.min(N, M) / 2;

        int[][] array = new int[N][M]; // 수정된 부분

        // array input
        for (int i = 0; i < N; i++) {
            String[] rowArr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(rowArr[j]);
            }
        }

        // 회전한 결과를 저장할 새로운 배열 생성
        for (int i = 0; i < count; i++) {
            rotateArray(squareCount, N, array);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotateArray(int squareCount, int N, int[][] array) {
        int[] moveLeft = {0, 1, 0, -1};
        int[] moveUp = {-1, 0, 1, 0}; // 위, 오른쪽, 아래, 왼쪽으로 이동

        for (int i = 0; i < squareCount; i++) { // 수정된 부분
            int x = i;
            int y = i;
            int temp = array[x][y]; // 첫번째 값을 담아놓고 연산 후에 넣어준다.

            int index = 0;

            while (index < 4) {
                int nx = x + moveUp[index];
                int ny = y + moveLeft[index];

                // 회전할 위치가 배열의 범위를 벗어나는지 확인
                if (nx < i || ny < i || nx >= N - i || ny >= array[0].length - i) {
                    index++;
                } else {
                    array[x][y] = array[nx][ny];

                    x = nx;
                    y = ny;
                }
            }
            array[i + 1][i] = temp;
        }
    }

}
