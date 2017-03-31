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
			
			System.out.println("\n\n\t\tProgrammer's Music Player");
			System.out.println("1. Play Song\t   2. Pause/Play\t    3. Next\t      4. Previous\n"
					+ "5. Show Playlist\t    6. Add Song To Playlist\t  7. Remove Song from Playlist\n8. Quit\t  9. About\n");
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
					myPlayer.stop();
					System.out.println("Music Player Stopped successfully.");
					break;
			case 9: aboutAuthor();
					break;
			default: System.out.println("Invalid Selection");
			}
		}
		
	}
	
	public static void aboutAuthor(){
			System.out.println("\nAuthor: Vivek Kaushik");
			System.out.println("Email: kaushikvivek.17@gmail.com");
			System.out.println("Current Version: 2.5");
			System.out.println("Project Website: https://vivek5287445.github.io/Music-Player/");
			System.out.println("My GitHub Page: https://github.com/Vivek5287445/\n\n");
			
			System.out.println("About the program: ");
			System.out.println("This is a Music Player program. It does what it says it does. With this, you can play \n"
					+ "music right from Command Prompt or a Terminal. Which by the way looks so cool. Currently you can\n"
					+ "play only mp3 files but I think I will add the codecs for other format as well(at least I hope so).\n"
					+ "So please enjoy the program I think you will like it. And did I tell how cool it is to play music using\n"
					+ "terminal, Yup I did. You can also check out my blog \"techtrickswithvk.blogspot.com\".\n");
			
			System.out.println("\nWhat's New: \n");
			
			System.out.println("version 2.5:\n- Some Major Bug Fixes.\n- Fixed the issue of dual music playback\n"
					+ "- Some Minor Bug Fixes\n- Fixed the issue where program does not terminate while music is playing.\n");
			
			System.out.println("version 2.0:\n- Major Bug Fixes.\n- Added the ability to go to next and previous song.\n"
					+ "- Added Playlist Functionality.\n- Added file selection functionality.\n");
			
			System.out.println("version 1.0:\n- Added control functions.\n- Bug Fixes.");
			
	}
	public static void playSong(){
		
		myPlayer.showPlaylist();
		System.out.println("Enter Song Number from Playlist:");
	
		try{
		int indexNumber = Integer.parseInt(scanner.nextLine());
		myPlayer.playMusic(myPlayer.getSongName(indexNumber-1));
		}catch(NumberFormatException e){
			System.out.println("Invalid song"+e);
		}
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
