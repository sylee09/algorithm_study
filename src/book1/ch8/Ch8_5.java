package book1.ch8;

import java.util.*;

public class Ch8_5 {

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<int[]>> genresPlayMap = new HashMap<>();
        HashMap<String, Integer> genresPlayCount = new HashMap<>();
        TreeMap<Integer, String> countGenresMap = new TreeMap<>((a, b) -> b - a);

        for (int i = 0; i < genres.length; i++) {
            genresPlayCount.put(genres[i], genresPlayCount.getOrDefault(genres[i], 0) + plays[i]);
            if (genresPlayMap.get(genres[i]) == null) {
                ArrayList<int[]> list = new ArrayList<>();
                list.add(new int[]{i, plays[i]});
                genresPlayMap.put(genres[i], list);
            } else {
                ArrayList<int[]> list = genresPlayMap.get(genres[i]);
                list.add(new int[]{i, plays[i]});
            }
        }

        for (String key : genresPlayCount.keySet()) {
            int count = genresPlayCount.get(key);
            countGenresMap.put(count, key);
        }

        for (String key : genresPlayMap.keySet()) {
            ArrayList<int[]> list = genresPlayMap.get(key);
            list.sort((a, b) -> {
                if (a[1] < b[1]) {
                    return 1;
                } else if (a[1] > b[1]) {
                    return -1;
                } else if (a[0] < b[0]) {
                    return -1;
                } else if (a[0] > b[0]) {
                    return 1;
                }
                return 0;
            });
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        while (!countGenresMap.isEmpty()) {
            Map.Entry<Integer, String> polled = countGenresMap.pollFirstEntry();
            String key = polled.getValue();
            ArrayList<int[]> list = genresPlayMap.get(key);
            for (int i = 0; i < list.size(); i++) {
                if (i > 1) {
                    break;
                }
                answerList.add(list.get(i)[0]);
            }
        }
        return answerList.stream().mapToInt(x -> x.intValue()).toArray();
    }

    public static void main(String[] args) {
        Ch8_5 solution = new Ch8_5();
        System.out.println(Arrays.toString(solution.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
    }
}
