package week_2.sapientia1007;

import java.util.*;

public class PGS_같은숫자는싫어 {

    static class Solution {
        public int[] solution(int[] arr) {

            // 스택 생성
            ArrayDeque<Integer> s = new ArrayDeque<>();

            s.add(arr[0]); // 일단 하나 저장

            // arr 배열 내 숫자 중 s의 가장 최근에 들어간 숫자와 같지 않다면 추가
            for (int a : arr) {
                if (s.peekLast() != a) {
                    s.add(a);
                }
            }

            int[] answer = new int[s.size()];

            int idx = 0;
            // 배열 저장
            while(!s.isEmpty()){
                answer[idx++] = s.pop();
            }
            return answer;
        }
    }

    public static void main(String[] args) throws Exception {
        Solution s1 = new Solution();
        System.out.println(Arrays.toString(s1.solution(new int[] {1,1,3,3,0,1,1}))); // [1,3,0,1]
        System.out.println(Arrays.toString(s1.solution(new int[] {4,4,4,3,3}))); // [4,3]
    }
}
