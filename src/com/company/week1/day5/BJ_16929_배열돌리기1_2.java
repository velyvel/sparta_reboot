package src.com.company.week1.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 사람이 생각하는데로 왼 -> 아래 -> 오 -> 위 순서로 하려니 어려웠음, 안바뀐 숫자를 바꿔주는 로직으로 하니 ok..
public class BJ_16929_배열돌리기1_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int count = Integer.parseInt(input[2]);
        int squareCount = Math.min(N, M) / 2;


        int[][] array = new int[N][M];

        // array input
        for (int i = 0; i < N; i++) {
            String[] rowArr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(rowArr[j]);
            }
        }

        // 회전한 결과를 저장할 새로운 배열 생성
        //int[][] resultArray = rotateArray(array, N, M, squareCount, count);

        //7번 도는데, 밖에 네모부터.. 돌기 시작
        for(int i = 0; i < count; i++) {
            for(int j = 0; j < squareCount; j++) {
                // 현재 위치 저장(임시저장)
                int now = array[j][j];
                // 맨 위에 줄을 왼쪽으로 이동 : (k는 1부터 : 위치가 1,1 부터 시작이니까
                // 배열의 한 행을 왼쪽으로 한 칸씩 회전 첫째 줄 1,2,3,4, 였던 것 -> 2,3,4,4
                for(int k = j + 1; k < (M - j); k++) {
                    // 그러나 첫번째 행을 뺀 : 대신 아래 저장...
                    // j = 0 일때  array[0][0] 값 1을 = arr[0][1]에 저장
                    array[j][k - 1] = array[j][k];
                }
                // 두 번째 루프 수정 : j = 0
                // 위:
                for(int k = j + 1; k < (N - j); k++) {
                    array[k - 1][M - 1 - j] = array[k][M - 1 - j];
                }
                // 세 번째 루프 수정 : 오른쪽
                for(int k = M - 2 - j; k >= j; k--) {
                    array[N - 1 - j][k + 1] = array[N - 1 - j][k];
                }
                //for(int k = M -2 - j; k > j + 1; k--) {
                // 아래
                for(int k = N -2 - j; k >= j; k--) {
                    array[k + 1][j] = array[k][j];
                }
                // 지금 돈 것 중 arr[0,0]을 저장
                array[j+1][j] = now;
            }

        }

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 배열을 회전하는 함수
//    public static int[][] rotateArray(int[][] array, int N, int M, int squareCount, int count) {
//        int[] moveLeft = {0, 1, 0, -1};
//        int[] moveUp = {1, 0, -1, 0};
//
//        int[][] resultArray = new int[N][M];
//
//        // 회전 로직 : 왜 한번만 가고 멈추는가 ?
//        for (int c = 0; c < count; c++) {
//            for (int k = 0; k < squareCount; k++) {
//                int row = k;
//                int column = k;
//                // [0,0] 부터 밑으로 내리려고 하는데..
//                int first = array[k][k];
//                int index = 0;
//
//                while (index < 4) {
//                    int movedRow = row + moveLeft[index];
//                    int movedColumn = column + moveUp[index];
//
//                    if (movedRow < k || movedColumn < k || movedRow > N - 1 - k || movedColumn > M - 1 - k) {
//                        index++;
//                    } else {
//                        resultArray[row][column] = array[movedRow][movedColumn];
//                        row = movedRow;
//                        column = movedColumn;
//                    }
//                }
//                resultArray[k+1][k] = first;
//            }
//        }
//
//        return resultArray;
//    }

}
