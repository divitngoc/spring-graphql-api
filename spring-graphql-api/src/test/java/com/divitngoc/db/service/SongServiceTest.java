package com.divitngoc.db.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.divitngoc.db.dao.SongDao;
import com.divitngoc.generated.tables.pojos.Song;

@ExtendWith(MockitoExtension.class)
class SongServiceTest {

	@Mock
	private SongDao dao;
	@InjectMocks
	private SongService service;

	private final EasyRandom random = new EasyRandom();

	@Test
	void testFetchSongsByArtistId() {
		when(dao.fetchSongsByArtistId(anyInt())).thenReturn(Arrays.asList(random.nextObject(Song.class)));
		assertEquals(1, service.fetchSongsByArtistId(5).size());
		
		// Argument less than 1
		assertTrue(service.fetchSongsByArtistId(-1).isEmpty());
		assertTrue(service.fetchSongsByArtistId(0).isEmpty());
		verify(dao, times(1)).fetchSongsByArtistId(anyInt());
	}

	@Test
	void testFetchAllSongs() {
		when(dao.fetchAllSongs()).thenReturn(Arrays.asList(random.nextObject(Song.class)));
		assertEquals(1, service.fetchAllSongs().size());
	}
}
