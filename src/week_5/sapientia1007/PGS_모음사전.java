package week_5.sapientia1007;

import java.util.ArrayList;

public class PGS_모음사전 {
    static class Solution {
        static ArrayList<String> list; // 모음 문자열 저장한 사전 리스트
        String[] dict = new String[] {"A","E","I","O","U"}; // 모음 배열

        public int solution(String word) {
            int answer = 0;

            list = new ArrayList<>();
            dfs("", 0); // dfs 호출로 모든 가능한 문자열 생성

            for (int i=0; i<list.size(); i++) { // 주어진 단어가 리스트에서 몇번째 위치에 있는지 찾기
                if (word.equals(list.get(i))) answer = i;
            }
            return answer;
        }
        // dfs : 모든 가능한 경로 파악
        public void dfs(String str, int len) {
            list.add(str); // 현재 문자열 추가
            if (len == 5) return; // 문자열 길이가 5이면 종료 (최대문자열길이=5)
            for (int i=0; i<5; i++) { // 모든 모음을 현재 문자열에 추가하여 새로운 문자열 생성하는 재귀 호출
                dfs(str+dict[i], len+1); 
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        System.out.println(s.solution("AAAAE")); // 6
        System.out.println(s.solution("AAAE")); // 10
        System.out.println(s.solution("I")); // 1563
        System.out.println(s.solution("EIO")); // 1189
    }
}

/*
정확성 테스트
테스트 1 〉	통과 (7.05ms, 69.4MB)
테스트 2 〉	통과 (6.73ms, 79.7MB)
테스트 3 〉	통과 (3.75ms, 72.6MB)
테스트 4 〉	통과 (3.48ms, 71.4MB)
테스트 5 〉	통과 (3.19ms, 74.5MB)
테스트 6 〉	통과 (5.66ms, 70.8MB)
테스트 7 〉	통과 (4.67ms, 79.4MB)
테스트 8 〉	통과 (3.92ms, 73.2MB)
테스트 9 〉	통과 (4.17ms, 80.3MB)
테스트 10 〉	통과 (3.34ms, 71.7MB)
테스트 11 〉	통과 (4.27ms, 77.4MB)
테스트 12 〉	통과 (3.09ms, 72.9MB)
테스트 13 〉	통과 (3.47ms, 73.3MB)
테스트 14 〉	통과 (6.77ms, 66.6MB)
테스트 15 〉	통과 (4.54ms, 74.1MB)
테스트 16 〉	통과 (4.69ms, 83.5MB)
테스트 17 〉	통과 (6.20ms, 78.6MB)
테스트 18 〉	통과 (3.21ms, 75.4MB)
테스트 19 〉	통과 (3.04ms, 76.8MB)
테스트 20 〉	통과 (3.48ms, 74.9MB)
테스트 21 〉	통과 (5.06ms, 71.8MB)
테스트 22 〉	통과 (7.57ms, 73.6MB)
테스트 23 〉	통과 (3.13ms, 76.7MB)
테스트 24 〉	통과 (3.61ms, 75.3MB)
테스트 25 〉	통과 (4.86ms, 82.4MB)
테스트 26 〉	통과 (3.07ms, 75.8MB)
테스트 27 〉	통과 (3.86ms, 77MB)
테스트 28 〉	통과 (3.15ms, 72.1MB)
테스트 29 〉	통과 (5.24ms, 76.5MB)
테스트 30 〉	통과 (3.39ms, 72.9MB)
테스트 31 〉	통과 (3.07ms, 74.4MB)
테스트 32 〉	통과 (3.11ms, 75.3MB)
테스트 33 〉	통과 (4.47ms, 74.2MB)
테스트 34 〉	통과 (3.03ms, 75.2MB)
테스트 35 〉	통과 (3.02ms, 74.8MB)
테스트 36 〉	통과 (3.11ms, 75.2MB)
테스트 37 〉	통과 (3.97ms, 74.1MB)
테스트 38 〉	통과 (4.09ms, 75.6MB)
테스트 39 〉	통과 (3.27ms, 75.4MB)
테스트 40 〉	통과 (3.54ms, 78.9MB)
*/