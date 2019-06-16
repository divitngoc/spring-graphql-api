package com.divitngoc.graphql;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.divitngoc.db.service.SongService;
import com.divitngoc.generated.tables.pojos.Artist;

@ExtendWith(MockitoExtension.class)
class ArtistResolverTest {

	@Mock
	private SongService songService;
	@InjectMocks
	private ArtistResolver resolver;
	
	private final EasyRandom random = new EasyRandom();
	
	@Test
	void testGetSongs() {
		// Method call
		resolver.getSongs(random.nextObject(Artist.class));
		
		// Verify result
		verify(songService, times(1)).fetchSongsByArtistId(anyInt());
		verify(songService, never()).fetchAllSongs();
	}

}
