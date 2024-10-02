package week_10.skwent77;

public class PGS_순위 {
// 이긴사람들의 수 세기 위해 화살표 방향으로 진행하면서 만나는정점개수 세는 메서드
        public int countForward(int u,boolean[][] graph, boolean[] isVisted){
            int count = 1;
            for(int v=0 ; v<graph[u].length ; v++){ // v는 진행 시작할 정점

                if(!graph[u][v] || isVisted[v]) continue;
                isVisted[v]= true; //한 번 센 정점2번 세는 것 방지
                count += countForward(v,graph,isVisted);
            }
            return count;
        }
        //u 시작 노드 (현재 탐색 중인 노드)
        public int countBackward(int u,boolean[][] graph, boolean[] isVisited){
            int count=1;
            for ( int v=0; v<graph.length;v++) {
                /// 만약 노드 v가 u와 연결되지 않았거나, 이미 방문한 노드라면 건너뜀
                if(!graph[v][u] || isVisited[v])
                    continue;
                isVisited[v]=true;
                count +=countBackward(v,graph,isVisited);
            }
            return count; //연결된 노드의 총 개수
        }
    //
        public int solution(int n, int[][] results) {
            boolean[][] graph = new boolean[n][n];
            for (int[] edge: results){
                int u = edge[0] - 1;
                int v = edge[1] - 1;
                graph[u][v] = true;
            }


        int count = 0;
            for (int u = 0; u <n; u++){
            int wins = countForward(u, graph, new boolean[n])-1;
            int loses = countBackward(u, graph, new boolean[n])-1;
            if (wins + loses + 1 == n) {
                count++;
            }
    }
        return count;
    }


}

/*
테스트 1 〉	통과 (0.04ms, 71.9MB)
테스트 2 〉	통과 (0.07ms, 71.5MB)
테스트 3 〉	통과 (0.06ms, 75.1MB)
테스트 4 〉	통과 (0.08ms, 72.2MB)
테스트 5 〉	통과 (0.58ms, 79.1MB)
테스트 6 〉	통과 (1.01ms, 86.6MB)
테스트 7 〉	통과 (4.23ms, 73.1MB)
테스트 8 〉	통과 (6.61ms, 78.5MB)
테스트 9 〉	통과 (9.09ms, 80.7MB)
테스트 10 〉	통과 (8.05ms, 85MB)
*/
