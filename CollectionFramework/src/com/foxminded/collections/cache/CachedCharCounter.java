package com.foxminded.collections.cache;

import java.util.HashMap;
import java.util.Map;

import com.foxminded.collections.CharCounter;
import com.foxminded.collections.servise.CharCounterImpl;

public class CachedCharCounter implements CharCounter {

	private Map<String, String> cache = new HashMap<>();
	private CharCounterImpl counter = new CharCounterImpl();

	public String countUniqueChars(String stringInput) {
		String result = "";
		if (cache.containsValue(stringInput)) {
			result = cache.get(stringInput);
		} else {
			result = counter.countUniqueChars(stringInput);
			cache.put(stringInput, result);
		}
		return result;
	}
}
