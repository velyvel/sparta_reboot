package src.com.company.week1.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1213_펠린드롬 {
    // 펠린드롬 문자열 ? 앞으로 읽어도 뒤로 읽어도 똑같은 문자열(난 왜 대칭이면 복사가 떠오르지)

    // 펠린드롬 문자열인지 판별하는 함수
    public static boolean isPalindrome(String original) {
        int left = 0;
        int right = original.length() - 1;

        while (left < right) {
            if(original.charAt(left) != original.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original = br.readLine();

        if(isPalindrome(original)) {
            System.out.println(original);
        } else {
            System.out.println("I'm Sorry Hansoo");
        }

    }
}
