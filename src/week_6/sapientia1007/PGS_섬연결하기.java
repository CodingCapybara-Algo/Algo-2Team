package week_6.sapientia1007;

import java.util.*;


public class PGS_섬연결하기 {
    static class Solution {
        private int[] parent;

        // 부모 찾기
        public int find(int a){
            if (parent[a] == a) return a;
            else return parent[a] = find(parent[a]);
        }

        // 연결
        public void union(int a, int b){
            a = find(a); b = find(b);
            if (a!=b) parent[b] = a;
        }

        public int solution(int n, int[][] costs) {
            int answer = 0;

            parent = new int[n]; // 섬 개수에 따라 부모 섬 배열
            for (int i=0; i<n; i++) parent[i] = i; // 일단 자기 자신
            Arrays.sort(costs, (c1, c2) -> c1[2]-c2[2]); // 비용을 기준으로 정렬

            for (int i=0; i<costs.length; i++) {
                if (find(costs[i][0]) != find(costs[i][1])) { // 연결된 섬의 두 점이 서로 부모가 다르다면
                    union(costs[i][0], costs[i][1]); // 연결
                    answer += costs[i][2]; // 비용 합하기
                }
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}})); // 4
    }
}

/*
테스트 1 〉	통과 (0.67ms, 78.3MB)
테스트 2 〉	통과 (0.53ms, 78.7MB)
테스트 3 〉	통과 (0.73ms, 74.6MB)
테스트 4 〉	통과 (0.76ms, 74.9MB)
테스트 5 〉	통과 (0.53ms, 77.1MB)
테스트 6 〉	통과 (0.87ms, 76.4MB)
테스트 7 〉	통과 (0.66ms, 71.5MB)
테스트 8 〉	통과 (0.55ms, 72.7MB)
*/
