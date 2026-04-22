package book1;

import java.util.HashSet;
import java.util.Objects;

public class Ch5_7 {

    public int solution(String dirs) {
        HashSet<Edge> set = new HashSet<>();

        int[] cur = new int[]{0, 0};
        for (char dir : dirs.toCharArray()) {
            int nx = cur[0];
            int ny = cur[1];

            if (dir == 'U') {
                nx -= 1;
            } else if (dir == 'L') {
                ny -= 1;
            } else if (dir == 'D') {
                nx += 1;
            } else if (dir == 'R') {
                ny += 1;
            }

            if (nx > 5 || nx < -5 || ny > 5 || ny < -5) {
                continue;
            }

            Edge edge1 = new Edge(cur[0], cur[1], nx, ny);
            Edge edge2 = new Edge(nx, ny, cur[0], cur[1]);
            set.add(edge1);
            set.add(edge2);

            cur[0] = nx;
            cur[1] = ny;
        }

        return set.size() / 2;
    }

    static class Edge {
        int fromX;
        int fromY;
        int toX;
        int toY;

        public Edge(int fromX, int fromY, int toX, int toY) {
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (this.getClass() != other.getClass()) {
                return false;
            }
            Edge o = (Edge) other;
            return this.fromX == o.fromX && this.fromY == o.fromY
                    && this.toX == o.toX && this.toY == o.toY;
        }

        @Override
        public int hashCode() {
            return Objects.hash(fromX, fromY, toX, toY);
        }
    }


}
