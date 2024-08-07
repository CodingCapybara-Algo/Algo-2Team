package week_5.sapientia1007;

import java.util.*;
import java.io.*;

/*
* numbers 문자열로 수의 조합 구하기
* 구한 수의 조합 중 소수인지 확인
*/
public class PGS_소수찾기 {
    static HashSet<Integer> numberLst;
    static class Solution {
        public int solution(String numbers) {
            int answer = 0;

            // 수의 조합을 담을 배열 (중복 제거)
            numberLst = new HashSet<>();
            permNumber("", numbers); // 숫자 조합 생성

            for (int n : numberLst) {
                if (checkNumber(n)) answer ++; // 소수인지 확인 후 개수 세기
            }
            return answer;
        }
    }
    // 수 조합 생성 메서드
    public static void permNumber(String current, String reset) {
        int n = reset.length();
        if (!current.equals("")) { // 만들어진 숫자가 있다면 numberLst에 추가
            numberLst.add(Integer.valueOf(current));
        }
        for (int i = 0; i < n; i++) { // 각 문자에 대해 재귀적으로 숫자 조합 생성
            permNumber(current + reset.charAt(i), reset.substring(0, i) + reset.substring(i + 1, n));
        }
    }
    // 소수인지 확인
    static boolean checkNumber(int num) {
        if (num <= 1) return false; // 1 이하는 소수가 아님
        if (num == 2) return true; // 2는 소수
        if (num % 2 == 0) return false; // 2를 제외한 짝수는 소수가 아님
        for (int i = 3; i <= Math.sqrt(num); i += 2) { // 3부터 주어진 숫자의 제곱근까지의 홀수로 나누어 떨어지는지 확인
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        System.out.println(s.solution("17")); // 3
        System.out.println(s.solution("011")); // 2
    }
}

/*
정확성 테스트
테스트 1 〉	통과 (10.40ms, 74.9MB)
테스트 2 〉	통과 (13.86ms, 75.3MB)
테스트 3 〉	통과 (9.09ms, 76.6MB)
테스트 4 〉	통과 (14.11ms, 76.2MB)
테스트 5 〉	통과 (21.85ms, 89MB)
테스트 6 〉	통과 (9.10ms, 78.4MB)
테스트 7 〉	통과 (10.18ms, 75.8MB)
테스트 8 〉	통과 (22.42ms, 88.3MB)
테스트 9 〉	통과 (13.12ms, 79.4MB)
테스트 10 〉	통과 (14.05ms, 77.2MB)
테스트 11 〉	통과 (10.91ms, 67.6MB)
테스트 12 〉	통과 (10.85ms, 77.6MB)
*/