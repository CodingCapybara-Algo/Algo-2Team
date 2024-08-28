package week_8.lsh981127;

import java.util.ArrayDeque;

public class pgs_네트워크 {
    static boolean[] v;
    static int answer = 0;
    static int size;
    static int[][] comp;
    public static int solution(int n, int[][] computers) {

        // 각 노드들의 시작점에 대해 DFS 돌려서 연결된 네트워크 탐색
        comp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                comp[i][j] = computers[i][j];
            }
        }
        v = new boolean[n];
        size = n;

        for(int i = 0; i < n; i++) {
            if(v[i]) continue;
            answer++;
            dfs(i);
        }

        return answer;
    }

    static void dfs(int x) {
        for(int i = 0; i < size; i++) {
            if(i == x || comp[x][i] != 1 || v[i])
                continue;
            v[i] = true;
            dfs(i);
        }
    }
}

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.02ms, 78.8MB)
 * 테스트 2 〉	통과 (0.04ms, 74.5MB)
 * 테스트 3 〉	통과 (0.06ms, 75.4MB)
 * 테스트 4 〉	통과 (0.04ms, 69.2MB)
 * 테스트 5 〉	통과 (0.02ms, 71.2MB)
 * 테스트 6 〉	통과 (0.14ms, 73MB)
 * 테스트 7 〉	통과 (0.04ms, 71.3MB)
 * 테스트 8 〉	통과 (0.11ms, 81.6MB)
 * 테스트 9 〉	통과 (0.08ms, 70.5MB)
 * 테스트 10 〉	통과 (0.08ms, 71.7MB)
 * 테스트 11 〉	통과 (0.70ms, 76.5MB)
 * 테스트 12 〉	통과 (0.37ms, 78.6MB)
 * 테스트 13 〉	통과 (0.18ms, 77.6MB)
 */
