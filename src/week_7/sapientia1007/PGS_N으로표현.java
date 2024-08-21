package week_7.sapientia1007;

import java.util.*;

/*
N만을 사용해서 number을 만드는 경우의 수 중 N을 가장 적게 사용한 수 = answer
https://isshosng.tistory.com/173
*/
public class PGS_N으로표현 {
    static class Solution {
        public int solution(int N, int number) {
            int answer = -1; // 못 만들면 -1 반환

            if (N == number) return 1; // 동일한 숫자면 단순 1

            // 숫자 N을 이용하여 만들 수 있는 숫자 배열 초기화
            List<Set<Integer>> dp = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                dp.add(new HashSet<>());
            }

            // N을 1번 사용해서 만들 수 있는 숫자 초기화
            dp.get(1).add(N);

            // N을 2번부터 8번까지 사용하여 만들 수 있는 숫자 계산
            for (int i = 2; i < 9; i++) {
                Set<Integer> currentSet = dp.get(i);

                // N을 i번 반복한 수를 currentSet에 추가
                currentSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));

                // j번과 k번 조합으로 사칙연산을 통해 i번 사용한 숫자들을 currentSet에 추가
                for (int j = 1; j < i; j++) {
                    int k = i - j;
                    for (int num1 : dp.get(j)) {
                        for (int num2 : dp.get(k)) {
                            currentSet.add(num1 + num2);
                            currentSet.add(num1 * num2);
                            currentSet.add(num1 - num2);
                            if (num2 != 0) currentSet.add(num1 / num2);
                        }
                    }
                }
            }
            // dp 리스트에서 각 인덱스 i에 대해, number가 존재하는지 확인 -> dp[0]은 비어있음
            for (int i = 1; i < dp.size(); i++) if (dp.get(i).contains(number)) return i;

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5, 12)); // 4
        System.out.println(s.solution(2, 11)); // 3
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (22.87ms, 88.5MB)
테스트 2 〉	통과 (3.91ms, 76MB)
테스트 3 〉	통과 (11.84ms, 80.4MB)
테스트 4 〉	통과 (25.39ms, 85.8MB)
테스트 5 〉	통과 (15.12ms, 78.1MB)
테스트 6 〉	통과 (14.07ms, 83MB)
테스트 7 〉	통과 (21.01ms, 93.7MB)
테스트 8 〉	통과 (18.83ms, 79.5MB)
테스트 9 〉	통과 (0.02ms, 74.6MB)
*/