package com.vivek;

public interface IMusicPlayer {
	boolean playMusic(String song);
	boolean nextSong();
	boolean previousSong();
	boolean pause();
	boolean play();
	boolean stop();
}
