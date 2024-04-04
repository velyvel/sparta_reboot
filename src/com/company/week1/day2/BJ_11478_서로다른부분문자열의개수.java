package src.com.company.week1.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ_11478_서로다른부분문자열의개수 {

    /**
     * 중복이 없어야 하니까 set, 입력값 한줄이니까 좀 편하게 쓰겠군
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        HashSet<String> set = new HashSet<>();
        /**
         * "ababc" 라는 문자열이 주어졌을 때
         * */
        for(int i = 0; i < sentence.length(); i++ ) {
            String strings = "";
            /**
             * j = 0 부터 도는데, a부터 자르기 시이작! 0,0(즉 a)를 반환한다, 다음 자른다 -> set에는 a, ab 저장, 그 다음 aba, abab, ababc 저장
             * ㅓ = 1, b 부터 시작, b 없으니까 set에 저장, ba, bab, babc 중복 값 없으니 그대로 set에 저장 .. 반복! 끝 !
             * */
            for(int j = i; j < sentence.length(); j++) {
                strings += sentence.substring(j, j+1);
                set.add(strings);
            }
        }
        System.out.println(set.size());
    }

}
