package week_6.skwent77;
import java.util.Arrays;

public class PGS_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 투 포인터
        int left, right;
        Arrays.sort(people);
        left = 0;
        right = people.length-1;

        // 최대한 적게 사용하여 모든 사람 구출
        while (left <= right) {
            //두 사람의 몸무게 합이 보트의 무게 제한 넘지 않으면 둘을 함께 태우고 보트를 사용
            if (people[left] + people[right] <= limit) {
                left += 1;
            }
            right -= 1;
            answer += 1;


        }
        return answer;
    }
}


/*
정확성  테스트
테스트 1 〉	통과 (1.51ms, 69.4MB)
테스트 2 〉	통과 (1.19ms, 84.9MB)
테스트 3 〉	통과 (1.89ms, 69.8MB)
테스트 4 〉	통과 (1.44ms, 86.6MB)
테스트 5 〉	통과 (1.11ms, 67.8MB)
테스트 6 〉	통과 (0.89ms, 75.7MB)
테스트 7 〉	통과 (0.84ms, 71.6MB)
테스트 8 〉	통과 (0.45ms, 71.6MB)
테스트 9 〉	통과 (0.61ms, 74.9MB)
테스트 10 〉	통과 (1.10ms, 76MB)
테스트 11 〉	통과 (1.70ms, 76.9MB)
테스트 12 〉	통과 (1.52ms, 67MB)
테스트 13 〉	통과 (1.05ms, 79MB)
테스트 14 〉	통과 (1.12ms, 76.5MB)
테스트 15 〉	통과 (0.49ms, 70.4MB)
테스트 16 〉	통과 (0.53ms, 73.1MB)
테스트 17 〉	통과 (0.63ms, 70.8MB)
테스트 18 〉	통과 (0.43ms, 77.4MB)
테스트 19 〉	통과 (0.51ms, 76.7MB)
테스트 20 〉	통과 (0.38ms, 73.3MB)
테스트 21 〉	통과 (0.68ms, 77.4MB)
테스트 22 〉	통과 (0.59ms, 64.9MB)
효율성  테스트
테스트 1 〉	통과 (10.98ms, 55.5MB)
테스트 2 〉	통과 (8.26ms, 54MB)
테스트 3 〉	통과 (9.41ms, 56.3MB)
테스트 4 〉	통과 (6.69ms, 53.8MB)
테스트 5 〉	통과 (9.67ms, 53.8MB)
    정확성: 81.5
    효율성: 18.5
 */