package src.com.company.week3.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyBackpackExample {
    static ArrayList<String> itemNames;

    // 물건을 표현하는 클래스
    static class Item {
        int weight;
        int value;
        double valuePerWeight;
        String name;

        public Item(int weight, int value, String name) {
            this.weight = weight;
            this.value = value;
            this.valuePerWeight = (double) value / weight;
            this.name = name;
        }
    }

    // 그리디 알고리즘을 사용하여 배낭에 담을 수 있는 최대 가치를 계산하는 함수
    public static double greedyKnapsack(int capacity, Item[] items) {
        // 가치가 높은 순으로 물건 정렬
        Arrays.sort(items, Comparator.comparingDouble(o -> -o.valuePerWeight));

        double totalValue = 0;
        int currentWeight = 0;
        itemNames = new ArrayList<>();
        // 물건을 담을 수 있는 만큼 최대한 담기
        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                totalValue += item.value;
                currentWeight += item.weight;
                itemNames.add(item.name);
            } else {
                int remainingWeight = capacity - currentWeight;
                totalValue += item.valuePerWeight * remainingWeight;
                itemNames.add(item.name);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int capacity = 50; // 배낭의 용량
        Item[] items = {
                new Item(10, 60, "물"),
                new Item(20, 100, "핫팩"),
                new Item(30, 120, "신분증")
        }; // 예시 물건들 (무게, 가치)

        double maxValue = greedyKnapsack(capacity, items);
        System.out.println("배낭에 담을 수 있는 최대 가치: " + maxValue);
        System.out.print("배낭에 담긴 물건들: ");
        for (String name : itemNames) {
            System.out.print(name + " ");
        }
    }
}
/**
 * 출력
 * 배낭에 담을 수 있는 최대 가치: 240.0
 * 배낭에 담긴 물건들: 물 핫팩 신분증
 * */