package week_1.skwent77;

import java.util.Arrays;

public class pgs_전화번호목록 {
    class Solution {

        public boolean solution(String[] phone_book) {
            // 전화번호 목록을 정렬
            Arrays.sort(phone_book);

            // 인접한 전화번호들만 비교
            for (int i = 0; i < phone_book.length - 1; i++) {
                // 현재 전화번호가 다음 전화번호의 접두사인지 확인
                if (phone_book[i + 1].startsWith(phone_book[i])) {
                    return false;
                }
            }

            return true;
        }
    }
}