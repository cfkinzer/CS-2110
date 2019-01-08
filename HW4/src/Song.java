
public class Song implements Comparable<Song>, Playable {
	private String artist; /** artist performing the song*/
	private String title; /** title of the song*/
	private int minutes; /** number of minutes in length*/
	private int seconds; /** number of seconds in the song (always < 60)*/

	public Song(String a, String t) { /** Constructs a song with the given title and artist with no runtime*/
		artist = a;
		title = t;
		minutes = 0;
		seconds = 0;
	}
	public Song(String a, String t, int m, int s) { /** Constructs a song with the given title, artist, and runtime*/
		artist = a;
		title = t;
		minutes = m;
		seconds = s;
	}
	public Song(Song s) { /** Constructs a copy of a song from another song*/
		artist = s.getArtist();
		title = s.getTitle();
		minutes = s.getMinutes();
		seconds = s.getSeconds();
	}

	public String getArtist() {
		return this.artist;
	}
	public String getTitle() {
		return this.title;
	}
	public int getMinutes() {
		return this.minutes;
	}
	public int getSeconds() {
		return this.seconds;
	}
	public void setArtist(String s) {
		this.artist = s;
	}
	public void setTitle(String s) {
		this.title = s;
	}
	public void setMinutes(int i) {
		this.minutes = i;
	}
	public void setSeconds(int i) {
		this.seconds = i;
	}

	public boolean equals(Object o) { /** Returns true if two songs are the same*/
		if(o instanceof Song) {
			Song s = (Song)o;
			if(this.title.equals(s.getTitle()) && this.artist.equals(s.getArtist()) && this.minutes == s.getMinutes() && this.seconds == s.getSeconds()) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public String toString() { /** Converts a song into a string*/
		return "{Song: title = " + title + " artist = " + artist + "}";
	}
	public void play() { /** Plays a song*/
		System.out.printf("Playing Song: artist = %-20s title = %s\n", artist, title);
	}
	public int compareTo(Song s) { /**Compares songs first by Artist, then by Title*/
		int retVal = 0;
		retVal = this.getArtist().compareTo(s.getArtist());
		if (retVal == 0) {
			retVal = this.getTitle().compareTo(s.getTitle());
		}
		return retVal;
	}
	public int getPlayTimeSeconds() { /** Returns the runtime of a song in seconds*/
		return (this.getMinutes() * 60) + this.getSeconds();
	}
	public int numberOfSongs() { /** Returns 1 because one song is one song*/
		return 1;
	}
	public String getName() { /** Returns the title of the song*/
		return this.title;
	}
}

