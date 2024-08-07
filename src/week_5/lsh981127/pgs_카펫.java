package week_5.lsh981127;

import java.util.*;
public class pgs_카펫 {
    public int[] solution(int brown, int yellow) {
        // yellow 의 값 : x * y
        // brown : 2 (x + y + 2)
        // yellow 값이 나오는 숫자들 정리
        // 그 이후 brown과 일치하는 것 찾기
        // 그 다음 x + 2, y+2 출력

        Set<int[]> set = new HashSet<>();
        if(yellow == 1) {

        }
        for(int i = 1; i <= yellow; i++) {
            if(i > yellow / i) break;
            if(yellow % i == 0) { // 제대로 나뉘면
                set.add(new int[]{i, yellow / i});
            }
        }

        int result_x = 0, result_y = 0;
        for(int[] i : set) {
            int x = i[0], y = i[1];
            if((y+2+x) * 2 == brown) {
                result_x = x;
                result_y = y;
                break;
            }

        }
        int[] answer = {result_y+2, result_x + 2};

        return answer;
    }

}
