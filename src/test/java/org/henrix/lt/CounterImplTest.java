package org.henrix.lt;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CounterImplTest {

    private static final List<Integer> NUMBERS = List.of(1, 2, 2, 4);
    private static final int SIZE = 4;
    private static final int MAP_SIZE = 3;

    private final Counter counter = new CounterImpl();

    @Test
    void countFrequency() {
        List<Frequency> frequencies = List.of(new Frequency(1,1), new Frequency(2, 2),
                new Frequency(3,0), new Frequency(4,1));

        List<Frequency> actual = counter.countFrequency(NUMBERS);

        assertEquals(SIZE, actual.size());
        assertEquals(frequencies.get(1).getFrequency(), actual.get(1).getFrequency());
        assertEquals(frequencies.get(1).getNumber(), actual.get(1).getNumber());
        assertIterableEquals(frequencies, actual);
    }

    @Test
    void getFrequencyMap() {
        String line1 = "  *     ";
        String line2 = "* *   * ";
        String line3 = "1 2 3 4";

        Map<Integer, String> frequencyMap = new HashMap<>();
        frequencyMap.put(0, line1);
        frequencyMap.put(1, line2);
        frequencyMap.put(2, line3);

        List<Frequency> frequencies = counter.countFrequency(NUMBERS);

        Map<Integer, String> actual = counter.getFrequencyMap(frequencies);

        assertEquals(MAP_SIZE, actual.size());
        assertIterableEquals(frequencyMap.values(), actual.values());
    }

}
