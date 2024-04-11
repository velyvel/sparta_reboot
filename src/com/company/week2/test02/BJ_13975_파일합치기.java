package src.com.company.week2.test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_13975_파일합치기 {
    public static void main(String[] args) throws IOException {

        // 누적합 구하기(작은수부터 정렬해 더해감) : Arrays.sort 대신 PriorityQueue
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트케이스의 수
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            // 챕터 수
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 우선순위 큐에 파일 크기 저장
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < K; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            // 누적합 구하기
            long sum = 0;
            // 누적합은 파일이 두개 있어야 해서.. isEmpty 는 null pointer 난다.
//            while (!pq.isEmpty()) {
            while (pq.size() > 1) {
                long chapter1 = pq.poll();
                long chapter2 = pq.poll();
                // 앞 뒤 파일 계속 합한거 임시저장
                long mergeCost = chapter1 + chapter2;
                sum += mergeCost;
                pq.add(mergeCost);
            }
            System.out.println(sum);
        }
    }
}
