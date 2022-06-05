package org.henrix.lt;

import java.util.List;
import java.util.Map;

public interface Counter {

    List<Frequency> countFrequency(List<Integer> numbers);

    Map<Integer, String> getFrequencyMap(List<Frequency> frequenciesMap);
}
