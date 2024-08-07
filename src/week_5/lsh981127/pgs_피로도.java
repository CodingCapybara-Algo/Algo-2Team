package week_5.lsh981127;

public class pgs_피로도 {

    static boolean[] visited;
    static int max;

    /**
     * 모든 가능한 경우를 탐색하면서 최대값을 업데이트하는 방법
     */

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        // visited 를 dfs 이후에 선언해뒀어서 계속 틀렸음
        dfs(dungeons, k, 0);
        return max;
    }

    static void dfs(int[][] dungeons, int current, int count) {
        // current : 현재 피로도
        // count : 방문한 던전 갯수

        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i] || dungeons[i][0] > current) {  // 방문했거나, 현재 피로도로 인해 방문 불가한 경우
                continue;
            }
            visited[i] = true;

            dfs(dungeons, current - dungeons[i][1], count + 1);
            // count++ 을 하면 틀린다!!
            // 해당 dfs가 이미 실행된 이후에 count 값이 증가하기 때문에 틀린다!!

            visited[i] = false;
        }

        max = Math.max(max, count);


    }
}


/**
 * 테스트 1 〉	통과 (0.06ms, 75.9MB)
 * 테스트 2 〉	통과 (0.06ms, 74.3MB)
 * 테스트 3 〉	통과 (0.05ms, 74.3MB)
 * 테스트 4 〉	통과 (0.13ms, 74.5MB)
 * 테스트 5 〉	통과 (0.35ms, 75.3MB)
 * 테스트 6 〉	통과 (0.69ms, 73.7MB)
 * 테스트 7 〉	통과 (5.67ms, 71.3MB)
 * 테스트 8 〉	통과 (3.45ms, 76.6MB)
 * 테스트 9 〉	통과 (0.04ms, 71.3MB)
 * 테스트 10 〉	통과 (0.61ms, 73.9MB)
 * 테스트 11 〉	통과 (0.03ms, 76.3MB)
 * 테스트 12 〉	통과 (0.60ms, 79MB)
 * 테스트 13 〉	통과 (0.12ms, 77.5MB)
 * 테스트 14 〉	통과 (0.08ms, 69.6MB)
 * 테스트 15 〉	통과 (0.05ms, 71.8MB)
 * 테스트 16 〉	통과 (0.07ms, 72.7MB)
 * 테스트 17 〉	통과 (0.08ms, 66.2MB)
 * 테스트 18 〉	통과 (0.05ms, 68.1MB)
 * 테스트 19 〉	통과 (0.06ms, 78.9MB)
 */
