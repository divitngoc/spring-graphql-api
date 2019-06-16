/*
 * This file is generated by jOOQ.
 */
package com.divitngoc.generated.tables.daos;


import com.divitngoc.generated.tables.Song;
import com.divitngoc.generated.tables.records.SongRecord;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SongDao extends DAOImpl<SongRecord, com.divitngoc.generated.tables.pojos.Song, Integer> {

    /**
     * Create a new SongDao without any configuration
     */
    public SongDao() {
        super(Song.SONG, com.divitngoc.generated.tables.pojos.Song.class);
    }

    /**
     * Create a new SongDao with an attached configuration
     */
    public SongDao(Configuration configuration) {
        super(Song.SONG, com.divitngoc.generated.tables.pojos.Song.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.divitngoc.generated.tables.pojos.Song object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>ID IN (values)</code>
     */
    public List<com.divitngoc.generated.tables.pojos.Song> fetchById(Integer... values) {
        return fetch(Song.SONG.ID, values);
    }

    /**
     * Fetch a unique record that has <code>ID = value</code>
     */
    public com.divitngoc.generated.tables.pojos.Song fetchOneById(Integer value) {
        return fetchOne(Song.SONG.ID, value);
    }

    /**
     * Fetch records that have <code>SUMMARY IN (values)</code>
     */
    public List<com.divitngoc.generated.tables.pojos.Song> fetchBySummary(String... values) {
        return fetch(Song.SONG.SUMMARY, values);
    }

    /**
     * Fetch records that have <code>TITLE IN (values)</code>
     */
    public List<com.divitngoc.generated.tables.pojos.Song> fetchByTitle(String... values) {
        return fetch(Song.SONG.TITLE, values);
    }

    /**
     * Fetch records that have <code>LYRICS IN (values)</code>
     */
    public List<com.divitngoc.generated.tables.pojos.Song> fetchByLyrics(String... values) {
        return fetch(Song.SONG.LYRICS, values);
    }

    /**
     * Fetch records that have <code>PUBLISHED_DATE IN (values)</code>
     */
    public List<com.divitngoc.generated.tables.pojos.Song> fetchByPublishedDate(LocalDate... values) {
        return fetch(Song.SONG.PUBLISHED_DATE, values);
    }

    /**
     * Fetch records that have <code>ARTIST_ID IN (values)</code>
     */
    public List<com.divitngoc.generated.tables.pojos.Song> fetchByArtistId(Integer... values) {
        return fetch(Song.SONG.ARTIST_ID, values);
    }
}
