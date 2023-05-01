package com.foxminded.collections;

import java.io.IOException;

import com.foxminded.collections.cache.CachedCharCounter;

public class App {
	public static void main(String[] args) throws IOException {
		CharCounter stringOfUniqueCharacters = new CachedCharCounter();

		System.out.println(stringOfUniqueCharacters.countUniqueChars("Kelbekker"));
	}
}
