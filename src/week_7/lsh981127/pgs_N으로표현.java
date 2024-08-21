package week_7.lsh981127;

import java.util.*;
public class pgs_N으로표현 {

    // 문제 못 풀어서 참고함!
    // https://velog.io/@dh1010a/Java-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A442895-N%EC%9C%BC%EB%A1%9C-%ED%91%9C%ED%98%84
    // 핵심! 미리 1개, 2개 ~~ 사용한 경우들에 대해 준비하고 연산하는 것

    // 근데, 그게 최솟값이 보장되는 이유?
    public int solution(int N, int number) {
        if(N == number) return 1;

        ArrayList<Set<Integer>> dp = new ArrayList<>();
        // 각 자릿수별 나올 수 있는 수를 보관하기 위한 리스트<세트> 자료구조

        for(int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }

        // 1개만 쓴 경우 : N 1개밖에 없으니 넣어주고
        dp.get(1).add(N);

        for(int i = 2; i < 9; i++) {
            // i 개를 사용한 경우들
            Set<Integer> set = dp.get(i);

            // N이란 값을 i번 반복해서 붙이는 코드
            // 33, 333, 3333 이런 식
            set.add(Integer.parseInt(String.valueOf(N).repeat(i)));

            for(int j = 1; j <= i; j++) {
                // j 번째 자리 ~ i-j번째 자리 경우
                // 각 경우들에 대해 4칙 연산 진행

                Set<Integer> aSet = dp.get(j);
                Set<Integer> bSet = dp.get(i-j);

                for(int aVal : aSet) {
                    for(int bVal : bSet) {
                        set.add(aVal + bVal);   // A + B
                        set.add(aVal - bVal);   // A - B
                        set.add(bVal - aVal);   // B - A
                        set.add(aVal * bVal);   // A * B
                        if(aVal != 0) set.add(bVal / aVal);     // B / A
                        if(bVal != 0) set.add(aVal / bVal);     // A / B
                    }

                }
            }

        }

        // 근데, 이게 최솟값이 보장이 되는 거야?
        // 아, 자리 갯수를 1부터 올라가면서 탐색하니까
        // 최초로 찾은 경우가 최소 자리로 구한 경우인거지.

        for(Set<Integer> set : dp) {
            if(set.contains(number)) {
                return dp.indexOf(set);
            }
        }
        return -1;
    }
}

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (31.10ms, 82MB)
 * 테스트 2 〉	통과 (5.82ms, 80.3MB)
 * 테스트 3 〉	통과 (11.83ms, 74.6MB)
 * 테스트 4 〉	통과 (40.92ms, 79.7MB)
 * 테스트 5 〉	통과 (27.12ms, 84.4MB)
 * 테스트 6 〉	통과 (30.06ms, 88.6MB)
 * 테스트 7 〉	통과 (39.23ms, 93.9MB)
 * 테스트 8 〉	통과 (27.49ms, 86.6MB)
 * 테스트 9 〉	통과 (0.02ms, 76.1MB)
 */
