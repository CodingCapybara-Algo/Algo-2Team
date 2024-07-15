package week_2.heogeonho;

import java.util.*;
import java.io.*;

public class PGS_같은숫자는싫어 {
    public static int[] solution(int[] arr) {

        ArrayList<Integer> ansList=new ArrayList<>();
        ansList.add(arr[0]);
        int prev=arr[0];
        for(int i=1; i< arr.length; i++){
            if(arr[i]!=prev){
                ansList.add(arr[i]);
                prev=arr[i];
            }
        }
//        System.out.println(ansList.toString());

        int[] answer=new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] arr={1,1,3,3,0,1,1};
        System.out.println(Arrays.toString(solution(arr)));
    }
}