package week_8.sapientia1007;

import java.io.*;


public class BJ_11727_2n타일링2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 입력받은 문자열을 정수로 변환하여 n에 저장
        int[] dp = new int[n+1]; // 크기 n+1의 dp 배열 선언, dp[i]는 2×i 크기의 직사각형을 채우는 경우의 수를 저장

        // 초기화 - dp 배열 크기에 따라 조건 필요
        if (n>=1) dp[1] = 1;  // 2×1 크기의 사각형을 채우는 경우는 1가지
        if (n>=2) dp[2] = 3; // 2×2 크기의 산각형을 채우는 경우는 3가지

        // dp 배열 저장
        for (int i=3; i<n+1; i++){
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 10_007;
        }

        for (int d : dp) System.out.println(d);

        System.out.println(dp[n]);

        br.close();
    }
}
