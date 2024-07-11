package week_1.heogeonho;

import java.util.*;
import java.io.*;

public class PGS_폰켓몬 {
    public static int solution(int[] nums) {
        int pickNum=nums.length/2;
        HashMap<Integer,Integer> hm = new HashMap<>(10);

        for(int n:nums) {
            if(hm.containsKey(n)) {
                int temp=hm.get(n);
                hm.replace(n, temp++);
            } else {
                hm.put(n, 1);
            }
        }
        if(hm.size()>pickNum) {
            return pickNum;
        }
        return hm.size();
    }

    public static void main(String[] args) throws Exception{
        int[] input={3,3,3,2,2,4};
        System.out.println(solution(input));
    }
}