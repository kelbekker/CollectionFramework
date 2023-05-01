package com.foxminded.collections.servise;

import java.util.HashMap;
import java.util.Map;

import com.foxminded.collections.CharCounter;
import com.foxminded.collections.cache.CachedCharCounter;

public class CharCounterImpl implements CharCounter {

	@Override
	public String countUniqueChars(String stringInput) {
		Map<Character, Integer> cacheManager = new HashMap<>();
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(stringInput + "\n");

		if (stringInput.equals("")) {
			throw new IllegalArgumentException("The input is empty");
		}
		for (int i = 0; i < stringInput.length(); i++) {
			char value = stringInput.charAt(i);
			cacheManager.put(value, cacheManager.getOrDefault(value, 0) + 1);
		}
		for (Map.Entry<Character, Integer> entry : cacheManager.entrySet()) {
			char key = entry.getKey();
			int value = entry.getValue();
			stringBuilder.append(key + " - " + value + "\n");
		}
		return stringBuilder.toString();
	}
}
