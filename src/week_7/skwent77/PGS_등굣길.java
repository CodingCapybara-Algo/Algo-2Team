package week_7.skwent77;
import java.util.Arrays;

public class PGS_등굣길 {

    public static int solution(int m, int n, int[][] puddles) {
        int ans =0;
        int[][] dp = new int[n+1][m+1];
        int x,y; //x y 는 배열의 행 열 idx

        for (int[] row : dp) {
            Arrays.fill(row, 1); //O(n) time complexity 배열의 각 요소를 순회하며 값을 할당합니다 
        }
//1로 초기화하는 것은 기본적으로 각 셀까지의 경로 수를 계산할 때, 경로가 1개인 것으로 가정하고 시작하기 때문

        for (int[] water : puddles ){
            y = water[0] ; x= water[1];
                dp[x][y] = 0;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == 0) {
                    continue;  // 물 웅덩이는 경로 개수를 0으로 유지
                }

                // 첫 행일 경우 (위에서 오는 경로가 없음)
                //-> 첫 행의 경우(위에서 오는 경로가 없음): 첫 행의 각 셀은 바로 왼쪽 셀의 경로 수를 그대로 가져옵니다.
                if (i == 1 && j > 1) {
                    dp[i][j] = dp[i][j - 1];
                }

                // 첫 열일 경우 (왼쪽에서 오는 경로가 없음)
                // 첫 열의 각 셀은 바로 위 셀의 경로 수를 그대로 가져옵니다.
                else if (j == 1 && i > 1) {
                    dp[i][j] = dp[i - 1][j];
                }

                // 그 외의 경우
                else if (i > 1 && j > 1) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                }
            }
        }
//        dp[i+1][j+1] = dp[i][j+1]+dp[i+1][j];

        ans = dp[n][m];
//착점 (m, n)까지의 경로 수는 dp[n][m]에 저장됩
        return ans ;
    }
//    1. 배열 만들어놓기 각 지점까지의 최단 경로
//    2. 점화식 찾기 -> 고등수학에서 배웠던 로직이라 크게 어렵지는 않았음
//  sub problem의 최적의 결과값을 사용하여 전체 문제의 최적의 결과를 이끌어간다는 것은 명확했음
    public static void main(String[] args) {
        int ans;
        int[][] arr = {{2,2}};
        System.out.println(arr.getClass());
        ans =  solution(4,3,arr);
        System.out.println(ans);
    }
}
