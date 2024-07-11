package week_1.heogeonho;

import java.util.*;
import java.io.*;

public class PGS_의상 {

        public static int solution(String[][] clothes) {
            HashMap<String,Integer>cMap = new HashMap<>();

            for(int i=0; i<clothes.length; i++) {
                String key=clothes[i][1];
                if(cMap.containsKey(key)) {
                    int temp= cMap.get(key);
                    cMap.put(key,temp+1);
                } else cMap.put(key, 2);
            }
            int result=1;
            for(int c:cMap.values()) {
                result*=c;
            }
            return result-1;
        }

    public static void main(String[] args) throws Exception{
        String[][] input={{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(input));
    }
}