package week_1.heogeonho;

import java.util.*;
import java.io.*;
public class PGS_전화번호목록 {

    public static boolean solution(String[] phoneBook) {
        HashMap<String,Integer> pMap = new HashMap<>();
        for(String p:phoneBook) {
            pMap.put(p, 0);
        }

        for(int i=0; i<phoneBook.length; i++) {
            for(int j=0; j<phoneBook[i].length(); j++) {
                if(pMap.containsKey(phoneBook[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        String[] input={"12","123","1235","567","88"};
        System.out.println(solution(input));
    }
}