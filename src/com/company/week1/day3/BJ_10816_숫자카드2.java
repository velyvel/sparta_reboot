package src.com.company.week1.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10816_숫자카드2 {
    public static void main(String[] args) throws IOException {
         /** 입력 :
          *  N /  내가 가지고 있는 숫자카드 종류 / M(출력해야 할 카드 개수) / 비교해야 할 숫자배열
          * 풀이 1. 배열로 풀기
          * 풀이 2. 이분탐색으로 풀기 : 아쉬움: 시간상,. while 루프를 매번 탄다.. high 랑 low 를 분리했으면 하는 고민
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 입력 값(카드의 개수) : 첫째 줄 읽음
        int N = Integer.parseInt(br.readLine());
        // 두번째 입력값 들어갈 자리(카드의 개수와 같다) N = 10으로 들어왔음
        int[] arrN = new int[N];

        //split 사용하려다.. 간편하게 사용하여고 사용 : 둘쨰 줄 읽음
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            // 반복문 돌면서 값 넣어주가
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        // 이분탐색(반으로 쪼개 오른쪽 왼쪽 가야하니까 오름차순 정렬(작은 수 -> 큰 수) arrN = {-10, -10, 2, 3, 3, 6, 7, 10, 10, 10}
        Arrays.sort(arrN);

        // 비교해야 할 숫자카드의 개수, M=8
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 네번째 입력값 넣기 비교해야 할 숫자 배열 : st 안에는 str 변수로 10 9 -5 2 3 4 5 -10 들어있음
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            // 찾아야 할 번호 : number = 10
            int number = Integer.parseInt(st.nextToken());
            //high : number보다 큰 값이 처음으로 나타나는 위치
            int high = searchNum(arrN, number, false);
            //low : number 가 처음 나오는 수.. 사실 생각대로라면 변수 거꾸로 쓰고 싶다
            int low = searchNum(arrN, number, true);
            /** low와 high를 찾은 후 그 차이를 구하고 StringBuilder에 추가
             * 차이를 구하는 이유는 : high, low 변수 주석에 걸어두었음(처음 나온 수 ~ 다른 수 사이의 개수 나와서)
             * 고민.. 왜 나는 개수세기 할 때  + 1 을 습관적으로 하는가.. 기준점 잡는 방법이 있는가? 질문
             * 문제에서 출력할 때 공백으로 구분해 출력하라고 한다.*/
            sb.append(high - low).append(' ');
        }
        System.out.println(sb);
    }


    // 중복되는 값이 있는지 찾기 위한 메소드.. 매개변수 isTarget 이 잘 파악이 되지 않아 isLow라고 변경
    public static int searchNum(int[] arrN, int number, boolean isLow) {
//    public static int searchNum(int[] arrN, int number, boolean isTarget) {
        int start = 0;
        int end = arrN.length; //arrN: {-10, -10, 2, 3, 3, 6, 7, 10, 10, 10}

        /** if 문 사용하면 안되는 이유 : 계속 0, 0, 0, 0 이 나와서.. 디버깅 돌렸는데
         * number 을 정하고 탐색 대상이 있는 범위를 정하고 시작(배열 전체 포함).
         * 반복적으로 범위를 줄이기 위해
         */
        //if (start < end) { 1. start : 0, end 10, middle: 5
        while (start < end) {
            int middle = (start + end) / 2;

            /** 조건 걸다가 눈물이 차오른다 익숙해지...자
             * 1. 왼쪽으로 갈 조건을 찾기
             * - 중간 값이 번호보다 큰 경우
             * - 왼쪽값(low)로 갈 때 true 조건을 만족해야한다
             * - 내가 찾으려는 값이 중간값 일 경우
             * */
//            if(arrN[middle] > number || (isTarget && arrN[middle] == number)) {arrN[5] : 6, number은 10이라서 start 6으로 바뀜
            if(arrN[middle] > number || (isLow && arrN[middle] == number)) {
                // 여기서 값 바꿔버렷!
                end = middle;
            } else {
                // (중간값을 제외하기 위함) 중간값보다 클 경우에는 오른쪽으로 한 칸 이
                start = middle + 1;
            }
        }
        return end;
    }






}
