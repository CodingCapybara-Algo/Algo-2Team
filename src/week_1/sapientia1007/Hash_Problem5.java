package week_1.sapientia1007;

import java.util.*;

public class Hash_Problem5 {
    static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            // 장르별 총 재생 횟수를 저장할 HashMap
            HashMap<String, Integer> genrePlayCount = new HashMap<>(); // {"classic" : 400}
            // 장르별 곡 인덱스와 재생 횟수를 저장할 HashMap
            HashMap<String, ArrayList<int[]>> genreSongs = new HashMap<>(); // {"classic" = [[0,500], [2,150]]}

            for (int i = 0; i < genres.length; i++) {
                // 총 재생 횟수를 계산
                genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);

                // 곡 정보를 ArrayList에 추가
                genreSongs.putIfAbsent(genres[i], new ArrayList<>());
                genreSongs.get(genres[i]).add(new int[]{i, plays[i]});
            }

            // 장르별 재생 횟수를 내림차순으로 정렬
            List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
            sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

            // 결과를 저장할 리스트
            ArrayList<Integer> result = new ArrayList<>();

            for (String genre : sortedGenres) {
                // 곡들을 재생 횟수에 따라 내림차순으로 정렬, 재생 횟수가 같으면 인덱스 오름차순
                List<int[]> songs = genreSongs.get(genre);
                songs.sort((a, b) -> {
                    if (b[1] == a[1]) {
                        return a[0] - b[0];
                    }
                    return b[1] - a[1];
                });

                // 상위 두 곡만 추가
                result.add(songs.get(0)[0]);
                if (songs.size() > 1) {
                    result.add(songs.get(1)[0]);
                }
            }

            // 결과를 int 배열로 변환
            int[] answer = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                answer[i] = result.get(i);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(
                new String[] {"classic", "pop", "classic", "classic", "pop"},
                new int[] {500, 600, 150, 800, 2500}
        ))); // [4, 1, 3, 0]
    }
}
