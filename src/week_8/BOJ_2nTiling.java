package week_8;
import java.util.Scanner;
 //BOJ에는 Main class로 제출
public class BOJ_2nTiling {
    static int[] dp;
    static final int MOD = 10007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new int[n + 1];

        System.out.println(tile(n));
    }

    private static int tile(int n) {
        if (n == 1) return 1;
        if (n == 2) return 3;

        if (dp[n] != 0) return dp[n];

        dp[n] = (tile(n - 1) + 2 * tile(n - 2)) % MOD;
        return dp[n];
    }

}
//메모리 : 17844KB 시간 : 168ms