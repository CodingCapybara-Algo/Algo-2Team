package week_1.lsh981127;
import java.util.*;
public class pgs_폰켓몬 {
    public static int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                // 기존 replace를 써서 값을 바꾸려 했는데
                // add를 하면 값을 업데이트해준다고 하네요.

            } else {
                map.put(nums[i], 1);
            }
        }

        if (map.keySet().size() > count) {
            return count;
        } else {
            return map.keySet().size();
        }
    }

}
