package week_8.heogeonho;

import java.util.*;

public class PGS_네트워크 {
	
	/*
	그래프의 탐색 문제
	그래프 탐색
	인접행렬로 표현된 그래프 탐색

	 n개의 노드 전체 순회 하면서 v[i] false일 때마다 bfs() 진행
	 */

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {
				{1, 1, 0},
				{1, 1, 0},
				{0, 0, 1}
		};

		int[][] computers2 = {
				{1, 1, 0},
				{1, 1, 1},
				{0, 1, 1}
		};
		System.out.println(solution(n, computers));
	}

	static boolean[] v;
	static int solution(int n, int[][] computers) {
		v =new boolean[n];
		int answer = 0;

		for(int i=0; i<n; i++) {
			if(!v[i]) {
				bfs(i, n, computers);
				answer+=1;
			}
		}
		return answer;
	}

	private static void bfs(int i, int n, int[][] computers) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(i);
		v[i] = true;

		while(!dq.isEmpty()) {
			int node = dq.poll();

			for (int k = 0; k < n; k++) {
				if (computers[node][k] == 1 && !v[k]) {
					dq.offer(k);
					v[k] = true;
				}
			}
		}
	}
}

/*
테스트 1 〉	통과 (0.06ms, 72.9MB)
테스트 2 〉	통과 (0.04ms, 82.8MB)
테스트 3 〉	통과 (0.08ms, 75.9MB)
테스트 4 〉	통과 (0.09ms, 77.3MB)
테스트 5 〉	통과 (0.04ms, 71.6MB)
테스트 6 〉	통과 (0.13ms, 78.8MB)
테스트 7 〉	통과 (0.05ms, 74.4MB)
테스트 8 〉	통과 (0.11ms, 74.4MB)
테스트 9 〉	통과 (0.08ms, 74.4MB)
테스트 10 〉	통과 (0.08ms, 75.9MB)
테스트 11 〉	통과 (0.34ms, 77.3MB)
테스트 12 〉	통과 (0.23ms, 67.2MB)
테스트 13 〉	통과 (0.16ms, 73.4MB)
*/
