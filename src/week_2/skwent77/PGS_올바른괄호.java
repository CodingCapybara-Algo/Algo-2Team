package week_2.skwent77;

public class PGS_올바른괄호 {
    public boolean solution(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i ) == '(')
            {
                count++;
            } else
            {
                count--;
            }
            if (count < 0)
            {
                return false;
            }
        }
        return count == 0;
    }

}
