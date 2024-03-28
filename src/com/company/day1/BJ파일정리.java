package src.com.company.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ파일정리 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문제에서 주어진 파일의 개수
        int N = Integer.parseInt(br.readLine());
        // 확장자와 개수를 저장할 map
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            // 파일명 입력받기
            String fileName = br.readLine();
            // 확장자 추출 부분 수정: substring 대신에 lastIndexOf를 사용하여 마지막 '.'의 인덱스를 찾는다
            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);

            // 확장자가 map에 없을 경우에만 list에 추가
            if(!map.containsKey(fileExt)) {
                list.add(fileExt);
            }
            // map에 확장자별로 개수를 센다. 확장자가 이미 존재한다면 기존 값에 1을 더하고, 그렇지 않다면 기본값으로 1을 넣는다.
            map.put(fileExt, map.getOrDefault(fileExt, 0) + 1);
        }

        // 확장자 이름으로 리스트를 정렬
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (String name : list) {
            sb.append(name).append(" ").append(map.get(name)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
