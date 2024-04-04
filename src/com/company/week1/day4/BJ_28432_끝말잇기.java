package src.com.company.week1.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_28432_끝말잇기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단어 저장 리스트 -> set으로 수정해서 여기서 계속 주거니 받거니 할 예정
        //List<String> wordList = new ArrayList<>();
        Set<String> wordSet = new LinkedHashSet<>();

        // 물음표 인덱스 초기롸
        int questionIdx = 0;

        // 인덱스 비교햐기 위한 배열
        List<Integer> list = new ArrayList<>();

        // 단어 수 입력
        int N = Integer.parseInt(br.readLine());

        // 단어 입력, 물음표 인덱스 찾기
        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            //wordList.add(word);
            wordSet.add(word);
            if (word.contains("?")) {
                questionIdx = i;

                //list.get(i) = i;
            }
        }

        // 지금 wordList 에는 뭐기 들어가있지 ? // 찰리, 에코, ?, 로미오, 오스카

        // 비교할 단어 수
        int M = Integer.parseInt(br.readLine());


        for(int i = 0; i < M; i++) {
            String compareWord = br.readLine();
            // 그럼 중복된 단어는 포함 안되것지?
            wordSet.add(compareWord);

            if(wordSet.contains(compareWord)) {
                if(questionIdx == 0) {

                }
            }

        }

//        if (questionIdx != -1 && questionIdx != 0 && questionIdx != N - 1) {
//            // 앞 뒤 단어 가져오기
//            String previousWord = wordSet.get(questionIdx - 1); // 앞 문자열
//            String nextWord = wordList.get(questionIdx + 1); // 뒷 문자열
//
//            //set에서 앞 뒤 단어 다 포함되는 단어 찾기 ->  출력까지
//            if(comparedSet.contains(previousWord) && comparedSet.contains(nextWord)) {
//                System.out.println("두글자 다 포함");
//            } else {
//                System.out.println("아님말고");
//            }
//
//        }
//        //
//        else if (questionIdx == 1){
//            System.out.println(comparedSet[questionIdx]);
//        } else {
//
//        }

    }
}
