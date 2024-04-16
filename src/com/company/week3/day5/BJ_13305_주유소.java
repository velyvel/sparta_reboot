package src.com.company.week3.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13305_주유소 {
    /**
     * 메모리 : 36100KB, 시간 : 364ms
     * 거리와 리터의 범위가 1,000,000,000 까지라 자료형 long 선택함
     * 최소비용 : 기름값 * 남은거리로 구했다
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        long[] distances = new long[N-1];  // 각 도시 사이의 거리
        long[] costs = new long[N];        // 각 도시의 기름 가격

        // 도시 간 거리 정보 입력 받기
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N - 1; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }

        // 기름 가격 정보 입력 받기
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            costs[i] = Long.parseLong(st.nextToken());
        }

        long totalCost = 0;
        long minCost = costs[0];  // 처음 도시의 기름 가격으로 초기화

        for (int i = 0; i < N - 1; i++) {
            if (costs[i] < minCost) {
                minCost = costs[i];  // 더 저렴한 기름 가격 발견 시 갱신
            }
            totalCost += minCost * distances[i];  // 현재 기름 가격으로 다음 도시까지 이동 비용 계산
        }

        System.out.println(totalCost);

    }
}
