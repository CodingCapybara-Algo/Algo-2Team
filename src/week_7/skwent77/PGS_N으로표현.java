package week_7.skwent77;

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;

public class PGS_N으로표현 {
    public static int solution(int N, int number) {
/* 예시 : N(5)을 3번 사용하여 만들 수 있는 수 표현하는 과정
줄 28에서 5를 1번 사용한 경우 dp[1]에 5가 추가됨 dp[1]={5}
for 문 안에서 해당 예시에 대해 이루어지는 프로세스 설명 =>
step 1. i가 2일 때
Integer.parseInt(String.valueOf(N).repeat(i))을 사용하여 55를 추가합니다.
dp[2] = {55}
dp[1]과 dp[1]의 조합을 사용하여 currentSet을 업데이트 x =y=dp[1] 의 값 5
dp[2] => {55, 10 , 5-5 , 5/5 }
 step 2 .i가 3일 때 currentSet은 dp[3]
 currentSet.add(Integer.parseInt(String.valueOf(N)) 에서 dp[3]={555}
 => dp[3]은 {555, 60, -50, 275, 15, 5, 50, 30, 20, 125, 6}

 dp 배열은 각 단계에서 가능한 모든 숫자들을 조합하여 업데이트 이루어짐


 */


        // 예외 처리: 만약 N이 number와 같다면 바로 1을 반환
        if (N == number) {
            return 1;
        }

        // DP 테이블 생성: dp[i]는 N을 i번 이용하여 만들 수 있는 수들의 집합
        List<Set<Integer>> dp = new ArrayList<>();

        // 1부터 8까지의 DP 테이블 초기화
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
            //Set<Integer>는 해당 사용 횟수로 만들 수 있는 숫자들의 집합을 저장
        }

        // N을 1번 사용했을 때는 N 그 자체만 만들 수 있음
        dp.get(1).add(N);

        // 2번부터 8번까지 사용하여 만들 수 있는 숫자들을 채워나감
        for (int i = 2; i <= 8; i++) {
            Set<Integer> currentSet = dp.get(i);

            // N을 i번 연속해서 사용한 숫자를 추가 (예: 55, 555 등)
            currentSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));

            // j번 사용한 결과와 i-j번 사용한 결과의 조합으로 i번 사용한 결과를 생성
            for (int j = 1; j < i; j++) {
                for (int x : dp.get(j)) {
                    for (int y : dp.get(i - j)) {
                        currentSet.add(x + y);      // 덧셈
                        currentSet.add(x - y);      // 뺄셈
                        currentSet.add(x * y);      // 곱셈
                        if (y != 0) {               // 나눗셈 (0으로 나누는 경우를 피함)
                            currentSet.add(x / y);
                        }
                    }
                }
            }

            // 현재 집합에 목표 숫자가 포함되어 있는지 확인
            if (currentSet.contains(number)) {
                return i;  // 포함되어 있으면 현재 사용한 횟수 i를 반환
            }
        }

        // 목표 숫자를 8번 이내로 만들 수 없는 경우 -1을 반환
        return -1;
    }
        //https://gurumee92.tistory.com/164 못풀어서 참고



    public static void main(String[] args) {
        int answer = 0;
        int N = 5;
        int number = 3;
        answer = solution(N, number);
    }
}

