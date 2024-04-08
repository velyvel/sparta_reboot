package src.com.company.week2.day2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

    public static void main(String[] args) {
        // Person 객체를 담을 리스트 생성
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", 25));
        people.add(new Person("Sarah", 20));
        people.add(new Person("Mark", 30));

        // 나이를 기준으로 오름차순 정렬 (람다식 사용)
        people.sort((Person p1, Person p2) -> p1.getAge() - p2.getAge());

        // 정렬된 리스트 출력
        for (Person p : people) {
            System.out.println(p.getName() + ": " + p.getAge());
        }

        // 더 간결한 방식으로 나이를 기준으로 내림차순 정렬
        people.sort(Comparator.comparingInt(Person::getAge).reversed());

        // 정렬된 리스트 출력
        System.out.println("After reverse sorting:");
        for (Person p : people) {
            System.out.println(p.getName() + ": " + p.getAge());
        }
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
