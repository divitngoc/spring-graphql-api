package com.divitngoc.db.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.divitngoc.db.dao.ArtistDao;
import com.divitngoc.generated.tables.pojos.Artist;

@ExtendWith(MockitoExtension.class)
class ArtistServiceTest {

	@Mock
	private ArtistDao dao;
	@InjectMocks
	private ArtistService service;

	private final EasyRandom random = new EasyRandom();

	@Test
	void testFetchArtistById() {
		when(dao.fetchArtistById(anyInt())).thenReturn(random.nextObject(Artist.class));
		assertNotNull(service.fetchArtistById(5));
		
		// Argument less than 1
		assertNull(service.fetchArtistById(-1));
		assertNull(service.fetchArtistById(0));
		verify(dao, times(1)).fetchArtistById(anyInt());
	}

}
