package week_5.sapientia1007;

public class PGS_피로도 {

    static class Solution {
        public boolean[] visited; public int answer;
        public int solution(int k, int[][] dungeons) {
            answer = -1;
            visited = new boolean[dungeons.length]; // 방문 배열 초기화
            dfs(0, k, dungeons); // dfs 호출 - 시작 인덱스 0, 초기 피로도 k
            return answer;
        }

        // dfs : 모든 가능한 경로 파악
        public void dfs(int idx, int k, int[][] dungeons) { // 현재까지 클리어한 던전 수, 현재 피로도, 던전 배열
            for (int i=0; i<dungeons.length; i++){
                if (!visited[i] && k >= dungeons[i][0]){ // 현재 던전을 방문하지 않았고, 현재 피로도가 필요 피로도보다 높으면
                    visited[i] = true; // 방문 처리
                    dfs(idx+1, k-dungeons[i][1], dungeons); // 다음 던전을 탐색하기 위해 재귀 호출 -> 피로도 감소
                    visited[i] = false; // 방문 해제
                }
            }
            answer = Math.max(answer, idx); // 최대값
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(80, new int[][] {{80,20},{50,40},{30,10}})); //3
    }
}

/*
정확성 테스트
테스트 1 〉	통과 (0.10ms, 75.7MB)
테스트 2 〉	통과 (0.06ms, 74.2MB)
테스트 3 〉	통과 (0.10ms, 80MB)
테스트 4 〉	통과 (0.17ms, 77.9MB)
테스트 5 〉	통과 (0.36ms, 85.4MB)
테스트 6 〉	통과 (0.68ms, 77.8MB)
테스트 7 〉	통과 (2.11ms, 72.4MB)
테스트 8 〉	통과 (2.89ms, 78.2MB)
테스트 9 〉	통과 (0.11ms, 75.9MB)
테스트 10 〉	통과 (0.38ms, 70.6MB)
테스트 11 〉	통과 (0.03ms, 81MB)
테스트 12 〉	통과 (0.51ms, 76.9MB)
테스트 13 〉	통과 (0.11ms, 76MB)
테스트 14 〉	통과 (0.05ms, 85.6MB)
테스트 15 〉	통과 (0.04ms, 73.7MB)
테스트 16 〉	통과 (0.04ms, 74.3MB)
테스트 17 〉	통과 (0.05ms, 75.5MB)
테스트 18 〉	통과 (0.04ms, 76MB)
테스트 19 〉	통과 (0.04ms, 75MB)
*/