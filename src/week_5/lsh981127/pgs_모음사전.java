package week_5.lsh981127;

import java.util.*;
public class pgs_모음사전 {
    static List<String> list;
    static String [] words = {"A", "E", "I", "O", "U"};

    // 처음에 그냥 조합으로 풀었다가 지문 다시 보니 순서가 달랐다.
    // 저 순서를 어떻게 해야할지 도무지 모르겠어서 참조..

    /**
     * ArrayList에 순서대로 값들을 넣는 방식
     * 왜 ArrayList냐? 바로 index를 활용할 수 있기 때문이다!
     * get() 사용해 ArrayList는 index를 사용할 수 있다!!
     * 0번째 인덱스는 "" 이기에 무의미하고 1번부터 A, AA, AAA 이런 식으로 넣어준다.
     */
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("", 0);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    static void dfs(String str, int len) {
        list.add(str);
        if (len == 5) return;
        // 계속해서 for문의 i = 0부터 값이 들어가기에 알파벳의 제일 앞값부터 들어간다

        for (int i = 0; i < 5; i++) {
            dfs(str + words[i], len + 1);
        }
    }
}

/**
 * 테스트 1 〉	통과 (5.56ms, 64.4MB)
 * 테스트 2 〉	통과 (5.89ms, 78.8MB)
 * 테스트 3 〉	통과 (4.19ms, 64.4MB)
 * 테스트 4 〉	통과 (5.55ms, 83.9MB)
 * 테스트 5 〉	통과 (3.88ms, 72.2MB)
 * 테스트 6 〉	통과 (3.90ms, 79.8MB)
 * 테스트 7 〉	통과 (2.92ms, 74.4MB)
 * 테스트 8 〉	통과 (5.46ms, 89.2MB)
 * 테스트 9 〉	통과 (4.53ms, 77.8MB)
 * 테스트 10 〉	통과 (3.16ms, 72.5MB)
 * 테스트 11 〉	통과 (4.42ms, 82.4MB)
 * 테스트 12 〉	통과 (4.12ms, 73.3MB)
 * 테스트 13 〉	통과 (4.03ms, 73.4MB)
 * 테스트 14 〉	통과 (5.22ms, 83.2MB)
 * 테스트 15 〉	통과 (7.99ms, 77.5MB)
 * 테스트 16 〉	통과 (4.63ms, 74.4MB)
 * 테스트 17 〉	통과 (4.57ms, 80.5MB)
 * 테스트 18 〉	통과 (4.63ms, 83.1MB)
 * 테스트 19 〉	통과 (3.75ms, 76.8MB)
 * 테스트 20 〉	통과 (3.50ms, 73.9MB)
 * 테스트 21 〉	통과 (4.15ms, 73.4MB)
 * 테스트 22 〉	통과 (3.38ms, 75.3MB)
 * 테스트 23 〉	통과 (3.64ms, 77MB)
 * 테스트 24 〉	통과 (3.84ms, 70.1MB)
 * 테스트 25 〉	통과 (4.17ms, 77.5MB)
 * 테스트 26 〉	통과 (3.89ms, 71.1MB)
 * 테스트 27 〉	통과 (5.12ms, 76.7MB)
 * 테스트 28 〉	통과 (3.28ms, 78.8MB)
 * 테스트 29 〉	통과 (3.91ms, 73.7MB)
 * 테스트 30 〉	통과 (3.03ms, 71.3MB)
 * 테스트 31 〉	통과 (3.12ms, 71MB)
 * 테스트 32 〉	통과 (4.16ms, 73.9MB)
 * 테스트 33 〉	통과 (2.97ms, 73.8MB)
 * 테스트 34 〉	통과 (3.64ms, 75.9MB)
 * 테스트 35 〉	통과 (3.25ms, 77.8MB)
 * 테스트 36 〉	통과 (2.99ms, 76.3MB)
 * 테스트 37 〉	통과 (3.95ms, 77MB)
 * 테스트 38 〉	통과 (2.78ms, 77.1MB)
 * 테스트 39 〉	통과 (3.40ms, 78.5MB)
 * 테스트 40 〉	통과 (2.73ms, 73.2MB)
 */