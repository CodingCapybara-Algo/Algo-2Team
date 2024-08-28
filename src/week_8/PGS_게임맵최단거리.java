package week_8;

import java.util.LinkedList;
import java.util.Queue;

// 회고: 처음에 dfs로 접근했다가 고생함
// 2d arr에서 최단거리 찾는 것은 왜 bfs인가
public class PGS_게임맵최단거리 {
    private static class State {
        public final int x;
        public final int y;
        public final int step;

        private State(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

     static final int[] dx = {0, 1, 0, -1};
     static final int[] dy = {-1, 0, 1, 0};

    public int solution(int[][] maps) {
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 1));
        isVisited[0][0] = true;
// 초기 상태를 다시 방문하더라도 정답에 영향 x
        while (!queue.isEmpty()) {
            State state = queue.poll();
            // 목표 상태에 도달했는지 검사하고 도달했다면 초기 상태부터 세어준 step 반환
            if (state.y == maps.length - 1 && state.x == maps[state.y].length - 1) {
                return state.step;
            }

            for (int d = 0; d < 4; d++) {
                //변환된 좌표 계산
                int nx = state.x + dx[d];
                int ny = state.y + dy[d];

                if (ny < 0 || ny >= maps.length || nx < 0 || nx >= maps[ny].length) {
                    continue;
                }

                if (maps[ny][nx] != 1 || isVisited[ny][nx]) {
                    continue;
                }
// 방문 처리 & 상태 전이
                isVisited[ny][nx] = true;
                queue.add(new State(nx, ny, state.step + 1));
            }
        }

        return -1; // 경로가 없을 경우
    }
}
/*
import java.util.ArrayDeque;
class Solution {
     static int[] dr = {0, 1, 0, -1}; // 상, 우, 하, 좌 (row 방향)
    static int[] dc = {1, 0, -1, 0}; // 우, 하, 좌, 상 (column 방향)
    static boolean[][] visited;
    static int numColumns, numRows;

    public int solution(int[][] maps) {
        numRows = maps.length;        // 세로 크기
        numColumns = maps[0].length;  // 가로 크기
        visited = new boolean[numRows][numColumns];

        return bfs(0, 0, maps);
    }

    static int bfs(int row, int col, int[][] maps) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[row][col] = true;
        q.offer(new int[]{row, col, 1}); // 시작 위치와 거리(1) 추가

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cur_row = current[0];
            int cur_col = current[1];
            int depth = current[2];

            // 목표 지점에 도달하면 최단 거리 반환
            if (cur_row == numRows - 1 && cur_col == numColumns - 1) {
                return depth;
            }

            for (int d = 0; d < 4; d++) {
                int newRow = cur_row + dr[d];
                int newCol = cur_col + dc[d];

                // 유효한 위치인지, 벽이 아닌지, 방문하지 않았는지 확인
                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numColumns
                    && maps[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    q.offer(new int[]{newRow, newCol, depth + 1});
                }
            }
        }

        return -1; // 목표 지점에 도달할 수 없는 경우
    }
}
정확성  테스트
테스트 1 〉	통과 (0.31ms, 75.3MB)
테스트 2 〉	통과 (0.30ms, 74.1MB)
테스트 3 〉	통과 (0.44ms, 71.2MB)
테스트 4 〉	통과 (0.30ms, 73.2MB)
테스트 5 〉	통과 (0.42ms, 73MB)
테스트 6 〉	통과 (0.44ms, 72.1MB)
테스트 7 〉	통과 (0.34ms, 74.4MB)
테스트 8 〉	통과 (0.29ms, 72.6MB)
테스트 9 〉	통과 (0.33ms, 75.4MB)
테스트 10 〉	통과 (0.32ms, 75.7MB)
테스트 11 〉	통과 (0.31ms, 75.3MB)
테스트 12 〉	통과 (0.28ms, 76.5MB)
테스트 13 〉	통과 (0.48ms, 76.2MB)
테스트 14 〉	통과 (0.42ms, 73.6MB)
테스트 15 〉	통과 (0.35ms, 73.7MB)
테스트 16 〉	통과 (0.38ms, 77.4MB)
테스트 17 〉	통과 (0.42ms, 86.8MB)
테스트 18 〉	통과 (0.40ms, 75MB)
테스트 19 〉	통과 (0.43ms, 76.6MB)
테스트 20 〉	통과 (0.30ms, 79.5MB)
테스트 21 〉	통과 (0.29ms, 76.3MB)
효율성  테스트
테스트 1 〉	통과 (9.07ms, 61MB)
테스트 2 〉	통과 (3.06ms, 56.2MB)
테스트 3 〉	통과 (5.92ms, 56.6MB)
테스트 4 〉	통과 (4.94ms, 53.7MB)
 */

//정확성: 69.9
//효율성: 30.1
//합계: 100.0 / 100.0