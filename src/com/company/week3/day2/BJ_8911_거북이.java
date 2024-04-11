package src.com.company.week3.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 오늘의 교훈 : 문제를 잘 읽자, 거북이가 오른쪽, 왼쪽으로도 이동하는 줄 알고 한참 고생했다
 * 오른쪽 왼쪽은 돌려주기만 하자
 * 풀이 :
 *   1) F : 앞으로 가야 하니까 dx[0],dy[0], 거북이 이동 x, y 좌표도 움직여준다
 *   2) B : 뒤로 가야 하니까 앞으로 가야 하는것에 마이너스 붙여준다 (- dx[0], -dy[0]) 거북이 이동 x, y 좌표도 움직여준다
 *   1) L : 왼쪽으로 돌려주기 : 방향만 돌려준다 나는 index 라는 변수를 사용하고 있어 갱신 안되게 나머지값을 가져다가 씀
 *   1) R : 오른쪽으로 돌려주기 : 위랑 같다
 * */

public class BJ_8911_거북이 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = 0, y = 0;

            int minX = 0, minY = 0, maxX = 0, maxY = 0;
            // 북쪽
            int index = 0;

            String directions = br.readLine();
            for (char dir : directions.toCharArray()) {
                switch (dir) {
                    case 'F':
                        x += dx[index];
                        y += dy[index];
//                        x += dx[0];
//                        y += dy[0];
                        break;
                    case 'R':
//                        index = (index + 1);
                        index = (index + 1) % 4;
                        break;
                    case 'B':
//                        x += dx[2];
//                        y += dy[2];
                        x -= dx[index];
                        y -= dy[index];
                        break;
                    case 'L':
                        // 'L' 케이스에서는 방향만 변경하고 위치는 변경하지 않음
                        //index = (index + 3); : index 라는 변수 값이 바뀌어버려서 답이 안나옴
                        index = (index + 3) % 4;
                        break;
                }
                // 최소, 최대 x, y 좌표 업데이트
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }

            // 곱해주기
            int area = Math.abs(maxX - minX) * Math.abs(maxY - minY);
            System.out.println(area);
        }
    }
}
