package week_8.lsh981127;

import java.util.*;

public class pgs_게임맵최단거리 {
    public static void main(String[] args) {
        int[][] maps = new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }
    public static int solution(int[][] maps) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] v = new boolean[n][m];
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        v[0][0] = true;
        dq.offer(new int[]{0,0});
        while(!dq.isEmpty()) {
            int[] temp = dq.poll();
            int x = temp[0];
            int y = temp[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0 <= nx && nx < n && 0 <= ny && ny < m && !v[nx][ny]) {
                    // 난 누적값으로 저장할 것이기에 1인 경우만 진행하면 된다.
                    // 0이면 막힌 거, 1이 아닌 양수면 이미 누가 방문한 거
                    // 그러다가, 그냥 값이 1, 즉 시작점을 다시 방문하는 문제 발생
                    // 귀찮아서 결국 visited를 사용해서 구현

                    if(maps[nx][ny] == 1) {
                        maps[nx][ny] += maps[x][y];
                        v[nx][ny] = true;
                        dq.offer(new int[]{nx,ny});
                    }
                }
            }
        }

        if(maps[n-1][m-1] != 1) {
            return maps[n-1][m-1];
        }
        return -1;


    }
}

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.08ms, 73MB)
 * 테스트 2 〉	통과 (0.06ms, 73MB)
 * 테스트 3 〉	통과 (0.12ms, 76.9MB)
 * 테스트 4 〉	통과 (0.09ms, 72.9MB)
 * 테스트 5 〉	통과 (0.09ms, 80.2MB)
 * 테스트 6 〉	통과 (0.10ms, 67.6MB)
 * 테스트 7 〉	통과 (0.12ms, 76.8MB)
 * 테스트 8 〉	통과 (0.09ms, 72.2MB)
 * 테스트 9 〉	통과 (0.14ms, 74.4MB)
 * 테스트 10 〉	통과 (0.12ms, 88.7MB)
 * 테스트 11 〉	통과 (0.06ms, 77.3MB)
 * 테스트 12 〉	통과 (0.07ms, 64.6MB)
 * 테스트 13 〉	통과 (0.06ms, 77.5MB)
 * 테스트 14 〉	통과 (0.08ms, 68.9MB)
 * 테스트 15 〉	통과 (0.09ms, 71.6MB)
 * 테스트 16 〉	통과 (0.05ms, 77.3MB)
 * 테스트 17 〉	통과 (0.13ms, 82.4MB)
 * 테스트 18 〉	통과 (0.04ms, 65.1MB)
 * 테스트 19 〉	통과 (0.05ms, 77.8MB)
 * 테스트 20 〉	통과 (0.05ms, 74.8MB)
 * 테스트 21 〉	통과 (0.06ms, 82.6MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (7.01ms, 54.4MB)
 * 테스트 2 〉	통과 (3.09ms, 56.3MB)
 * 테스트 3 〉	통과 (4.71ms, 52.5MB)
 * 테스트 4 〉	통과 (5.17ms, 52.7MB)
 */