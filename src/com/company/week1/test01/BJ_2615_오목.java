package src.com.company.week1.test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ_2615_오목 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [][] array = new int [19][19];

        // 좌표 저장 dequeue 선언!
        Deque<int[]> coordinate = new ArrayDeque<>();

        // arrayA input
        for (int i = 0; i < 19; i++) {
            String[] row = br.readLine().split(" "); // 각 행에 대한 입력을 공백으로 분리
            for (int j = 0; j < 19; j++) {
                array[i][j] = Integer.parseInt(row[j]); // 분리된 값을 arrayA에 저장
            }
        }

        for(int i = 0; i < 19; i++) {
            for(int j = 0; j < 19; j++) {
                if(array[j][j] ==1 || array[i][j] == 2) {
                    coordinate.add((new int[] {i, j}));
                    // 판별하는 로직 만들어 끼우기
                    winningRules(coordinate);
                }
            }
        }

        // 출력은
        System.out.println("이긴놈");
        System.out.println("좌표");


    }

    public static void winningRules(Deque<int[]> coordinate){

        while (!coordinate.isEmpty()){

            int[] startPoint = coordinate.poll();
            int xCoordinate = startPoint[0];
            int yCoordinate = startPoint[1];

            for(int i = 0; i < 5; i++) {

                // 좌표들 비교하면서 가로 세로 대각선 비교할 예정이였음...

            }

        }

    }

}
