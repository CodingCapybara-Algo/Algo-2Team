package week_7.skwent77;

public class PGS_삼각형 {
    /*  사고의 편의를 위해 일반 배열처럼 생각하며 피라미드 모양을 1 2 3 4 5 개씩 늘어나는 계단으로 바꿔 생각
        1단계 위에서 아래로 내려가며 더 큰수를 만든다면 4 5 중 큰 값 5 선택
        2단계 : 삼각형을 더 확장 맨 위부터 시작해서 갈 수 있는 모든 방향으로 진행하며 최대값 갱신
        8       8
        2 7     2+8  8+7
        4 5 2   -   -   -
        3단계: 10에서 아래 두 수 보고 갱신 \
         8
         2    7
         10+4 15+5   기존의 5였던 경로는 8->7->15로 이동하는 것이 더 크므로 더 큰 값 20으로 갱신
         4단계: 이제 점화식 생각하기
          아래에서 위로 가도 숫자를 거치는 경로는 같기에 아래에서 위로 거꾸로 출발

          8          8
          2  7       (1단계)2대신7  (2단계)7대신 12
          4  5  2    4  5  2
     */
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {

            dp[n - 1][i] = triangle[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {

                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];

            }
        }
        answer = dp[0][0];
        return answer;


    }
}
