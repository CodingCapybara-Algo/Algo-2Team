package week_5.lsh981127;
import java.util.*;

public class pgs_소수찾기 {
    static Set<Integer> set;
    static boolean[] visited;

    public static int solution(String numbers) {

        /**
         * 조합을 써서 가능한 수들을 Hashset에 넣고
         * Hashset의 값들에 대해 소수 판별하는 방법
         *
         * 참조한 것
         * - 조합 코드 작성하면서 계속 틀려서
         */

        set = new HashSet<>();
        visited = new boolean[7];

        for(int i = 0; i < numbers.length(); i++) {
            // 글자수에 따른 조합 진행
            comb(numbers, "", i+1);
        }


        int answer = 0;
        for(Integer i : set) {
            // set 안에 있는 값들에 대해 소수 판별하고 소수인 경우, 값 increment
            if(prime(i)) {
                answer++;
            }
        }

        return answer;
    }

    static boolean prime(int n) {
        // 소수 판별
        // 에라토스테네스 체 활용

        if(n < 2) return false;

        for(int i = 2; i <= (int) Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }

        return true;

    }

    static void comb(String numbers, String current, int count) {
        // current : 현재 문자열
        // count : 최대 글자수

        if(count == current.length()) {
            int num = Integer.parseInt(current);
            set.add(num);
            return;
        }

        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb(numbers, current + numbers.charAt(i), count);
                visited[i] = false;
            }
        }
    }
}


/**
 * 테스트 1 〉	통과 (11.36ms, 78.4MB)
 * 테스트 2 〉	통과 (27.33ms, 84.2MB)
 * 테스트 3 〉	통과 (9.26ms, 72.1MB)
 * 테스트 4 〉	통과 (31.16ms, 77.8MB)
 * 테스트 5 〉	통과 (60.89ms, 88.7MB)
 * 테스트 6 〉	통과 (10.49ms, 67.7MB)
 * 테스트 7 〉	통과 (15.32ms, 80.8MB)
 * 테스트 8 〉	통과 (61.60ms, 105MB)
 * 테스트 9 〉	통과 (9.74ms, 86.9MB)
 * 테스트 10 〉	통과 (27.40ms, 80.3MB)
 * 테스트 11 〉	통과 (20.74ms, 76.6MB)
 * 테스트 12 〉	통과 (18.92ms, 81MB)
 */