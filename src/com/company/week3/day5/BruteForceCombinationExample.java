package src.com.company.week3.day5;

import java.util.ArrayList;
import java.util.List;

public class BruteForceCombinationExample {

    // 주어진 배열의 모든 조합을 찾는 함수
    public static List<List<Integer>> generateCombinations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    // 재귀적으로 조합을 생성하는 보조 함수
    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // 현재 조합을 결과에 추가
        result.add(new ArrayList<>(current));

        // 각 요소를 선택하여 조합 생성
        for (int i = start; i < nums.length; i++) {
            // 요소 선택
            current.add(nums[i]);
            // 재귀 호출하여 다음 요소 선택
            backtrack(nums, i + 1, current, result);
            // 선택한 요소 제거 (백트래킹)
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3}; // 예시 배열
        List<List<Integer>> combinations = generateCombinations(nums);

        // 결과 출력
        System.out.println("배열의 조합:");
        for (List<Integer> combination : combinations) {
            System.out.print(combination + " ");
        }
    }
}
