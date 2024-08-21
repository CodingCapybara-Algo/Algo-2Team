package week_7.heogeonho;

import java.util.*;
/*
특정 i의 연산을 위해서 이전 연산을 통해 만들어진 수를 사용하여 (메모이제이션)
처리한다라는 아이디어가 새로웠음
 */
public class PGS_N으로표현 {

	static int solution(int N, int number) {
		// DP 리스트 생성
		// 각 인덱스 i는 N을 i번 사용해서 만들 수 있는 경우
		List<Set<Integer>> dp = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			dp.add(new HashSet<>()); // HashSet을 사용하여 중복된 수가 저장되지 않도록 함
		}

		// N을 통해 만들수 있는 기본 수 저장 (기저상태?)
		for (int i = 1; i < 9; i++) {
			int num = 0;
			int repeat = N;

			for (int j = 0; j < i; j++) {
				num = num * 10 + repeat;
			}
			dp.get(i).add(num);
		}

		// DP?? 처리
		// dp[i]에 대해 dp[j]와 dp[i-j]의 연산 결과로 새로운 값을 생성
		// 예를 들어 4인 경우를 구하려면 (1,3) (2,2) (3,1) 의 경우를 통해 연산해야 하니 i-j로 처리!!
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < i; j++) {
				// dp[j]와 dp[i-j]에 있는 모든 값을 가져와서 사칙연산을 수행
				for (int x : dp.get(j)) {
					for (int y : dp.get(i - j)) {
						dp.get(i).add(x + y); // 덧셈 결과 추가
						dp.get(i).add(x - y); // 뺄셈 결과 추가
						dp.get(i).add(x * y); // 곱셈 결과 추가
						if (y != 0) {
							dp.get(i).add(x / y); // 나눗셈 결과 추가 (0으로 나누는 경우 제외)
						}
					}
				}
			}

			// dp[i]에 목표 숫자(number)가 포함되어 있으면 i를 반환
			// 이 경우, N을 i번 사용하여 목표 숫자를 만들 수 있다는 의미 (빠른 return)
			if (dp.get(i).contains(number)) {
				return i; // 최소 사용 횟수 i 반환
			}
		}

		// 8번 이하로 목표 숫자를 만들 수 없는 경우 -1 반환
		return -1;
	}

	public static void main(String[] args) {
		int N = 5;
		int number = 12;

		System.out.println(solution(N, number)); // 결과 출력
	}
}
