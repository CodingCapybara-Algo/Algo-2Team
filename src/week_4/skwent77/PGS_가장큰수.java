package week_4.skwent77;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class PGS_가장큰수 {
    public static String solution(int[] numbers) {
        // 각 가능한 선두 숫자 (0부터 9까지)에 대한 버킷 생성
        List<List<String>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        // 숫자를 문자열로 변환하고 선두 숫자에 따라 버킷에 분배
        for (int num : numbers) {
            String numStr = Integer.toString(num);
            int leadingDigit = numStr.charAt(0) - '0';
            buckets.get(leadingDigit).add(numStr);
        }

        // 각 버킷을 커스텀 비교기를 사용하여 정렬
        for (List<String> bucket : buckets) {
            bucket.sort(new Comparator<String>() {
                @Override
                public int compare(String n1, String n2) {
                    return (n2 + n1).compareTo(n1 + n2);
                }
            });
        }

        // 가장 큰 수를 만들기 위해 역순으로 정렬된 버킷들을 병합
        StringBuilder answer = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (String str : buckets.get(i)) {
                answer.append(str);
            }
        }

        // 가장 큰 수가 0인 경우만 따로 처리
        if (answer.charAt(0) == '0') {
            //(예: [0, 0])
            return "0";
        }

        return answer.toString();
    }
}
/*
테스트 1 〉	통과 (137.02ms, 118MB)
테스트 2 〉	통과 (97.53ms, 104MB)
테스트 3 〉	통과 (168.16ms, 145MB)
테스트 4 〉	통과 (13.58ms, 72.7MB)
테스트 5 〉	통과 (84.94ms, 109MB)
테스트 6 〉	통과 (83.16ms, 103MB)
테스트 7 〉	통과 (1.79ms, 74.4MB)
테스트 8 〉	통과 (1.58ms, 73.5MB)
테스트 9 〉	통과 (1.60ms, 77.5MB)
테스트 10 〉	통과 (1.49ms, 71.5MB)
테스트 11 〉	통과 (1.75ms, 76.1MB)
테스트 12 〉	통과 (1.81ms, 77MB)
테스트 13 〉	통과 (1.52ms, 73MB)
테스트 14 〉	통과 (1.54ms, 75.4MB)
테스트 15 〉	통과 (1.49ms, 75.8MB)
 */