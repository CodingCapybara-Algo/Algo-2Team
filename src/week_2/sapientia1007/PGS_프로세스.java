package week_2.sapientia1007;

import java.util.*;
import java.io.*;

public class PGS_프로세스 {
    static class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐

            // 값이 큰 기준으로 우선순위 큐 생성
            for (int p : priorities){
                pq.offer(p);
            }

            while (!pq.isEmpty()) {
                // 우선순위 큐의 값과 일치하는 값을 찾기 위해 priorities 배열 돌기
                for (int i=0; i< priorities.length; i++) {
                    // 현재 우선순위 큐의 가장 우선적인 값이 priorities 배열의 i번째 값과 일치할때
                    if (pq.peek() == priorities[i]){
                        pq.poll();
                        answer ++; // 우선순위 큐에서 제거하면서 출력 순서 증가

                        if (location == i) return answer; // 현재 인덱스가 찾아야하는 인덱스와 일치하면 출력 순서 출력
                    }
                }
            }
            return  answer;
        }
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {2,1,3,2}, 2)); // 1
        System.out.println(s.solution(new int[] {1,1,9,1,1,1}, 0)); //5
    }
}
