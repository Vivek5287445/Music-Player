package com.vivek;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist implements IPlaylist{
	
	
	 // This is the playlist class which contains a linkedList of type String 
	 
	public LinkedList<String> playlist = new LinkedList<String>();
	
	private String nowPlaying = "";
	private int playListSize;
	
	//returns the total number of elements in the playlist
	public int getPlaylistSize(){
		playListSize = playlist.size();
		return playListSize;
	}
	
	//returns the path of nowPlaying song
	public String getNowPlaying(){
		return nowPlaying;
	}
	
	//set the variable nowPlaying to keep track of the song that is playing.
	public void setNowPlaying(String songName){
		nowPlaying = songName;
	}
	
	@Override
	public boolean createPlaylist(String playlistName) {
		  /*
		   *Add more than one playlist
		   * Not ready yet
		   * 
		   */
		return false;
	}

	@Override
	public boolean removePlaylist(String playlistName) {
		/*
		 * remove a playlist
		 * Not ready yet
		 * 
		 */
		return false;
	}

	/*add song location to the playlist
	 * (non-Javadoc)
	 * @see com.vivek.IPlaylist#addSong(java.lang.String)
	 * 
	 * return true after successful addition of the song
	 * if the song already exist then returns false
	 */
	@Override
	public boolean addSong(String songName) {
		if(!playlist.contains(songName)){
			playlist.add(songName);
			
			System.out.println(songName+" added successfully to the playlist.\n");
			return true;
		}
		
		System.out.println(songName+" already exists in the playlist.\n");
		return false;
	}
	
	/*remove song location from the playlist
	 * (non-Javadoc)
	 * @see com.vivek.IPlaylist#removeSong(java.lang.String)
	 * 
	 * returns true after successfully removing the song
	 * returns false if song does not exist in the playlist
	 */
	@Override
	public boolean removeSong(String songName) {
		if(playlist.contains(songName)){
			playlist.remove(playlist.indexOf(songName));
			
			System.out.println(songName+" removed from playlist.\n");
			return true;
		}
		
		System.out.println(songName+" is not listed in the playlist.\n");
		return false;
	}
	
	/*
	 * this method is used to show the entries of the playlist
	 * uses a iterator to fetch all the entries and returns void
	 * 
	 */
	public void showPlaylist(LinkedList<String> linkedList){
		Iterator<String> myIterator = linkedList.iterator();
		
		for(int i=1; i<=linkedList.size(); i++)
		System.out.println(i+". "+myIterator.next());
		
	}
	
	
	/*
	 * returns true if the playlist contains the song
	 */
	public boolean containSong(String songName){
		if(playlist.contains(songName))
			return true;
		
		return false;
	}
	
	//returns the index of the song int the playlist
	public int indexOfSong(String songName){
		//returns negative value if song is not listed in the playlist
		return playlist.indexOf(songName);
	}
	
	//returns the path of the song
	public String songAt(int index){
		//throws a IndexOutOfBoundException
		try{
		nowPlaying = playlist.get(index);
		}catch(IndexOutOfBoundsException e){
			System.out.println("Playlist Empty. Please add some songs to the playlist.");
		}
		return nowPlaying;
	}
	
}
