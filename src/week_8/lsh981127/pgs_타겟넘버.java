package week_8.lsh981127;

import java.util.ArrayDeque;

public class pgs_타겟넘버 {
    public int solution(int[] numbers, int target) {

        // numbers 의 숫자 순서는 변하지 않는다.
        // 모든 숫자 앞에 + 일지, -일지만 고려하기
        // 각 값들은 양수, 즉 -1을 곱할지 말지만 고려하면 된다.
        int size = numbers.length;
        boolean[] visited = new boolean[size];
        int[] dir = new int[]{1, -1};
        ArrayDeque<int[]> aq = new ArrayDeque<>();
        aq.offer(new int[]{0, 0});
        // 왼쪽이 몇번째 숫자 작업중인지, 오른쪽이 숫자
        int answer = 0;
        while(!aq.isEmpty()) {
            int[] temp = aq.poll();
            int cur = temp[0];
            int num = temp[1];
            if(cur == size) {
                if(num == target) {
                    answer++;
                }
                continue;
            }

            if(cur < size) {
                int val = numbers[cur];
                for(int i : dir) {
                    int count = num + val * i;
                    aq.offer(new int[]{cur+1, count});
                }
            }
        }
        return answer;
    }
}

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (121.36ms, 162MB)
 * 테스트 2 〉	통과 (104.61ms, 167MB)
 * 테스트 3 〉	통과 (1.13ms, 84.4MB)
 * 테스트 4 〉	통과 (2.83ms, 78.5MB)
 * 테스트 5 〉	통과 (11.67ms, 88.5MB)
 * 테스트 6 〉	통과 (1.40ms, 78.7MB)
 * 테스트 7 〉	통과 (0.85ms, 73.2MB)
 * 테스트 8 〉	통과 (5.10ms, 79.4MB)
 */