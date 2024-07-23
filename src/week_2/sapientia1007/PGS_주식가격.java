package week_2.sapientia1007;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class PGS_주식가격 {
    static class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            ArrayDeque<Integer> st = new ArrayDeque<>(); // 스택 생성

            // 주식 가격 배열 돌기
            for (int i = 0; i < prices.length; i++) {
                // 현재 주식 가격이 스택 맨 앞 가격보다 작다면 => 주식 가격 떨어짐
                while (!st.isEmpty() && prices[i] < prices[st.peek()]) {
                    int idx = st.pop(); // 떨어진 주식 가격의 인덱스를 가져옴
                    answer[idx] = i-idx; // 떨어진 기간 계산
                }
                st.push(i); // 현재 인덱스 추가
            }

            while (!st.isEmpty()) {
                int idx = st.pop(); // 스택에 남아 있다 => 끝까지 가격 떨어지지 않음 => 남은 기간 계산
                answer[idx] = prices.length-idx-1;
            }
            return answer;
        }
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new int[] {1,2,3,2,3}))); // [4,3,1,1,0]
    }
}
