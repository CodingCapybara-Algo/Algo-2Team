package week_6.skwent77;

/*
그래프의 노드(정점) 수가 n일 때 , 최소 신장트리는 반드시 n-1개의 간선을 가져야 한다.
트리의 정의
노드와 간선의 관계: 트리에서는 n개의 노드가 있으면 항상 n-1개 간선이 존재
신장 트리 : 모든 노드를 포함하면서도 사이클이 없는 최소 간선의 집합
 */

import java.util.Arrays;

public class PGS_섬연결하기 {
    static int answer;

    //사이클 검사를 위한 유니온 파인드: findParent 함수를 사용하여 두 노드의 부모를 찾고, 서로 다른 부모를 가진 경우 간선을 추가합니다.
    public static int findParent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent, parent[x]);
        }
        return parent[x];
    }

    public static int solution(int n, int[][] costs) {
        answer = 0;

        // 1. 간선들을 비용에 따라 오름차순으로 정렬
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        System.out.println(Arrays.deepToString(costs));

        // 2. 부모 배열 초기화
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 3. 간선들을 순회하며 최소 비용으로 모든 섬을 연결
        for (int i = 0; i < costs.length; i++) {
            int start = findParent(parent, costs[i][0]);
            int end = findParent(parent, costs[i][1]);

            // 사이클이 발생하지 않으면 해당 간선을 선택
            if (start != end) {
                parent[end] = start;
                answer += costs[i][2];
            }
        }

        return answer;
    }
}
/* 시간 복잡도 O(E log E) (E는 간선의 수, costs.length에 해당)
테스트 1 〉	통과 (0.66ms, 72.8MB)
테스트 2 〉	통과 (0.84ms, 77.3MB)
테스트 3 〉	통과 (0.78ms, 73.8MB)
테스트 4 〉	통과 (0.80ms, 70.4MB)
테스트 5 〉	통과 (1.04ms, 71.6MB)
테스트 6 〉	통과 (1.11ms, 81.2MB)
테스트 7 〉	통과 (1.05ms, 73.2MB)
테스트 8 〉	통과 (0.75ms, 74.5MB)
*/