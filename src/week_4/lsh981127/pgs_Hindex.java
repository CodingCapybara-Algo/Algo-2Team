package week_4.lsh981127;

import java.util.*;

public class pgs_Hindex {
    public int solution(int[] citations) {
        int size = citations.length;
        int answer = 0;
        Integer[] reverse = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        // int[]을 내림차순 정렬하기 위해 Integer[]로 변환

        Arrays.sort(reverse, (a, b) -> b - a);
        // 내림차순 정렬

        // 결국, 넘어선 논문의 갯수!에 초점을 두어야한다.
        // 값들을 순차적으로 돌면서 현재 넘어선 논문의 갯수를 출력하는 방법
        // 인용한 논문 h 값 (reverse[i])을 내림차순한 순서로 돌기에, 최대값을 출력할 수 밖에 없다
        for(int i = 0; i < size; i++) {
            if(reverse[i] < i+1) {
                answer = i;
                return answer;
            }
        }
        return size;
    }
}


/**
 * 테스트 1 〉	통과 (4.41ms, 73.8MB)
 * 테스트 2 〉	통과 (4.43ms, 71.3MB)
 * 테스트 3 〉	통과 (4.64ms, 77.6MB)
 * 테스트 4 〉	통과 (3.22ms, 77.9MB)
 * 테스트 5 〉	통과 (4.81ms, 77.6MB)
 * 테스트 6 〉	통과 (6.21ms, 66.9MB)
 * 테스트 7 〉	통과 (3.98ms, 79.3MB)
 * 테스트 8 〉	통과 (3.82ms, 81.8MB)
 * 테스트 9 〉	통과 (2.87ms, 78.2MB)
 * 테스트 10 〉	통과 (4.06ms, 77.6MB)
 * 테스트 11 〉	통과 (3.93ms, 71.4MB)
 * 테스트 12 〉	통과 (3.53ms, 78MB)
 * 테스트 13 〉	통과 (8.92ms, 75.7MB)
 * 테스트 14 〉	통과 (3.79ms, 82.2MB)
 * 테스트 15 〉	통과 (3.90ms, 76.6MB)
 * 테스트 16 〉	통과 (2.30ms, 73.7MB)
 */