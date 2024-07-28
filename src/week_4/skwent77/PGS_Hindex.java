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
