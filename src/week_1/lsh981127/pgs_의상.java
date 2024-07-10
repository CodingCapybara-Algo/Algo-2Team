package week_1.lsh981127;
import java.util.*;
public class pgs_의상 {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> closet = new HashMap<>();
        for(String[] cloth : clothes) {
            closet.put(cloth[1], closet.getOrDefault(cloth[1], 0) + 1);
            // 기존 replace 를 사용해서 값을 변경하려 했으나 put을 넣어야 동작하더라
        }

        for(Map.Entry<String, Integer> entry : closet.entrySet()) {
            // Map.Entry<K, V> 형태의 entry 값 entrySet으로 생성
            // 해당 entry를 getvalue 해서 값을 가져온 뒤에 각 종류를 안입는 경우를 추가하기 위해 1 추가
            // 이후 모든 경우를 구하기 위해 누적 곱셈 진행
            answer *= entry.getValue() + 1;
        }
        // 최종적으로 아무것도 안 입는 경우를 제외하기 위해 1 빼기
        return answer -1;
    }
}
