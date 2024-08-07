package week_5.heogeonho;

import java.util.ArrayList;

public class PGS_피로도 {
	
	/*
	 */

	static boolean[] v; //방문 처리
	static int cnt = 0; //카운트를 위한 변수

	public int solution(int k, int[][] dungeons) {
		v = new boolean[dungeons.length]; //던전 수 만큼 초기화 (꼭 해주기->종종 선언 안해줘서 에러만듦)
		dfs(0, k, dungeons);
		return cnt;
	}

	private void dfs(int depth, int fatigue, int[][] dungeons){
		for (int i = 0; i < dungeons.length; i++){ //종료 조건 없이 전체 순회 (최댓값 찾기)
			if (v[i] || dungeons[i][0] > fatigue) {
				continue; //최소피로도 조건 필터링
			}
			v[i] = true;
			//재귀를 통해 depth => 던전 수 구하기
			dfs(depth + 1, fatigue - dungeons[i][1], dungeons);
			v[i] = false;
		}
		cnt = Math.max(cnt, depth);
	}

	public static void main(String[] args) {
	}
}

/*테스트 1 〉	통과 (0.03ms, 78.8MB)
테스트 2 〉	통과 (0.05ms, 77.8MB)
테스트 3 〉	통과 (0.05ms, 72.4MB)
테스트 4 〉	통과 (0.17ms, 74.1MB)
테스트 5 〉	통과 (0.35ms, 75.2MB)
테스트 6 〉	통과 (0.70ms, 80MB)
테스트 7 〉	통과 (6.48ms, 83.7MB)
테스트 8 〉	통과 (6.11ms, 85.5MB)
테스트 9 〉	통과 (0.06ms, 72.7MB)
테스트 10 〉	통과 (0.59ms, 75.4MB)
테스트 11 〉	통과 (0.06ms, 74.5MB)
테스트 12 〉	통과 (0.77ms, 78.4MB)
테스트 13 〉	통과 (0.20ms, 70.5MB)
테스트 14 〉	통과 (0.09ms, 70.4MB)
테스트 15 〉	통과 (0.09ms, 72.5MB)
테스트 16 〉	통과 (0.04ms, 73.5MB)
테스트 17 〉	통과 (0.09ms, 77.4MB)
테스트 18 〉	통과 (0.06ms, 72.8MB)
테스트 19 〉	통과 (0.07ms, 73.7MB)
*/
