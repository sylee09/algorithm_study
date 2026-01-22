package source1.ch06_5;

public class 문자열압축 {
    public int solution(String s) {
        // s의 길이 / 2 보다 크면 어차피 중복되는게 없음
        // s의 길이가 1이될수도 있으므로 (s.length()+1)/2를 해줘서 limit이 1이상이 되도록 함
        int limit = (s.length() + 1) / 2;
        int answer = Integer.MAX_VALUE;

        for (int l = 1; l <= limit; l++) {
            int idx = 0;
            StringBuilder compressed = new StringBuilder();
            int cnt = 0;
            String before = null;
            while (idx < s.length()) {
                StringBuilder cur = new StringBuilder();
                for (int i = 0; i < l; i++) {
                    cur.append(s.charAt(idx++));
                    if (idx == s.length()) {
                        break;
                    }
                }
                if (before == null) {
                    before = cur.toString();
                    cnt = 1;
                } else {
                    if (before.equals(cur.toString())) {
                        cnt++;
                    } else {
                        if (cnt > 1) {
                            compressed.append(cnt).append(before);
                        } else {
                            compressed.append(before);
                        }
                        cnt = 1;
                        before = cur.toString();
                    }
                }
            }
            if (cnt > 1) {
                compressed.append(cnt).append(before);
            } else {
                compressed.append(before);
            }
            System.out.println("l: " + l + " " + compressed);
            if (compressed.length() < answer) {
                answer = compressed.length();
            }
        }
        return answer;
    }
}
