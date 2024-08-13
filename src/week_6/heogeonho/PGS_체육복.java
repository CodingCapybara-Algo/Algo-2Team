package week_6.heogeonho;

import java.util.*;

public class PGS_체육복 {
	
	/*
	lost 체크
	일단 리 중 lost 해당 사람 있나 체크 후

	lost 작은번호부터 순회
	reserve에 번호 -1 체크 & +1 체크

	-> 추가 아이디어
	값을 빼는 것만 생각 했는데
	해당 위치의 값을 특정 값으로 처리해주면 같은 효과를 볼 수 있음
	 */


	static int solution(int n, int[] lost, int[] reserve) {

		int answer = n - lost.length;

		// 작은 번호부터 처리하기 위해 sort
		Arrays.sort(lost);
		Arrays.sort(reserve);

		for(int i = 0; i < lost.length; i++) {
			for(int j = 0; j < reserve.length; j++) {
				if(lost[i] == reserve[j]) {
					answer++;
					lost[i] = 0;
					reserve[j] = 0;
					break;
				}
			}
		}

		for(int i = 0; i < lost.length; i++) {
			for(int j = 0; j < reserve.length;j++) {
				if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])) {
					answer++;
					reserve[j]=0;
					break;
				}
			}
		}
		return answer;
	}


	public static void main(String[] args) {
		int n=5;
		int[] lost=new int[] {2, 4};
		int[] reserve=new int[] {1, 3, 5};
		System.out.println(solution(n, lost, reserve));
	}

}

/*

*/
