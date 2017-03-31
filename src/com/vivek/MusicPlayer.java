package com.vivek;

import java.io.File;

import javax.swing.JFileChooser;

public class MusicPlayer implements IMusicPlayer{
	
	boolean musicPlaying = false;
	MP3 newMusicPlayer = new MP3("");
	Playlist myPlaylist = new Playlist();
	
	
	JFileChooser fileChooser = new JFileChooser();
	File selectedFile = fileChooser.getSelectedFile();
	
	public String fileChooserMethod(){
		String fileName;
	
		fileChooser.showOpenDialog(null);
		
		fileName = selectedFile.getAbsolutePath();
		return fileName;
	}

	@Override
	public boolean playMusic(String song) {
		if(!musicPlaying){
			if(myPlaylist.containSong(song)){
				musicPlaying = true;
				myPlaylist.setNowPlaying(song);
				newMusicPlayer.setFileName(song);
				newMusicPlayer.play();
				System.out.println("Now playing: "+myPlaylist.getNowPlaying()+".\n");
				return true;
			}
		}else if(musicPlaying){
			System.out.println("Pausing current Music.\n");
			pause();
			playMusic(song);
			
		}
		System.out.println("Song is not listed in the playlist.\n");
		return false;
	}

	@Override
	public boolean nextSong() {
		if(musicPlaying){
			int indexOfNow = myPlaylist.indexOfSong(myPlaylist.getNowPlaying());
			if(indexOfNow == myPlaylist.getPlaylistSize()-1){
				System.out.println("Already On the last song.");
				return false;
			}
			
			newMusicPlayer.close();
			playMusic(myPlaylist.songAt(indexOfNow+1));
			return true;
		}
		
		System.out.println("Music is not Playing, Play some music First.");
		return false;
	}

	@Override
	public boolean previousSong() {
		
		if(musicPlaying){
			int indexOfNow = myPlaylist.indexOfSong(myPlaylist.getNowPlaying());
			if(indexOfNow == 0){
				System.out.println("Already On the last song.");
				return false;
			}
			
			newMusicPlayer.close();
			playMusic(myPlaylist.songAt(indexOfNow-1));
			return true;
		}
		
		System.out.println("Music is not Playing, Play some music First.");
		return false;
	}

	@Override
	public boolean pause() {
		if(musicPlaying){
			musicPlaying = false;
			newMusicPlayer.close();
			System.out.println("Music is now paused.");
			return true;
		}
		
		System.out.println("Music is already stopped.");
		return false;
	}

	@Override
	public boolean play() {
		if(!musicPlaying){
			//If music is not playing then start the music again
			newMusicPlayer.setFileName(myPlaylist.getNowPlaying());
			newMusicPlayer.play();
			System.out.println("Now Playing: "+myPlaylist.getNowPlaying());
			musicPlaying = true;
			
			return true;
		}
		
		System.out.println("Music is already Playing.");
		return false;
	}

	@Override
	public boolean stop() {
		if(musicPlaying){
		musicPlaying = false;
		newMusicPlayer.close();
		System.out.println("Music is now stopped.");
		
		myPlaylist.setNowPlaying("");
		
		return true;
		}
		
		System.out.println("Music is not playing.");
		return false;
	}

	public void addToPlaylist(String song){
		myPlaylist.addSong(song);
	}
	
	public void removeFromPlaylist(String song){
		myPlaylist.removeSong(song);
	}
	
	public void showPlaylist(){
		myPlaylist.showPlaylist(myPlaylist.playlist);
	}
	
	public String getSongName(int index){
		return myPlaylist.songAt(index);
	}
}
