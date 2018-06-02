package com.example.android.musicapp;

/**
 * Created by Toshiba on 4/4/2018.
 */

public class Song {

    /**
     * Song Name
     */
    private String mSongName;

    /**
     * Singer Name
     */
    private String mSingerName;

    /**
     * Create a new Song object.
     *
     * @param songName   is the name of the song
     * @param singerName is the name of the singer
     */
    public Song(String songName, String singerName) {
        mSongName = songName;
        mSingerName = singerName;
    }

    /**
     * Get the son name.
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the singer name.
     */
    public String getSingerName() {
        return mSingerName;
    }

}