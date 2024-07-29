package week_4.sapientia1007;

import java.util.Arrays;

/*
numbers 배열에 있는 값들을 문자열로 이어서 쓸때, 가장 큰 수를 구해야함
String array로 배열 생성해서, 정렬
 */
public class PGS_가장큰수 {
    static class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            StringBuilder sb = new StringBuilder();
            String[] answerLst = new String[numbers.length];
            for (int i=0; i<numbers.length; i++) {
                answerLst[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(answerLst, (n1, n2) -> (n2+n1).compareTo(n1+n2)); // 두 숫자를 문자열로 붙인 결과를 비교하여 정렬 (큰수->작은수)

            if (answerLst[0].equals("0")) return "0"; // 첫번째 요소가 0이면, 모든 요소가 0이므로 최종적으로 0

            for (String number : answerLst) sb.append(number);

            answer = String.valueOf(sb);

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {6,10,2})); // 6210
        System.out.println(s.solution(new int[] {3,30,34,5,9})); //9534330
    }
}

/*
정확성 테스트
테스트 1 〉	통과 (139.87ms, 129MB)
테스트 2 〉	통과 (71.98ms, 111MB)
테스트 3 〉	통과 (164.00ms, 136MB)
테스트 4 〉	통과 (10.09ms, 91.7MB)
테스트 5 〉	통과 (121.24ms, 129MB)
테스트 6 〉	통과 (101.28ms, 105MB)
테스트 7 〉	통과 (1.89ms, 75.5MB)
테스트 8 〉	통과 (1.65ms, 77.9MB)
테스트 9 〉	통과 (2.77ms, 83.4MB)
테스트 10 〉	통과 (2.13ms, 76.2MB)
테스트 11 〉	통과 (2.16ms, 76.5MB)
테스트 12 〉	통과 (1.89ms, 73.2MB)
테스트 13 〉	통과 (2.34ms, 76.7MB)
테스트 14 〉	통과 (1.81ms, 77.1MB)
테스트 15 〉	통과 (1.60ms, 72.1MB)
 */