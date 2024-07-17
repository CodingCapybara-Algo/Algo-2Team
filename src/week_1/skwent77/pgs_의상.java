package week_1.skwent77;


import java.util.*;

public class pgs_의상 {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 0;


            // 의상 종류별로 의상을 저장할 맵 생성
            HashMap<String, ArrayList<String>> clothesMap = new HashMap<>();

            // 의상을 맵에 추가
            for (String[] item : clothes) {
                String clothing = item[0];
                String category = item[1];
                clothesMap.putIfAbsent(category, new ArrayList<>());
                clothesMap.get(category).add(clothing);
            }

            // 모든 종류의 의상 개수를 세고 곱해준다.
            answer++;
            for (ArrayList<String> items : clothesMap.values()) {
                answer *= (items.size() + 1);
            }


            return answer - 1;
        }
    }
}