package org.henrix.lt;


import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final List<Integer> NUMBERS = List.of(1, 4, 1, 5, 8, 1, 3, 5, 1, 4, 1, 3, 7, 2);
    private final Counter counter;

    public Main(Counter counter) {
        this.counter = counter;
    }

    public static void main(String[] args) {
        Main main = new Main(new CounterImpl());
        main.run();
    }

    private void run() {
        List<Frequency> frequencies = counter.countFrequency(NUMBERS);
        printOutput(frequencies);
        printFrequencyMap(counter.getFrequencyMap(frequencies));
    }

    private void printOutput(List<Frequency> frequencies) {
        String frequencyString = frequencies.stream()
                .map(frequency -> String.valueOf(frequency.getFrequency()))
                .collect(Collectors.joining(", "));
        System.out.println("Frequency: " + frequencyString);

        String valueString = frequencies.stream()
                .map(number -> String.valueOf(number.getNumber()))
                .collect(Collectors.joining(", "));
        System.out.println("Number: " + valueString);
    }

    private void printFrequencyMap(Map<Integer, String> mapFrequencies) {
        mapFrequencies.forEach((key, value) -> System.out.println(value));
    }
}
