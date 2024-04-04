package src.com.company.week1.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BJ_1213_펠린드롬_2 {
    /***
     * 펠린드롬 ? 앞 뒤로 읽었을 때 똑같은 문자
     * 1. 짝수 길이 펠린드롬 문자열: 각 문자열의 개수가 모두 짝수
     * 2. 홀수 길이 펠린드롬 문자열: 한 문자를 제외하고는 모두 짝수
     * 질문 ? ABCCABB -> ACBBBCA, ABCBCBA 이 가능한데...
     * */


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 읽어오기
        String[] input = br.readLine().split("");
        int length = input.length;

        // 문자열 출연빈도(?) 저장하기 위한 맵 : aabcc -> a:2, b:3, c:1 로 저장
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String alphabet : input) {
            countMap.put(alphabet, countMap.getOrDefault(alphabet, 0) + 1);
        }

        // 캘린드롬 문자열인지 판별하기
        if (!isPalindrome(countMap, length)) {
            System.out.println("I'm Sorry Hansoo");
        }
        // 캘린드롬이면
        else {
            //countMap에는 a:2, b:3, c:1 들어있음
            ArrayList<String> evenArr = new ArrayList<>();
            for (String s : countMap.keySet()) { // 짝수인 a와 c만 저장 (b는 3개, 홀수라 따로 처리)
                for (int i = 0; i < countMap.get(s) / 2; i++) {
                    evenArr.add(s);
                }
            }
            Collections.sort(evenArr); //a, c로 정렬

            StringBuilder result = new StringBuilder();
            StringBuilder sb = new StringBuilder();

            for (String s : evenArr) {
                sb.append(s); //ac 가 된다
            }
            result.append(sb); //result : ac
            // 문자열 길이 홀수 : 아까 b 3개
            if (length % 2 != 0) {
                // 가운데 끼워넣을 변수
                String middle = "";
                for (String key : countMap.keySet()) {
                    // 아까 짝수 걸러질 때랑 중복되지만 어떻게 할 방법이 생각이 안남 : 홀수 인 경우 middle 에 저장 후 끝내기
                    if (countMap.get(key) % 2 != 0) {
                        middle = key;
                        // return;
                        break;
                    }
                }
                // ac + bbb
                result.append(middle);
            }

            // ac -> ca
            result.append(sb.reverse());
            System.out.println(result.toString());
        }
    }


    // 매개변수 : 문자열 종류,개수를 가지고 있는 맵, 입력받은 문자열 길이
    // 팰린드롬 문자인지 판별하는 함수
    public static boolean isPalindrome(HashMap<String, Integer> countMap, int length) {
        // 짝수 : 각 문자열이 짝수인가?
        if (length % 2 == 0) {
            for (Integer value : countMap.values()) {
                if (value % 2 != 0) return false; //ABBC 인 경우 A,C 가 홀수라 안됨
            }
            return true;
        }
        // 홀수
        else {
            // 홀수 세기
            int cnt = 1;
            for (Integer value : countMap.values()) {
                //이미 두 개 이상의 문자가 홀수 개인 경우 : (aabbbcc), 펠린드롬 문자열을 생성할 수 없음
                // 만약 aabcd 로 input이 들어왔다면.. a-> 짝수수(통과), b: 홀수 : cnt = 0, c : 홀수 -> cnt -1 되버려서 이제 못만들어
                if (cnt < 0) return false;
                // 홀수 개의 문자 발견 시 cnt 값을 감소 b발견! 0으로 변경
                if (value % 2 != 0) {
                    cnt--;
                }
            }
            return true;
        }
    }
}
