package week_6.sapientia1007;

import java.util.Arrays;
import java.io.*;

public class PGS_조이스틱 {

    static class Solution {
        public int solution(String name) {
            int answer = 0;

            // 기본적으로 왼쪽 -> 오른쪽으로 가는걸 기본
            int minMove = name.length()-1;

            for (int i=0; i<name.length(); i++){
                char targetChar = name.charAt(i);
                // 'A'에서 targetChar로 가는 거리와 'Z'에서 역으로 targetChar로 가는 거리 중 최소값을 구해 이동 횟수에 더하기
                int move = Math.min(targetChar-'A', 'Z'-targetChar+1);
                answer += move; // 해당 문자로 변경하는데 필요한 조작 횟수 추가

                int next = i+1; // 다음 위치

                // 다음 위치에 있는 문자가 'A'인 경우, 다음 'A'가 아닌 문자의 위치를 찾기
                while (next < name.length() && name.charAt(next) == 'A') next++;       // 다음 A가 아닌 문자의 위치 찾기

                // 현재 위치에서의 이동(오른쪽)과 되돌아가는 경로(왼쪽) 중 최소 이동 횟수 계산
                minMove = Math.min(minMove, i+name.length()-next+Math.min(i, name.length()-next));
            }
            answer += minMove; // 최소 이동 횟수를 총 조작 횟수에 더하기
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("JEROEN")); // 56
        System.out.println(s.solution("JAN")); // 23

    }
}

/*
테스트 1 〉	통과 (0.03ms, 74.2MB)
테스트 2 〉	통과 (0.03ms, 77.3MB)
테스트 3 〉	통과 (0.04ms, 76.9MB)
테스트 4 〉	통과 (0.05ms, 72.9MB)
테스트 5 〉	통과 (0.03ms, 74.8MB)
테스트 6 〉	통과 (0.03ms, 74.8MB)
테스트 7 〉	통과 (0.04ms, 76.3MB)
테스트 8 〉	통과 (0.03ms, 75.2MB)
테스트 9 〉	통과 (0.03ms, 77.6MB)
테스트 10 〉	통과 (0.04ms, 78.4MB)
테스트 11 〉	통과 (0.04ms, 82MB)
테스트 12 〉	통과 (0.05ms, 75.6MB)
테스트 13 〉	통과 (0.04ms, 75.2MB)
테스트 14 〉	통과 (0.05ms, 84MB)
테스트 15 〉	통과 (0.04ms, 75.1MB)
테스트 16 〉	통과 (0.05ms, 76MB)
테스트 17 〉	통과 (0.03ms, 77.1MB)
테스트 18 〉	통과 (0.03ms, 74.6MB)
테스트 19 〉	통과 (0.03ms, 76.4MB)
테스트 20 〉	통과 (0.03ms, 77MB)
테스트 21 〉	통과 (0.03ms, 71.7MB)
테스트 22 〉	통과 (0.03ms, 77.6MB)
테스트 23 〉	통과 (0.04ms, 73.1MB)
테스트 24 〉	통과 (0.05ms, 81.9MB)
테스트 25 〉	통과 (0.05ms, 77.5MB)
테스트 26 〉	통과 (0.03ms, 77.5MB)
테스트 27 〉	통과 (0.03ms, 76.6MB)
 */