package week_5.skwent77;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class PGS_소수찾기 {
    static boolean[] used;

    public int solution(String numbers) {
        Set<Integer> primes = new HashSet<>(); //not mine
        int answer = 0;
        int[] arr = new int[numbers.length()];
        used = new boolean[numbers.length()];

        String[] tokens = numbers.split("");
        int index = 0;
        for (String token : tokens)
            arr[index++] = Integer.parseInt(token);
        generateNumbers(arr, used, "", primes);
        answer = primes.size();
        return answer;
    }

    void generateNumbers(int[] arr, boolean[] used, String current, Set<Integer> primes) {

        if (!current.isEmpty()) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {  // 현재 숫자가 사용되지 않았다면
                used[i] = true;
                generateNumbers(arr, used, current + arr[i], primes); // 재귀적으로 숫자 생성
                used[i] = false;
                //방문값을 원래대로 돌려놓는 행위는 백트래킹의 중요한 부분 중 하나니 잊지 말기
            }
        }
    }

    boolean isPrime(int n) {
        if (n <= 1) {
            return false; // 1 이하의 숫자는 소수가 아님
        }
        for (int i = 2; i < n; i++) {

            if (n % i == 0) {
                return false;

            }
        }
        return true;
    }

    public static void main(String[] args) {
        PGS_소수찾기 solution = new PGS_소수찾기();
        System.out.println(solution.solution("17")); // 예시 테스트 3
        System.out.println(solution.solution("011")); // 예시 테스트 2
    }
}
/*
 접근법 1) 숫자 조합해서 자연수로 만들기 2) 탐색으로 조합한 숫자의 소수인지 판별
 회고: 탐색을 재귀적으로 구현하는 데에 몰두한 나머지 Set의 필요성 스스로 생각 못함.
      다음에는 PermMain의 로직 잘 익혀놓고 비슷한 방식으로 구현하면 문제 x
 분석: 주어진 숫자 길이가 작기 떄문에 시간 복잡도 큰 문제 없음. 실행 시간 아래와 같음
/*
테스트 1 〉	통과 (10.35ms, 75.1MB)
테스트 2 〉	통과 (30.60ms, 83.2MB)
테스트 3 〉	통과 (10.29ms, 77.5MB)
테스트 4 〉	통과 (26.25ms, 79.2MB)
테스트 5 〉	통과 (18.28ms, 82.7MB)
테스트 6 〉	통과 (13.18ms, 73.8MB)
테스트 7 〉	통과 (15.02ms, 77.2MB)
테스트 8 〉	통과 (27.38ms, 87.9MB)
테스트 9 〉	통과 (10.75ms, 80.1MB)
테스트 10 〉	통과 (123.88ms, 81.9MB)
테스트 11 〉	통과 (17.43ms, 73MB)
테스트 12 〉	통과 (13.70ms, 77.9MB)
 */
