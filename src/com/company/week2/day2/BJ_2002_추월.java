package src.com.company.week2.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 메모리 : 14256KB, 시간 132ms
 * 들어가는 차 큐, 나오는 차 큐랑 비교
 * 들어간 차 peek 랑 나오는 차 다르면 추월(count++) 그대로 진행하면 밀리니까
 * inQueue에 있는 비교한 차는 제거
 * 들어간 차 나온차 똑같으면 꺼내놓기(착한차들이니끼)
 --------------------------------------------------
 */

public class BJ_2002_추월 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 들어간 차 & 나온 차
        Queue<String> inQueue = new ArrayDeque<>();
        Queue<String> outQueue = new ArrayDeque<>();

        for(int i = 0; i < N; i ++) {
            inQueue.offer(br.readLine());
        }

        for(int i = 0; i < N; i++) {
            outQueue.offer(br.readLine());
        }

        int count = countQueueUnEqual(inQueue, outQueue);
        System.out.println(count);

    }

    public static int countQueueUnEqual(Queue<String> inQueue, Queue<String> outQueue) {

        int count = 0;
        while (!inQueue.isEmpty()) {
            String outCar = outQueue.poll();

            if(!inQueue.peek().equals(outCar)) {
                count++;
                // inqueue에 있는 추월한 차 제거해준다 -> 그래야 다음것부터 나가니까
                inQueue.remove(outCar);
            }
            else {
                inQueue.poll();
            }
        }
        return count;
    }
}
