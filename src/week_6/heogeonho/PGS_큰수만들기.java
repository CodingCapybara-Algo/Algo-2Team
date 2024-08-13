package week_6.heogeonho;

import java.util.*;

public class PGS_큰수만들기 {
	
	/*
	더 큰 자리수부터 비교해야 한다고 생각
	비교하는 범위는 지울 수 있는 수의 갯수 + 1 범위를 비교하고
	해당 범위 내의 최댓값을 찾아 왼쪽 인덱스들은 지운다
	지운 수 갯수만큼 k에서 빼고 위에서 남은 최댓값 자리 이후로 반복하고 k가 0인 경우 종료?

	number

	1231234 3

	0~3 1231 -> 3 -> k-2=1
	3~4 12 -> 2 -> k-1=0
	 */


	static String solution(String number, int k) {
		int left=0;
		int right=k;
		int finalLen=number.length()-k;

		//반복 과정에서
		//왼쪽 포인트는 찾은 큰수 + 1
		//오른쪽 포인트는 왼쪽 + k
		StringBuilder answer = new StringBuilder();
		while(true) {
			char max=' ';
			int maxIdx=0;
			for(int i=left; i<=right; i++) {
				if(max<number.charAt(i)) {
					max = number.charAt(i);
					maxIdx = i;
				}
			}
			System.out.println("left:"+left+" // right: "+right+" /// maxidx"+maxIdx+"-->ans"+answer+" k는"+k);
			answer.append(number.charAt(maxIdx));

			k=k-(maxIdx-left);
			left=maxIdx+1;
			if(k==0) break;
			if(answer.length()==finalLen) break;
			right=left+k;
//			System.out.println("left:"+left+" right:"+right);
		}
//		System.out.println("left:"+left);
		if(answer.length()!=finalLen) {
			for (int i = left; i < number.length(); i++)
				answer.append(number.charAt(i));
		}
		return answer.toString();
	}


	public static void main(String[] args) {
		String number="1000100011";
		String numb="1 0 0 0 1 0 0 0 1 1";
		String numbx="0 1 2 3 4 5 6 7 8 9";
		//
		int k=5;
		System.out.println(numb);
		System.out.println(numbx);
		System.out.println(solution(number, k));
	}

}

/*
테스트 1 〉	통과 (0.04ms, 71.4MB)
테스트 2 〉	통과 (0.03ms, 74.6MB)
테스트 3 〉	통과 (0.05ms, 74.5MB)
테스트 4 〉	통과 (0.09ms, 74MB)
테스트 5 〉	통과 (0.54ms, 79.2MB)
테스트 6 〉	통과 (28.98ms, 81MB)
테스트 7 〉	통과 (49.68ms, 92.9MB)
테스트 8 〉	통과 (200.29ms, 79.6MB)
테스트 9 〉	통과 (14.20ms, 81MB)
테스트 10 〉	통과 (6970.37ms, 74MB)
테스트 11 〉	통과 (0.04ms, 73.4MB)
테스트 12 〉	통과 (0.05ms, 76MB)
*/
