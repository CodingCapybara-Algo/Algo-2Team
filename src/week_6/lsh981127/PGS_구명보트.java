package week_6.lsh981127;
import java.util.*;
public class PGS_구명보트 {
    //https://velog.io/@seonydg/%EC%BD%94%ED%85%8C-%EA%B7%B8%EB%A6%AC%EB%94%94Greedy-%EA%B5%AC%EB%AA%85%EB%B3%B4%ED%8A%B8%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4
    public int solution(int[] people, int limit) {

        // 처음에는 그냥 오름차순 정렬 -> 작은 애들 순서로 채우기라고 생각했지만 틀렸지..
        // 반례 존재, 30 50 50 70


        // 작은 애를 뽑았으면 채울 수 있는 애들 중 가장 큰 애랑 태워야 최대로 태울 수 있다!
        // 투포인터 느낌으로 진행
        // 현재 애 기준으로 남은 애들 중 태울 수 있는 애들을 찾고, 그 중 최대 무게인 애를 선택
        int answer = 0;
        int left= 0;
        int right = people.length - 1;
        Arrays.sort(people);

        while(left < right) {
            int lw = people[left];
            int rw = people[right];
            if(lw + rw <= limit) {
                answer++;
                left++;
                right--;
            } else {
                right--;
            }
        }

        return people.length - answer;
    }

    /**
     * 테스트 1 〉	통과 (2.03ms, 78MB)
     * 테스트 2 〉	통과 (0.88ms, 84MB)
     * 테스트 3 〉	통과 (1.32ms, 75.7MB)
     * 테스트 4 〉	통과 (1.22ms, 76.7MB)
     * 테스트 5 〉	통과 (0.86ms, 82.2MB)
     * 테스트 6 〉	통과 (0.64ms, 78.7MB)
     * 테스트 7 〉	통과 (0.74ms, 81.9MB)
     * 테스트 8 〉	통과 (0.37ms, 77MB)
     * 테스트 9 〉	통과 (0.54ms, 88MB)
     * 테스트 10 〉	통과 (1.09ms, 75.1MB)
     * 테스트 11 〉	통과 (1.16ms, 74MB)
     * 테스트 12 〉	통과 (1.01ms, 69.1MB)
     * 테스트 13 〉	통과 (1.15ms, 73.9MB)
     * 테스트 14 〉	통과 (0.92ms, 76.1MB)
     * 테스트 15 〉	통과 (0.59ms, 73.2MB)
     * 테스트 16 〉	통과 (0.50ms, 78.5MB)
     * 테스트 17 〉	통과 (0.44ms, 72.3MB)
     * 테스트 18 〉	통과 (0.51ms, 75.6MB)
     * 테스트 19 〉	통과 (0.53ms, 77.3MB)
     * 테스트 20 〉	통과 (0.40ms, 72.3MB)
     * 테스트 21 〉	통과 (0.35ms, 76.9MB)
     * 테스트 22 〉	통과 (0.40ms, 71.9MB)
     * 효율성  테스트
     * 테스트 1 〉	통과 (10.41ms, 56.7MB)
     * 테스트 2 〉	통과 (10.14ms, 54MB)
     * 테스트 3 〉	통과 (10.53ms, 56MB)
     * 테스트 4 〉	통과 (6.85ms, 54.1MB)
     * 테스트 5 〉	통과 (8.59ms, 53.3MB)
     */
}
