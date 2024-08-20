package week_7.sapientia1007;

/*
puddles위치를 피해서 [1,1] ~ [m,n]가는 경로
*/
public class PGS_등굣길 {
    static class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int answer = 0;
            int[][] dp = new int[m][n];

            // 집의 위치 초기화(시작점 -> dp[m-1][n-1]까지 가야함)
            dp[0][0] = 1;

            // 웅덩이 위치 저장
            for (int[] p : puddles) {
                dp[p[0]-1][p[1]-1] = -1;
            }

            // 첫번째 행과 첫번째 열 초기화 (웅덩이가 아닌 경우, 왼쪽 셀/윗쪽 셀 값을 가져옴)
            for (int i=1; i<m; i++) dp[i][0] = (dp[i][0] == -1) ? 0 : dp[i-1][0];
            for (int i=1; i<n; i++) dp[0][i] = (dp[0][i] == -1) ? 0 : dp[0][i-1];

            // 나머지 셀 계산 => 웅덩이가 아닌 경우 위쪽 셀 + 왼쪽 셀
            for (int i=1; i<m; i++){
                for (int j=1; j<n; j++){
                    if (dp[i][j] == -1) dp[i][j] = 0; // 웅덩이
                    else dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000007;
                }
            }

            answer = dp[m-1][n-1];
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, 3, new int[][] {{2,2}})); // 4
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.02ms, 75.2MB)
테스트 2 〉	통과 (0.03ms, 77MB)
테스트 3 〉	통과 (0.02ms, 79.3MB)
테스트 4 〉	통과 (0.03ms, 70.7MB)
테스트 5 〉	통과 (0.03ms, 74.5MB)
테스트 6 〉	통과 (0.04ms, 75.4MB)
테스트 7 〉	통과 (0.03ms, 76.6MB)
테스트 8 〉	통과 (0.05ms, 70.4MB)
테스트 9 〉	통과 (0.02ms, 79.4MB)
테스트 10 〉	통과 (0.02ms, 77.2MB)
효율성  테스트
테스트 1 〉	통과 (0.55ms, 51.8MB)
테스트 2 〉	통과 (0.24ms, 52.2MB)
테스트 3 〉	통과 (0.32ms, 52.4MB)
테스트 4 〉	통과 (0.42ms, 52.4MB)
테스트 5 〉	통과 (0.35ms, 52.4MB)
테스트 6 〉	통과 (0.54ms, 52.1MB)
테스트 7 〉	통과 (0.27ms, 62.6MB)
테스트 8 〉	통과 (0.47ms, 51.8MB)
테스트 9 〉	통과 (0.46ms, 52.1MB)
테스트 10 〉	통과 (0.46ms, 60.7MB)
*/
