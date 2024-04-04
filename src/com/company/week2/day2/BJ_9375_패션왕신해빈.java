package src.com.company.week2.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 메모리 14212KB, 128ms
 * 조합의 원리 참고해야 함
 * count *= (value + 1);
 * nCr : (n! / (r!(n-r)!) 로 구하기
 *
 * 모든 조합을 구합니다.
 * 해당 종류의 의상 개수(styleMap의 value 값에 아무것도 선택하지 않는 경우도 포함)
 * 머리쓰는것 : 모자, 터번(2개) : 모자, 터번, 안씀
 * count = 1 * 3 = 3으로 변경
 * 얼궁 착용 : 썬구리(1개) count = 3 * 2 (썬구리/ 모자/ 터번 / 모자 + 썬구리 / 터번 + 썬구리 / 아무것도)
 * */

public class BJ_9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 해빈이가 가진 의상의 수
            // 키 : 옷의 종류 , value : 옷의 개수
            Map<String, Integer> styleMap = new HashMap<>();

            for (int j = 0; j < N; j++) {
                String[] cloth = br.readLine().split(" ");
                styleMap.put(cloth[1], styleMap.getOrDefault(cloth[1], 0) + 1); // 옷의 종류를 키값으로 두어 중복없이 저장할 수 있게 : t1 : headgear(2), eyewear(1) 2가지만 저장되었음
            }
            // 곱하기 연산 들어가야 해서 최소값 1로 잡아두기
            int count = 1;
            for (int value : styleMap.values()) {

                count *= (value + 1);
            }
            count -= 1; // 모든 의상을 선택하지 않는 경우 제외

            System.out.println(count);
        }
    }

}
