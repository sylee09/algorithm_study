package book1.ch8;

import java.util.HashMap;

public class Ch8_8 {

    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }

        int answer = 1;

        for (int value : map.values()) {
            answer *= (value + 1);
        }

        return answer - 1;
    }
}
