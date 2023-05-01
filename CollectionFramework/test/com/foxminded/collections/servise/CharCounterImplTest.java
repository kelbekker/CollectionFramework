package com.foxminded.collections.servise;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CharCounterImplTest {

	CharCounterImpl charCounterTest = new CharCounterImpl();

	@Test
	void countUniqueCharsWhenStringInputShoudBeCharCounter() {
		String StringInputTest = "helo world!";

		StringBuilder expectedOutput = new StringBuilder();
		expectedOutput.append(String.format("helo world!\n  - 1\n! - 1\nr - 1\nd - 1\ne - 1\nw - 1\n"
		+ "h - 1\nl - 2\no - 2\n"));

		String actualOutput = charCounterTest.countUniqueChars(StringInputTest);

		assertEquals(expectedOutput.toString(), actualOutput);
	}

	@Test
	void countUniqueCharsWhenEmptyInputShoudBeExceptionMassageResult() {

		assertThrows(IllegalArgumentException.class, () -> charCounterTest.countUniqueChars(""),
				"The input is empty");
	}

}
