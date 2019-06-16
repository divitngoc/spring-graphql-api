package com.divitngoc.graphql;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.divitngoc.db.service.SongService;

@ExtendWith(MockitoExtension.class)
class QueryTest {

	@Mock
	private SongService songService;
	@InjectMocks
	private Query query;
	
	@Test
	void test() {
		// Method call
		query.fetchAllSongs();
		
		// Verify result
		verify(songService, times(1)).fetchAllSongs();
	}

}
