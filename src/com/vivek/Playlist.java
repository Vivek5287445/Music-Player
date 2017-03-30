package com.vivek;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist implements IPlaylist{
	
	public LinkedList<String> playlist = new LinkedList<String>();
	
	private String nowPlaying = "";
	private int playListSize;
	
	public int getPlaylistSize(){
		playListSize = playlist.size();
		return playListSize;
	}
	
	public String getNowPlaying(){
		return nowPlaying;
	}
	
	public void setNowPlaying(String songName){
		nowPlaying = songName;
	}
	
	@Override
	public boolean createPlaylist(String playlistName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removePlaylist(String playlistName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addSong(String songName) {
		if(!playlist.contains(songName)){
			playlist.add(songName);
			
			System.out.println("Song added successfully.");
			return true;
		}
		
		System.out.println("Song already exists in the playlist.");
		return false;
	}
	
	@Override
	public boolean removeSong(String songName) {
		if(playlist.contains(songName)){
			playlist.remove(playlist.indexOf(songName));
			
			System.out.println("Song removed from playlist.");
			return true;
		}
		
		System.out.println(songName+" is not listed in the playlist.");
		return false;
	}
	
	public void showPlaylist(LinkedList<String> linkedList){
		Iterator<String> myIterator = linkedList.iterator();
		
		for(int i=1; i<=linkedList.size(); i++)
		System.out.println(i+". "+myIterator.next());
		
	}
	
	public boolean containSong(String songName){
		if(playlist.contains(songName))
			return true;
		
		return false;
	}
	
	public int indexOfSong(String songName){
		return playlist.indexOf(songName);
	}
	
	public String songAt(int index){
		try{
		nowPlaying = playlist.get(index);
		}catch(IndexOutOfBoundsException e){
			System.out.println("Playlist Empty. Please add some songs to the playlist.");
		}
		return nowPlaying;
	}
	
}
