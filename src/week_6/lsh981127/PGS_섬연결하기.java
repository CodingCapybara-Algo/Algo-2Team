package week_6.lsh981127;
import java.util.*;
public class PGS_섬연결하기 {
    static int[] p;
    private int find(int a) {
        if(p[a] == a) return a;
        return p[a]=find(p[a]);
    }

    private void union(int a, int b) {
        int ar = find(a);
        int br = find(b);
        if(ar != br) {
            p[br] = ar;
        }
    }

    // 보자마자 MST인가 싶었으나 그리디 알고리즘인가에 대한 불확신이 있었다.
    // MST 알고리즘 중 크루스칼 알고리즘은 그리디 알고리즘으로 분류된다.

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        p = new int[n];
        for(int i = 0; i < n; i++) p[i] = i;
        int answer = 0;
        for(int[] e : costs) {
            if(find(e[0]) != find(e[1])) {
                union(e[0], e[1]);
                answer += e[2];
            }
        }
        return answer;
    }
}

/**
 * 테스트 1 〉	통과 (0.48ms, 71.2MB)
 * 테스트 2 〉	통과 (0.59ms, 73.4MB)
 * 테스트 3 〉	통과 (0.60ms, 73.2MB)
 * 테스트 4 〉	통과 (0.51ms, 76.1MB)
 * 테스트 5 〉	통과 (0.52ms, 75.6MB)
 * 테스트 6 〉	통과 (0.70ms, 74.6MB)
 * 테스트 7 〉	통과 (0.64ms, 74.3MB)
 * 테스트 8 〉	통과 (0.44ms, 76.1MB)
 */