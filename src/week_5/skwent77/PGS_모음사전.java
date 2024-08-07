package week_5.skwent77;
import java.util.*;

public class PGS_모음사전 {
    static char[] arr = {'A', 'E', 'I', 'O', 'U'};

    //중복 허용하는 순열
    public static void comp(String word, int length, List<String> dict) {
        if (length > 5) return;

        dict.add(word);

        for (char vowel : arr) {
            comp(word + vowel, length + 1, dict);
        }
    }

    public static int solution(String word) {
        List<String> dict = new ArrayList<>();

        comp("", 0, dict);
        Collections.sort(dict);  // 사전순 정렬

        return dict.indexOf(word);
    }
}
/*
테스트 1 〉	통과 (21.44ms, 78.3MB)
테스트 2 〉	통과 (29.85ms, 97.1MB)
테스트 3 〉	통과 (24.70ms, 84.2MB)
테스트 4 〉	통과 (27.24ms, 86.7MB)
테스트 5 〉	통과 (25.76ms, 90.6MB)
테스트 6 〉	통과 (20.42ms, 77.9MB)
테스트 7 〉	통과 (21.49ms, 76.6MB)
테스트 8 〉	통과 (26.31ms, 68.5MB)
테스트 9 〉	통과 (19.36ms, 85.6MB)
테스트 10 〉	통과 (23.76ms, 80.8MB)
테스트 11 〉	통과 (20.39ms, 78.9MB)
테스트 12 〉	통과 (19.58ms, 78.2MB)
테스트 13 〉	통과 (19.55ms, 79.5MB)
테스트 14 〉	통과 (26.83ms, 88.3MB)
테스트 15 〉	통과 (17.58ms, 81.7MB)
테스트 16 〉	통과 (21.67ms, 84.2MB)
테스트 17 〉	통과 (24.05ms, 81.3MB)
테스트 18 〉	통과 (24.92ms, 82.5MB)
테스트 19 〉	통과 (43.19ms, 78.3MB)
테스트 20 〉	통과 (27.64ms, 97.4MB)
테스트 21 〉	통과 (21.16ms, 80.6MB)
테스트 22 〉	통과 (17.86ms, 83.6MB)
테스트 23 〉	통과 (24.10ms, 85.9MB)
테스트 24 〉	통과 (23.43ms, 84.8MB)
테스트 25 〉	통과 (20.98ms, 82.4MB)
테스트 26 〉	통과 (23.33ms, 83.5MB)
테스트 27 〉	통과 (19.12ms, 73.8MB)
테스트 28 〉	통과 (25.58ms, 87.9MB)
테스트 29 〉	통과 (19.33ms, 74.4MB)
테스트 30 〉	통과 (24.50ms, 88MB)
테스트 31 〉	통과 (16.24ms, 78.4MB)
테스트 32 〉	통과 (19.20ms, 81.1MB)
테스트 33 〉	통과 (20.30ms, 85.2MB)
테스트 34 〉	통과 (24.47ms, 81.3MB)
테스트 35 〉	통과 (27.40ms, 71.2MB)
테스트 36 〉	통과 (21.33ms, 80.1MB)
테스트 37 〉	통과 (30.31ms, 84.8MB)
테스트 38 〉	통과 (16.52ms, 81.2MB)
테스트 39 〉	통과 (20.84ms, 79MB)
테스트 40 〉	통과 (21.75ms, 82.1MB)
 */