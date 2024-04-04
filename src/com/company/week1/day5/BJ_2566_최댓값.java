package src.com.company.week1.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2566_최댓값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 최대값
        //int max = 0;
        int max = -1;
        // 행
        int row = 0;
        // 열
        int coloum = 1;
        int[][] array = new int[9][9];

        for(int i = 0; i < 9; i++) {
            String[] rowArr = br.readLine().split(" ");
            for(int j = 0; j < 9; j++) {
                array[i][j] = Integer.parseInt(rowArr[j]);

                if(max < array[i][j]){
                    max = array[i][j];
                    // 인덱스 값이라 1 더해주기
                    row = i + 1;
                    coloum = j + 1;
                }
            }
        }

        // 출력1 : max
        System.out.println(max);
        // 출력2 : 위치 : 줄(열)번호 + " " + 행번호
        System.out.println(row + " " + coloum);


    }
}
