package week_6.sapientia1007;

import java.util.*;

public class PGS_큰수만들기 {
    static class Solution {
        public String solution(String number, int k) {
//            String answer = "";
            StringBuilder answer = new StringBuilder();
            int numLen = number.length() - k; // 만들어야 할 숫자 길이
            int idx = 0;

            while (answer.length() < numLen) {
                char maxNum = '0';
                int endIdx = number.length() - numLen + answer.length();
                int maxIdx = idx;

                for (int i = idx; i <= endIdx; i++) {
                    char currentChar = number.charAt(i);
                    if (currentChar > maxNum) {
                        maxNum = currentChar;
                        maxIdx = i;
                    }
                }

                answer.append(maxNum);
                idx = maxIdx + 1;
                k-=1;
            }

            return answer.toString();
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("1924",2)); // 94
        System.out.println(s.solution("1231234",3)); // 3234
        System.out.println(s.solution("4177252841",4)); // 775841
    }
}

/*
테스트 1 〉	통과 (0.05ms, 78.9MB)
테스트 2 〉	통과 (0.05ms, 76.6MB)
테스트 3 〉	통과 (0.07ms, 76.6MB)
테스트 4 〉	통과 (0.44ms, 80MB)
테스트 5 〉	통과 (0.84ms, 70.6MB)
테스트 6 〉	통과 (25.67ms, 85.2MB)
테스트 7 〉	통과 (41.67ms, 76.7MB)
테스트 8 〉	통과 (194.05ms, 84.6MB)
테스트 9 〉	통과 (20.25ms, 79.5MB)
테스트 10 〉	통과 (7338.69ms, 75.5MB)
테스트 11 〉	통과 (0.04ms, 77.1MB)
테스트 12 〉	통과 (0.05ms, 69.1MB)
*/