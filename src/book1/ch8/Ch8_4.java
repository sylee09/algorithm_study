package book1.ch8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Ch8_4 {

    public String[] solution(String[] record) {
        HashMap<String, String> nameMap = new HashMap<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String str : record) {
            String[] split = str.split(" ");
            queue.offer(str);
            if (split[0].equals("Enter")) {
                nameMap.put(split[1], split[2]);
            } else if (split[0].equals("Change")) {
                nameMap.put(split[1], split[2]);
            }
        }

        ArrayList<String> answerList = new ArrayList<>();

        while (!queue.isEmpty()) {
            String poll = queue.poll();
            String[] split = poll.split(" ");
            if (split[0].equals("Enter")) {
                answerList.add(nameMap.get(split[1]) + "님이 들어왔습니다.");
            } else if (split[0].equals("Leave")) {
                answerList.add(nameMap.get(split[1]) + "님이 나갔습니다.");
            }
        }

        return answerList.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        Ch8_4 solution = new Ch8_4();
        System.out.println(Arrays.toString(solution.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }
}
