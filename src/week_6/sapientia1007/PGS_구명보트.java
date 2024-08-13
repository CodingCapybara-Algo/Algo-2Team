package week_6.sapientia1007;

import java.util.*;
public class PGS_구명보트 {
    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);

            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int p : people) q.offer(p); // 오름차순으로 일단 q에 담기

            while (q.size()>1) {
                // 가장 큰 값과 가장 작은 값의 합이 무게 제한 이내라면, 가장 작은 값(가벼운 사람) 제거
                if (q.peekFirst()+q.peekLast() <= limit) q.pollFirst();
                q.pollLast();  // 가장 무거운 사람은 조건에 상관없이 일단 태워 보내기 위해 제거
                answer += 1; // 만약 덱에 마지막으로 한 명만 남았다면, 더 태워보내야 하므로 카운트 증가


                if (q.size() == 1) answer += 1;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {70, 50, 80, 50}, 100)); //3
        System.out.println(s.solution(new int[] {70, 80, 50}, 100)); //3
    }
}

/*
정확성 테스트
테스트 1 〉	통과 (3.37ms, 84.2MB)
테스트 2 〉	통과 (3.96ms, 78.2MB)
테스트 3 〉	통과 (2.56ms, 75.2MB)
테스트 4 〉	통과 (3.65ms, 80.3MB)
테스트 5 〉	통과 (2.77ms, 77.8MB)
테스트 6 〉	통과 (2.13ms, 73.1MB)
테스트 7 〉	통과 (1.75ms, 78.8MB)
테스트 8 〉	통과 (0.80ms, 71.8MB)
테스트 9 〉	통과 (1.34ms, 70.3MB)
테스트 10 〉	통과 (3.20ms, 80.1MB)
테스트 11 〉	통과 (2.74ms, 75.9MB)
테스트 12 〉	통과 (2.30ms, 75.8MB)
테스트 13 〉	통과 (2.54ms, 78.5MB)
테스트 14 〉	통과 (3.11ms, 80.1MB)
테스트 15 〉	통과 (1.47ms, 74.3MB)
테스트 16 〉	통과 (1.40ms, 73.1MB)
테스트 17 〉	통과 (0.68ms, 73.1MB)
테스트 18 〉	통과 (0.67ms, 82.8MB)
테스트 19 〉	통과 (0.79ms, 74.2MB)
테스트 20 〉	통과 (0.72ms, 81.5MB)
테스트 21 〉	통과 (0.75ms, 73.9MB)
테스트 22 〉	통과 (0.73ms, 74.4MB)
효율성  테스트
테스트 1 〉	통과 (24.71ms, 57.4MB)
테스트 2 〉	통과 (20.44ms, 54.5MB)
테스트 3 〉	통과 (22.71ms, 54.3MB)
테스트 4 〉	통과 (18.89ms, 55.4MB)
테스트 5 〉	통과 (20.43ms, 54.3MB)
*/
