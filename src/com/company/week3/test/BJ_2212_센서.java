package src.com.company.week3.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2212_센서 {
    /**
     * 메모리 : 16640KB, 시간 : 216ms
     * 연습할 때 풀었던 행복유치원과 비슷하게 풀었다..거리들의 차이 오름차순 정렬하고 큰 것 부터 잘라줬다
     * */
    static int N, K;
    static int[] sensors;
    // reverseOrder 시용하기 위헤..
    static Integer[] distances ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 센서
        K = Integer.parseInt(br.readLine()); // 집중국
        sensors = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        int sum = makeMinDistance();
        System.out.println(sum);

    }

    private static int makeMinDistance() {
        Arrays.sort(sensors);
        // 센서 사이사이 배열(파티션, 그래서 N-1개 필요함
        distances = new Integer[N - 1];
        for(int i = 0; i < N - 1; i++){
            // 거리배열 값 넣기 2번 노드 - 1번 노드
            distances[i] = sensors[i + 1] - sensors[i];
        }
        Arrays.sort(distances, Collections.reverseOrder());

        int sum = 0;
        for(int i = K - 1; i < N - 1; i++) {
            sum += distances[i];
        }
        return sum;
        /**
         * 파티션 설치 로직과 비슷하게 풀었다
         * 1) distance 배열에 각 노드간 거리를 저장해둔다
         * 2) 내림차순(큰 수) 정렬해준다, 왜냐면 멀면 수신가능영역 길이가 저엄점 길어지니까
         * 3) K-1, N-1
         *  - k-1 : distance 배열 기준 인덱스라 k-1, 실제 기지국 개수와 인덱스 맞춰주기
         *  - N-1 : 센서 사이들 거리보다 하나 적게.. 왜냐면 거리배열 기준이니까
         * */
    }

}