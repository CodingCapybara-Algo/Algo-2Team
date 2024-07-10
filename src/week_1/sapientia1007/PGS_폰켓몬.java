package week_1.sapientia1007;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/1845
폰켓몬 - Level 1
 */

import java.util.*;
public class PGS_폰켓몬 {
    static class Solution {
        public int solution(int[] nums) {

            int maxNum = nums.length/2; // 최대로 가져갈 수 있는 폰켓몬 수

            HashSet<Integer> ponketmon = new HashSet<>();
            for (int n : nums) {
                ponketmon.add(n); // 중복 제거한 총 폰켓몬 종류
            }
            if (maxNum > ponketmon.size()) return  ponketmon.size(); // 최대로 가져갈 수 있는 수가 중복 제거한 폰켓몬 종류보다 크다 -> 그만큼의 폰켓몬이 없다 -> 중복 제거한 폰켓몬 리턴
            else return maxNum;
        }
    }
    public static void main(String[] args) throws Exception{
        Solution sl = new Solution();
        System.out.println(sl.solution(new int[]{3, 1, 2, 3}));// 2
        System.out.println(sl.solution(new int[]{3, 3, 3, 2, 2, 4}));// 3
        System.out.println(sl.solution(new int[]{3, 3, 3, 2, 2, 2}));// 2
    }
}
