package src.com.company.week2.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_19638_센티 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        // 인구수
        int N = Integer.parseInt(input[0]);
        // 센티 키
        int centiHeight = Integer.parseInt(input[1]);
        // 뿅망치 횟수제한
        int limit = Integer.parseInt(input[2]);
        // 가장 큰 키 저장
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++) {
            priorityQueue.offer(Integer.parseInt(br.readLine()));
        }

        int min;
        // 뿅망치 횟수만큼 때리기
        for(min = 0; min < limit; min++) {
            // 가장 큰 사람이 센티보다 작으면 멈춤
            if(priorityQueue.peek() < centiHeight) {
                break;
            }
            // 가장 큰 사람이 1보다 클때만 반으로 줄어들기(반복)
            else if(priorityQueue.peek() > 1) {
                int half = priorityQueue.poll() / 2;
                priorityQueue.offer(half);
            }
        }

        // 출력초과라 바꿔줌
        // 센치가 가장 큰 거인보다 크면
        if(priorityQueue.peek() < centiHeight) {
            System.out.println("YES"+ "\n" + min);
        }
        else {
            System.out.println("NO" + "\n" + priorityQueue.peek());
        }

        }

    }