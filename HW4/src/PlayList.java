import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PlayList implements Playable {
	private String name; /** contains the name of the playlist*/
	private ArrayList<Playable> playableList; /** ArrayList of Playable elements that make up the playlist*/
	
	public PlayList() { /** Constructor for an empty, untitled playlist*/
		name = "Untitled";
		playableList = new ArrayList<Playable>();
	}
	public PlayList(String newName) { /** Constructor for an empty, titled playlist*/
		name = newName;
		playableList = new ArrayList<Playable>();
	}
	
	public void setName(String s) {
		this.name = s;
	}
	public void setPlayableList(ArrayList<Playable> l) {
		this.playableList = l;
	}
	public String getName() {
		return this.name;
	}
	public ArrayList<Playable> getPlayableList() {
		return this.playableList;
	}
	
	public boolean clear() { /** Clears the playlist of any songs or other playlists*/
		this.setPlayableList(new ArrayList<Playable>());
		return true;
	}
	public boolean addSong(Song s) { /** Adds a song to the end of a playlist*/
		ArrayList<Playable> list = this.getPlayableList();
		list.add(s);
		this.setPlayableList(list);
		return true;
	}
	public Playable removePlayable(int index) { /** Removes a song or playlist located at the given index in a playlist*/
		ArrayList<Playable> list = this.getPlayableList();
		Playable answer = list.get(index);
		list.remove(index);
		this.setPlayableList(list);
		return answer;
	}
	public Playable removePlayable(Playable p) { /** Removes a song or playlist that is equal to the parameter from a playlist*/
		for (Playable a : this.playableList) {
			if (a.equals(p)) {
				this.playableList.remove(a);
				return a;
			}
		}
		return null;
	}
	
	public boolean equals(PlayList p) { /** Returns true if two playlists have the same name and contents*/
		if (this.getName().equals(p.getName()) && this.getPlayableList().equals(p.getPlayableList())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() { /** Returns a string with the playlist's name and contents*/
		String s = this.getName() + "\n";
		for (Playable p : this.getPlayableList()) {
			s += p.toString() + "\n";
		}
		return s;
	}
	
	public Playable getPlayable(int index) { /** Returns the playlist or song located at the given index*/
		if (0 <= index && index < this.getPlayableList().size()) {
			ArrayList<Playable> list = this.getPlayableList();
			return list.get(index);
		}
		else return null;
	}
	
	public boolean addPlayList(PlayList pl) { /** Adds the given playlist to the end of a playlist*/
		ArrayList<Playable> list = this.getPlayableList();
		int counter = 0;
		for (Playable p : list) {
			if (p.getName().equals(pl.getName())) {
				counter += 1;
			}
		}
		if (counter == 0) {
			list.add(pl);
			this.setPlayableList(list);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void play() { /** Plays all of the contents of a playlist*/
		for (Playable p : this.getPlayableList()) {
			p.play();
		}
	}
	
	public int getPlayTimeSeconds() { /** Returns the total runtime of a playlist in seconds*/
		int time = 0;
		for (Playable p : this.getPlayableList()) {
			time += p.getPlayTimeSeconds();
		}
		return time;
	}
	
	public int numberOfSongs() { /** Returns the total number of songs in a playlist*/
		int count = 0;
		for (Playable p : this.getPlayableList()) {
			count += p.numberOfSongs();
		}
		return count;
	}
	
	public boolean loadSongs(String fileName) { /** Loads songs from a text file into a playlist*/
		try {
			Scanner scan = new Scanner(new FileReader(fileName));
			while (scan.hasNextLine()) {
				String a = scan.nextLine();
				a = a.trim();
				String title = scan.nextLine();
				title = title.trim();
				String[] time = scan.nextLine().trim().split(":");
				int[] t = new int[time.length];
				for (int i = 0; i < time.length; i++) {
					t[i] = Integer.parseInt(time[i]);
				}
				int min = t[0];
				int sec = t[1];
				if (sec >= 60) {
					min += sec / 60;
					sec = sec % 60;
				}
				scan.nextLine();
				Song s = new Song(title, a, min, sec);
				this.addSong(s);
			}
			return true;
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void sortByName() { /** Sorts the contents of a playlist by name*/
		ArrayList<Playable> list = this.getPlayableList();
		Collections.sort(list, new cmpByName());
		this.setPlayableList(list);
	}
	public void sortByTime() { /** Sorts the contents of a playlist by runtime*/
		ArrayList<Playable> list = this.getPlayableList();
		Collections.sort(list, new cmpByTime());
		this.setPlayableList(list);
	}
}
