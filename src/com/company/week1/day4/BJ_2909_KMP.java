package src.com.company.week1.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2909_KMP {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] longText = br.readLine().split("-");

        StringBuilder sb = new StringBuilder();

        for(String str : longText) {
            for(int i = 0; i < str.length(); i++) { //str: Knuth
                char ch = str.charAt(i);
                if(Character.isUpperCase(ch)) { //K? append u? xx
                    // 대문자일 경우에만 StringBuilder에 추가
                    sb.append(ch);
                }
            }
        }
        System.out.println(sb);
    }

}
