package src.com.company.week2.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 메모리 : 64540KB, 시간 840ms
 *
 * */
public class BJ_2108_통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArray = new int[N];

        int sum = 0;
        int midIndex = N / 2;

        //최빈값 구하기 위한 맵
        Map<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < N; i++) {
            // 값 넣으면서
            numArray[i] = Integer.parseInt(br.readLine());
            // 산술평균에 필요한 합 구하고
            sum += numArray[i];
            // 최빈값 구하는 맵에도 넣고(키: 배열요소, 값: 빈도수)
            map.put(numArray[i],map.getOrDefault(numArray[i],0) + 1);
        }
        // 오름차순 정렬
        Arrays.sort(numArray);

        //1. 산술평균 : 은근.. 자료형이 어려웠습니다.
        int average = calculateAverage(sum, N);
        System.out.println(average);
        //2. 중앙값
        int median = numArray[midIndex];
        System.out.println(median);
        //3. 최빈값
        int frequency = calculateFrequency(map);
        System.out.println(frequency);
        //4. 범위
        int range = Math.abs(numArray[N-1] - numArray[0]);
        //int range2 = numArray[N-1] - numArray[0];
        System.out.println(range);

    }

    public static int calculateAverage(int sum, int N) {

        double doubleAverage = (double) sum / N;
        if(doubleAverage < 0) {
            // 여기서 애먹었다.. 음수 양수로 만들고(절댓값) 다시 음수 만들고 반올림(round) 해줘야 함
            return (int) Math.round(Math.abs(doubleAverage) * -1);
        } else {
            return (int) Math.round(doubleAverage);
        }
    }

    public static int calculateFrequency(Map<Integer, Integer> map) {
        //(키: 배열요소, 값: 빈도수) 인 맵 : 빈도수 큰 것부터 정렬

        int freq = Collections.max(map.values());
        // 최빈값 배열
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //해당 value값이 maxValue값과 같으면 또 최빈값이 있는거니까 키값(원래의 값 넣어주기)
            if (entry.getValue() == freq) {
                arrayList.add(entry.getKey());
            }
        }

        // 두번째 작은 값 구하기
        if(arrayList.size() > 1) {
            return arrayList.get(1);
        }
        else {
            return arrayList.get(0);
        }

    }
}
