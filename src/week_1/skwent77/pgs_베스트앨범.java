import java.util.*; //Collections도 포함

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수를 저장
        Map<String, Integer> genreCounts = new HashMap<>();
        List<Genre> genreRanking = new ArrayList<>(); //장르 정렬한 리스트
        Map<String, List<Song>> genreSongs = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            genreCounts.put(genres[i], genreCounts.getOrDefault(genres[i], 0) + plays[i]);

            List<Song> list = genreSongs.getOrDefault(genres[i], new ArrayList<>());
            list.add(new Song(i, genres[i], plays[i]));
            genreSongs.put(genres[i], list);
        }

        for (String genre : genreCounts.keySet()) {
            genreRanking.add(new Genre(genre, genreCounts.get(genre)));
        }

        Collections.sort(genreRanking);

        // 각 장르 내에서 재생 횟수가 많은 상위 두 곡 선택
        for (Genre g : genreRanking) {
            int count = 0;
            List<Song> list = genreSongs.get(g.name);
            Collections.sort(list);
            for (Song song : list) {
                if (count == 2)
                    break;

                result.add(song.id);
                count++;
            }
        }
        // 결과 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    // 곡 정보를 저장하는 클래스
    class Song implements Comparable<Song> {
        int id;
        String genre;
        int plays;

        Song(int id, String genre, int plays) {
            this.id = id;
            this.genre = genre;
            this.plays = plays;
        }

        @Override
        public int compareTo(Song other) {
            // 재생 횟수를 기준으로 내림차순 정렬, 같다면 ID를 기준으로 오름차순 정렬
            if (this.plays == other.plays) {
                return this.id - other.id;
            } else {
                return other.plays - this.plays;
            }
        }
    }

    // 장르 정보를 저장하는 클래스
    class Genre implements Comparable<Genre> {
        String name;
        int totalPlays;

        Genre(String name, int totalPlays) {
            this.name = name;
            this.totalPlays = totalPlays;
        }

        @Override
        public int compareTo(Genre other) {
            // 총 재생 횟수를 기준으로 내림차순 정렬
            return other.totalPlays - this.totalPlays;
        }
    }
}
