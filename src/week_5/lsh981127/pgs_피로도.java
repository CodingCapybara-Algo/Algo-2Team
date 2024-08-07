package week_5.lsh981127;
import java.util.*;
public class pgs_피로도 {

    static boolean[] visited;
    static int max;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        // visited 를 dfs 이후에 선언해뒀어서 계속 틀렸음
        dfs(dungeons, k, 0);
        return max;
    }

    static void dfs(int[][] dungeons, int current, int count) {

        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i] || dungeons[i][0] > current) {
                continue;
            }
            visited[i] = true;
            dfs(dungeons, current - dungeons[i][1], count + 1);
            // count++ 을 하면 틀린다!!

            visited[i] = false;
        }

        max = Math.max(max, count);


    }
}
