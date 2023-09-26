package com.learning.mockito.mockito.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListTest {

	@Test
	void test() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(9).thenReturn(2).thenReturn(5);
		assertEquals(9, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(5, listMock.size());
		assertEquals(5, listMock.size());
		assertEquals(5, listMock.size());
		assertEquals(5, listMock.size());
		
		when(listMock.get(0)).thenReturn("someString");
		assertEquals("someString", listMock.get(0));
		when(listMock.get(1)).thenReturn("someAnotherString");
		assertEquals("someAnotherString", listMock.get(1));
		
		when(listMock.get(0)).thenReturn("someString");
		assertEquals(null, listMock.get(2));
		
		
		when(listMock.indexOf(Mockito.anyInt())).thenReturn(2);
		assertEquals(2,listMock.indexOf(3));
		assertEquals(2,listMock.indexOf(9));
	}

}
