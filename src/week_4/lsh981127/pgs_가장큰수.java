package week_4.lsh981127;

import java.util.Arrays;
import java.util.Comparator;

public class pgs_가장큰수 {
    public String solution(String[] numbers) {
        String[] arr = new String[numbers.length];
        String answer = "";
        for(int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        if(arr[0].equals("0")) {
            return "0";
        }

        return String.join("", arr);
    }
}
