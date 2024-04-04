package src.com.company.week1.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.StringTokenizer;

public class CalendarSample {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        // 특정 날짜 요일 구하기(영문 대문자)
        LocalDate date = LocalDate.of(2007, month, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        System.out.println(dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase()); // Sat
    }

}
