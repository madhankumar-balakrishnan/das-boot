package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckGet(){
		Shipwreck wreck = new Shipwreck();
		wreck.setId(1L);
		when(shipwreckRepository.findOne(1L)).thenReturn(wreck);
		
		Shipwreck actual = sc.get(1L);

		verify(shipwreckRepository).findOne(1L);
		
		//assertEquals(1L,actual.getId().longValue());
		
		assertThat(actual.getId(),is(1L));
	}
}
