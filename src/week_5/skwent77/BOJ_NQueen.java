package week_5.skwent77;

import java.util.*;
import java.io.*;

/* 부가 설명
문제
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
    PGS_모음 사전 문제를 잘 풀지 못해서, 대체로 백준 골드 문제 9663번 푼 것 첨부합니다.
    스터디 규칙에 맞게 실행 시간 첨부합니다.
 */
public class BOJ_NQueen {
    static int N, ans, col[];

    // 현재 행까지의 퀸 배치가 가능한지 평가하는 함수
    static boolean isAvailable(int curRow) {
        for (int j = 0; j < curRow; j++) {
            // 같은 열에 있거나 대각선에 있는지 확인
            if (col[curRow] == col[j] || Math.abs(col[curRow] - col[j]) == (curRow - j)) {
                return false;
            }
        }
        return true;
    }

    // 현재 행에 퀸을 배치하고 재귀적으로 다음 행에 퀸을 배치하는 함수
    static void queen(int curRow) {
        // 현재 행까지의 배치가 불가능하면 반환
        if (!isAvailable(curRow - 1))
            return;

        // 모든 행에 퀸을 배치했으면 해결책 하나를 찾은 것
        if (curRow == N) {
            ans++;
            return;
        }

        // 각 열에 퀸 배치 시도
        for (int idx = 0; idx < N; idx++) {
            col[curRow] = idx;
            queen(curRow + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N];
        queen(0);
        System.out.println(ans);
        sc.close();
    }
}
// 5896ms 메모리 17720KB