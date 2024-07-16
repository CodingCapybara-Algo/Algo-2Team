package week_2.lsh981127;

import java.util.Stack;

public class pgs_올바른관호 {
    public boolean solution(String s) {
        int left = 0;       // ( 의 갯수
        int right = 0;      // ) 의 갯수
        for(char i : s.toCharArray()) {
            if(i == ')') {
                right++;
                if(left != 0) {         // 1개라도 ( 가 존재한다면 (   ) 가 성립되기에 둘다 1개씩 Decrement
                    left--;
                    right--;
                } else {
                    return false;       // ( 가 존재하지 않는데 ) 가 나오면 ()가 성립할 수 없기에 무조건 False!
                }
            }

            if(i == '(') {
                left++;
                if(right != 0) {        // '(' 는 ')'의 존재 유무와 관계없이 언제든 와도 된다. 그렇기에 () 가 성립하는 경우에 대해서만 기록
                    left--;
                    right--;
                }
            }
        }
        if(left != 0 || right != 0)     // 만약 '('와 ')'의 갯수가 남아있다면, () 가 성립하지 않는 경우가 존재한다는 뜻이므로 false
            return false;
        return true;

    }
}
