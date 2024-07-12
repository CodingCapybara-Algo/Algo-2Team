package week_1.lsh981127;
import java.util.*;
public class pgs_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> sum = new HashMap<>();
        // 장르별 [노래 index, 재생횟수]
        HashMap<String, ArrayList<int[]>> songs = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            sum.put(genres[i], sum.getOrDefault(genres[i], 0) + plays[i]);
            songs.putIfAbsent(genres[i], new ArrayList<>());
            songs.get(genres[i]).add(new int[]{i, plays[i]}); // 노래 index, 노래 재생횟수
        }


        List<String> genreSort = new ArrayList<>(sum.keySet());
        // genre 값들에 대해 genresongs에 넣어서 sorting하기 위한 용도
        genreSort.sort((o1,o2) -> sum.get(o2) - sum.get(o1));
        // 내림차순 정렬

        // genreSort의 장르별 각각 가장 많이 플레이 된 애들로 정렬
        List<Integer> result = new ArrayList<>();
        for(String g : genreSort) {
            // g : 장르값
            List<int[]> tempSong = songs.get(g);
            tempSong.sort((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1]);
            result.add(tempSong.get(0)[0]); // 첫번째
            if(tempSong.size() > 1) result.add(tempSong.get(1)[0]); // 두번째
        }

        int[] temp = new int[result.size()];
        for(int i = 0; i < result.size(); i++) temp[i] = result.get(i);
        return temp;
    }
}


