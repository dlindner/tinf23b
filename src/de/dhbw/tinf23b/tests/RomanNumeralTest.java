package de.dhbw.tinf23b.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RomanNumeralTest {

	@Test
	public void converts_1() {
		// Arrange
		RomanNumeral target = new RomanNumeral();
		int given = 1;
		
		// Act
		String actual = target.convert(given); // CuT - Code under Test
		
		// Assert
		String expected = "I";
		assertEquals(
			expected,
			actual
		);
	}

	@Test
	public void converts_2() {
		// Arrange
		RomanNumeral target = new RomanNumeral();
		
		// Act
		String actual = target.convert(2); // CuT - Code under Test
		
		// Assert
		assertEquals(
			"II",
			actual
		);
	}
	
	@Test
	public void converts_3() {
		RomanNumeral target = new RomanNumeral();
		
		String actual = target.convert(3);
		
		assertEquals("III", actual);
	}
	
	@Test
	public void converts_4() {
		String actual = new RomanNumeral().convert(4);
		assertEquals("IV", actual);
	}

	@Test
	public void converts_5() {
		assertEquals(
			"V",
			new RomanNumeral().convert(5)
		);
	}
	
	@Test
	public void converts_6() {
		assertEquals(
			"VI",
			new RomanNumeral().convert(6)
		);
	}
}
