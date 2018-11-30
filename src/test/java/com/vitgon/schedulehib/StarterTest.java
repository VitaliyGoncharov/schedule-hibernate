package com.vitgon.schedulehib;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class StarterTest {
	
	@Test
	public void testMain() {
		Starter starter = new Starter();
		
		starter.fillDB();
		verify(starter, times(1)).fillDB();
	}
}
