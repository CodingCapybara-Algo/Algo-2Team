package week_1.sapientia1007;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42577
전화번호 목록 - Level 2
 */

import java.io.*;
import java.util.*;

public class Hash_Problem3 {
    static class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            // 해당 배열 저장
            HashMap<String, Integer> numbers = new HashMap<>();
            for (int i=0; i<phone_book.length; i++){
                numbers.put(phone_book[i], i);
            }
            // 특정 번호의 접두가 해시에 key 중 존재한다면 answer=false
            for (int i=0; i<phone_book.length; i++){
                for (int j=0; j<phone_book[i].length(); j++){
                    if (numbers.containsKey(phone_book[i].substring(0, j))) answer = false;
                }
            }

            return answer;
        }

        public static void main(String[] args) throws Exception {
            Solution s = new Solution();
            System.out.println(s.solution(new String[]{"119", "97674223", "1195524421"})); //false
            System.out.println(s.solution(new String[]{"123","456","789"})); //true
            System.out.println(s.solution(new String[]{"12","123","1235","567","88"})); //false
        }
    }
}
