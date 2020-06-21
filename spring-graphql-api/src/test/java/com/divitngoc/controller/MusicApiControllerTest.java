package com.divitngoc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.divitngoc.db.service.SongService;
import com.divitngoc.generated.tables.pojos.Song;

@ExtendWith(MockitoExtension.class)
class MusicApiControllerTest {

	@Mock
	private SongService songService;
	@InjectMocks
	private MusicApiController controller;

	private final EasyRandom random = new EasyRandom();

	@Test
	void testGetAllSongs() {
		// Stub
		when(songService.fetchAllSongs()).thenReturn(List.of(random.nextObject(Song.class)));
		// Method call
		final ResponseEntity<?> result = controller.getSongs(null);
		// Verify result
		assertEquals(1, ((List<?>) result.getBody()).size());
		assertEquals(HttpStatus.OK, result.getStatusCode());
		verify(songService, times(1)).fetchAllSongs();
	}

}
