package week_4.lsh981127;

import java.util.Arrays;
import java.util.Comparator;

public class pgs_가장큰수 {
    public String solution(String[] numbers) {
        String[] arr = new String[numbers.length];
        String answer = "";

        for(int i = 0; i < numbers.length; i++) {
            // arr안에 String 형태로 값을 저장
            arr[i] = String.valueOf(numbers[i]);
        }

        // 2개 문자열을 (o1 + o2), (o2 + o1) 붙인 숫자를 비교해 내림차군으로 비교하는 코드
        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        // 제일 큰 값이 0이면 나머지가 전부 0이기에 그냥 0 하나만 출력
        if(arr[0].equals("0")) {
            return "0";
        }

        return String.join("", arr);
    }
}

/**
 * 테스트 1 〉	통과 (197.53ms, 139MB)
 * 테스트 2 〉	통과 (113.38ms, 103MB)
 * 테스트 3 〉	통과 (209.56ms, 123MB)
 * 테스트 4 〉	통과 (14.08ms, 78.3MB)
 * 테스트 5 〉	통과 (129.63ms, 123MB)
 * 테스트 6 〉	통과 (114.32ms, 119MB)
 * 테스트 7 〉	통과 (2.54ms, 66.6MB)
 * 테스트 8 〉	통과 (2.07ms, 73.3MB)
 * 테스트 9 〉	통과 (2.18ms, 76MB)
 * 테스트 10 〉	통과 (2.72ms, 80.1MB)
 * 테스트 11 〉	통과 (2.04ms, 70.3MB)
 * 테스트 12 〉	통과 (2.40ms, 73.8MB)
 * 테스트 13 〉	통과 (1.98ms, 65.1MB)
 * 테스트 14 〉	통과 (1.84ms, 72.5MB)
 * 테스트 15 〉	통과 (2.58ms, 76.3MB)
 */