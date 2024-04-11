package src.com.company.week3.day1;

import java.util.ArrayList;

public class SubsequenceCombination {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        generateSubsequences(nums, 0, new ArrayList<Integer>(), result);

        // 부분수열 출력
        for (ArrayList<Integer> subsequence : result) {
            System.out.println(subsequence);
        }
    }

    public static void generateSubsequences(int[] nums, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 현재 인덱스의 원소를 포함하지 않는 경우
        generateSubsequences(nums, index + 1, current, result);

        // 현재 인덱스의 원소를 포함하는 경우
        current.add(nums[index]);
        generateSubsequences(nums, index + 1, current, result);

        // Backtrack
        current.remove(current.size() - 1);
    }
}

