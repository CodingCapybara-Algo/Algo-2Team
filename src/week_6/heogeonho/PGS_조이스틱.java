package week_6.heogeonho;

public class PGS_조이스틱 {
	
	/*
	단순히 좌우 상하 처리 잘 해주면 될 것이라고 생각
	먼저 좌우 처리가 먼저라고 생각
		좌우는 A가 없는 (더 적은) 방향을 찾는 것이 관건
		A의 수 찾아 좌우 결정
		aCnt -> 오른쪽 탐색 횟수
		현재 인덱스 + (전체길이-(현재인덱스+aCnt)) -> 왼쪽 탐색 횟수
	자리 찾은 후에는 상하 결정
		상하는 더 가까운 (더 적은값 처리하기) char 처리
	 */


	static int solution(String name) {

		int answer = 0;
		int move = name.length() - 1;
		for(int i=0; i<name.length(); i++) {
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1); //위 아래 커서 char 의 특징 활용

			int idx = i + 1;
			while (idx < name.length() && name.charAt(idx) == 'A') {
				idx++;
			}
			// 이 파트 한가지 방식만 생각해서 틀렸었음
			// 아래처럼 모든 상황에 대해 판단하여 계산해야 함을 확인(여려웠던 부분이었음)
			move = Math.min(move, i * 2 + name.length() - idx);
			move = Math.min(move, (name.length() - idx) * 2 + i);
		}

		return answer + move;
	}



	public static void main(String[] args) {
		String name="JAN";
		System.out.println(solution(name));
	}
}

/*

*/
