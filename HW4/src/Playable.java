
public interface Playable {
	public void play();
	public String getName(); /** returns the name for PlayList or title for Song of a Playable object*/
	public int getPlayTimeSeconds(); /** For Song, returns the number of seconds in the song. For PlayList, return the number of seconds in the entire PlayList*/
	public int numberOfSongs(); /** For Song, returns 1. For PlayList, returns the number of songs in the PlayList and all PlayLists contained within*/
}
