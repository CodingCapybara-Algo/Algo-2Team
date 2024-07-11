package week_1.lsh981127;
import java.util.*;
public class pgs_전화번호목록 {
    public static boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        // ArrayList로 진행하니 시간 초과
        // index를 활용해 비교하고 넘어가고 싶어서 HashSet 사용

        for (int i = 0; i < phone_book.length; i++) {
            set.add(phone_book[i]);
        }

        for (int i = 0; i < phone_book.length; i++) {
            // 각 값들에 대해
            for (int j = 0; j < phone_book[i].length(); j++) {
                // 길이 0부터 해당 길이까지 해당 값들의 Key가 존재하는지 확인하는 거야
                // O(N^2)라서 다른 방법 없나 고민했는데 더 좋은 아이디어가 없어서 ㅠ
                // 1,000,000 ^ 2  = 10^12
                if (set.contains(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }

}
