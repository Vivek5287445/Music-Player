package com.vivek;

import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;


public class Main {
	

//	static JFileChooser fileChooser = new JFileChooser();
//	static int result = fileChooser.showOpenDialog(null);
//	static File selectedFile = fileChooser.getSelectedFile();
//	
	
	static Scanner scanner = new Scanner(System.in);

	static MusicPlayer myPlayer = new MusicPlayer();
	
	static MP3 song;
	
	
	
	public static void main(String[] args) {
		
		boolean quit = false;
		
		while(!quit){
			int selection;
			
			System.out.println("\n\n\t\tWelcome to the Music Player");
			System.out.println("1. Play Song\t2. Pause/Play\t3. Next\t4. Previous\n"
					+ "5. Show Playlist\t6. Add Song To Playlist\n7. Remove Song from Playlist\t8. Quit\n9.Open");
			System.out.println("\nEnter Your Selection:");
			try{
			selection = Integer.parseInt(scanner.nextLine());
			}catch(NumberFormatException e){
				selection = 0;
				System.out.println("Sorry invalid Input. "+e);
			}
			switch(selection){
			case 1: playSong();
					break;
			case 2: pause_Play();
					break;
			case 3: next();
					break;
			case 4: previous();
					break;
			case 5: showPlaylist();
					break;
			case 6: addToPlaylist();
					break;
			case 7: removeFromPlaylist();
					break;
			case 8: quit = true;
					System.out.println("Music Player Stopped successfully.");
					break;
			case 9: openFile();
					break;
			default: System.out.println("Invalid Selection");
			}
		}
		
	}
	
	public static void openFile(){
//
//		JFileChooser fileChooser = new JFileChooser();
//		int result = fileChooser.showOpenDialog(null);
//		File selectedFile = fileChooser.getSelectedFile();
//		
		song = new MP3(fileChooserMethod());
		System.out.println("Now Playing: "+fileChooserMethod());
		song.play();
	}
	
	public static void playSong(){
		
		myPlayer.showPlaylist();
		System.out.println("Enter Song Number from Playlist:");
		int indexNumber = Integer.parseInt(scanner.nextLine());
		
		myPlayer.playMusic(myPlayer.getSongName(indexNumber-1));
	}
	
	public static void pause_Play(){
		if(myPlayer.musicPlaying){
		myPlayer.pause();
		}else{
			myPlayer.play();
		}
	}
	
	public static void next(){
		myPlayer.nextSong();
	}
	
	public static void previous(){
		myPlayer.previousSong();
	}
	
	public static void showPlaylist(){
		myPlayer.showPlaylist();
		System.out.println("\n");
	}
	
	public static void addToPlaylist(){
		
		boolean quit = false;
		while(!quit){
			System.out.println("Add Song to Playlist: ");
			System.out.println("1. Slect a song\t\t2. Enter a File Location\n3. Go Back");
			
			int selection;
			System.out.println("Enter your Selection: ");
			try{
				selection = Integer.parseInt(scanner.nextLine());
			}catch(Exception e){
				selection = 0;
				System.out.println(e);
			}
			
			switch(selection){
			case 1:
				myPlayer.addToPlaylist(fileChooserMethod());
				break;
			case 2:
				String path;
				System.out.println("Enter file path: ");
				path = scanner.nextLine();
				myPlayer.addToPlaylist(path);
			case 3:
				quit = true;
				break;
			default :
				System.out.println("Invalid Selection.");
			}
		}
	}

	public static String fileChooserMethod(){
		String fileName;
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(null);
		File selectedFile = fileChooser.getSelectedFile();
		fileName = selectedFile.getAbsolutePath();
		return fileName;
	}
	
	public static void removeFromPlaylist(){
		System.out.println("Enter Song Name: ");
		String songName = scanner.nextLine();
		
		myPlayer.removeFromPlaylist(songName);
	}
}
