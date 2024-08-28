package week_8.sapientia1007;

import java.util.*;

public class PGS_네트워크 {
    static class Solution {
        int[] parent ; // 각 노드의 부모를 저장하는 배열
        public int find(int a){ // 주어진 노드의 부모 찾기
            if (parent[a] == a) return a;
            return parent[a] = find(parent[a]);
        }

        public void union(int a, int b){ // 두 노드를 하나의 집합으로 합침
            a = find(a); b = find(b); // 각 부모
            if (a!=b) parent[b] = a;
        }

        public int solution(int n, int[][] computers) {
            int answer = 1;
            parent = new int[n];
            // 일단 부모 자기자신으로 담기
            for (int i=0; i<n; i++) parent[i] = i;

            for (int i = 0; i < computers.length; i++) {
                for (int j=0; j< computers[i].length; j++){
                    if (computers[i][j] == 1){
                        union(i, j); // 연결된 노드들을 하나의 집합으로 합침
                    }
                }
            }

            for (int i=0; i<n; i++){
                find(i); // 모든 노드에 대해 find 연산 수행하여 경로 구하기
            }

            HashSet<Integer> newtork = new HashSet<>(); // 중복 값 제거하고 배열 담기
            for (int p : parent){
                newtork.add(parent[p]);
            }
            answer = newtork.size();

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(3, new int[][] {{1,1,0}, {1,1,0}, {0,0,1}})); // 2
        System.out.println(s.solution(3, new int[][] {{1,1,0}, {1,1,1}, {0,1,1}})); // 1
        System.out.println(s.solution(4, new int[][] {{1, 1, 0, 0}, {1, 1, 0, 0},
                                                            {0, 0, 1, 1}, {0, 0, 1, 1}})); //2
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.08ms, 75.9MB)
테스트 2 〉	통과 (0.09ms, 72.6MB)
테스트 3 〉	통과 (0.20ms, 78.5MB)
테스트 4 〉	통과 (0.15ms, 76.8MB)
테스트 5 〉	통과 (0.05ms, 76MB)
테스트 6 〉	통과 (0.32ms, 73.7MB)
테스트 7 〉	통과 (0.10ms, 81.9MB)
테스트 8 〉	통과 (0.20ms, 68.9MB)
테스트 9 〉	통과 (0.31ms, 71.7MB)
테스트 10 〉	통과 (0.30ms, 71.4MB)
테스트 11 〉	통과 (0.72ms, 76.4MB)
테스트 12 〉	통과 (0.68ms, 77.9MB)
테스트 13 〉	통과 (0.23ms, 72.1MB)
*/