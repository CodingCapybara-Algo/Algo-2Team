package week_2.lsh981127;

import java.util.Stack;

public class pgs_올바른관호 {
    public class Solution {
        boolean solution(String s) {
            int left = 0;
            int right = 0;
            for(char i : s.toCharArray()) {
                if(i == ')') {
                    right++;
                    if(left != 0) {
                        left--;
                        right--;
                    } else {
                        return false;
                    }
                }

                if(i == '(') {
                    left++;
                    if(right != 0) {
                        left--;
                        right--;
                    }
                }
            }
            if(left != 0 || right != 0)
                return false;
            return true;
        }
    }
}
