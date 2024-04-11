package src.com.company.week3.day1;

public class MakeCombination {
    public static void main(String[] args) {
        String[] dresses = {"분홍원피스", "노랑원피스", "정렬의 래드", "시크한 블랙"};
        String[] shoes = {"유리구두", "분홍꽃신", "검정하이힐"};

        combination(dresses, shoes);
    }

    public static void combination(String[] dresses, String[] shoes) {
        // 각 드레스마다 하나의 신발만을 고려하여 조합을 출력
        int count = 0;
        for (String dress : dresses) {
            for (String shoe : shoes) {
                System.out.println(dress + " + " + shoe);
                count++;
            }
        }
        System.out.println("조합의 수는 ? " + count);
    }
}

