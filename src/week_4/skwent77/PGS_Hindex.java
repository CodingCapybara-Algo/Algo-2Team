package week_4.skwent77;

import java.util.Arrays;

public class PGS_Hindex {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 논문의 인용 횟수를 정렬합니다.
        // 정렬방법은 고민 x

        int n = citations.length;
        for (int i = 0; i < n; i++) {
            // 남은 논문의 수
            int h = n - i;
            //현재 인덱스 i에서 남은 논문의 수를 계산
            // 예를 들어, i가 0이면 남은 논문의 수는 n이고, i가 1이면 남은 논문의 수=> n-1
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }


}
/*
테스트 1 〉	통과 (0.48ms, 73.5MB)
테스트 2 〉	통과 (0.81ms, 74.1MB)
테스트 3 〉	통과 (0.85ms, 75.5MB)
테스트 4 〉	통과 (1.55ms, 72.7MB)
테스트 5 〉	통과 (0.92ms, 91.6MB)
테스트 6 〉	통과 (0.61ms, 78.9MB)
테스트 7 〉	통과 (0.53ms, 78.4MB)
테스트 8 〉	통과 (0.34ms, 75.7MB)
테스트 9 〉	통과 (0.38ms, 80.5MB)
테스트 10 〉	통과 (0.46ms, 76MB)
테스트 11 〉	통과 (0.61ms, 78.9MB)
테스트 12 〉	통과 (0.36ms, 72.3MB)
테스트 13 〉	통과 (0.58ms, 76.3MB)
테스트 14 〉	통과 (0.62ms, 74.3MB)
테스트 15 〉	통과 (0.74ms, 78.5MB)
테스트 16 〉	통과 (0.35ms, 73.7MB)
 */