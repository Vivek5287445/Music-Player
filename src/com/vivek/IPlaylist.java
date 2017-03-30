package com.vivek;

public interface IPlaylist {
	boolean createPlaylist(String playlistName);
	boolean removePlaylist(String playlistName);
	boolean addSong(String songName);
	boolean removeSong(String songName);
}
