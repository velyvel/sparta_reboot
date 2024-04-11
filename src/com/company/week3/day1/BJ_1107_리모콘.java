package src.com.company.week3.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1107_리모콘 {

    /**
     * 500000일때 케이스 처리 안되서 그냥 옴
     * */

    // 고장난 버튼을 체크하기 위한 배열(0~9)
    static boolean[] isMiss = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 목표 채널
        int N = Integer.parseInt(br.readLine());
        // 고장난 버튼 개수
        int M = Integer.parseInt(br.readLine());

        // 고장난 버튼이 있을때만 missBtn 추가 : 안하면 null
        if(M > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int missBtn = Integer.parseInt(st.nextToken());
                // 고장난 버튼 체크
                isMiss[missBtn] = true;
            }
            //System.out.println("잃어버린 버튼 ? " + Arrays.toString(isMiss));
        }

        // +,- 버튼만.. 100번 맞춰주기(0 ~ 100까지, 부호빼기)
        int result = Math.abs(N - 100);
        //int result = 0;

        // 모든 채널 검색 : 딱 5만일 떄만 통과를 못함
        for (int channel = 0; channel <= 500000; channel++) {
            // 현재 리모컨으로 조작할 수 있는 채널? ->  길이(누른 횟수)를 구하기(1541)
            int length = calculateNum(channel);
            // 누룰 수 있는 버튼이 있으면
            if (length > 0) {
                int usePlusMinus = Math.abs(channel - N);

                // 직접 채널을 입력? +/- 버튼 사용 방법 중 더 작은 값을 선택
                result = Math.min(result, length + usePlusMinus);
            }
        }

        System.out.println(result);
    }

    // 고장 안난 버튼만 눌러 누른 횟수 return
    public static int calculateNum(int channel) {
        if (channel == 0) { // 0인 경우 고장났는지만 체크
            // 0번이면 0 하나 누르면 된다
            return isMiss[0] ? 0 : 1;
        }
        int length = 0;
        while (channel > 0) {
            //채널(가장 오른쪽에 있는 자릿수의 숫자가 고장난 버튼인지를 검사, 고장나면 다음체널로 넘어가기..
            if (isMiss[channel % 10]) {
                return 0;
            }
            // 고장 안난거면 증가해주기
            length++;
            // 맨 오른쪽 자리수 0으로 만들어 주고 순회
            channel /= 10;
            //System.out.println("마지막 빠진건가 ? " + channel);
        }
        // 버튼(고장안난거) 누른 횟수 반환
        return length;
    }
}

