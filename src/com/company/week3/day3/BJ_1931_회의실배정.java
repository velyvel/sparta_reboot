package src.com.company.week3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1931_회의실배정 {
    /**
     * 메모리 : 41780KB, 시간 512ms
     * Timeline 객체에 회의 시작, 종료 시간을 저장할 공간을 만들어둔 후 우선순위 큐에 저장한다.
     * 회의 종료시간이 같을 경우에는 시작시간을 비교하여 시작시간이 빠른 순서대로 저장한다.
     * 현재 회의 시작 시간이 마지막으로 선택된 회의의 종료 시간 이후라면 추가(count변수를 update 하면서 구한다)
     * */

    static int N;
    static PriorityQueue<Timeline> timelines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 회의의 종료 시간을 기준으로 우선순위 큐를 정렬하는 comparator 설정
        timelines = new PriorityQueue<>((timeline1, timeline2) -> {
            if (timeline1.end == timeline2.end) {
                // 종료 시간이 같으면 시작 시간을 기준으로 정렬
                return timeline1.start - timeline2.start;
            }
            // 기본적으로는 종료 시간을 기준으로 정렬
            return timeline1.end - timeline2.end;
        });

        // 값 넣기
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            timelines.add(new Timeline(start, end));
        }

        // 회의실을 사용할 수 있는 최대 횟수를 계산
        int count = calculateTimelines(0, 0);
        System.out.println(count);
    }

    /**
     * 회의실 사용 가능한 최대 회의 수를 계산, 최대 사용 가능한 회의 수 반환
     * count:  현재까지 카운트된 회의 수, lastEndTime: 마지막으로 선택된 회의의 종료 시간
     */
    private static int calculateTimelines(int count, int lastEndTime) {
        while (!timelines.isEmpty()) {
            // 현재 회의의 시작 시간이 마지막으로 선택된 회의의 종료 시간 이후라면 추가 가능
            Timeline current = timelines.poll();
            if (current.start >= lastEndTime) {
                lastEndTime = current.end; // 종료 시간 업데이트
                count++; // 회의 수 증가
            }
        }

        return count;
    }


    static class Timeline {
        int start;
        int end;

        public Timeline(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
