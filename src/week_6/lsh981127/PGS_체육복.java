package week_6.lsh981127;
import java.util.*;
public class PGS_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        // n : 학생 수
        // Lost : 잃어버린 학생 번호
        // reserve : 가지고 있는 학생 번호

        /**
         * 처음에는, 가지고 있는 애들에 대해서만 hashset을 선언.
         * 여유 있는 애들 중 분실한 애들에 대한 검증을 진행한 이후 진행했으나 13, 14번 예제에서 계속 실패
         *
         * 다른 풀이 참조해보니, 인원수 카운팅을 모든 과정이 끝난 이후
         * 아직 잃어버린 애들만 전체 학생에서 빼주는 식으로 진행하는 것 참고
         *
         * 방법)
         * 잃어버린 애들 / 여유분 있는 애들 에 대해 각각 HashSet 선언
         *
         * 1. 중복되는 애들은 reserveSet에서 제거해주고, 정말 잃어버린 애들만 lost HashSet에 추가
         * 2. reserveSet에 남아있는, 진짜 여분이 있는 애들의 -1, +1 값들이 lost set에 있는지 판단
         *  - 이떄 , 먼저 -1부터 검사하도록 해서 그리디 진행 => 최솟값 보장
         * 3. 최종적으로, lost set에 남아있는 애들은 정말 잃어버린 애들이기에, 전체 학생 수 - lostset 학생 으로 답 return
         *
         */


        Set<Integer> lostS = new HashSet<>();
        Set<Integer> reserveS = new HashSet<>();

        for(int i : reserve) {
            reserveS.add(i);
        }

        for(int i : lost) {
            if(reserveS.contains(i)){
                reserveS.remove(i);
            } else {
                lostS.add(i);
            }
        }

        // 그르네, 굳이 잃어버린 애들 기준으로 생각할 필요가 없네
        // 남은 애들 기준으로 왼,오 판단해서 removeS를 줄이고 길이만 사용하면 되네
        for(Integer i : reserveS) {
            if(lostS.contains(i-1)) {
                lostS.remove(i-1);
            } else if(lostS.contains(i+1)) {
                lostS.remove(i+1);
            }
        }

        return n - lostS.size();
    }
}

/**
 * 테스트 1 〉	통과 (0.07ms, 79.5MB)
 * 테스트 2 〉	통과 (0.07ms, 66.8MB)
 * 테스트 3 〉	통과 (0.12ms, 75.9MB)
 * 테스트 4 〉	통과 (0.06ms, 77.5MB)
 * 테스트 5 〉	통과 (0.11ms, 82.5MB)
 * 테스트 6 〉	통과 (0.08ms, 72.6MB)
 * 테스트 7 〉	통과 (0.07ms, 76.6MB)
 * 테스트 8 〉	통과 (0.07ms, 74.9MB)
 * 테스트 9 〉	통과 (0.08ms, 76.7MB)
 * 테스트 10 〉	통과 (0.16ms, 74.6MB)
 * 테스트 11 〉	통과 (0.06ms, 74.6MB)
 * 테스트 12 〉	통과 (0.06ms, 73MB)
 * 테스트 13 〉	통과 (0.07ms, 73.2MB)
 * 테스트 14 〉	통과 (0.07ms, 73.4MB)
 * 테스트 15 〉	통과 (0.08ms, 75.1MB)
 * 테스트 16 〉	통과 (0.05ms, 73.4MB)
 * 테스트 17 〉	통과 (0.07ms, 78.1MB)
 * 테스트 18 〉	통과 (0.07ms, 73.4MB)
 * 테스트 19 〉	통과 (0.13ms, 71.5MB)
 * 테스트 20 〉	통과 (0.05ms, 76.5MB)
 * 테스트 21 〉	통과 (0.07ms, 88.1MB)
 * 테스트 22 〉	통과 (0.05ms, 70.4MB)
 * 테스트 23 〉	통과 (0.05ms, 76.4MB)
 * 테스트 24 〉	통과 (0.05ms, 73MB)
 * 테스트 25 〉	통과 (0.06ms, 76.5MB)
 * 테스트 26 〉	통과 (0.08ms, 75.9MB)
 * 테스트 27 〉	통과 (0.08ms, 77.8MB)
 * 테스트 28 〉	통과 (0.06ms, 75.6MB)
 * 테스트 29 〉	통과 (0.06ms, 77MB)
 * 테스트 30 〉	통과 (0.06ms, 77.6MB)
 */
