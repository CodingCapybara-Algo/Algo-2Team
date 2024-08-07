package week_5.skwent77;

import java.util.*;

public class PGS_전력망둘로나누기 {
    private static List<List<Integer>> graph; // 그래프를 인접 리스트로 표현
    private static boolean[] visited; // 방문한 노드를 추적하기 위한 배열

    public int solution(int n, int[][] wires) {
        int from, to;
        graph = new ArrayList<>();

        // 그래프 초기화: 각 노드에 대해 인접 리스트 생성
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 주어진 간선 정보를 이용하여 그래프 구축
        for (int[] wire : wires) {
            from = wire[0];
            to = wire[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        // 두 서브트리의 노드 개수 차이를 저장할 변수
        int minDiff = Integer.MAX_VALUE;

        // 모든 간선을 하나씩 제거하고 결과 확인
        for (int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];

            // 간선 제거
            graph.get(u).remove((Integer) v);
            graph.get(v).remove((Integer) u);

            // 방문 배열 초기화
            visited = new boolean[n + 1];

            // 노드 u에서 시작하여 한 서브트리의 크기를 계산
            int subtreeCount = dfs(u);
            int totalCount = n;

            // 두 서브트리의 노드 개수 차이 계산
            int diff = Math.abs(totalCount - 2 * subtreeCount);
            minDiff = Math.min(minDiff, diff);

            // 간선을 다시 원상태로 복구
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return minDiff;
    }

    // 서브트리의 노드 개수를 계산하는 DFS함수 안에서 별도의 조건 확인 필요 x
    private int dfs(int node) {
        visited[node] = true; // 현재 노드를 방문 처리
        int count = 1; // 현재 노드를 포함한 카운트

        // 인접한 노드를 재귀적으로 방문하여 서브트리 크기 계산
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor);
            }
        }
        return count;
    }
}
/*
회고: 그래프 구현 방식에서 선택의 기준 이제 확실해짐
 -> 이 문제는 간선이 많은 편이라 인접 리스트로 표현
테스트 1 〉	통과 (0.51ms, 72.8MB)
테스트 2 〉	통과 (1.91ms, 89.4MB)
테스트 3 〉	통과 (1.92ms, 76.7MB)
테스트 4 〉	통과 (1.99ms, 74.3MB)
테스트 5 〉	통과 (2.88ms, 82MB)
테스트 6 〉	통과 (0.11ms, 75MB)
테스트 7 〉	통과 (0.06ms, 78.2MB)
테스트 8 〉	통과 (0.35ms, 68.1MB)
테스트 9 〉	통과 (0.31ms, 82.8MB)
테스트 10 〉	통과 (1.89ms, 79.6MB)
테스트 11 〉	통과 (1.93ms, 77.7MB)
테스트 12 〉	통과 (1.75ms, 78.2MB)
테스트 13 〉	통과 (1.38ms, 73.4MB)

 */