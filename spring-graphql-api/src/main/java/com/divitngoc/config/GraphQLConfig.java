package com.divitngoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.divitngoc.db.service.ArtistService;
import com.divitngoc.db.service.SongService;
import com.divitngoc.graphql.ArtistResolver;
import com.divitngoc.graphql.Query;
import com.divitngoc.graphql.SongResolver;

@Configuration
public class GraphQLConfig {

	@Bean
	public SongResolver songResolver(final ArtistService artistService) {
		return new SongResolver(artistService);
	}

	@Bean
	public ArtistResolver artistResolver(final SongService songService) {
		return new ArtistResolver(songService);
	}

	@Bean
	public Query query(final SongService songService) {
		return new Query(songService);
	}

//	@Bean
//	public Mutation mutation() {
//		TODO
//	}

}
