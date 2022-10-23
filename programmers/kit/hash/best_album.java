package programmers.kit.hash;

import java.util.*;

public class best_album {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Genre>> genreMap = new HashMap<>();
        List<Music> musicList = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            Genre genre = new Genre();
            genre.setId(i);
            genre.setGen(genres[i]);
            genre.setCount(plays[i]);

            List<Genre> genList = new ArrayList<>();
            if (genreMap.containsKey(genres[i])) {
                genList = genreMap.get(genres[i]);
            }
            genList.add(genre);
            genreMap.put(genres[i], genList);
        }

        for (String key : genreMap.keySet()) {
            int genreSum = 0;
            for (Genre genre : genreMap.get(key)) {
                genreSum += genre.getCount();
            }
            Music music = new Music();
            music.setGenre(key);
            music.setMusicCount(genreSum);
            musicList.add(music);
        }

        Collections.sort(musicList, (o1, o2) -> o2.getMusicCount() - o1.getMusicCount());

        List<Integer> ret = new ArrayList<>();
        for (Music music : musicList) {
            List<Genre> list = genreMap.get(music.getGenre());
            Collections.sort(list, (o1, o2) -> {
                if(o1.getCount() == o2.getCount()) return o1.getId() - o2.getId();
                else return o2.getCount() - o1.getCount();
            });

            if(list.size() > 0) {
                for (int i = 0; i < 2; i++) {
                    ret.add(list.get(i).getId());
                    if (list.size() == 1) break;
                }
            }
        }

        return ret.stream().mapToInt(i->i).toArray();
    }

    public class Music {
        private String genre;
        private int musicCount;

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public int getMusicCount() {
            return musicCount;
        }

        public void setMusicCount(int musicCount) {
            this.musicCount = musicCount;
        }
    }

    public class Genre {
        private int id;
        private String gen;
        private int count;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGen() {
            return gen;
        }

        public void setGen(String gen) {
            this.gen = gen;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
