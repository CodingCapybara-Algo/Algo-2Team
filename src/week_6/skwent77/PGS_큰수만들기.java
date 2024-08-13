package week_6.skwent77;

import java.util.*;

public class PGS_큰수만들기 {
    public String solution(String number, int k) {
        // String answer = "";
        ArrayDeque<Character> stack = new ArrayDeque<>();

        int len = number.length();

        for (int i = 0; i < len; i++) {

            char c = number.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peekLast() < c) {

                stack.removeLast();
                k--;
            }
            stack.addLast(c);
        }
        while (k > 0) {

            stack.removeLast();
            k--;
        }
        StringBuilder answer = new StringBuilder();
        for (char c : stack) {

            answer.append(c);
        }
        // number에서 k개의 수 제거 ->: 만들 수 있는 가장 큰 숫자를 문자열로 리턴

        return answer.toString();
    }
}
/*
정확성 테스트 케이스
테스트 1 〉	통과 (0.21ms, 74.6MB)
테스트 2 〉	통과 (0.15ms, 82.7MB)
테스트 3 〉	통과 (0.50ms, 80.7MB)
테스트 4 〉	통과 (0.90ms, 74.8MB)
테스트 5 〉	통과 (1.12ms, 74.1MB)
테스트 6 〉	통과 (5.29ms, 72.6MB)
테스트 7 〉	통과 (15.81ms, 82MB)
테스트 8 〉	통과 (25.22ms, 79.5MB)
테스트 9 〉	통과 (30.47ms, 81.8MB)
테스트 10 〉	통과 (42.97ms, 95MB)
테스트 11 〉	통과 (0.16ms, 72MB)
테스트 12 〉	통과 (0.16ms, 75MB)
 */