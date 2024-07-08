package week_1.sapientia1007;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42578
의상 - Level 2
 */

import java.io.*;
import java.util.*;

public class Hash_Problem4 {
    static class Solution {
        public int solution(String[][] clothes) {
            HashMap<String, Integer> clothHash = new HashMap<>();

            // 배열 저장 (각 종류별 갯수 저장)
            for (int i=0; i<clothes.length; i++) {
                String clothType = clothes[i][1];
                String clothName = clothes[i][0];
                if (clothHash.containsKey(clothType)) clothHash.put(clothType, clothHash.get(clothType) + 1);
                else clothHash.put(clothType, 1);
            }

            // 조합
            int answer =1;
            for (int i: clothHash.values()) answer *= (i+1);

            return answer-1; // 아무것도 안 입은 경우 제외
        }
    }

        public static void main(String[] args) throws Exception {
            Solution s = new Solution();
            System.out.println(s.solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}})); //5
            System.out.println(s.solution(new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}})); //3
        }
    }

