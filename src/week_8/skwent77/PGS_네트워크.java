package week_8.skwent77;
//도움을 얻은 링크: https://velog.io/@soorim_yoon/DFSBFS-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Level-3
/*
** 로직:
answer: 최종적으로 찾아야 할 네트워크의 개수를 카운트합니다.
각각의 컴퓨터를 방문하여 연결된 네트워크를 검사합니다.
만약 방문하지 않은 컴퓨터를 찾으면 DFS를 호출하고, 탐색이 끝나면 네트워크의 수를 하나 증가시
 */

public class PGS_네트워크 {
    static boolean[] visited;
    static int[][] g;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        int cntComp = computers.length;
        visited = new boolean[cntComp];
//        for (0~n-1 ) 방문 dfs함수
        /*
        중복검사를 위한 방문 배열은 DFS 진행할 떄 선언해도 ok
         */
        //모든 노드 순회
        for (int i = 0; i < n; i++) {

            if (visited[i] == false) {

                dfs(n, computers, i);
                answer += 1;
            }
        }
        return answer;
    }

    void dfs(int n, int[][] computers, int cur) {
        visited[cur] = true;
        //현재 컴퓨터 방문 처리
        for (int j = 0; j < n; j++) {
            //0번부터 n-1까지 인접 노드 모두 탐색
            if (j != cur && computers[j][cur] == 1 && !visited[j]) {
               // 자기 자신이 아니고, 연결되어 있으며, 아직 방문하지 않은 컴퓨터에 대해 재귀적으로 DFS를 호출합니
                dfs(n, computers, j);
            }
        }

    }
}
/* 시간복잡도 O(n^2)
테스트 1 〉	통과 (0.03ms, 73.4MB)
테스트 2 〉	통과 (0.02ms, 75.8MB)
테스트 3 〉	통과 (0.02ms, 76MB)
테스트 4 〉	통과 (0.04ms, 72.4MB)
테스트 5 〉	통과 (0.02ms, 73.9MB)
테스트 6 〉	통과 (0.12ms, 79MB)
테스트 7 〉	통과 (0.02ms, 72.2MB)
테스트 8 〉	통과 (0.07ms, 74.7MB)
테스트 9 〉	통과 (0.04ms, 74.1MB)
테스트 10 〉	통과 (0.06ms, 81.8MB)
테스트 11 〉	통과 (0.21ms, 87.9MB)
테스트 12 〉	통과 (0.17ms, 74.6MB)
테스트 13 〉	통과 (0.09ms, 79.9MB)
정확성: 100.0
합계: 100.0 / 100.0
 */