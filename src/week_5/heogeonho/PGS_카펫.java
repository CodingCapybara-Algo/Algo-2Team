package week_5.heogeonho;

import java.util.Arrays;

public class PGS_카펫 {
	
	/*
	입력 받은 수의 약수를 전부 찾아 계산 (제곱근까지 순회)
	yellow의 약수 하나 찾아서 가로세로 찾기
	약수를 num이라고 할 때

	(num*2) + ((yellow/num)*2) + 4
	위 값이 brown이 될 때가 결괴
	 */


	static int[] solution(int brown, int yellow) {
		int num=1; // 노란색의 세로 길이로 생각
		int[] answer = new int[2];
		while (num<=Math.sqrt(yellow)) {
			if(yellow%num==0) {
				if((num*2) + ((yellow/num)*2) + 4 == brown) {
					answer[1] = num+2;
					answer[0] = (yellow/num) + 2;
					break;
				}
			}
			num++;
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(24, 24)));
	}
}

/*
테스트 1 〉	통과 (0.02ms, 70.9MB)
테스트 2 〉	통과 (0.03ms, 74.4MB)
테스트 3 〉	통과 (0.05ms, 75.6MB)
테스트 4 〉	통과 (0.03ms, 73.2MB)
테스트 5 〉	통과 (0.09ms, 73.2MB)
테스트 6 〉	통과 (0.03ms, 76.6MB)
테스트 7 〉	통과 (0.04ms, 77.9MB)
테스트 8 〉	통과 (0.05ms, 67.7MB)
테스트 9 〉	통과 (0.05ms, 73.6MB)
테스트 10 〉	통과 (0.05ms, 73MB)
테스트 11 〉	통과 (0.03ms, 71.4MB)
테스트 12 〉	통과 (0.03ms, 68.7MB)
테스트 13 〉	통과 (0.03ms, 71.4MB)
*/
