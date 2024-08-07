package week_5.lsh981127;

import java.util.*;
public class pgs_전력망을둘로나누기 {

    static int[][] graph;
    static int diff = 101;          // n이 최대 100이라서 최대 차이값을 101개로
    static boolean[] visited;

    public static int solution(int n, int[][] wires) {
        // 모든 간선들 중, 끊었을 때, 1. 2개로 나누어지는지(만약 나눠지면 그때 2개 트리의 노드들의 차가 최소값이랑 업데이트)
        // 트리 구조이기에 => 끊으면 무조건 2개로 나누어질 것이라 판단. 확실하지는 않지만

        // 끊은 간선 기준 (a,b)를 끊었으면, a와 b에서 시작하도록 dfs나 BFS를 돌리고, 각각 방문한 노드 갯수 비교하기

        graph = new int[n][n];

        for(int i = 0; i < n-1; i++) {
            int[] temp = wires[i];
            int x = temp[0];
            int y = temp[1];
            graph[x-1][y-1] = 1;
            graph[y-1][x-1] = 1;
            // 양쪽 간선 모두 연결
        }

        for(int i = 0; i < n-1; i++) {
            int[] erase = wires[i];
            int x = erase[0]-1, y = erase[1] -1;
            visited = new boolean[n];

            // 현재 진행하는 간선을 임시로 끊고
            graph[x][y] = 0;
            graph[y][x] = 0;

            // 각각 bfs를 돌려서 연결되어 있는 노드 갯수를 카운팅
            int diff_x = bfs(x);
            visited = new boolean[n];
            int diff_y = bfs(y);

            // 차이 구하고
            int temp = Math.abs(diff_x - diff_y);

            // 최솟값 비교
            diff = Math.min(diff, temp);

            // 다시 연결
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        return diff;
    }

    static int bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        int count = 0;
        queue.offer(start);
        while(!queue.isEmpty()) {
            int cur = queue.pop();
            count++;
            for(int i = 0; i < graph[cur].length; i++) {
                if (graph[cur][i] == 1 && !visited[i]) { // 연결되어 있으면
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        return count;
    }
}

/**
 * 테스트 1 〉	통과 (18.88ms, 86.9MB)
 * 테스트 2 〉	통과 (12.97ms, 89.2MB)
 * 테스트 3 〉	통과 (28.11ms, 76.8MB)
 * 테스트 4 〉	통과 (17.15ms, 80MB)
 * 테스트 5 〉	통과 (12.75ms, 82.2MB)
 * 테스트 6 〉	통과 (0.13ms, 78.9MB)
 * 테스트 7 〉	통과 (0.08ms, 70.1MB)
 * 테스트 8 〉	통과 (0.83ms, 69.7MB)
 * 테스트 9 〉	통과 (2.33ms, 66.3MB)
 * 테스트 10 〉	통과 (17.80ms, 84.3MB)
 * 테스트 11 〉	통과 (16.08ms, 82.5MB)
 * 테스트 12 〉	통과 (14.17ms, 83.6MB)
 * 테스트 13 〉	통과 (12.74ms, 73.9MB)
 */