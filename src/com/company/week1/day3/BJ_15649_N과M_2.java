package src.com.company.week1.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15649_N과M_2 {
    /**
     * 1~N까지 자연수 중에서 "중복 없이" M개를 고른 수열
     * 1 ≤ M ≤ N ≤ 8 : 여기서 M은 N보다 같거나 작다(N이 큰수), N부터 주어짐
     * 출력조건 : "124~~" , 각 수열 숫자 공백구분, 다른 수열 개행문자("\n")
     */

    public static void main(String[] args) throws  IOException {

        /**
         * 알고리즘 : 백트래킹(재귀함수랑 차이가 뭐지? 질문하기) : 모든 조합 찾아 출력하기
         * 질문 2) 전역변수로 빼 두는것의 이점(코딩테스트 시?)
         * 대표 예시: 깃허브에 올려놓음(https://github.com/velyvel/sparta_reboot/blob/main/src/com/company/day3/%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9_%EC%98%88%EC%8B%9C.java)
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 3
        int N = Integer.parseInt(st.nextToken());
        // 2
        int M = Integer.parseInt(st.nextToken());
        //[0,0] 인 상태
        int[] arr = new int[M];
        //[false, false, false] 인 상태
        boolean[] isVisited = new boolean[N];

        combineNumbers(M, N,0, arr, isVisited);

    }

    public static void combineNumbers(int M, int N, int count, int[] arr, boolean[] isVisited){
        StringBuilder sb = new StringBuilder();
        /** 나의 의도 : 선택한개 개수(count)를 증가시켜 최댓값 M(2)이 되면 종료
         * 이유 : N(4)개의 숫자 중에서 M(2)개를 선택하여 조합만드려고..
         */

        /**
         * 1. count 가 0 이고 M이 2 이기 때문에 for문 탄다
         * 2. (1-0 종료 후 올라옴) count 가 1 이 된 상황 -> 다시 포문으로
         * 3. (1-1 종료 후 올라옴) count 가 2 가 된 상황 -> if 아래 for 문 탄다 현재 arr : {1,2} 인 상황이다.
         *  - sb에 쓰기 : 1 2
         *  - 출력 후 리턴 ->  마지막 isVisited[i] false -> [t,f,f]로 돌려놓기
         * 4. (1-1 종료 후 올라옴) count 는 계속 2
         *  - 1, 3 출력 -> 다시 아래 for문
         *  ... 이렇게 반복된다..
         *  즉, isVisited true의 인덱스 + 1 값을 출력해준다..
         */

        if(count == M) {
            for(int number : arr) {
                sb.append(number).append(' ');
            }
            //System.out.println();
            // 질문? '\n' 와 "\n"의 출력의 차이?
            sb.append('\n');
            System.out.print(sb);
            return;
        }
        // 그리고 굳이 sort 넣으려고 애썼다..
        /**
         * (count) - (i)
         * 0 - 0 : isvisited [f,f,f] -> [t,f,f], arr[1,0] -> 재귀
         * 1 - 0 부터 도는데 isVisited[0]은 true 라서 다시 올라감
         * 1 - 1 : isVisited[t,f,f] -> [t,t,f] -> 다시 재귀 호출
         * 2 - 1 : isvisited [t,f,t] -> arr{1,3} ->  다시 재귀 호출
         * */
        for (int i = 0; i < N; i++) {
            if(isVisited[i] == false) {
                isVisited[i] = true;
                arr[count] = i + 1;
                combineNumbers(M, N, count+1, arr, isVisited);
                // 이 코드 안넣어서 자꾸 에러났었음.. 다음 경우를 위해 원래 상태로 되돌려주기..
                isVisited[i] = false;
            }
        }
    }

}
