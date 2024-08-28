package week_8.heogeonho;

import java.util.ArrayDeque;
import java.util.Deque;

public class PGS_게임맵최단거리 {

	/*
	bfs로 최단 거리 찾기
	이전 공간의 value에 다음 공간에 넘어갈 때 +1을 해주는 idea -> 최종 공간에 있는 value가 최단거리

	<구현>
	maps 2차원 배열 하나만 주어져있음

	가로 세로 길이 먼저 구하고 같은 크기의 v[][] 생성하기

	maps[0][0]에서 bfs 탐색 시작하기. 출발 값은 1.
	(n,m) 도달 시 종료 및 해당 칸의 value 결과 추출

	+++++ 코딩 끝내고 다른사람이 변수값들 어떤식으로 넘겨주고 다루는지 참고하기! +++++

	풀면서 생각해보니 maps 이거 하나만으로 풀 수 있을지도 모르겠다는 생각을 함 (혹시나...? 해서 메모)
	 */

	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps));
	}

	static int[] di = new int[] {-1,0,1,0};
	static int[] dj = new int[] {0,1,0,-1};
	static boolean[][] v;
	static int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;

		v = new boolean[n][m];

		return bfs(0,0, maps, n, m);
	}

	private static int bfs(int i, int j, int[][] maps, int n, int m) {

		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {0, 0});
		v[0][0]=true;
		maps[0][0]=1;

		while (!dq.isEmpty()) {
			int[] ij = dq.poll();
			int ii = ij[0];
			int jj = ij[1];
			for (int d=0; d<4; d++) {
				int ni = ii + di[d];
				int nj = jj + dj[d];
				if(0<=ni&&ni<n && 0<=nj&&nj<m && !v[ni][nj] && maps[ni][nj]==1) {
					dq.offer(new int[] {ni, nj});
					maps[ni][nj]=maps[ii][jj]+1;
					v[ni][nj]=true;
				}
			}
		}

		if(v[n-1][m-1]) {
			return maps[n-1][m-1];
		}
		return -1;
	}
}

/*
정확성  테스트
테스트 1 〉	통과 (0.10ms, 77.1MB)
테스트 2 〉	통과 (0.11ms, 71.1MB)
테스트 3 〉	통과 (0.08ms, 75MB)
테스트 4 〉	통과 (0.07ms, 73.1MB)
테스트 5 〉	통과 (0.10ms, 77.5MB)
테스트 6 〉	통과 (0.15ms, 79.4MB)
테스트 7 〉	통과 (0.11ms, 71.3MB)
테스트 8 〉	통과 (0.09ms, 72MB)
테스트 9 〉	통과 (0.15ms, 76.8MB)
테스트 10 〉	통과 (0.13ms, 75.3MB)
테스트 11 〉	통과 (0.07ms, 75.6MB)
테스트 12 〉	통과 (0.08ms, 70.7MB)
테스트 13 〉	통과 (0.08ms, 74.7MB)
테스트 14 〉	통과 (0.07ms, 71.2MB)
테스트 15 〉	통과 (0.06ms, 78.5MB)
테스트 16 〉	통과 (0.07ms, 66.8MB)
테스트 17 〉	통과 (0.13ms, 71.7MB)
테스트 18 〉	통과 (0.07ms, 79.4MB)
테스트 19 〉	통과 (0.06ms, 73.6MB)
테스트 20 〉	통과 (0.09ms, 82.7MB)
테스트 21 〉	통과 (0.06ms, 77.1MB)
효율성  테스트
테스트 1 〉	통과 (8.34ms, 53.2MB)
테스트 2 〉	통과 (3.70ms, 56.1MB)
테스트 3 〉	통과 (6.59ms, 52.2MB)
테스트 4 〉	통과 (4.05ms, 54.4MB)
채점 결과
정확성: 69.9
효율성: 30.1
합계: 100.0 / 100.0
*/
