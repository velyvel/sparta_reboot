package src.com.company.week2.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2346_풍선터트리기_2 {
    /**
     * 시간부족으로.. 변수명 이상한거 이해부탁드려요
     * deque를 사용해 풀었는데, 풍선을 썼다 지웠다 하기때문입니다.
     * 오늘 깨달은 점은 자료형을 Node로 두고 클래스로 따로 빼서 쓰면 필요한 정보들을 다 담아두고 그때그때
     * 뽑아 사용할 수 있다는 점입니다. 공부할게
     --------------------------------------------------
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<int[]> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for( int i = 0; i < N; i++) { //deque에 [1,3], [2,2], [3,1], [4,-3], [5,-1]
            // map 쓰고 싶었다... 풍선의 숫자와 풍선의 value를 넣어준다..
            int[] balloon = {i + 1, Integer.parseInt(st.nextToken())};
            deque.add(balloon);
        }

        StringBuilder sb = new StringBuilder();
        // 마지막 풍선이 남을 때 까지 반복 : 1번은 먼저 터트리니까 일단빠져!
        while (deque.size() > 1) {
        //while (!deque.isEmpty()) {
            // 맨 앞 풍선 나와라!
            int[] balloon2 = deque.pollFirst();
            // 풍선 번호 sb애 추가해두기(1번 풍선)
            sb.append(balloon2[0]).append(" ");
            // 다음 풍선의 거리만큼 오른쪽
            int nextBalloon = balloon2[1];
            // 오른쪽 : 3번 타기
            if(nextBalloon>0) {
                for(int j = 1; j < nextBalloon; j++) {
                    deque.offerLast(deque.pollFirst());
                }
            }
            else if(nextBalloon < 0){
                for(int j = nextBalloon; j != 0; j++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }
        // 1번 맨 앞에 추가
        sb.append(deque.poll()[0]);
        System.out.println(sb);
        }

}
