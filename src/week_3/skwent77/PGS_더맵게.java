package week_3.skwent77;

import java.util.*;
public class PGS_더맵게{
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int a : scoville) {
            heap.add(a);
        }

        int count = 0;

        while (heap.peek() < K) {
            if (heap.size() < 2)
                return -1;
            int a = heap.poll();
            int b = heap.poll();
            int c = a + 2 * b;
            heap.add(c);
            count++;
        }

        return count;
    }

}

/*

테스트 1 〉	통과 (0.04ms, 80.2MB)
테스트 2 〉	통과 (0.05ms, 83.1MB)
테스트 3 〉	통과 (0.07ms, 76.2MB)
테스트 4 〉	통과 (0.07ms, 75.3MB)
테스트 5 〉	통과 (0.05ms, 73.5MB)
테스트 6 〉	통과 (1.70ms, 77.4MB)
테스트 7 〉	통과 (1.55ms, 69.3MB)
테스트 8 〉	통과 (0.59ms, 77.9MB)
테스트 9 〉	통과 (0.49ms, 76.6MB)
테스트 10 〉	통과 (1.37ms, 82.8MB)
테스트 11 〉	통과 (2.54ms, 75.2MB)
테스트 12 〉	통과 (2.47ms, 74.6MB)
테스트 13 〉	통과 (1.99ms, 75.9MB)
테스트 14 〉	통과 (0.13ms, 75.5MB)
테스트 15 〉	통과 (2.39ms, 78.5MB)
테스트 16 〉	통과 (0.05ms, 70.4MB)
테스트 17 〉	통과 (0.05ms, 74.1MB)
테스트 18 〉	통과 (0.04ms, 78.5MB)
테스트 19 〉	통과 (0.05ms, 73.9MB)
테스트 20 〉	통과 (0.04ms, 77.9MB)
테스트 21 〉	통과 (0.05ms, 75.4MB)
테스트 22 〉	통과 (0.05ms, 91.1MB)
테스트 23 〉	통과 (0.06ms, 75.4MB)
테스트 24 〉	통과 (0.06ms, 69.3MB)
테스트 25 〉	통과 (0.08ms, 79.5MB)
테스트 26 〉	통과 (0.10ms, 75.8MB)
효율성  테스트
테스트 1 〉	통과 (137.56ms, 65.4MB)
테스트 2 〉	통과 (255.08ms, 87MB)
테스트 3 〉	통과 (1347.58ms, 123MB)
테스트 4 〉	통과 (115.65ms, 64MB)
테스트 5 〉	통과 (1658.25ms, 122MB)
*/




