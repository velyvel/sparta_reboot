package src.com.company.week2.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1966_프린터큐 {
    /**
     * Queue 사용해 풀었습니다.
     * 메모리 : 15368KB, 시간 152ms
     --------------------------------------------------
     * 1. 입력값을 받는다
     * 2. 문서의 중요도를 넣는 큐(importanceQueue) :인쇄 대기열의 역할
     * 3. 궁금한 문서 위치(queryList)
     *  - 특정 문서의 위치 표시.
     * 4. 각 문서가 궁금한 문서(isHigh)인지 아닌지를 true 또는 false로 표시
     *  - 해당 문서가 인쇄될 차례가 되었는지를 판별하는 데 사용.
     *  - 중요도가 높은 문서부터 순차적으로 출력,
     *  - 동일한 중요도의 문서가 여러 개 있을 경우 먼저 큐에 추가된 문서가 먼저 인쇄
     *  - 사용자가 궁금해하는 문서가 인쇄될 때까지 이 과정을 반복(while문).
     * 5. 출력 : importance 변수에 계산된 중요도(출력 순서)를 넣어 출력
     --------------------------------------------------
     *  - 마지막 예제 : 1 1 9 1 1 1 가 어려웠다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 몇번 ?
        int N = Integer.parseInt(br.readLine());


        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            // 문서의 개수
            int sheet = Integer.parseInt(input[0]);
            // 궁금한 문서 몇번째인지 ? (위치)
            int count = Integer.parseInt(input[1]);

            // 중요도
            String[] importanceArray = br.readLine().split(" ");
            // 중요도 구하는 함수
            int importance = calculateImportance(sheet, count, importanceArray);
            // 출력
            System.out.println(importance);
        }

    }

    public static int calculateImportance(int sheet, int count, String[] importanceArray) {

        // 문서의 중요도를 넣는 큐
        Queue<Integer> importanceQueue = new LinkedList<>();
        // 궁금한 문서 위치 표시용
        LinkedList<Boolean> countList = new LinkedList<>();

        // 중요도 큐에 넣고, 궁금한 문서 위치 표시하기
        for(int i = 0; i < sheet; i++) {
            importanceQueue.add(Integer.parseInt(importanceArray[i]));
            countList.add(i == count);

        }

        int printCount = 0;
        // 큐에 내용이 있을때만 반복
        while (!importanceQueue.isEmpty()) {
            // 지금 문서의 중요도
            int current = importanceQueue.poll();
            // 궁금한 문서인가 ?
            boolean isCount = countList.poll();

            // 지금 문서보다 중요한 문서가 있는가?
            boolean isHigh = false;
            for(int higher : importanceQueue) {
                if(higher > current) {
                    isHigh = true;
                    break;
                }
            }

            if(isHigh == true) {
                // 중요한 문서 있으면 큐의 끝과 리스트의 끝에 다시 추가(중요한 거 먼저 뽑아야 하니까)
               importanceQueue.add(current);
                countList.add(isCount);
            }
            else {
                // 지금 문서 출력
                printCount++;
                if(isCount == true) {
                    // 지금 문서가 궁금한 문서인지 처리 : 출력된 문서의 수 반환
                    return printCount;
                }
            }

        }

        // 궁금한 문서가 출력될 때 까지 반환
        return printCount;
    }
}
