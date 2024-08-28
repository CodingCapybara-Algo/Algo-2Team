package week_8.sapientia1007;

import java.util.*;

public class PGS_게임맵최단거리 {
    static class Solution {
        // 0 : 벽이 있는 자리 <-> 1: 벽이 없는 자리(이동 가능한 자리)
        static int[] di = {-1,0,1,0};
        static int[] dj = {0,1,0,-1};
        static boolean[][] v ;
        static int row; static int col;
        public int solution(int[][] maps) {
            int answer = 0;

            row = maps.length; col = maps[0].length;

            v = new boolean[row][col]; // 방문 여부

            answer = bfs(maps,0, 0); // 시작점

            return answer;
        }
        public int bfs(int[][] maps, int i, int j){
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.offer(new int[] {i, j, 1}); // 위치 저장 및 방문
            v[i][j] = true;

            while (!q.isEmpty()) {
                int[] ij = q.poll();
                int ni = ij[0];
                int nj = ij[1];
                int distance = ij[2];

                if (ni == row - 1 && nj == col - 1) { // 목표 지점 도달
                    return distance;
                }

                for (int d = 0; d < 4; d++) {
                    int newi = di[d] + ni;
                    int newj = dj[d] + nj;

                    if (newi >= 0 && newi < row && newj >= 0 && newj < col && !v[newi][newj] && maps[newi][newj] == 1) {
                        v[newi][newj] = true;
                        q.offer(new int[]{newi, newj, distance + 1});
                    }
                }
            }

            return -1; // 도달할 수 없는 경우
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}})); // 11
        System.out.println(s.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}})); // -1
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.08ms, 78.5MB)
테스트 2 〉	통과 (0.09ms, 74MB)
테스트 3 〉	통과 (0.10ms, 74.7MB)
테스트 4 〉	통과 (0.09ms, 71MB)
테스트 5 〉	통과 (0.10ms, 78.1MB)
테스트 6 〉	통과 (0.08ms, 75.9MB)
테스트 7 〉	통과 (0.10ms, 76.4MB)
테스트 8 〉	통과 (0.12ms, 73.6MB)
테스트 9 〉	통과 (0.12ms, 75.4MB)
테스트 10 〉	통과 (0.13ms, 81.1MB)
테스트 11 〉	통과 (0.06ms, 69.5MB)
테스트 12 〉	통과 (0.05ms, 76.9MB)
테스트 13 〉	통과 (0.09ms, 70.9MB)
테스트 14 〉	통과 (0.11ms, 76.7MB)
테스트 15 〉	통과 (0.08ms, 78.3MB)
테스트 16 〉	통과 (0.05ms, 77.7MB)
테스트 17 〉	통과 (0.09ms, 74.1MB)
테스트 18 〉	통과 (0.05ms, 67.9MB)
테스트 19 〉	통과 (0.07ms, 73.3MB)
테스트 20 〉	통과 (0.06ms, 81MB)
테스트 21 〉	통과 (0.04ms, 76.2MB)

효율성  테스트
테스트 1 〉	통과 (7.09ms, 53.1MB)
테스트 2 〉	통과 (2.50ms, 52.4MB)
테스트 3 〉	통과 (4.79ms, 52.6MB)
테스트 4 〉	통과 (3.64ms, 53.9MB)
*/