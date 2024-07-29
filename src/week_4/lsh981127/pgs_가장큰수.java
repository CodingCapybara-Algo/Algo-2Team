package week_4.lsh981127;

import java.util.Arrays;
import java.util.Comparator;

public class pgs_가장큰수 {
    public String solution(String[] numbers) {
        String[] arr = new String[numbers.length];
        String answer = "";

        for(int i = 0; i < numbers.length; i++) {
            // arr안에 String 형태로 값을 저장
            arr[i] = String.valueOf(numbers[i]);
        }

        // 2개 문자열을 (o1 + o2), (o2 + o1) 붙인 숫자를 비교해 내림차군으로 비교하는 코드
        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        // 제일 큰 값이 0이면 나머지가 전부 0이기에 그냥 0 하나만 출력
        if(arr[0].equals("0")) {
            return "0";
        }

        return String.join("", arr);
    }
}
