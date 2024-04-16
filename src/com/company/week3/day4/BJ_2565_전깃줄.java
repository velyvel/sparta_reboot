package src.com.company.week3.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2565_전깃줄 {
    /**
     * 메모리 : 14172KB, 시간 120ms
     * 시작타워 중심으로 정렬시킨다음, 그 도착지점이 작은 경우(선이 오른쪽 위로 올라가는 경우
     * */
    static Cable[] cables;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        cables = new Cable[N];
        memo = new int[N];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            cables[i] = new Cable(start, end);
        }
        //바꾸는 전깃줄 count 하는 함수
        int maxCount = untangledCables();

        // 지금까지 꼬인 것만 구했으니 안꼬인것도 구해준다
        int count = N - maxCount;
        System.out.println(count);
    }

    private static int untangledCables() {
        // 시작점 기준으로 정렬
        Arrays.sort(cables);

        int maxCount = 0;
        for (int i = 0; i < cables.length; i++) {
            // 전깃줄이 일자로 쪽 다 나열되어 있는 경우
            memo[i] = 1;

            for (int j = 0; j < i; j++) {
                if (cables[j].end < cables[i].end) {
                    System.out.println(cables[j].end + " < " + cables[i].end + " , " + j + "번째 전깃줄을 포함.");
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                } else {
                    System.out.println(cables[j].end + " >= " + cables[i].end + " , " + j + "번째 전깃줄 제거.");
                }
            }
            System.out.println("현재까지의 길이: " + memo[i]);
            maxCount = Math.max(maxCount, memo[i]);
        }
        return maxCount;
    }
}

class Cable implements Comparable<Cable> {
    int start;
    int end;

    public Cable(int start, int end){
        this.start = start;
        this.end = end;
    }
    // Arrays.sort 쓰기 위해..
    @Override
    public int compareTo(Cable cable) {
        return this.start - cable.start;
    }
}
