package week_6.lsh981127;
import java.util.*;
public class PGS_큰수만들기 {
    // https://velog.io/@joonghyun/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%81%B0-%EC%88%98-%EB%A7%8C%EB%93%A4%EA%B8%B0-%EC%9E%90%EB%B0%94
    public String solution(String number, int k) throws Exception{

        // k 자리를 뺀다 = number.size() - k 개 자리만 고려한다.
        // 뒤에서부터 구해야하는 자리수 만큼 남겨두고 생각하기

        /**
         *  i번째 뽑는 자리
         *  선택한 부분의 앞으로는 필요없으니 계속해서 start 를 사용해서 불필요한 부분에 대한 탐색은 제거
         *  구해야하는 남은 갯수들을 구한다.
         */
        int len = number.length() - k;
        int start = 0;
        char[] num = number.toCharArray();
        StringBuilder sb = new StringBuilder();
        String answer = "";
        for(int i = 0; i < len; i++) {
            // i는 뽑은 자릿수
            char max = '0';
            for(int j = start; j <= i+k;j++) {
                // start 지점부터 i번째 자리+ 잘라야할 k개
                if(num[j] > max) {
                    max = num[j];
                    start = j + 1;
                    // j번째를 넣으면, j+1번째부터 탐색하게 하기 위해
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }
}

/**
 * 테스트 1 〉	통과 (0.10ms, 74.1MB)
 * 테스트 2 〉	통과 (0.03ms, 71.8MB)
 * 테스트 3 〉	통과 (0.06ms, 81.1MB)
 * 테스트 4 〉	통과 (0.11ms, 73.9MB)
 * 테스트 5 〉	통과 (0.27ms, 74.5MB)
 * 테스트 6 〉	통과 (15.98ms, 80.3MB)
 * 테스트 7 〉	통과 (30.56ms, 85.6MB)
 * 테스트 8 〉	통과 (164.25ms, 79.8MB)
 * 테스트 9 〉	통과 (15.61ms, 87.8MB)
 * 테스트 10 〉	통과 (6058.70ms, 93.6MB)
 * 테스트 11 〉	통과 (0.03ms, 76.1MB)
 * 테스트 12 〉	통과 (0.05ms, 77MB)
 */
