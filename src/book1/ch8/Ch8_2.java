package book1.ch8;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Ch8_2 {

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participantMap = new HashMap<>();
        for (String p : participant) {
            participantMap.put(p, participantMap.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            participantMap.put(c, participantMap.get(c) - 1);
            if (participantMap.get(c) == 0) {
                participantMap.remove(c);
            }
        }

        return participantMap.keySet().stream().collect(Collectors.toList()).get(0);
    }

}
