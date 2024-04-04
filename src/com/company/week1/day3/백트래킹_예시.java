package src.com.company.week1.day3;


import java.util.ArrayList;
import java.util.List;
public class 백트래킹_예시 {

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        int length = 3;

        System.out.println("준비된 배열은 ? " + nums.toString());
        /**
         * 출력 결과
         * [1, 2, 3, 4]
         * */

        backtrack(result, new ArrayList<>(), nums, length, 0);

        // 결과 출력
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }

        /**
         * 출력 결과
         * [1, 2, 3]
         * [1, 2, 4]
         * [1, 3, 4]
         * [2, 3, 4]
         * */
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> current, List<Integer> nums, int length, int start) {
        // 기저 조건: 현재 숫자의 길이가 원하는 길이와 같은 경우
        if (current.size() == length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 모든 숫자를 시도
        for (int i = start; i < nums.size(); i++) {
            // 이미 사용된 숫자는 건너뜀
            if (current.contains(nums.get(i))) {
                continue;
            }
            // 다음 자리 숫자 시도
            current.add(nums.get(i));
            backtrack(result, current, nums, length, i); // 재귀 호출
            current.remove(current.size() - 1); // 백트래킹: 마지막 요소 제거
        }
    }

}
