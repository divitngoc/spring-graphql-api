package com.divitngoc.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.divitngoc.db.dao.ArtistDao;
import com.divitngoc.db.dao.SongDao;
import com.divitngoc.db.service.ArtistService;
import com.divitngoc.db.service.SongService;

@ExtendWith(MockitoExtension.class)
class GraphQLConfigTest {

	private final GraphQLConfig config = new GraphQLConfig();
	
	@Test
	void testSongResolver() {
		assertNotNull(config.songResolver(new ArtistService(mock(ArtistDao.class))));
	}

	@Test
	void testArtistResolver() {
		assertNotNull(config.artistResolver(new SongService(mock(SongDao.class), new ModelMapper())));
	}

	@Test
	void testQuery() {
		assertNotNull(config.query(new SongService(mock(SongDao.class), new ModelMapper())));
	}
}
