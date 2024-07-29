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
