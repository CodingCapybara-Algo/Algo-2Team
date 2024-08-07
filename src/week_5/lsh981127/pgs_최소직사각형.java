package week_5.lsh981127;
import java.util.*;
public class pgs_최소직사각형 {
    public int solution(int[][] sizes) {
        // 한쪽으로 큰 값들을 다 몰고
        // 다른 한쪽에 작은 값들 몰아
        int size = sizes.length;
        int[] row = new int[size];
        int[] col = new int[size];

        for(int i = 0; i < size; i++) {
            int[] temp = sizes[i];
            if(temp[0] < temp[1]) {
                row[i] = temp[1];
                col[i] = temp[0];
            } else {
                row[i] = temp[0];
                col[i] = temp[1];
            }
        }

        Arrays.sort(row);
        Arrays.sort(col);

        int answer = row[size-1]*col[size-1];
        return answer;
    }
}
