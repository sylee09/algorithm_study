package book1;

import java.util.Arrays;

public class Ch5_8 {
    public double solution(int[] numbers) {
        return Arrays.stream(numbers).average().getAsDouble();
    }
}
