package week_8.lsh981127;
import java.util.*;
import java.io.*;

public class bj_11727_2xn타일링2 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        dp[1] = 1;  // 1 X 2
        dp[2] = 3;  // 1X2, 2X1, 2X2
//        dp[3] = 0(dp[1] * dp[2]) * 2
//        dp[4] = (dp[1] * dp[3]) * 2 + 1(전부 네모네모인 경우만)


        /**
         * 점화식
         * n = 3일때부터 점화식을 고민해보자
         * n-2일 때, 붙일 수 있는 경우, n-1일때 왼쪽 1개를 붙이는 경우
         * dp[n] = dp[n-1] + dp[n-2] * 2(붙일 수 있는 경우가 2개라서(2X1, 2 X 2))
         */

        for(int i = 3; i < 1001; i++) {
            dp[i] = dp[i-1] + dp[i-2] * 2;
        }

        System.out.println(dp[N]);


    }

}
