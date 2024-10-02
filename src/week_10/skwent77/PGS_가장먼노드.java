package week_10.skwent77;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class PGS_가장먼노드 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        //인접리스트
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        //간선 정보로부터 그래프 구성
        for (int[] edges : edge) {
            int u = edges[0];
            int v = edges[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // 각 노드의 최단 거리를 저장할 배열
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);  // -1로 초기화 (방문하지 않은 노드)
        distance[1] = 0;

        // BFS를 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        // BFS 수행
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adj.get(current)) {
                if (distance[neighbor] == -1) {  // 아직 방문하지 않은 노드일 경우
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        // 최대 거리 찾기
        int maxDistance = 0;
        for (int dist : distance) {
            if (dist > maxDistance) {
                maxDistance = dist;
            }
        }

        // 최대 거리와 같은 거리를 가진 노드 개수 세기
        for (int dist : distance) {
            if (dist == maxDistance) {
                answer++;
            }
        }


        return answer;
    }
}
/*
테스트 1 〉	통과 (0.25ms, 76.8MB)
테스트 2 〉	통과 (0.34ms, 76.2MB)
테스트 3 〉	통과 (0.48ms, 78.3MB)
테스트 4 〉	통과 (1.46ms, 78.3MB)
테스트 5 〉	통과 (3.89ms, 82.4MB)
테스트 6 〉	통과 (6.73ms, 88.9MB)
테스트 7 〉	통과 (29.86ms, 98.8MB)
테스트 8 〉	통과 (51.49ms, 117MB)
테스트 9 〉	통과 (30.44ms, 112MB)
정확성  테스트
테스트 1 〉	통과 (0.25ms, 76.8MB)
테스트 2 〉	통과 (0.34ms, 76.2MB)
테스트 3 〉	통과 (0.48ms, 78.3MB)
테스트 4 〉	통과 (1.46ms, 78.3MB)
테스트 5 〉	통과 (3.89ms, 82.4MB)
테스트 6 〉	통과 (6.73ms, 88.9MB)
테스트 7 〉	통과 (29.86ms, 98.8MB)
테스트 8 〉	통과 (51.49ms, 117MB)
테스트 9 〉	통과 (30.44ms, 112MB)
 */