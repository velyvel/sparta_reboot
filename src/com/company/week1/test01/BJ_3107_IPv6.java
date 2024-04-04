package src.com.company.week1.test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3107_IPv6 {

    public static String expandIPv6(String shortIp) {

        //::으로 끝나는 경우 터리


        StringBuilder expandedIPv6 = new StringBuilder();
        String[] segments = shortIp.split(":");


        int numOfSegments = 0;
        for (String segment : segments) {
            if (!segment.isEmpty()) numOfSegments++;
        }


        boolean expandDoubleColon = false;

        int doubleColonIndex = shortIp.indexOf("::");


        int nowLen = 0;
        // ::이 마지막에 있는 경우 : split 으로 자르니까 : 만 남는다
        if (shortIp.endsWith("::")) {
            for(int i = 0; i < numOfSegments; i++) {
                if(segments[i].length() != 4) {
                    //size 가 4 만큼 0으로 채워준다.
                    // : 붙여준다
                    expandedIPv6.append(segments[i]).append(":");
                }
                nowLen = expandedIPv6.length();
                if(expandedIPv6.length() < 39) {
                    //39개 만큼 0으로 채워준다
                }
            }


            return expandedIPv6.toString();
        }
        //:: 이 첫번째|| 중간에 있는 경우

        if (doubleColonIndex != -1) {
            expandDoubleColon = true;
            if (doubleColonIndex == 0) numOfSegments++;
            if (doubleColonIndex + 2 == shortIp.length()) numOfSegments++;
        }

        for (int i = 0; i < segments.length; i++) {
            if (expandDoubleColon && segments[i].isEmpty()) {
                int numOfZeroesToAdd = 8 - numOfSegments;
                for (int j = 0; j < numOfZeroesToAdd; j++) expandedIPv6.append("0000:");
                while (i < segments.length - 1 && segments[i + 1].isEmpty()) i++;
                continue;
            }

            while (segments[i].length() < 4) segments[i] = "0" + segments[i];
            expandedIPv6.append(segments[i]);
            if (i < segments.length - 1) expandedIPv6.append(":");
        }

        while (expandedIPv6.length() < 39) {
            expandedIPv6.insert(5, "0000:");
        }

        return expandedIPv6.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String shortIp = br.readLine();
        String expandedIPv6 = expandIPv6(shortIp);
        System.out.println(expandedIPv6);
    }
}
