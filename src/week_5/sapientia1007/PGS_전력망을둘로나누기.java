package week_5.sapientia1007;

import java.util.*;

public class PGS_전력망을둘로나누기 {
    static class Solution {
        static int[][] g;
        public int solution(int n, int[][] wires) {
            int answer = -1;
            g = new int[n+1][n+1];

            for (int i=0; i<wires.length; i++) {
                int n1 = wires[i][0]; int n2 = wires[i][1];
                g[n1][n2] = 1; g[n2][n1] = 1; // 양방향 - 인접행렬 input
            }
            // 각 간선을 끊어서 분리된 두 부분의 차이를 계산
            for (int i=0; i<wires.length; i++) {
                int n1 = wires[i][0]; int n2 = wires[i][1];
                g[n1][n2] = 0; g[n2][n1] = 0; // 간선 끊기

                // 분리된 두 부분의 크기를 계산
                int cnt1 = bfs(n, n1); // 송전탑의 개수, n1을 시작으로 하는 부분의 크기
                int cnt2 = n - cnt1;   // 나머지 부분의 크기

                // 두 부분의 크기 차이를 계산하고, 최소값 찾기
                if (answer == -1 || Math.abs(cnt1 - cnt2) < answer) {
                    answer = Math.abs(cnt1 - cnt2);
                }
                g[n1][n2] = 1; g[n2][n1] = 1; // 선 복구

            }
            return answer;
        }

        // bfs를 사용하여 주어진 노드와 연결된 모든 노드를 찾는 함수 - 인접한 경로부터  (dfs: 갈 수 있는 위치 전체 탐색 / bfs : 인접한 위치부터 탐색)
        public static int bfs(int n, int n1) {
            boolean[] v = new boolean[n+1];
            int cnt = 0;
            ArrayDeque<Integer> q = new ArrayDeque<>();
            v[n1] = true; // 방문 처리
            q.offer(n1);
            while (!q.isEmpty()){
                int tmp = q.poll();
                cnt++;
                // 인접 노드를 순회
                for (int i=1; i<=n; i++){
                    if (g[tmp][i] == 1 && !v[i]){ // 연결되어 있고 방문하지 않았다면
                        v[i] = true;
                        q.offer(i);
                    }
                }
            }
            return cnt ; // 현재 연결된 노드의 수 반환
        }
    }

    public static void main(String[] args)  {
        Solution s = new Solution();
        System.out.println(s.solution(9, new int[][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}})); //3
        System.out.println(s.solution(4, new int[][] {{1,2},{2,3},{3,4}})); //0
        System.out.println(s.solution(7, new int[][] {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));// 1
    }
}

/*
정확성 테스트
테스트 1 〉	통과 (0.81ms, 77.5MB)
테스트 2 〉	통과 (10.53ms, 74.7MB)
테스트 3 〉	통과 (12.56ms, 75.1MB)
테스트 4 〉	통과 (8.82ms, 73.1MB)
테스트 5 〉	통과 (14.38ms, 83.2MB)
테스트 6 〉	통과 (0.08ms, 79.5MB)
테스트 7 〉	통과 (0.06ms, 73.7MB)
테스트 8 〉	통과 (0.43ms, 74.8MB)
테스트 9 〉	통과 (0.54ms, 72MB)
테스트 10 〉	통과 (6.88ms, 88MB)
테스트 11 〉	통과 (7.62ms, 77.7MB)
테스트 12 〉	통과 (9.11ms, 80.9MB)
테스트 13 〉	통과 (5.21ms, 78.3MB)
 */