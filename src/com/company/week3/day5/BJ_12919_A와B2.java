package src.com.company.week3.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_12919_A와B2 {
    /**
     * 메모리 : 14272KB, 시간 : 124ms
     * 길이비교하고 재귀로 풀었다
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original = br.readLine();
        String target = br.readLine();

        int result = canTransform(original, target) ? 1 : 0;

        System.out.println(result);
    }

    public static boolean canTransform(String original, String target) {
        boolean isTarget = false;
        if(target.length() <= original.length()) {
            if (original.equals(target)) {
               return isTarget = true;
            }
          return isTarget = false;
        }

            if(target.charAt(target.length() - 1) == 'A') { // 문자열 뒤에 A를 추가
                isTarget = isTarget || canTransform(original, target.substring(0, target.length() -1));
            }
            if(target.charAt(0) == 'B') { // 문자열 뒤에 B 추가 후 뒤집음
                String extras = new StringBuilder().append(target).reverse().substring(0, target.length()-1);
                //isTarget |= canTransform(original, extras);
                isTarget = isTarget || canTransform(original, extras);
            }
        return isTarget;
    }
}



