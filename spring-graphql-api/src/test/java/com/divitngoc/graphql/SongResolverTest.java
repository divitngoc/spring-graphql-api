package com.divitngoc.graphql;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.divitngoc.db.service.ArtistService;
import com.divitngoc.generated.tables.pojos.Song;

@ExtendWith(MockitoExtension.class)
class SongResolverTest {

	@Mock
	private ArtistService artistService;
	@InjectMocks
	private SongResolver resolver;
	
	private final EasyRandom random = new EasyRandom();

	@Test
	void testGetArtist() {
		// Method call
		resolver.getArtist(random.nextObject(Song.class));
		
		// Verify result
		verify(artistService, times(1)).fetchArtistById(anyInt());
	}

}
