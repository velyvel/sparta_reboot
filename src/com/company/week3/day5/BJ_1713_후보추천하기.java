package src.com.company.week3.day5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1713_후보추천하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = 0, now = 0, changeIdx = 0;

        int pictureNum = Integer.parseInt(br.readLine());
        StringTokenizer st;

        total = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        List<Student> students = new ArrayList<>(pictureNum);
        for (int i = 0; i < pictureNum; i++) {
            students.add(new Student(0, 0, 0)); // 초기화된 학생 추가
        }

        for (int x = 0; x < total; x++) {
            now = Integer.parseInt(st.nextToken());
            changeIdx = 0;

            for (int y = 0; y < pictureNum; y++) {
                if (students.get(y).id == 0 || students.get(y).id == now) {
                    changeIdx = y;
                    break;
                }
                if (students.get(changeIdx).recommendCount > students.get(y).recommendCount ||
                        (students.get(changeIdx).recommendCount == students.get(y).recommendCount &&
                                students.get(changeIdx).time > students.get(y).time)) {
                    changeIdx = y;
                }
            }

            if (students.isEmpty() || students.get(changeIdx).id != now) {
                students.set(changeIdx, new Student(now, 0, x));
            }

            students.get(changeIdx).recommendCount++;
        }

        Collections.sort(students, Comparator.comparingInt(o -> o.id));

        for (Student student : students) {
            if (student.id != 0)
                System.out.print(student.id + " ");
        }

    }
}

class Student {
    int id;
    int recommendCount;
    int time;

    public Student(int id, int recommendCount, int time) {
        this.id = id;
        this.recommendCount = recommendCount;
        this.time = time;
    }
}



