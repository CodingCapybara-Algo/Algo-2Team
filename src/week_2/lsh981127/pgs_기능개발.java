package week_2.lsh981127;
import java.util.*;
public class pgs_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] date = new int[progresses.length];
        for(int i = 0 ; i < progresses.length; i++) {
            int due = 100 - progresses[i];
            int temp = due / speeds[i];
            int day = (due % speeds[i]) > 0 ? temp + 1 : temp;
            date[i] = day;
        }

        List<Integer> re = new ArrayList<>();
        int cur = date[0];
        int count = 0;
        for(int j = 0; j < date.length; j++) {
            // if(j == date.length - 1) {
            //     if(cur >= j) {
            //         re.add(count+1);
            //     } else {
            //         re.add(count);
            //         re.add(1);
            //     }
            //     break;
            // }
            if(cur >= date[j]) {
                count++;
                continue;
            }

            cur = date[j];  // 더 오래 걸리는 작업
            re.add(count);
            count = 1;
        }

        int[] result = new int[re.size()];
        for(int i = 0; i < re.size(); i++) {
            result[i] = re.get(i);
        }
        return result;
    }
}
