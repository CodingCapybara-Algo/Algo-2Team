package week_7.sapientia1007;

public class PGS_정수삼각형 {
    static class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            // dp 배열 : 삼각형 높이만큼 생성
            int[] dp = new int[triangle.length];

            // 일단 맨 위 꼭대기는 포함=> 초기화
            dp[0] = triangle[0][0];

            // 삼각형 순회하면서 dp 배열 갱신
            for (int i = 1; i < triangle.length; i++) {
                for (int j=i; j>=0; j--) { // 오른쪽부터 순회
                    if (j == i) { // 가장 오른쪽 요소일떄
                        dp[j] = dp[j-1] + triangle[i][j]; // 이전 레벨의 바로 위쪽 요소 + 현재 요소
                    }
                    else if (j == 0) { // 가장 왼쪽 요소일떄
                        // 이전 레벨에서 바로 위의 요소만 고려 가능
                        dp[j] = dp[j] + triangle[i][j]; // 이전 레벨의 바로 위쪽 요소 + 현재 요소
                    } else {
                        dp[j] = Math.max(dp[j-1], dp[j]) + triangle[i][j]; // 중간 요소일때는 이전 레벨의 왼쪽 오른쪽 값 비교
                        // 왼쪽과 오른쪽 위쪽 요소 중 큰 값 선택 후 현재 요소 추가
                    }
                }
            }

            for (int i=0; i<dp.length; i++) answer = Math.max(answer,dp[i]); // 최댓값

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}})); //30
    }
}


/*
정확성 테스트
테스트 1 〉	통과 (0.03ms, 71.3MB)
테스트 2 〉	통과 (0.07ms, 72.5MB)
테스트 3 〉	통과 (0.03ms, 72.3MB)
테스트 4 〉	통과 (0.08ms, 73.7MB)
테스트 5 〉	통과 (0.20ms, 90.7MB)
테스트 6 〉	통과 (0.08ms, 81MB)
테스트 7 〉	통과 (0.22ms, 85.5MB)
테스트 8 〉	통과 (0.06ms, 72.9MB)
테스트 9 〉	통과 (0.03ms, 71.1MB)
테스트 10 〉	통과 (0.05ms, 77.3MB)

효율성 테스트
테스트 1 〉	통과 (7.31ms, 61MB)
테스트 2 〉	통과 (5.74ms, 56.4MB)
테스트 3 〉	통과 (8.27ms, 60.8MB)
테스트 4 〉	통과 (5.65ms, 59.4MB)
테스트 5 〉	통과 (5.91ms, 60.1MB)
테스트 6 〉	통과 (6.39ms, 60.4MB)
테스트 7 〉	통과 (6.33ms, 59.8MB)
테스트 8 〉	통과 (5.81ms, 59.2MB)
테스트 9 〉	통과 (5.67ms, 60.1MB)
테스트 10 〉	통과 (4.93ms, 57.3MB)
*/