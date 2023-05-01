package com.foxminded.collections.cache;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import com.foxminded.collections.CharCounter;

import org.mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CachedCharCounterTest {

	@Mock
	CharCounter cachedCharCounterMock;

	@BeforeEach
	void setUp() {
		cachedCharCounterMock = Mockito.mock(CharCounter.class);
	}

	@Test
	void countUniqueCharsWhenStringInputShoudBeCharCounter() {
		String stringInputTest = "hello";
		CachedCharCounter cachedCharCounter = new CachedCharCounter();

		String expectOutput = "hello\n" + "e - 1\n" + "h - 1\n" + "l - 2\n" + "o - 1\n";
		StringBuilder result = new StringBuilder();
		Map<Character, Integer> cacheManagerTest = new HashMap<>();

		cacheManagerTest.put('e', 1);
		cacheManagerTest.put('h', 1);
		cacheManagerTest.put('l', 2);
		cacheManagerTest.put('o', 1);

		for (Map.Entry<Character, Integer> entry : cacheManagerTest.entrySet()) {
			char key = entry.getKey();
			int value = entry.getValue();
			result.append(key + " - " + value + "\n");
		}

		when(cachedCharCounterMock.countUniqueChars(stringInputTest)).thenReturn(result.toString());

		String actualOutput = cachedCharCounter.countUniqueChars(stringInputTest);

		assertEquals(expectOutput, actualOutput);
	}

}
